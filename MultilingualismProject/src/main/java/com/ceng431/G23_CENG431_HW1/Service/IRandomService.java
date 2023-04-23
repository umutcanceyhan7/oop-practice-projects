package main.java.com.ceng431.G23_CENG431_HW1.Service;

import main.java.com.ceng431.G23_CENG431_HW1.Entity.Audio;

import java.util.Map;

public interface IRandomService {
    int createRandomInt(int lowerBound, int upperBound);
    int createRandomInt(int upperBound);
    String createRandomString(int stringBound);
    Audio createRandomAudio(int secondsBound);
    Map<String, String> createRandomStringMap(int wordBound);
    boolean createRandomBoolean();
}
