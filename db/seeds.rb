# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).
#
# Examples:
#
#   cities = City.create([{ name: 'Chicago' }, { name: 'Copenhagen' }])
#   Mayor.create(name: 'Emanuel', city: cities.first)

# Albums

Album.create(name: 'The Life of Pablo', description:"The Life of Pablo is the seventh studio album by American rapper Kanye West. It was released on February 14, 2016, by Roc-A-Fella Records, GOOD Music and Def Jam Recordings.",
      release_date: Date.new(2016,2,14), duration: '59:44', artist: 'Kanye West',
      producer: 'Rick Rubin', studio: 'Windmark Studios',
      features:'Chance the Rapper, Ty Dolla $ign, Kendrick Lamar, Chris Brown, The Weeknd')

#Album.create (name: 'Abbey Road', description: "" )
