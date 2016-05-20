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
  has_many :reviews

  scope :games, -> { where(actable_type: 'Game')}
  scope :movies, -> { where(actable_type: 'Movie')}
  scope :shows, -> { where(actable_type: 'Show')}
  scope :albums, -> { where(actable_type: 'Album')}
  scope :best, -> { order(score: :desc)}
  scope :coming_soon, -> { where('release_date > ?', Date.today).order(:release_date).limit(10) }
  scope :hot, -> { order(importance: :desc) }

  validates :trailer, format: { with: /(https?\:\/\/)?(www\.youtube\.com|youtu\.?be)\//,
                                    message: "not a youtube link" }

  validates :avatar, format: { with: /https?:\/\/(\w+\.)?imgur.com\//,
                                message: "not a imgur link" }




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

end
