# == Schema Information
#
# Table name: reviews
#
#  id         :integer          not null, primary key
#  text       :text
#  score      :integer
#  likes      :integer
#  dislikes   :integer
#  user_id    :integer
#  product_id :integer
#  created_at :datetime         not null
#  updated_at :datetime         not null
#

class Api::ReviewsController < ApiController
    load_and_authorize_resource
    before_action :set_product, only: [:index, :create]

    def index
        @reviews = @product.reviews.includes(:user).paginate(page: params[:page], per_page: 10)
        render json: @reviews
    end

    def create
        @review = Review.new(review_params)
        @review.product = @product
        @review.user = current_user

        respond_to do |_format|
            if @review.save
                render :show, status: :created, location: @review
            else
                render json: @review.errors, status: :unprocessable_entity
            end
        end
    end

    private

    def set_product
        @product = Product.find(params[:product_id])
    end

    def review_params
        params.require(:review).permit(:text, :score)
    end
end
