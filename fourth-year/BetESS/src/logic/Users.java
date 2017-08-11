/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.HashMap;
import java.util.Map;
import logic.exceptions.UserNotRegistered;

/**
 *
 * @author joses
 */
class Users {

    private Map<String, User> users;

    /**
     *
     */
    Users() {
        this.users = new HashMap<>();
    }

    void registerUser(String name, String email, String password, float balance) {
        this.users.put(email, new User(name, email, password, balance));
    }

    void registerBookie(String name, String email, String password, float balance) {
        this.users.put(email, new Bookie(name, email, password, balance));
    }

    User authenticateUser(String email, String password) throws UserNotRegistered {
        User user = users.get(email);
        if (user == null) {
            throw new UserNotRegistered("User not registered!");
        } else {
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        }
    }

    User getUser(String email) {
        return users.get(email);
    }

}
