class ShowsChangeDurationToString < ActiveRecord::Migration
  def self.up
    change_column :shows, :duration, :string
  end

  def self.down
    change_column :shows, :duration, :int
  end
end
