class HomeController < ApplicationController
  helper ProductsHelper

  def index
    if user_signed_in?
      if current_user.role == 'moderator' || current_user.role == 'admin'
        render 'moderator-home'
      end
    end
    @games = Product.games.best.map(&:specific)
    @movies = Product.movies.best.map(&:specific)
    @shows = Product.shows.best.map(&:specific)
    @albums = Product.albums.best.map(&:specific)
    @top5 = Product.hot.limit(5)
  end
end
