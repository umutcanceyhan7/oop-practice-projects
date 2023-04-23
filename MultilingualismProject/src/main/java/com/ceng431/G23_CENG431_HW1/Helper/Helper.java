package main.java.com.ceng431.G23_CENG431_HW1.Helper;

import main.java.com.ceng431.G23_CENG431_HW1.Builder.*;
import main.java.com.ceng431.G23_CENG431_HW1.Entity.*;
import main.java.com.ceng431.G23_CENG431_HW1.IO.CSVReader;
import main.java.com.ceng431.G23_CENG431_HW1.IO.CSVWriter;
import main.java.com.ceng431.G23_CENG431_HW1.IO.ICSVReader;
import main.java.com.ceng431.G23_CENG431_HW1.IO.ICSVWriter;
import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.LEAGUES;
import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.LANGUAGES;
import main.java.com.ceng431.G23_CENG431_HW1.Service.*;

import java.io.IOException;
import java.util.*;

public class Helper {
    private final RandomBuilder random;
    private final int MIN_QUIZ_COUNT = 6;
    Comparator<Integer> compareTo = Comparator.naturalOrder();
    private ICSVReader reader;
    private ICSVWriter writer;
    private ILanguageService languageService;


    public Helper() {
        ICSVReader reader = new CSVReader();
        ICSVWriter writer = new CSVWriter();

        // Create Builders
        IQuestionService questionService = new QuestionBuilder();
        IQuizService quizService = new QuizBuilder(questionService);
        IUnitService unitService = new UnitBuilder(quizService);
        ILeagueService leagueService = new LeagueBuilder();
        ILanguageService languageBuilder = new LanguageBuilder(unitService, leagueService);


        this.reader = reader;
        this.writer = writer;
        this.random = new RandomBuilder();
        this.languageService = languageBuilder;

    }

    // Initialize Users, save them to the DB then return the Users Array
    public User[] userInitialization(String file) throws IOException {
        // Users information are stored in a list of list string for initialization
        List<List<String>> usersInformationArray = reader.readFile(file, ';');
        // Users Array created to store Items
        User[] usersArray = new User[usersInformationArray.size()];

        // Random and User Builder Listings
        IRandomService random = new RandomBuilder();
        UserBuilder userBuilder = new UserBuilder(random);

        // Users are created by using a tempUser and stored in a different array
        for (int i = 0; i < usersInformationArray.size(); i++) {
            User tempUser = userBuilder.createUser(usersInformationArray.get(i).get(0), usersInformationArray.get(i).get(1));

            // User has put to the usersArray
            usersArray[i] = tempUser;
        }
        return usersArray;
    }

    public List<Language> createLanguages() {
        // Prepare data boundaries
        List<Language> languages = new ArrayList<>(LANGUAGES.values().length);

        // Create language entities
        for (LANGUAGES language : LANGUAGES.values()) {
            languages.add(this.languageService.createLanguage(language));
        }
        return languages;
    }

    public void createLanguagesFile(List<Language> languagesList) {
        // Languages CSV File Creation
        List<String[]> data = createLanguagesFileData(languagesList);
        // Create CSV File If Not Exist
        writer.createCSVFile("languages.csv", data);
    }
    public void createUsersFile(List<User> usersList) {
        // Languages CSV File Creation
        List<String[]> data = createUsersFileData(usersList);
        // Create CSV File If Not Exist
        writer.createCSVFile("users.csv", data);

    }
    private List<String[]> createUsersFileData(List<User> usersList){
        List<String[]> data = new ArrayList<>();
        for (User user : usersList) {
            List<String> tempUserData = new ArrayList<>();
            // User Information
            tempUserData.add(user.getUsername());
            tempUserData.add(user.getPassword());
            tempUserData.add(user.getChosenLanguage().name());
            tempUserData.add(String.valueOf(user.getCurrentUnit()));
            tempUserData.add(String.valueOf(user.getSolvedQuizCount()));

            // Add a complete user data
            data.add(tempUserData.toArray(new String[0]));
        }
        return data;
    }
    private List<String[]> createLanguagesFileData(List<Language> languagesList) {
        List<String[]> data = new ArrayList<>();
        for (Language language : languagesList) {
            List<String> tempLanguageData = new ArrayList<>();
            // Language Name
            String tempLanguageName = language.getName().name();
            tempLanguageData.add(tempLanguageName);
            // Units
            List<Unit> tempUnits = language.getUnits();
            for (Unit unit : tempUnits) {
                // Write Unit with its number
                tempLanguageData.add("Unit " + unit.getUnitNumber());

                // Quizzes
                List<Quiz> tempQuizzes = unit.getQuizzes();
                for (Quiz quiz : tempQuizzes) {
                    // Write Quiz with its number
                    tempLanguageData.add("Quiz " + quiz.getQuizNumber());

                    // Questions
                    List<Question> tempQuestions = quiz.getQuestions();
                    // Question Type Counts
                    tempLanguageData.add(calculateQuestionTypeCounts(tempQuestions));
                }
            }
            // Add a complete language data
            data.add(tempLanguageData.toArray(new String[0]));
        }
        return data;
    }

    private String calculateQuestionTypeCounts(List<Question> questions) {
        // R count
        int rCount = 0;
        // L count
        int lCount = 0;
        // S count
        int sCount = 0;
        // W count
        int wCount = 0;
        for (Question question : questions) {
            switch (question.getQuestionType()) {
                case ("R"):
                    rCount++;
                    break;
                case ("L"):
                    lCount++;
                    break;
                case ("S"):
                    sCount++;
                    break;
                case ("W"):
                    wCount++;
                    break;
                default:
                    break;
            }
        }
        // Create count list
        List<String> questionTypeCounts = new ArrayList<>();
        if (rCount != 0) {
            questionTypeCounts.add(String.valueOf(rCount) + "R");
        }
        if (lCount != 0) {
            questionTypeCounts.add(String.valueOf(lCount) + "L");
        }
        if (sCount != 0) {
            questionTypeCounts.add(String.valueOf(sCount) + "S");
        }
        if (wCount != 0) {
            questionTypeCounts.add(String.valueOf(wCount) + "W");
        }
        return String.join(":", questionTypeCounts);

    }

    public void startTakingQuizSession(User[] usersArray, List<Language> languagesList) {
        List<User> usersList = Arrays.stream(usersArray).toList();
        for (User user : usersList) {
            takeQuiz(user, languagesList);
        }
    }

    public void takeQuiz(User user, List<Language> languageList) {
        for (Language language : languageList) {
            // If chosen language matches
            if (user.getChosenLanguage().name() == language.getName().name()) {
                int takenQuizCount = random.createRandomInt(language.getTotalQuizCount() - MIN_QUIZ_COUNT) + MIN_QUIZ_COUNT;
                user.setCurrentUnit(calculateCurrentUnit(takenQuizCount, language));
                user.setPoints(calculatePointsForUser(takenQuizCount, language));
                user.setSolvedQuizCount(takenQuizCount);
                return;
            }
        }
    }

    // It calculates the points of the user according to taken quiz count
    private int calculatePointsForUser(int takenQuizCount, Language language) {
        List<Unit> units = language.getUnits();
        int remainingQuizCount = takenQuizCount;
        int currentPoints = 0;
        for (Unit unit : units) {
            List<Quiz> currentUnitsQuizList = unit.getQuizzes();
            int currentUnitsQuizCount = unit.getQuizzes().size();
            if (currentUnitsQuizCount < remainingQuizCount) {
                remainingQuizCount = remainingQuizCount - currentUnitsQuizCount;

                for (Quiz tempQuiz : currentUnitsQuizList) {
                    List<Question> currentQuizzesQuestionList = tempQuiz.getQuestions();
                    for (Question tempQuestion : currentQuizzesQuestionList) {
                        if (random.createRandomBoolean()) {
                            currentPoints += tempQuestion.getPoints();
                        }
                    }
                }
            } else {
                for (int i = 0; i < remainingQuizCount; i++) {

                    List<Question> currentQuizzesQuestionList = currentUnitsQuizList.get(i).getQuestions();
                    for (Question tempQuestion : currentQuizzesQuestionList) {
                        if (random.createRandomBoolean()) {
                            currentPoints += tempQuestion.getPoints();
                        }
                    }
                }
                remainingQuizCount = 0;
                return currentPoints;
            }
        }
        return currentPoints;
    }

    // It calculates the current unit according to taken quiz count
    private int calculateCurrentUnit(int takenQuizCount, Language language) {
        List<Unit> units = language.getUnits();
        int currentUnit = 1;
        for (Unit unit : units) {
            int currentUnitsQuizCount = unit.getQuizzes().size();
            if (currentUnitsQuizCount < takenQuizCount) {
                takenQuizCount = takenQuizCount - currentUnitsQuizCount;
                currentUnit++;
            }
        }
        return currentUnit;
    }

    // It assigns users to their current league then checks for league update situations.
    public List<User> updateUsersLeague(User[] usersList, List<Language> languages) {
        // Assign each user to their current league in this loop
        for (User user : usersList) {
            List<League> chosenLanguageLeagues = null;
            Language userLanguage = null;
            for (Language language : languages) {
                if (language.getName().name() == user.getChosenLanguage().name()) {
                    chosenLanguageLeagues = language.getLeagues();
                    userLanguage = language;
                }
            }

            // Assign user to current league
            for (League league : chosenLanguageLeagues) {
                if (league.getName().name() == user.getLeague().name()) {
                    // Get old list
                    List<User> tempUserList = league.getUsers();
                    // Add current user
                    tempUserList.add(user);
                    // Update the list
                    league.setUsers(tempUserList);
                    // Update the language league
                    userLanguage.setLeagues(chosenLanguageLeagues);
                    break;
                }
            }
        }

        // Control and if needed change league
        findAdvancedPlayersInLeagues(languages);

        return List.of(usersList);
    }

    // It finds players that need to advance upper league or leagues
    private void findAdvancedPlayersInLeagues(List<Language> languages) {
        for (Language language : languages) {
            List<League> leagues = language.getLeagues();
            for (League league : leagues) {
                int indexBoundary = 0;
                List<League> updatedLeagues = null;
                switch (league.getName()) {
                    // List of rules
                    // Bronze Rules
                    // To advance to the Silver League, he/she must be
                    // in the top 15 of the points ranking!
                    case Bronze:
                        List<User> tempBronzeUsersList = league.getUsers();
                        sortUsersByPoints(tempBronzeUsersList);
                        if (tempBronzeUsersList.isEmpty()) {
                            return;
                        }
                        indexBoundary = 15;
                        if (tempBronzeUsersList.size() < 15) {
                            indexBoundary = tempBronzeUsersList.size();
                        }

                        for (int index = 1; index <= indexBoundary; index++) {
                            User tempUser = tempBronzeUsersList.get(tempBronzeUsersList.size() - 1);
                            updatedLeagues = updateUserLeague(tempUser, leagues, LEAGUES.Bronze, LEAGUES.Silver);
                        }
                        language.setLeagues(updatedLeagues);
                        break;
                    // To advance to the Golden League, user must be
                    // in the top 10 of the points rankings!
                    case Silver:
                        List<User> tempSilverUsersList = league.getUsers();
                        sortUsersByPoints(tempSilverUsersList);
                        if (tempSilverUsersList.isEmpty()) {
                            return;
                        }
                        indexBoundary = 10;
                        if (tempSilverUsersList.size() < 10) {
                            indexBoundary = tempSilverUsersList.size();
                        }
                        for (int index = 1; index <= indexBoundary; index++) {
                            User tempUser = tempSilverUsersList.get(tempSilverUsersList.size() - 1);
                            updatedLeagues = updateUserLeague(tempUser, leagues, LEAGUES.Silver, LEAGUES.Gold);
                        }
                        language.setLeagues(updatedLeagues);
                        break;
                    // Gold Rules
                    // To advance to the Sapphire League, he/she must have
                    // at least a streak of 7 days
                    // and is in the top 5 of the point rankings.
                    case Gold:
                        List<User> tempGoldUsersList = league.getUsers();
                        sortUsersByPoints(tempGoldUsersList);
                        if (tempGoldUsersList.isEmpty()) {
                            return;
                        }
                        indexBoundary = 5;
                        if (tempGoldUsersList.size() < 5) {
                            indexBoundary = tempGoldUsersList.size();
                        }
                        for (int index = 1; index <= indexBoundary; index++) {
                            User tempUser = tempGoldUsersList.get(tempGoldUsersList.size() - 1);
                            if (tempUser.getStreak() >= 7) {
                                updatedLeagues = updateUserLeague(tempUser, leagues, LEAGUES.Gold, LEAGUES.Sapphire);
                            }
                        }
                        language.setLeagues(updatedLeagues);
                        break;
                    // Sapphire Rules
                    //  To be advanced to the Ruby League, user must have
                    //  at least a streak of 30 days
                    //  and collect more than 5000 points
                    //  or be in at least Unit 10 of the selected language.
                    case Sapphire:
                        List<User> tempSapphireUsersList = league.getUsers();
                        sortUsersByPoints(tempSapphireUsersList);
                        if (tempSapphireUsersList.isEmpty()) {
                            return;
                        }
                        for (int index = 0; index < tempSapphireUsersList.size(); index++) {
                            User user = tempSapphireUsersList.get(index);
                            if ((user.getStreak() >= 30 && user.getPoints() > 5000) || (user.getCurrentUnit() >= 10)) {
                                updatedLeagues = updateUserLeague(user, leagues, LEAGUES.Sapphire, LEAGUES.Ruby);
                            }
                        }
                        language.setLeagues(updatedLeagues);
                        break;
                }
            }
        }
    }
    // It updates current users league with new one
    private List<League> updateUserLeague(User user, List<League> leagues, LEAGUES oldLeague, LEAGUES newLeague) {
        // Update User Entity
        user.setLeague(newLeague);

        // Update Old League Entity
        List<User> oldList = leagues.get(oldLeague.ordinal()).getUsers();
        oldList.remove(user);
        leagues.get(oldLeague.ordinal()).setUsers(oldList);

        // Update New League Entity
        List<User> newList = leagues.get(newLeague.ordinal()).getUsers();
        newList.add(user);
        leagues.get(newLeague.ordinal()).setUsers(newList);

        return leagues;
    }

    // Sorting operations are made here
    private void sortUsersByPoints(List<User> userList) {
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return Integer.compare(user1.getPoints(), user2.getPoints());
            }
        });
    }

    private void sortUsersByUnitCounts(List<User> userList) {
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return Integer.compare(user1.getCurrentUnit(), user2.getCurrentUnit());
            }
        });
    }

    private void sortLanguagesByUnitCounts(List<Language> languageList) {
        Collections.sort(languageList, new Comparator<Language>() {
            @Override
            public int compare(Language language1, Language language2) {
                return Integer.compare(language1.getUnits().size(), language2.getUnits().size());
            }
        });
    }
    private void sortLanguagesByQuizCounts(List<Language> languageList) {
        Collections.sort(languageList, new Comparator<Language>() {
            @Override
            public int compare(Language language1, Language language2) {
                return Integer.compare(language1.getTotalQuizCount(), language2.getTotalQuizCount());
            }
        });
    }
    public void displayQueries(User[] userList, List<Language> languageList){
        List<User> tempUserList = Arrays.asList(userList);
        List<User> newUserList = new ArrayList<>(tempUserList);
        findUserHasMaximumPoints(newUserList);
        findUserMostAdvancedInALanguage(newUserList, LANGUAGES.German);
        findLanguageHasMaximumUnits(languageList);
        findLanguageHasMaximumQuizCount(languageList);
        findSpecifiedAmountOfUserOfALanguage(3, newUserList, LANGUAGES.Italian, LEAGUES.Silver);
    }
    private void findUserHasMaximumPoints(List<User> userList){
        sortUsersByPoints(userList);
        User user = userList.get(userList.size() -1);
        System.out.println("1- " + user.getUsername() + " " + user.getPoints() + " points");
    }
    private void findUserMostAdvancedInALanguage(List<User> userList, LANGUAGES language){
        List<User> subList = new ArrayList<>();
        for(User user : userList){
            if(user.getChosenLanguage().name() == language.name()){
                subList.add(user);
            }
        }
        sortUsersByUnitCounts(subList);
        User user = subList.get(subList.size() -1);
        System.out.println("2- " + user.getUsername() + " Unit " + user.getCurrentUnit());
    }
    private void findLanguageHasMaximumUnits(List<Language> languageList){
        sortLanguagesByUnitCounts(languageList);
        Language language = languageList.get(languageList.size() -1);
        System.out.println("3- " + language.getName().name() + " " + language.getUnits().size() + " Units");
    }
    private void findLanguageHasMaximumQuizCount(List<Language> languageList){
        sortLanguagesByQuizCounts(languageList);
        Language language = languageList.get(languageList.size() -1);
        System.out.println("4- " + language.getName().name() + " " + language.getTotalQuizCount() + " Quizzes");
    }
    private void findSpecifiedAmountOfUserOfALanguage(int userCount, List<User> userList, LANGUAGES language, LEAGUES league){
        List<User> subList = new ArrayList<>();
        for(User user : userList){
            if(user.getChosenLanguage().name() == language.name()){
                if(user.getLeague().name() == league.name()){
                    subList.add(user);
                }
            }
        }
        sortUsersByPoints(subList);
        String userNamesWithPlacementNumbers = "";
        // Out of bounds check
        if(subList.size() < userCount){
            userCount = subList.size();
        }
        for (int index = 1; index <= userCount; index++) {
            User user = subList.get(subList.size() - index);
            userNamesWithPlacementNumbers +=  index + "." + user.getUsername() + " ";
        }
        System.out.println("5- " + language + " " + league + " League Top " + userCount + ": " +userNamesWithPlacementNumbers);
    }
}
