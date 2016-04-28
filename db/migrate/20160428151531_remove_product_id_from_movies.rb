class RemoveProductIdFromMovies < ActiveRecord::Migration
  def change
    remove_column :movies, :product_id
  end
end
