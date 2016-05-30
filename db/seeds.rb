#default admin
User.create(email: "admin@critique.com", password:12345678, gender: "Male", role: "admin")
#default moderator
User.create(email: "moderator@critique.com", password:12345678, gender: "Male", role: "moderator")

##### Albums

Album.create!(name: 'The Life of Pablo', description:"The Life of Pablo is the seventh studio album by American rapper Kanye West. It was released on February 14, 2016, by Roc-A-Fella Records, GOOD Music and Def Jam Recordings.",
      release_date: Date.new(2016,2,14), duration: '59m44s', artist: 'Kanye West',
      producer: 'Rick Rubin', studio: 'Windmark Studios',
      features:'Chance the Rapper, Ty Dolla $ign, Kendrick Lamar, Chris Brown, The Weeknd', trailer: "https://www.youtube.com/embed/lNkYEgyVxBg", avatar: "http://i.imgur.com/9iRkK16.jpg")

Album.create!(name: 'Abbey Road', description: "Abbey Road is the 11th studio album by the English rock band the Beatles, released on 26 September 1969 by Apple Records. The recording sessions for the album were the last in which all four Beatles participated. Although \"Let It Be\" was the final album that the Beatles completed before the band's dissolution in April 1970, most of the album had been recorded before the Abbey Road sessions began.",
      release_date: Date.new(1969,9,26), duration:"47m23s", artist:'The Beatles', producer: "George Martin",
      studio: "EMI, Olympic and Trident Studios", features:"", trailer: "https://www.youtube.com/embed/5_9dT3W_9jw", avatar: "http://i.imgur.com/H8cY0aU.jpg")

Album.create!(name: "Rage Against the Machine", description:"Rage Against the Machine is the debut studio album by American rap metal band Rage Against the Machine. The album was released on November 3, 1992. It went to #1 on the Billboard Heatseekers chart, and #45 on the Billboard 200 chart.",
      release_date: Date.new(1992,11,3), duration:"52m52s", artist:"Rage Against the Machine", producer:"Garth Richardson",
      studio:"Sound City, Scream Studios, Industrial Recording", features:"Maynard James Keenan, Stephen Perkins", trailer:"https://www.youtube.com/embed/bWXazVhlyxQ", avatar: "http://i.imgur.com/pXlzU68.jpg")

Album.create!(name: 'Violence Begets Violence', description:"Violence Begets Violence is the seventh studio album by underground Philadelphia hip hop duo Jedi Mind Tricks. This is their only album to not feature production from Stoupe the Enemy of Mankind because \"his heart wasn't into making JMT records anymore\" as well as the fact that both Vinnie Paz and Jus Allah grew tired of waiting. Two singles were released, \"Target Practice\" and \"When Crows Descend Upon You,\" for which a video has been made. In addition, Shuko remixed the song \"Target Practice\".",
      release_date: Date.new(2011, 10, 25), duration:"46m54s", artist:"Jedi Mind Tricks",
      producer: "C-Lance, DJ Kwestion, Grand Finale, Hypnotist Beats, Illinformed, Junior Makno, Mr. Green, Nero, Scott Stallone, Shuko",
      studio: "	Enemy Soil", features: "Demoz, Blacastan, King Magnetic, Young Zee & Pacewon and Chip Fu", trailer: "https://www.youtube.com/embed/5BsL6upejZ8", avatar: "http://i.imgur.com/lzM0FOT.jpg")

Album.create!(name: 'The Wall', description: "The Wall is the eleventh studio album by the English rock band Pink Floyd. It is the last studio album released with the classic line-up of guitarist David Gilmour, bass guitarist/lyricist Roger Waters, keyboardist Richard Wright, and drummer Nick Mason before Wright left the band. Originally released as a double album on 30 November 1979, it was supported by a tour with elaborate theatrical effects, and adapted into a 1982 feature film, Pink Floyd – The Wall. The album features the band's only single to be number one on various charts, \"Another Brick in the Wall, Part 2\".",
              release_date: Date.new(1979,11,30), duration:"80m54s", artist:'Pink Floyd', producer: "Bob Ezrin, David Gilmour, James Guthrie, Roger Waters",
              studio: "Britannia Row, Super Bear Studio, Studio Miraval (France), CBS 30th Street Studio (New York), Producers Workshop (Los Angeles)", features:"", trailer: "https://www.youtube.com/embed/FrOQC-zEog", avatar: "http://i.imgur.com/teussw8.jpg")

Album.create!(name: 'California', description: "California is the upcoming seventh studio album by the American rock band Blink-182, set for release on July 1, 2016 through BMG.",
              release_date: Date.new(2016,7,1), duration:"42m36s", artist:'Blink-182', producer: "John Feldmann",
              studio: "Foxy Studios", features:"", trailer: "https://www.youtube.com/embed/8yGipyel-3I", avatar: "http://i.imgur.com/2Itu1bs.jpg")


##### games

Game.create!(name:"Mario Kart 8", description:"Mario Kart 8 is a 2014 kart racing game and the eighth major installment in the Mario Kart series, developed and published by Nintendo for the Wii U video game console. First announced at E3 2013, the game was released worldwide in late May 2014.",
      release_date: Date.new(2014,5,30), platform: "Wii U", studio:"Nintendo", trailer:"https://www.youtube.com/embed/mU7tXqYplA8", avatar:"http://i.imgur.com/V4bMfGZ.jpg")

Game.create!(name:"Dark Souls 3", description:"Dark Souls III is an action role-playing video game developed by FromSoftware and published by Bandai Namco Entertainment for PlayStation 4, Xbox One, and Microsoft Windows. The fourth entry in the Souls series, Dark Souls III was released in Japan in March 2016, and worldwide in April 2016.",
      release_date: Date.new(2016,4,12), platform: "PS4, Xbox One", studio:"FromSoftware", trailer:"https://www.youtube.com/embed/3hPmbLA-v2Q", avatar:"http://i.imgur.com/noMUmGy.jpg")

Game.create!(name:"The Witcher 3: Wild Hunt", description:"The Witcher 3: Wild Hunt is a dark fantasy open-world action role-playing video game developed by CD Projekt RED.[5] Announced in February 2013, it was released worldwide for Microsoft Windows, PlayStation 4, and Xbox One on 19 May 2015. The game is the third in the series, preceded by The Witcher and The Witcher 2: Assassins of Kings, which are based on the series of fantasy novels by Polish author Andrzej Sapkowski.",
      release_date: Date.new(2015,5,19), platform: "PS4, Xbox One", studio:"CD Projekt Red", trailer:"https://www.youtube.com/embed/xt_65k-gv1U", avatar:"http://i.imgur.com/LjqHbIY.jpg")

Game.create!(name:"Fifa 16", description:"FIFA 16 is an association football simulation video game developed by EA Canada and published by EA Sports for Microsoft Windows, Xbox One, PlayStation 4.",
      release_date: Date.new(2015,9,24), platform: "PS4, Xbox One", studio:"EA Sports", trailer:"https://www.youtube.com/embed/bwz98athxQ8", avatar:"http://i.imgur.com/Jqj3LuL.jpg")

Game.create!(name:"Pes 2016", description:"Pro Evolution Soccer 2016 (abbreviated to PES 2016, known as Winning Eleven 2016 in Japan) is a football simulation game developed by PES Productions and published by Konami for Microsoft Windows, PlayStation 3, PlayStation 4, Xbox 360, and Xbox One.",
             release_date: Date.new(2015,9,15), platform: "PS4, Xbox One", studio:"Konami", trailer:"https://www.youtube.com/embed/3UfOW9x0oeA", avatar:"http://i.imgur.com/nfZyGO3.jpg")

Game.create!(name:"LEGO Star Wars: The Force Awakens", description:"The LEGO video game franchise triumphantly returns with a fun-filled, humorous journey based on the blockbuster Star Wars film.",
             release_date: Date.new(2016,6,28), platform: "PS4, Xbox One", studio:"Warner Bros. Interactive", trailer:"https://www.youtube.com/embed/i0IJqIzO_YM", avatar:"http://i.imgur.com/HRD3Gqw.jpg")




#### movies

Movie.create!(name:"2001: Space Odissey", description:"Humanity finds a mysterious, obviously artificial object buried beneath the Lunar surface and, with the intelligent computer H.A.L. 9000, sets off on a quest.",
      release_date: Date.new(1968,10,1), cast:"Keir Dullea, Gary Lockwood, William Sylvester, Daniel Richter, Leonard Rossiter, Margaret Tyzack",
      director: "Stanley Kubrick", studio:"MGM", duration:"2h29min", trailer:"https://www.youtube.com/embed/Z2UWOeBcsJI", avatar:"http://i.imgur.com/F1ntnN1.jpg")

Movie.create!(name:"Monty Python and the Holy Grail", description:"King Arthur and his knights embark on a low-budget search for the Grail, encountering many, very silly obstacles.",
      release_date: Date.new(1975,10,27), cast:"Graham Chapman, John Cleese, Eric Idle, Terry Gilliam, Terry Jones, Michael Palin",
      director: "Terry Gilliam, Terry Jones", studio:"Michael White Productions, National Film Trustee Company", duration:"1h31min", trailer:"https://www.youtube.com/embed/LG1PlkURjxE", avatar:"http://i.imgur.com/7LmqrkM.jpg")

Movie.create!(name:"The AristoCats", description:"With the help of a smooth talking tomcat, a family of Parisian felines set to inherit a fortune from their owner try to make it back home after a jealous butler kidnaps them and leaves them in the country.",
      release_date: Date.new(1971, 12, 17), cast:"Phil Harris, Eva Gabor, Sterling Holloway, Scatman Crothers, Paul Winchell",
      director: "Wolfgang Reitherman", studio:"Walt Disney", duration:"1h18min", trailer:"https://www.youtube.com/embed/scZSFUwgeIM", avatar: "http://i.imgur.com/KEIWBiB.jpg")

Movie.create!(name:"The Little Mermaid", description:"A mermaid princess makes a Faustian bargain with an unscrupulous sea-witch in order to meet a human prince on land.",
      release_date: Date.new(1990,12,21), cast:"Rene Auberjonois, Christopher Daniel Barnes, Jodi Benson, Pat Carrol, Paddi Edwards, Buddy Hackett",
      director: "Ron Clements, John Musker", studio:"Walt Disney", duration:"1h23min", trailer:"https://www.youtube.com/embed/ZGZX5-PAwR8", avatar:"http://i.imgur.com/3LeuKvn.jpg")

Movie.create!(name:"Her", description:"Her is a 2013 American romantic science fiction comedy-drama film written, directed, and produced by Spike Jonze. It marks Jonze's solo screenwriting debut. The film follows Theodore Twombly (Joaquin Phoenix), a man who develops a relationship with Samantha (Scarlett Johansson), an intelligent computer operating system personified through a female voice.",
              release_date: Date.new(2013,10,13), cast:"Joaquin Phoenix, Amy Adams, Rooney Mara, Olivia Wilde, Scarlett Johansson",
              director: "Spike Jonze", studio:"Warner Bros. Pictures", duration:"2h06min", trailer:"https://www.youtube.com/embed/WzV6mXIOVl4", avatar:"http://i.imgur.com/JVbc4ik.jpg")

Movie.create!(name:"Dunkirk", description:"The film tells the story of the Dunkirk evacuation, which took place at the beginning of World War II.",
              release_date: Date.new(2017,7,19), cast:"Tom Hardy, Cillian Murphy, Kenneth Branagh",
              director: "Christopher Nolan", studio:"Warner Bros", duration:"", trailer:"https://www.youtube.com/embed/kes93ngu4lY", avatar:"http://i.imgur.com/5gJPfML.jpg")



### tv shows

Show.create!(name:"Game of Thrones", description:"While a civil war brews between several noble families in Westeros, the children of the former rulers of the land attempt to rise up to power. Meanwhile a forgotten race, bent on destruction, return after thousands of years in the North.",
      release_date: Date.new(2011,4,11), cast:"Peter dinklage, Lena Headey, Emilia Clarke, Kit Harrington, Sophie Turner, Maisie Williams, Nikolaj Coster-Waldau, Alfie Allen, 	Aidan Gillen",
      seasons: 6, duration: "56m", episodes:52, trailer:"https://www.youtube.com/embed/ihKK0PixYAs", avatar:"http://i.imgur.com/KrbvxUh.jpg")

Show.create!(name:"Silicon Valley", description:"In the high-tech gold rush of modern Silicon Valley, the people most qualified to succeed are the least capable of handling success. A comedy partially inspired by Mike Judge's own experiences as a Silicon Valley engineer in the late 1980s.",
      release_date: Date.new(2015,4,6), cast:"Thomas Middleditch, T.J. Miller, Martin Starr, Kumail Nanjiani, Amanda Crew, Zach Woods",
      seasons: 3, duration: "28m", episodes:19, trailer:"https://www.youtube.com/embed/69V__a49xtw", avatar:"http://i.imgur.com/t7tMG8H.jpg")

Show.create!(name:"Breaking Bad", description:"A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine, with his former student, in order to secure his family's financial future.",
      release_date: Date.new(2008,1,20), cast:"Bryan Cranston, Anna Gunn, Aaron Paul, Dean Norris, Betsy Brandt, RJ Mitte",
      seasons: 5, duration: "49m", episodes: 62, trailer:"https://www.youtube.com/embed/HhesaQXLuRY", avatar:"http://i.imgur.com/II9vEgE.jpg")

Show.create!(name:"Fargo", description:"Various chronicles of deception, intrigue and murder in and around frozen Minnesota. Yet all of these tales mysteriously lead back one way or another to Fargo, North Dakota.",
      release_date: Date.new(2014, 4, 15), cast:"Allison Tolman, Collin Hanks, Martin Freeman, Billy Bob Thompson, Kirsten Dunst, Patrick Wilson, Jesse Piemons",
      seasons: 2, duration: "53m", episodes: 20, trailer:"https://www.youtube.com/embed/vXfej6ekBZI", avatar:"http://i.imgur.com/x5pGrYa.jpg")

Show.create!(name:"Narcos", description:"Set and filmed in Colombia, season 1 tells the story of notorious drug kingpin Pablo Escobar, who became a billionaire through the production and distribution of cocaine, while also focusing on Escobar's interactions with drug lords, DEA agents, and various opposition entities.",
             release_date: Date.new(2015, 8, 28), cast:"Wagner Moura, Boyd Holbrook, Pedro Pascal",
             seasons: 1, duration: "50m", episodes: 10, trailer:"https://www.youtube.com/embed/U7elNhHwgBU", avatar:"http://i.imgur.com/9x6ZeJp.jpg")

Show.create!(name:"Westworld", description:"A series inspired by the 1973 film of the same title written by Michael Crichton about a futuristic theme park populated by artificial beings.",
             release_date: Date.new(2015, 10, 2), cast:"Ben Barnes, Ingrid Bolsø Berdal, Clifton Collins Jr.",
             seasons: 0, duration: "60m", episodes: 0, trailer:"https://www.youtube.com/embed/OM8HNuRLIBI", avatar:"http://i.imgur.com/d4OldEH.jpg")
