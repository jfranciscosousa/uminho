class GamesController < ApplicationController
  before_action :set_game, only: [:show, :edit, :update, :destroy]

  def index
    @games = Game.all
  end

  def show
    @game = Game.find(params[:id])
  end

  def new
    @game = Game.new
  end

  def edit
  end

  def create
    @game = Game.new(game_params)

    respond_to do |format|
        if @game.save
           format.html {flash[:notice]='Game was successfully created.' and redirect_to action: "index" }
           format.json { render :show, status: :created, location: @game }
        else
           format.html { render :new }
           format.json { render json: @game.errors, status: :unprocessable_entity }
        end
     end
  end

  def update
    puts game_params['release_date']
    respond_to do |format|
      if @game.update(game_params)
        format.html {flash[:notice]='Game was successfully updated.' and redirect_to action: "index"}
        format.json { render :show, status: :ok, location: @game }
      else
        format.html { render :edit }
        format.json { render json: @game.errors, status: :unprocessable_entity }
      end
    end
  end

  def destroy
    @game.destroy
    respond_to do |format|
      format.html { flash[:notice]='Game was successfully deleted.' and redirect_to action: "index"}
      format.json { head :no_content }
    end
  end

  private

  def set_game
    @game = Game.find(params[:id])
  end

  def game_params
    params.require(:game).permit(:name,
                                 :description,
                                 :release_date,
                                 :rating,
                                 :importance,
                                 :platform,
                                 :studio)
  end
end
