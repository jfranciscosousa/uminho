Rails.application.routes.draw do
    root 'home#index'

    devise_for :users, controllers: { registrations: 'registrations' }
    get 'users/:id' => 'users#show', :as => :user

    resources :games
    resources :albums
    resources :movies
    resources :shows

    resources :products, only: [:index] do
        resources :reviews, only: [:index, :new, :create]
    end

    resources :users, only: [:index]
    post 'users/:id/promote' => 'users#promote', as: 'promote_user'

    post 'reviews/:id/like' => 'reviews#like', as: 'like_review'
    post 'reviews/:id/dislike' => 'reviews#dislike', as: 'dislike_review'

    get 'statistics/age_distribution' => 'statistics#age_distribution'
    get 'statistics/gender_distribution' => 'statistics#gender_distribution'
    get 'statistics/score_by_age' => 'statistics#average_score_by_age'
    get 'statistics/score_by_gender' => 'statistics#average_score_by_gender'
    get 'statistics/reviews_by_country' => 'statistics#reviews_by_country'
    get 'statistics/score_by_country' => 'statistics#average_score_by_country'

    namespace :api, defaults: { format: 'json' } do
        resources :games, except: [:new]
        resources :albums, except: [:new]
        resources :movies, except: [:new]
        resources :shows, except: [:new]
        resources :products, only: [:index, :show] do
            resources :reviews, only: [:index, :create]
        end
        resources :users, only: [:show]
    end
end
