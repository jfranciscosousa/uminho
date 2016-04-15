# == Schema Information
#
# Table name: users
#
#  id         :integer          not null, primary key
#  name       :string
#  birth_date :date
#  gender     :string
#  country    :string
#  created_at :datetime         not null
#  updated_at :datetime         not null
#

class User < ActiveRecord::Base
  has_many :reviews
  has_many :products, :through => :reviews
end
