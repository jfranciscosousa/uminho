class StatisticsController < ApplicationController
    before_action :set_product

    def age_distribution
        render json: @product.age_hash_count
    end

    def gender_distribution
        render json: @product.gender_distribution
    end

    def average_score_by_age
        render json: @product.age_hash_average
    end

    def average_score_by_gender
        render json: @product.gender_distribution_score
    end

    def reviews_by_country
        render json: @product.geo_distribution
    end

    def average_score_by_country
        render json: @product.geo_distribution_score
    end

    private

    def set_product
        @product = Product.find(params[:id])
    end
end
