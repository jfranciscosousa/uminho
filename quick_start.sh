#!/bin/bash

set -x

rake db:drop
rake db:migrate
rake db:seed
rake test_data:users n=50
rake test_data:reviews
