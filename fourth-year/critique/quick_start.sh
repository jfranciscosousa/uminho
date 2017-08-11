#!/bin/bash

set -x

bundle exec rake db:drop
bundle exec rake db:create
bundle exec rake db:migrate
bundle exec rake db:seed
bundle exec rake test_data:users n=50
bundle exec rake test_data:reviews
