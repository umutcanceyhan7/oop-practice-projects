package main.java.com.ceng431.G23_CENG431_HW1.Builder;

import main.java.com.ceng431.G23_CENG431_HW1.Entity.*;
import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.LANGUAGES;
import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.LEAGUES;
import main.java.com.ceng431.G23_CENG431_HW1.Service.IRandomService;
import main.java.com.ceng431.G23_CENG431_HW1.Service.IUserService;

public class UserBuilder implements IUserService {
    private final int MAX_POINTS = 100;
    private final int MAX_STREAK = 365;
    private IRandomService random;

    public UserBuilder(IRandomService random) {
        this.random = random;
    }

    public User createUser(String username, String password) {
        // Random integers are initialized
        int tempPoints = random.createRandomInt(MAX_POINTS);
        int tempStreak = random.createRandomInt(MAX_STREAK);
        LANGUAGES tempRandomLanguage = LANGUAGES.chooseRandomLanguage();
        LEAGUES tempRandomLeague = LEAGUES.Bronze;
        // Return entity
        return new User(tempStreak, tempPoints, username, password, tempRandomLanguage, tempRandomLeague);
    }


}
