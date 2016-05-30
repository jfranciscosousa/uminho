# == Schema Information
#
# Table name: movies
#
#  id       :integer          not null, primary key
#  cast     :text
#  director :string
#  studio   :string
#  duration :string
#

class Movie < ActiveRecord::Base
  acts_as :product
end
