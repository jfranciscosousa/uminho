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
end
