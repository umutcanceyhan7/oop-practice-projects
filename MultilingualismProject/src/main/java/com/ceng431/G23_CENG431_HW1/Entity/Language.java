package main.java.com.ceng431.G23_CENG431_HW1.Entity;


import main.java.com.ceng431.G23_CENG431_HW1.MultilingualismApplication.LANGUAGES;

import java.util.ArrayList;
import java.util.List;

public class Language {
    private LANGUAGES name;
    List<League> leagues = new ArrayList<>();
    List<Unit> units = new ArrayList<>();
    public Language(LANGUAGES name, List<Unit> units) {
        this.name = name;
        this.units = units;
    }

    public LANGUAGES getName() {
        return name;
    }
    public List<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }
    public List<Unit> getUnits() {
        return units;
    }

    public int getTotalQuizCount(){
        int totalQuizCount = 0;
        for(Unit unit : getUnits()){
            totalQuizCount += unit.getQuizzes().size();
        }
        return totalQuizCount;
    }

    @Override
    public String toString() {
        return "Language{" +
                "name=" + name +
                ", leagues=" + leagues +
                ", units=" + units +
                '}';
    }
}
