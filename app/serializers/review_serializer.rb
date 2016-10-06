class ReviewSerializer < ActiveModel::Serializer
    cache key: 'review', expires_in: 3.hours

    attributes :id, :text, :score, :cached_votes_up, :cached_votes_down,
               :created_at, :updated_at
    has_one :user
end
