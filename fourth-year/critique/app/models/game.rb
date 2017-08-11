# == Schema Information
#
# Table name: games
#
#  id       :integer          not null, primary key
#  platform :string
#  studio   :string
#

class Game < ActiveRecord::Base
    acts_as :product
end
