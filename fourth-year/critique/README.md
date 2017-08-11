# critique
Work assignment for the Web Engineering course.

Course focuses on the exploration of diverse Web Development technologies, like HTML, CSS, Javascript and Ruby on Rails.


## Random Data Generation

The project contains rake tasks for generating random users and reviews. The random data is generated using Faker.

Add random users to the database
''rake test_data:users n=nr users''

Add reviews for each product
''rake test_data:reviews''

The quick_start.sh script allows for a quick reset of the database, using our rake tasks to create random users and reviews.

## Static analysis

The _rubocop.yml file has our style guidelines to keep our code nice and clean.

Traceroute was also used to ensure that all routes had a controller action and vice-versa.

## Extras

We also used the ERD gem, that generates a diagram based on our ActiveRecord models.

![alt tag](https://raw.githubusercontent.com/zeesousa/critique/master/erd.png)
