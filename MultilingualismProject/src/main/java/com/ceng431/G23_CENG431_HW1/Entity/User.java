package main.java.com.ceng431.G23_CENG431_HW1.Entity;

import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.LANGUAGES;
import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.LEAGUES;

public class User {
    private int currentUnit;
    private int streak;
    private int points;
    private String username;
    private String password;
    private LANGUAGES chosenLanguage;
    private LEAGUES league;
    private int solvedQuizCount;



    public User(int streak, int points, String username, String password, LANGUAGES chosenLanguage, LEAGUES league) {
        this.streak = streak;
        this.points = points;
        this.username = username;
        this.password = password;
        this.chosenLanguage = chosenLanguage;
        this.league = league;
    }

    public int getCurrentUnit() {
        return currentUnit;
    }

    public void setCurrentUnit(int currentUnit) {
        this.currentUnit = currentUnit;
    }

    public int getStreak() {
        return streak;
    }


    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public LANGUAGES getChosenLanguage() {
        return chosenLanguage;
    }
    public LEAGUES getLeague() {
        return league;
    }
    public void setLeague(LEAGUES league) {
        this.league = league;
    }
    public int getSolvedQuizCount() {
        return solvedQuizCount;
    }

    public void setSolvedQuizCount(int solvedQuizCount) {
        this.solvedQuizCount = solvedQuizCount;
    }
    @Override
    public String toString() {
        return "User{" +
                "currentUnit=" + currentUnit +
                ", streak=" + streak +
                ", points=" + points +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", chosenLanguage=" + chosenLanguage +
                ", league=" + league +
                '}';
    }
}
