class HomeController < ApplicationController
  helper ProductsHelper


  def index
    if user_signed_in?
      if current_user.role == 'admin'
        render 'admin-home'
      elsif current_user.role == 'moderator'
        render 'admin-home'
      end
    end
    @games = Product.games.best.map { |p| p.specific }
    @movies = Product.movies.best.map { |p| p.specific }
    @shows = Product.shows.best.map { |p| p.specific }
    @albums = Product.albums.best.map { |p| p.specific }
    @top5 = Product.hot.limit(5)
    @coming_soon = Product.coming_soon.limit(5)
  end
end
