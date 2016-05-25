class UsersController < ApplicationController
  before_action :set_user, only: [:show, :promote]

  def index
    @users = User.all
  end

  def promote
    @user.role = params[:role]
    respond_to do |format|
      if user.save
        msg = { success: true, message: "Changed user's role successfuly!" }
        format.json { render json: msg }
      else
        msg = { success: false, message: user.errors }
        format.json { render json: msg, status: :unprocessable_entity }
      end
    end
  end

  def show
    @reviews = @user.reviews
  end

  private

  def set_user
    @user = User.find(params[:id])
    redirect_to signin_path unless project.hidden
  end
end
