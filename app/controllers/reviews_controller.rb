class ReviewsController < ApplicationController
  load_and_authorize_resource
  before_filter :set_product

  def create
    @review = Review.new(review_params)
    @review.product = @product
    @review.user = current_user

    respond_to do |format|
        if @review.save
           format.html { flash[:notice]='Review was successfully created.' and redirect_to request.referrer}
           format.json { render :show, status: :created, location: @review }
        else
           format.html { render :new }
           format.json { render json: @review.errors, status: :unprocessable_entity }
        end
     end
  end

  private

  def set_product
    @product = Product.find(params[:product_id])
  end

  def set_review
    @review = Review.find(params[:id])
  end

  def review_params
    params.require(:review).permit(:text, :score)
  end
end
