class ProductSerializer < ActiveModel::Serializer
  attributes :id, :name, :description, :release_date, :score,
             :created_at, :updated_at, :trailer, :avatar
end
