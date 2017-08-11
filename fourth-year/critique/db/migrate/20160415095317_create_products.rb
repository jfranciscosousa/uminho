class CreateProducts < ActiveRecord::Migration
  def change
    create_table :products do |t|
      t.string :name
      t.text :description
      t.date :release_date
      t.string :rating
      t.integer :score
      t.integer :importance
      t.actable

      t.timestamps null: false
    end
  end
end
