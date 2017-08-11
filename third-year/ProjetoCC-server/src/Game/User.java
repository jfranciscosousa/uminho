/* 
 * Copyright (C) 2015 José Sousa & Nuno Carvalho
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Game;

/**
 *
 * @author José
 */
public class User {

    private final String name;
    private final String nick;
    private final String password;
    private int scoreGlobal;

    public User(String name, String nick, String password) {
        this.name = name;
        this.nick = nick;
        this.password = password;
        this.scoreGlobal = 0;
    }

    public String getName() {
        return name;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public int getScoreGlobal() {
        return scoreGlobal;
    }

    public void addScoreGlobal(int scoreGlobal) {
        this.scoreGlobal += scoreGlobal;
    }

    public void setScoreGlobal(int scoreGlobal) {
        this.scoreGlobal = scoreGlobal;
    }
}
