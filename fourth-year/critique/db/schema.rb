# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20160521153757) do

  create_table "albums", force: :cascade do |t|
    t.string "duration"
    t.string "artist"
    t.string "producer"
    t.string "studio"
    t.string "features"
  end

  create_table "games", force: :cascade do |t|
    t.string "platform"
    t.string "studio"
  end

  create_table "movies", force: :cascade do |t|
    t.text   "cast"
    t.string "director"
    t.string "studio"
    t.string "duration"
  end

  create_table "products", force: :cascade do |t|
    t.string   "name"
    t.text     "description"
    t.date     "release_date"
    t.string   "rating"
    t.integer  "score"
    t.integer  "importance"
    t.string   "actable_type"
    t.integer  "actable_id"
    t.datetime "created_at",   null: false
    t.datetime "updated_at",   null: false
    t.string   "trailer"
    t.string   "avatar"
  end

  create_table "reviews", force: :cascade do |t|
    t.text     "text"
    t.integer  "score"
    t.integer  "user_id"
    t.integer  "product_id"
    t.datetime "created_at",                     null: false
    t.datetime "updated_at",                     null: false
    t.integer  "cached_votes_up",    default: 0
    t.integer  "cached_votes_down",  default: 0
    t.integer  "cached_votes_total", default: 0
  end

  create_table "shows", force: :cascade do |t|
    t.text    "cast"
    t.integer "seasons"
    t.string  "duration"
    t.integer "episodes"
  end

  create_table "users", force: :cascade do |t|
    t.string   "name"
    t.date     "birth_date"
    t.string   "gender"
    t.string   "country"
    t.string   "role"
    t.datetime "created_at",                          null: false
    t.datetime "updated_at",                          null: false
    t.string   "email",                  default: "", null: false
    t.string   "encrypted_password",     default: "", null: false
    t.string   "reset_password_token"
    t.datetime "reset_password_sent_at"
    t.datetime "remember_created_at"
    t.index ["email"], name: "index_users_on_email", unique: true
    t.index ["reset_password_token"], name: "index_users_on_reset_password_token", unique: true
  end

  create_table "votes", force: :cascade do |t|
    t.string   "votable_type"
    t.integer  "votable_id"
    t.string   "voter_type"
    t.integer  "voter_id"
    t.boolean  "vote_flag"
    t.string   "vote_scope"
    t.integer  "vote_weight"
    t.datetime "created_at"
    t.datetime "updated_at"
    t.index ["votable_id", "votable_type", "vote_scope"], name: "index_votes_on_votable_id_and_votable_type_and_vote_scope"
    t.index ["voter_id", "voter_type", "vote_scope"], name: "index_votes_on_voter_id_and_voter_type_and_vote_scope"
  end

end
