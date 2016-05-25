class ProductsController < ApplicationController
  def index
    @search = params[:search]
    @products = if @search
                  Product.where('name like ?', "%#{@search}%")
                else
                  Product.all
                end
  end
end
