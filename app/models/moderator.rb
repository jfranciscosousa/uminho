# == Schema Information
#
# Table name: moderators
#
#  id         :integer          not null, primary key
#  name       :string
#  admin      :boolean
#  created_at :datetime         not null
#  updated_at :datetime         not null
#

class Moderator < ActiveRecord::Base
  has_many :products
end
