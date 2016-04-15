# == Schema Information
#
# Table name: shows
#
#  id       :integer          not null, primary key
#  cast     :text
#  seasons  :integer
#  duration :integer
#  episodes :integer
#

class Show < ActiveRecord::Base
  acts_as :product
end
