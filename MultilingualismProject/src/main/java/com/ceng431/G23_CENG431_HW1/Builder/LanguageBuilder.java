package main.java.com.ceng431.G23_CENG431_HW1.Builder;

import main.java.com.ceng431.G23_CENG431_HW1.Entity.Language;
import main.java.com.ceng431.G23_CENG431_HW1.Entity.League;
import main.java.com.ceng431.G23_CENG431_HW1.Entity.Unit;
import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.LEAGUES;
import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.LANGUAGES;
import main.java.com.ceng431.G23_CENG431_HW1.Service.ILanguageService;
import main.java.com.ceng431.G23_CENG431_HW1.Service.ILeagueService;
import main.java.com.ceng431.G23_CENG431_HW1.Service.IUnitService;

import java.util.ArrayList;
import java.util.List;

public class LanguageBuilder implements ILanguageService {

    private final IUnitService unitService;
    private final ILeagueService leagueService;
    private int MAX_UNIT_COUNT = 100;
    private int MIN_UNIT_COUNT = 60;
    private RandomBuilder random = new RandomBuilder();

    public LanguageBuilder(IUnitService unitService, ILeagueService leagueService) {
        this.unitService = unitService;
        this.leagueService = leagueService;
    }

    public Language createLanguage(LANGUAGES name){
        // Create Units
        int tempUnitCount = random.createRandomInt(MAX_UNIT_COUNT - MIN_UNIT_COUNT) + MIN_UNIT_COUNT; // Between 60-100
        List<Unit> units = new ArrayList<>();
        for (int unitNumber = 0; unitNumber < tempUnitCount; unitNumber++) {
            Unit tempUnit = unitService.createUnit(unitNumber + 1);
            units.add(tempUnit);
        }
        // Create Language
        Language tempLanguage = new Language(name, units);

        // Create Leagues
        List<League> leagues = new ArrayList<>();
        // Assign leagues to language
        for (LEAGUES league : LEAGUES.values()) {
            leagues.add(leagueService.createLeague(league, tempLanguage));
        }
        tempLanguage.setLeagues(leagues);
        return tempLanguage;
    }
}
