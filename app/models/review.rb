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
  belongs_to :user
  belongs_to :product
  #validaçoes
  validates :score, numericality: { only_integer: true, :greater_than_or_equal_to => 0, :less_than_or_equal_to => 100 }, :presence => true
end
