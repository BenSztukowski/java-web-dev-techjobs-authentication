package org.launchcode.javawebdevtechjobsauthentication.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity{

    private String username;

    private String pwhash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User(){}

    public User(String username, String password) {
        this.username = username;
        this.pwhash = encoder.encode(password);

    }

    public boolean isMatchingPassword(String password){
        return encoder.matches(password, pwhash);
    }

    public String getUsername() {
        return username;
    }
}

