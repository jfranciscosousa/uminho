class CreateShows < ActiveRecord::Migration
  def change
    create_table :shows do |t|
      t.text :cast
      t.integer :seasons
      t.integer :duration
      t.integer :episodes
    end
  end
end
