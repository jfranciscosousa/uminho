class MovieSerializer < ActiveModel::Serializer
  attributes :id, :name, :description, :release_date, :score,
             :importance, :created_at, :updated_at, :trailer, :avatar,
             :cast, :director, :studio, :duration
end
