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
    acts_as_voter
    scope :user, -> { where(role: 'user') }
    scope :admin, -> { where(role: 'admin') }
    scope :moderator, -> { where(role: 'moderator') }
    scope :male, -> { where(gender: 'Male') }
    scope :female, -> { where(gender: 'Female') }
    scope :other, -> { where(gender: 'Other') }

    devise :database_authenticatable, :registerable,
           :recoverable, :rememberable, :validatable

    # associations
    has_many :reviews, -> { order 'reviews.cached_votes_up DESC' }
    has_many :products, through: :reviews

    # validations
    validates :gender, inclusion: { in: %w(Male Female Other), message: 'is invalid!' }
    validates :role, inclusion: { in: %w(admin moderator user), message: 'is invalid!' }
    validates :name, presence: true
    validates :country, presence: true
    validates :birth_date, presence: true

    # default values
    before_validation :default_values

    def default_values
        self.role ||= 'user'
    end

    def can_review?(product)
        !product.in?(products)
    end

    def country_name
        country = ISO3166::Country[self.country]
        country.translations[I18n.locale.to_s] || country.name
    end
end
