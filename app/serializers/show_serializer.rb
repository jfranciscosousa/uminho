class ShowSerializer < ActiveModel::Serializer
  cache key: 'show', expires_in: 3.hours

  attributes :id, :name, :description, :release_date, :score,
             :importance, :created_at, :updated_at, :trailer, :avatar,
             :cast, :seasons, :duration, :episodes
end
