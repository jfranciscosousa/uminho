class Api::ShowsController < ApiController
  before_action :set_show, only: [:show, :edit, :update, :destroy]

  def index
    @shows = Show.all
    render json: @shows
  end

  def show
    @show = Show.find(params[:id])
    render json: @show
  end

  def new
    @show = Show.new
  end

  def edit
  end

  def create
    @show = Show.new(show_params)

    respond_to do |_format|
      if @show.save
        render :show, status: :created, location: @show
      else
        render json: @show.errors, status: :unprocessable_entity
      end
    end
  end

  def update
    respond_to do |_format|
      if @show.update(show_params)
        render :show, status: :ok, location: @show
      else
        render json: @show.errors, status: :unprocessable_entity
      end
    end
  end

  def destroy
    @show.destroy
    respond_to do |_format|
      head :no_content
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
