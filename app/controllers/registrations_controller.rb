class RegistrationsController < Devise::RegistrationsController

  private

  def sign_up_params
    params.require(:user).permit(:name, :email, :password, :password_confirmation, :birth_date, :gender, :country)
  end

  def account_update_params
    params.require(:user).permit(:name, :email, :password, :password_confirmation, :birth_date, :gender, :country, :current_password)
  end
end
