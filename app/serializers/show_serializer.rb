class ShowSerializer < ActiveModel::Serializer
  attributes :id, :name, :description, :release_date, :score,
             :importance, :created_at, :updated_at, :trailer, :avatar,
             :cast, :seasons, :duration, :episodes
end