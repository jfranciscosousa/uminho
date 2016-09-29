class ReviewSerializer < ActiveModel::Serializer
  attributes :id, :text, :score, :cached_votes_up, :cached_votes_down,
             :created_at, :updated_at
  has_one :user
end
