class ShowsController < ApplicationController
  before_action :set_show, only: [:show, :edit, :update, :destroy]

  def index
    @shows = Show.all
  end

  def show
    @show = Show.find(params[:id])
  end

  def new
    @show = Show.new
  end

  def edit
  end

  def create
    @show = Show.new(show_params)

    respond_to do |format|
      if @show.save
        format.html { flash[:notice] = 'Show was successfully created.' and redirect_to action: 'index' }
        format.json { render :show, status: :created, location: @show }
      else
        format.html { render :new }
        format.json { render json: @show.errors, status: :unprocessable_entity }
      end
    end
  end

  def update
    respond_to do |format|
      if @show.update(show_params)
        format.html { flash[:notice] = 'Show was successfully updated.' and redirect_to action: 'index' }
        format.json { render :show, status: :ok, location: @show }
      else
        format.html { render :edit }
        format.json { render json: @show.errors, status: :unprocessable_entity }
      end
    end
  end

  def destroy
    @show.destroy
    respond_to do |format|
      format.html { flash[:notice] = 'Show was successfully deleted.' and redirect_to action: 'index' }
      format.json { head :no_content }
    end
  end

  private

  def set_show
    @show = Show.find(params[:id])
  end

  def show_params
    params.require(:show).permit(:name,
                                 :description,
                                 :trailer,
                                 :avatar,
                                 :release_date,
                                 :rating,
                                 :importance,
                                 :cast,
                                 :seasons,
                                 :duration,
                                 :episodes)
  end
end
