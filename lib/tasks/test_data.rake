namespace :test_data do
  desc 'Add test users to the database'
  task create_users: :environment do
    names = Set.new
    genders = %w(Male Female)

    names.add(Faker::Name.name) while names.length < 50

    for name in names do
      user = User.create(
        name: name,
        email: Faker::Internet.free_email(name),
        password: 12_345_678,
        password_confirmation: 12_345_678,
        gender: genders[rand(0..1)],
        birth_date: Faker::Date.between(50.years.ago, 18.years.ago),
        country: Faker::Address.country_code
      )
      puts user.errors unless user.valid?
    end
  end
end
