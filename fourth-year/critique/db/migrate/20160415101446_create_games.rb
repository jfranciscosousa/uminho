class CreateGames < ActiveRecord::Migration
  def change
    create_table :games do |t|
      t.string :platform
      t.string :studio
    end
  end
end
