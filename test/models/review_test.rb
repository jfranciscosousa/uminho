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

require 'test_helper'

class ReviewTest < ActiveSupport::TestCase
  # test "the truth" do
  #   assert true
  # end
end
