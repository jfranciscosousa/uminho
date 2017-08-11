# == Schema Information
#
# Table name: shows
#
#  id       :integer          not null, primary key
#  cast     :text
#  seasons  :integer
#  duration :string
#  episodes :integer
#

class Show < ActiveRecord::Base
    acts_as :product
end
