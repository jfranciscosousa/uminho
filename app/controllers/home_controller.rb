class HomeController < ApplicationController
  helper ProductsHelper

  def index
    if user_signed_in?
      if current_user.role == 'moderator' || current_user.role == 'admin'
        render 'moderator-home'
      end
    end
    @games = Product.can_review.games.best.map(&:specific)
    @movies = Product.can_review.movies.best.map(&:specific)
    @shows = Product.can_review.shows.best.map(&:specific)
    @albums = Product.can_review.albums.best.map(&:specific)
    @top5 = Product.can_review.hot.limit(5)
    @coming_soon = Product.coming_soon.limit(5).map(&:specific)
  end
end
