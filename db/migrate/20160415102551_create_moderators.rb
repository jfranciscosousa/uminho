class CreateModerators < ActiveRecord::Migration
  def change
    create_table :moderators do |t|
      t.string :name
      t.boolean :admin
      t.timestamps null: false
    end
  end
end
