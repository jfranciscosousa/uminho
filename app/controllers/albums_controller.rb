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

class AlbumsController < AbstractProductController
  load_and_authorize_resource
  before_action :set_album, only: [:show, :edit, :update, :destroy]

  def index
    @albums = Album.all
  end

  def show
    @album = @product.specific
  end

  def new
    @album = Album.new
  end

  def edit
  end

  def create
    @album = Album.new(album_params)

    respond_to do |format|
      if @album.save
        format.html { flash[:notice] = 'Album was successfully created.' and redirect_to action: 'index' }
        format.json { render :show, status: :created, location: @album }
      else
        format.html { render :new }
        format.json { render json: @album.errors, status: :unprocessable_entity }
      end
    end
  end

  def update
    respond_to do |format|
      if @album.update(album_params)
        format.html { flash[:notice] = 'Album was successfully updated.' and redirect_to action: 'index' }
        format.json { render :show, status: :ok, location: @album }
      else
        format.html { render :edit }
        format.json { render json: @album.errors, status: :unprocessable_entity }
      end
    end
  end

  def destroy
    @album.destroy
    respond_to do |format|
      format.html { flash[:notice] = 'Album was successfully deleted.' and redirect_to action: 'index' }
      format.json { head :no_content }
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
