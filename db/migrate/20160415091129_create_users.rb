class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.string "name"
      t.date "birth_date"
      t.string "gender"
      t.string "country"
      t.string "role"
      t.timestamps null: false
    end
  end
end
