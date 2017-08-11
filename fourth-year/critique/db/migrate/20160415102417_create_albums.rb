class CreateAlbums < ActiveRecord::Migration
  def change
    create_table :albums do |t|
      t.integer :duration
      t.string :artist
      t.string :producer
      t.string :studio
      t.string :features
    end
  end
end
