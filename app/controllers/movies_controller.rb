# == Schema Information
#
# Table name: movies
#
#  id         :integer          not null, primary key
#  cast       :text
#  director   :string
#  studio     :string
#  duration   :integer
#  product_id :integer
#

class MoviesController < AbstractProductController
  load_and_authorize_resource
  before_action :set_movie, only: [:show, :edit, :update, :destroy]

  def index
    @movies = Movie.all
  end

  def show
    @movie = Movie.find(params[:id])
  end

  def new
    @movie = Movie.new
  end

  def edit
  end

  def create
    @movie = Movie.new(movie_params)

    respond_to do |format|
      if @movie.save
        format.html { flash[:notice] = 'Movie was successfully created.' and redirect_to action: 'index' }
        format.json { render :show, status: :created, location: @movie }
      else
        format.html { render :new }
        format.json { render json: @movie.errors, status: :unprocessable_entity }
      end
    end
  end

  def update
    respond_to do |format|
      if @movie.update(movie_params)
        format.html { flash[:notice] = 'Movie was successfully updated.' and redirect_to action: 'index' }
        format.json { render :show, status: :ok, location: @movie }
      else
        format.html { render :edit }
        format.json { render json: @movie.errors, status: :unprocessable_entity }
      end
    end
  end

  def destroy
    @movie.destroy
    respond_to do |format|
      format.html { flash[:notice] = 'Movie was successfully deleted.' and redirect_to action: 'index' }
      format.json { head :no_content }
    end
  end

  private

  def set_movie
    @movie = Movie.find(params[:id])
  end

  def movie_params
    params.require(:movie).permit(:name, :description, :trailer, :avatar,
                                  :release_date, :rating, :importance, :cast,
                                  :director, :duration, :studio)
  end
end
