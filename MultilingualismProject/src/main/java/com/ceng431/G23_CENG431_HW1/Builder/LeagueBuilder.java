package main.java.com.ceng431.G23_CENG431_HW1.Builder;

import main.java.com.ceng431.G23_CENG431_HW1.Entity.Language;
import main.java.com.ceng431.G23_CENG431_HW1.Entity.League;
import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.LEAGUES;
import main.java.com.ceng431.G23_CENG431_HW1.Service.ILeagueService;

public class LeagueBuilder implements ILeagueService {
    public League createLeague(LEAGUES name, Language language){
        League league = new League(name,language);

        return league;
    }
}
