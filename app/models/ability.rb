class Ability
  include CanCan::Ability

  def initialize(user)
    user ||= User.new # guest user

    can :read, :all

    if user.role == 'user'
      can :create, Review
      can :like, Review
      can :dislike, Review
    elsif user.role == 'admin'
      can :manage, :all
    elsif user.role == 'moderator'
      can :manage, Product
    end
  end
end
