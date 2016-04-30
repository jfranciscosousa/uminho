class ChangeDurationToString < ActiveRecord::Migration
  def self.up
    change_column :albums, :duration, :string
  end

  def self.down
    change_column :albums, :duration, :int
  end

end
