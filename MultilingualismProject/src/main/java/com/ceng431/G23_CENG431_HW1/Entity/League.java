package main.java.com.ceng431.G23_CENG431_HW1.Entity;

import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.LEAGUES;

import java.util.ArrayList;
import java.util.List;

public class League {
    private LEAGUES name;

    private Language language;
    private List<User> users = new ArrayList<>();

    public League(LEAGUES name, Language language) {
        this.name = name;
        this.language = language;
    }

    public LEAGUES getName() {
        return name;
    }

    public void setName(LEAGUES name) {
        this.name = name;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
