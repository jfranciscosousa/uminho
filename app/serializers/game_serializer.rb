class GameSerializer < ActiveModel::Serializer
  cache key: 'game', expires_in: 3.hours

  attributes :id, :name, :description, :release_date, :score,
             :importance, :created_at, :updated_at, :trailer, :avatar,
             :platform, :studio
end
