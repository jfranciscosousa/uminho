class AddColumnCachedLikes < ActiveRecord::Migration
    def change
        add_column :reviews, :cached_votes_up, :integer, default: 0
        add_column :reviews, :cached_votes_down, :integer, default: 0
        add_column :reviews, :cached_votes_total, :integer, default: 0
    end
end
