# == Schema Information
#
# Table name: users
#
#  id                     :integer          not null, primary key
#  name                   :string
#  birth_date             :date
#  gender                 :string
#  country                :string
#  role                   :string
#  created_at             :datetime         not null
#  updated_at             :datetime         not null
#  email                  :string           default(""), not null
#  encrypted_password     :string           default(""), not null
#  reset_password_token   :string
#  reset_password_sent_at :datetime
#  remember_created_at    :datetime
#

class User < ActiveRecord::Base
  scope :male, -> { where(gender: 'Male') }
  scope :female, -> { where(gender: 'Female') }
  scope :other, -> { where(gender: 'Other') }

  devise :database_authenticatable, :registerable,
         :recoverable, :rememberable, :validatable

  # associations
  has_many :reviews
  has_many :products, through: :reviews

  # validations
  validates :gender, inclusion: { in: %w(Male Female Other), message: 'Invalid gender.' }

  # default values
  before_save :default_values

  def default_values
    self.role ||= 'user'
  end

  def can_review?(product)
    !product.in?(self.products)
  end
end
