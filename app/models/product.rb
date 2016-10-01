# == Schema Information
#
# Table name: products
#
#  id           :integer          not null, primary key
#  name         :string
#  description  :text
#  release_date :date
#  rating       :string
#  score        :integer
#  importance   :integer
#  actable_id   :integer
#  actable_type :string
#  created_at   :datetime         not null
#  updated_at   :datetime         not null
#  trailer      :string
#  avatar       :string
#

class Product < ActiveRecord::Base
  actable

  has_many :reviews, -> { order 'reviews.cached_votes_up DESC' }
  has_many :users, through: :reviews

  scope :games, -> { where(actable_type: 'Game') }
  scope :movies, -> { where(actable_type: 'Movie') }
  scope :shows, -> { where(actable_type: 'Show') }
  scope :albums, -> { where(actable_type: 'Album') }
  scope :best, -> { order(score: :desc) }
  scope :coming_soon, -> { where('release_date > ?', Time.zone.today).order(:release_date).limit(10) }
  scope :can_review, -> { where('release_date < ?', Time.zone.today) }
  scope :hot, -> { order(importance: :desc) }

  validates :importance, numericality: { only_integer: true, greater_than_or_equal_to: 0, less_than_or_equal_to: 1000 }

  validates :trailer, format: { with: %r{(https?\:\/\/)?(www\.youtube\.com|youtu\.?be)\/},
                                message: 'not a youtube link' }

  validates :avatar, format: { with: %r{https?:\/\/(\w+\.)?imgur.com\/},
                               message: 'not a imgur link' }

  before_validation do
    self.importance ||= 0
  end

  before_save do
    if release_date.class == Hash
      self.release_date = Date.new(*release_date.values)
    end
  end

  def pretty_date
    release_date.strftime('%B %-d, %Y')
  end

  def age_hash_count
    ages = { '0-10' => [0, 10], '10-20' => [10, 20], '20-40' => [20, 40], '40-60' => [40, 60], '60-100' => [60, 100] }
    hash = {}
    ages.each do |desc, age|
      hash[desc] = users.where('birth_date BETWEEN ? AND ?', age[1].years.ago, age[0].years.ago).count
    end
    hash
  end

  def age_hash_average
    ages = { '0-10' => [0, 10], '10-20' => [10, 20], '20-40' => [20, 40], '40-60' => [40, 60], '60-100' => [60, 100] }
    hash = {}
    ages.each do |desc, age|
      hash[desc] = users.where('birth_date BETWEEN ? AND ?', age[1].years.ago, age[0].years.ago).average(:score)
    end
    hash
  end

  def gender_distribution
    { 'Male' => users.male.count, 'Female' => users.female.count, 'Other' => users.other.count }
  end

  def gender_distribution_score
    male_score = reviews.includes(:user).where('users.gender = ?', 'Male').references(:users).average(:score)
    female_score = reviews.includes(:user).where('users.gender = ?', 'Female').references(:users).average(:score)
    other_score = reviews.includes(:user).where('users.gender = ?', 'Other').references(:users).average(:score)
    { 'Male' => male_score, 'Female' => female_score, 'Other' => other_score }
  end

  def geo_distribution
    res_final = {}
    res = reviews.reorder('').joins(:user).group(:country).count
    res.each do |country, count|
      country = convert_country(country)
      res_final[country] = count
    end
    res_final
  end

  def geo_distribution_score
    res_final = {}
    res = reviews.reorder('').joins(:user).group(:country).average(:score)
    res.each do |country, count|
      country = convert_country(country)
      res_final[country] = count
    end
    res_final
  end

  private

  def convert_country(country)
    country = ISO3166::Country[country]
    country.translations[I18n.locale.to_s] || country.name
  end
end
