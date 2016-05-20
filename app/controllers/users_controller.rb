class UsersController < ApplicationController
    def index
        @users = User.all
    end

    def promote
        role = params[:role]
        user = User.find(params[:id])
        user.role = role
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
end
