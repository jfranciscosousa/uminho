class Api::ProductsController < ApiController
  def index
    @search = params[:search]
    @products = if @search
                  Product.where('name like ?', "%#{@search}%")
                else
                  Product.all
                end
    render :json => @products
  end
end
