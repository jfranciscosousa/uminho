class HomeController < ApplicationController
  def index
    if user_signed_in?
      if current_user.role == 'admin'
        render 'admin-home'
      elsif current_user.role == 'moderator'
        render 'moderator-home'
      end
    end
    @games = Game.all
    @movies = Movie.all
    @shows = Show.all
    @albums = Album.all
  end
end
