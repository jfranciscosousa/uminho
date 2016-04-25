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

require 'test_helper'

class ReviewsControllerTest < ActionController::TestCase
  # test "the truth" do
  #   assert true
  # end
end
