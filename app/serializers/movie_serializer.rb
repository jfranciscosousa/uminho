class MovieSerializer < ActiveModel::Serializer
  cache key: 'movie', expires_in: 3.hours

  attributes :id, :name, :description, :release_date, :score,
             :importance, :created_at, :updated_at, :trailer, :avatar,
             :cast, :director, :studio, :duration
end
