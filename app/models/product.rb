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
  validates :trailer, format: { with: /(https?\:\/\/)?(www\.youtube\.com|youtu\.?be)\//,
                                    message: "Only youtube links" }

  #validates :avatar, format: { with: ^(https?\:\/\/)?(www\.imgur\.com)\/.+$/,
   #                             message: "Only youtube links" }

  def score
    numreviews = reviews.count
    if  numreviews == 0
      return 0
    else
      total = 0
      for review in reviews
        total += review.score
      end
      total / numreviews
    end
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
