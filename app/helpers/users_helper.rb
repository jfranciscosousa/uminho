module UsersHelper

  def get_product_name (product_id)
    Product.find(product_id).name
  end

end
