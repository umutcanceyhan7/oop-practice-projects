package main.java.com.ceng431.G23_CENG431_HW1.Helper;

import main.java.com.ceng431.G23_CENG431_HW1.Entity.Language;
import main.java.com.ceng431.G23_CENG431_HW1.Entity.User;


import java.util.List;

public class Simulation {
    private static final String USERS_FILE = "./src/main/resources/static/users.csv";


    public Simulation(){
    }

    public void run(String... args) throws Exception {
            Helper helper = new Helper();
            User[] usersList = helper.userInitialization(USERS_FILE);
            List<Language> languages = helper.createLanguages();
            helper.createLanguagesFile(languages);
            helper.startTakingQuizSession(usersList, languages);
            helper.updateUsersLeague(usersList, languages);
            helper.createUsersFile(List.of(usersList));
            helper.displayQueries(usersList, languages);

    }
}
