# == Schema Information
#
# Table name: games
#
#  id       :integer          not null, primary key
#  platform :string
#  studio   :string
#

class Api::GamesController < ApiController
  load_and_authorize_resource
  before_action :set_game, only: [:show, :edit, :update, :destroy]

  def index
    @games = Game.all
    render json: @games
  end

  def show
    @game = Game.find(params[:id])
    render json: @game
  end

  def new
    @game = Game.new
  end

  def edit
  end

  def create
    @game = Game.new(game_params)

    respond_to do |_format|
      if @game.save
        render :show, status: :created, location: @game
      else
        render json: @game.errors, status: :unprocessable_entity
      end
    end
  end

  def update
    respond_to do |_format|
      if @game.update(game_params)
        render :show, status: :ok, location: @game
      else
        render json: @game.errors, status: :unprocessable_entity
      end
    end
  end

  def destroy
    @game.destroy
    respond_to do |_format|
      head :no_content
    end
  end

  private

  def set_game
    @game = Game.find(params[:id])
  end

  def game_params
    params.require(:game).permit(:name, :description, :trailer, :avatar,
                                 :release_date, :rating, :importance, :platform,
                                 :studio)
  end
end
