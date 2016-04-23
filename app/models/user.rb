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
  # Include default devise modules. Others available are:
  # :confirmable, :lockable, :timeoutable and :omniauthable
  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :validatable
  has_many :reviews
  has_many :products, :through => :reviews
  before_save :default_values

  def default_values
    self.role ||= 'user'
  end
end
