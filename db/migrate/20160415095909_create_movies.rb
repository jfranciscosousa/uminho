class CreateMovies < ActiveRecord::Migration
  def change
    create_table :movies do |t|
      t.text :cast
      t.string :director
      t.string :studio
      t.integer :duration
      t.integer :product_id
    end
  end
end
