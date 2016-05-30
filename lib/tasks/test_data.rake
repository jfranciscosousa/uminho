namespace :test_data do
  desc 'Add test users to the database'
  task users: :environment do |_args|
    names = Set.new
    genders = %w(Male Female)

    users = ENV['n'].to_i || 50

    names.add(Faker::Name.name) while names.length < users

    ActiveRecord::Base.transaction do
      for name in names do
        User.create(
          name: name,
          email: Faker::Internet.free_email(name),
          password: 12_345_678,
          password_confirmation: 12_345_678,
          gender: genders[rand(0..1)],
          birth_date: Faker::Date.between(50.years.ago, 18.years.ago),
          country: Faker::Address.country_code
        )
      end
    end

    puts "Added #{users} users to the database!"
  end

  desc 'Add test reviews to the database'
  task reviews: :environment do
    ActiveRecord::Base.transaction do
      for product in Product.all do
        for user in User.user do
          Review.create(
            text: Faker::Hipster.paragraph,
            score: Faker::Number.between(55, 100),
            user: user,
            product: product
          )
        end
      end
      puts 'Added reviews for each product!'
    end
  end
end
