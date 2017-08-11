class MoviesChangeDurationToString < ActiveRecord::Migration
  def self.up
    change_column :movies, :duration, :string
  end

  def self.down
    change_column :movies, :duration, :int
  end
end
