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
  scope :coming_soon, -> { where("release_date > ?", Date.today).order(:release_date).limit(10) }

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
