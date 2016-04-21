class HomeController < ApplicationController
  def index
    @games = Game.all
    @movies = Movie.all
    @shows = Show.all
    @albums = Album.all
  end
end
