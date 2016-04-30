# == Schema Information
#
# Table name: reviews
#
#  id         :integer          not null, primary key
#  text       :text
#  score      :integer
#  likes      :integer
#  dislikes   :integer
#  user_id    :integer
#  product_id :integer
#  created_at :datetime         not null
#  updated_at :datetime         not null
#

class Review < ActiveRecord::Base
  acts_as_votable
  belongs_to :user
  belongs_to :product
  #validaçoes
  validates :score, numericality: { only_integer: true, :greater_than_or_equal_to => 0, :less_than_or_equal_to => 100 }, :presence => true
  validates_uniqueness_of :user_id, :scope => :product_id, :message => 'can only have one review per product!'

  def one_review_per_product

    if #some validation code for model year and trim
      errors.add(:product, "Only one review per product!")
    end
  end

end
