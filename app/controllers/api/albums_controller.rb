# == Schema Information
#
# Table name: albums
#
#  id       :integer          not null, primary key
#  duration :integer
#  artist   :string
#  producer :string
#  studio   :string
#  features :string
#

class Api::AlbumsController < ApiController
  load_and_authorize_resource
  before_action :set_album, only: [:show, :edit, :update, :destroy]

  def index
    @albums = Album.all
    render json: @albums
  end

  def show
    @album = Album.find(params[:id])
    render json: @album
  end

  def new
    @album = Album.new
  end

  def edit
  end

  def create
    @album = Album.new(album_params)

    respond_to do |_format|
      if @album.save
        render :show, status: :created, location: @album
      else
        render json: @album.errors, status: :unprocessable_entity
      end
    end
  end

  def update
    respond_to do |_format|
      if @album.update(album_params)
        render :show, status: :ok, location: @album
      else
        render json: @album.errors, status: :unprocessable_entity
      end
    end
  end

  def destroy
    @album.destroy
    respond_to do |_format|
      head :no_content
    end
  end

  private

  def set_album
    @album = Album.find(params[:id])
  end

  def album_params
    params.require(:album).permit(:name, :description, :release_date, :trailer,
                                  :avatar, :rating, :importance, :duration,
                                  :artist, :producer, :studio, :features)
  end
end
