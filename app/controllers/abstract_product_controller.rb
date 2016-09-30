class AbstractProductController < ApplicationController
  before_action :set_product, only: [:show]

  private

  def set_product
    @product = Product.find(params[:id])
    @reviews = @product.reviews.paginate(page: params[:page], per_page: 10)
  end
end
