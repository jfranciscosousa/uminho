# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rake db:seed (or created alongside the db with db:setup).

##### Albums

Album.create(name: 'The Life of Pablo', description:"The Life of Pablo is the seventh studio album by American rapper Kanye West. It was released on February 14, 2016, by Roc-A-Fella Records, GOOD Music and Def Jam Recordings.",
      release_date: Date.new(2016,2,14), duration: '59:44', artist: 'Kanye West',
      producer: 'Rick Rubin', studio: 'Windmark Studios',
      features:'Chance the Rapper, Ty Dolla $ign, Kendrick Lamar, Chris Brown, The Weeknd')

Album.create(name: 'Abbey Road', description: "Abbey Road is the 11th studio album by the English rock band the Beatles, released on 26 September 1969 by Apple Records. The recording sessions for the album were the last in which all four Beatles participated. Although \"Let It Be\" was the final album that the Beatles completed before the band's dissolution in April 1970, most of the album had been recorded before the Abbey Road sessions began.",
      release_date: Date.new(1969,9,26), duration:"47:23", artist:'The Beatles', producer: "George Martin",
      studio: "EMI, Olympic and Trident Studios", features:"")

Album.create(name: "Rage Against the Machine", description:"Rage Against the Machine is the debut studio album by American rap metal band Rage Against the Machine. The album was released on November 3, 1992. It went to #1 on the Billboard Heatseekers chart, and #45 on the Billboard 200 chart.",
      release_date: Date.new(1992,11,3), duration:"52:52", artist:"Rage Against the Machine", producer:"Garth Richardson",
      studio:"Sound City, Scream Studios, Industrial Recording", features:"Maynard James Keenan, Stephen Perkins")

Album.create(name: 'Violence Begets Violence', description:"Violence Begets Violence is the seventh studio album by underground Philadelphia hip hop duo Jedi Mind Tricks. This is their only album to not feature production from Stoupe the Enemy of Mankind because \"his heart wasn't into making JMT records anymore\" as well as the fact that both Vinnie Paz and Jus Allah grew tired of waiting. Two singles were released, \"Target Practice\" and \"When Crows Descend Upon You,\" for which a video has been made. In addition, Shuko remixed the song \"Target Practice\".",
      release_date: Date.new(2011, 10, 25), duration:"46:54", artist:"Jedi Mind Tricks",
      producer: "C-Lance, DJ Kwestion, Grand Finale, Hypnotist Beats, Illinformed, Junior Makno, Mr. Green, Nero, Scott Stallone, Shuko",
      studio: "	Enemy Soil", features: "Demoz, Blacastan, King Magnetic, Young Zee & Pacewon and Chip Fu")

##### games

Game.create(name:"Mario Kart 8", description:"Mario Kart 8 is a 2014 kart racing game and the eighth major installment in the Mario Kart series, developed and published by Nintendo for the Wii U video game console. First announced at E3 2013, the game was released worldwide in late May 2014.",
      release_date: Date.new(2014,5,30), platform: "Wii U", studio:"Nintendo")

Game.create(name:"Dark Souls 3", description:"Dark Souls III is an action role-playing video game developed by FromSoftware and published by Bandai Namco Entertainment for PlayStation 4, Xbox One, and Microsoft Windows. The fourth entry in the Souls series, Dark Souls III was released in Japan in March 2016, and worldwide in April 2016.",
      release_date: Date.new(2016,4,12), platform: "PS4, Xbox One", studio:"FromSoftware")

Game.create(name:"The Witcher 3: Wild Hunt", description:"The Witcher 3: Wild Hunt is a dark fantasy open-world action role-playing video game developed by CD Projekt RED.[5] Announced in February 2013, it was released worldwide for Microsoft Windows, PlayStation 4, and Xbox One on 19 May 2015. The game is the third in the series, preceded by The Witcher and The Witcher 2: Assassins of Kings, which are based on the series of fantasy novels by Polish author Andrzej Sapkowski.",
      release_date: Date.new(2015,5,19), platform: "PS4, Xbox One", studio:"CD Projekt Red")

Game.create(name:"Fifa 16", description:"FIFA 16 is an association football simulation video game developed by EA Canada and published by EA Sports for Microsoft Windows, Xbox One, PlayStation 4.",
      release_date: Date.new(2015,9,24), platform: "PS4, Xbox One", studio:"EA Sports")




#### movies

Movie.create(name:"2001: Space Odissey", description:"Humanity finds a mysterious, obviously artificial object buried beneath the Lunar surface and, with the intelligent computer H.A.L. 9000, sets off on a quest.",
      release_date: Date.new(1968,10,1), cast:"Keir Dullea, Gary Lockwood, William Sylvester, Daniel Richter, Leonard Rossiter, Margaret Tyzack",
      director: "Stanley Kubrick", studio:"MGM", duration:"2h29min")

Movie.create(name:"Monty Python and the Holy Grail", description:"King Arthur and his knights embark on a low-budget search for the Grail, encountering many, very silly obstacles.",
      release_date: Date.new(1978,10,27), cast:"Graham Chapman, John Cleese, Eric Idle, Terry Gilliam, Terry Jones, Michael Palin",
      director: "Terry Gilliam, Terry Jones", studio:"Michael White Productions, National Film Trustee Company", duration:"1h31min")

Movie.create(name:"The AristoCats", description:"With the help of a smooth talking tomcat, a family of Parisian felines set to inherit a fortune from their owner try to make it back home after a jealous butler kidnaps them and leaves them in the country.",
      release_date: Date.new(1971, 12, 17), cast:"Phil Harris, Eva Gabor, Sterling Holloway, Scatman Crothers, Paul Winchell",
      director: "Wolfgang Reitherman", studio:"Walt Disney", duration:"1h18min")

Movie.create(name:"The Little Mermaid", description:"A mermaid princess makes a Faustian bargain with an unscrupulous sea-witch in order to meet a human prince on land.",
      release_date: Date.new(1990,12,21), cast:"Rene Auberjonois, Christopher Daniel Barnes, Jodi Benson, Pat Carrol, Paddi Edwards, Buddy Hackett",
      director: "Ron Clements, John Musker", studio:"Walt Disney", duration:"1h23min")


### tv shows

Show.create(name:"Game of Thrones", description:"While a civil war brews between several noble families in Westeros, the children of the former rulers of the land attempt to rise up to power. Meanwhile a forgotten race, bent on destruction, return after thousands of years in the North.",
      release_date: Date.new(2011,4,11), cast:"Peter dinklage, Lena Headey, Emilia Clarke, Kit Harrington, Sophie Turner, Maisie Williams, Nikolaj Coster-Waldau, Alfie Allen, 	Aidan Gillen",
      seasons: 6, duration: 56, episodes:52)

Show.create(name:"Silicon Valley", description:"In the high-tech gold rush of modern Silicon Valley, the people most qualified to succeed are the least capable of handling success. A comedy partially inspired by Mike Judge's own experiences as a Silicon Valley engineer in the late 1980s.",
      release_date: Date.new(2015,4,6), cast:"Thomas Middleditch, T.J. Miller, Martin Starr, Kumail Nanjiani, Amanda Crew, Zach Woods",
      seasons: 3, duration: 28, episodes:19)

Show.create(name:"Breaking Bad", description:"A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine, with his former student, in order to secure his family's financial future.",
      release_date: Date.new(2008,1,20), cast:"Bryan Cranston, Anna Gunn, Aaron Paul, Dean Norris, Betsy Brandt, RJ Mitte",
      seasons: 5, duration: 49, episodes: 62)

Show.create(name:"Fargo", description:"Various chronicles of deception, intrigue and murder in and around frozen Minnesota. Yet all of these tales mysteriously lead back one way or another to Fargo, North Dakota.",
      release_date: Date.new(2014, 4, 15), cast:"Allison Tolman, Collin Hanks, Martin Freeman, Billy Bob Thompson, Kirsten Dunst, Patrick Wilson, Jesse Piemons",
      seasons: 2, duration: 53, episodes: 20)
