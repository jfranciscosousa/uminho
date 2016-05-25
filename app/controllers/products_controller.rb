class ProductsController < ApplicationController
  def index
    @search = params[:search]
    if @search
      @products = Product.where("name like ?", "%#{@search}%")
	  else
		  @products = Product.all
	  end
  end
end
