# == Schema Information
#
# Table name: albums
#
#  id       :integer          not null, primary key
#  duration :string
#  artist   :string
#  producer :string
#  studio   :string
#  features :string
#

class Album < ActiveRecord::Base
    acts_as :product
end
