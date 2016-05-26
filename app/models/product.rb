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

  validates :trailer, format: { with: %r{(https?\:\/\/)?(www\.youtube\.com|youtu\.?be)\/},
                                message: 'not a youtube link' }

  validates :avatar, format: { with: %r{https?:\/\/(\w+\.)?imgur.com\/},
                               message: 'not a imgur link' }

  def score
    reviews.average(:score).to_f
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
   ages = {"0-10" => [0,10],"10-20"=>[10,20],"20-40"=>[20,40],"40-60"=>[40,60],"60-100"=>[60,100]}
   hash = {}
   ages.each do |desc, age|
     hash[desc] = users.where("birth_date BETWEEN ? AND ?", age[1].years.ago, age[0].years.ago).count
   end
   hash
  end
  def gender_distribution
    {"Male" => users.male.count, "Female" => users.female.count, "Other" => users.other.count}
  end
end
