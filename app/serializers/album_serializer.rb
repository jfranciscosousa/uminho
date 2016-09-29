class AlbumSerializer < ActiveModel::Serializer
  attributes :id, :name, :description, :release_date, :score,
             :importance, :created_at, :updated_at, :trailer, :avatar,
             :duration, :artist, :producer, :studio, :features
end
