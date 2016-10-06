class ProductSerializer < ActiveModel::Serializer
    cache key: 'product', expires_in: 3.hours

    attributes :id, :name, :description, :release_date, :score,
               :created_at, :updated_at, :trailer, :avatar
end
