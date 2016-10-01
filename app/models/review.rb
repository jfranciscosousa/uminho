# == Schema Information
#
# Table name: reviews
#
#  id                 :integer          not null, primary key
#  text               :text
#  score              :integer
#  user_id            :integer
#  product_id         :integer
#  created_at         :datetime         not null
#  updated_at         :datetime         not null
#  cached_votes_up    :integer          default(0)
#  cached_votes_down  :integer          default(0)
#  cached_votes_total :integer          default(0)
#

class Review < ActiveRecord::Base
  acts_as_votable
  belongs_to :user
  belongs_to :product
  after_save :update_product_score
  validates :score, numericality: { only_integer: true, greater_than_or_equal_to: 0, less_than_or_equal_to: 100 }, presence: true
  validates :user_id, uniqueness: { scope: :product_id, message: 'can only have one review per product!' }
  validate :product_must_be_released

  def product_must_be_released
    errors.add(:product, 'must be released before it can be reviewed!') if product.release_date > Time.zone.today
  end

  def update_product_score
    product.update_column(:score, product.reviews.average(:score))
  end
end
