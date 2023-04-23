package main.java.com.ceng431.G23_CENG431_HW1.Builder;

import main.java.com.ceng431.G23_CENG431_HW1.Entity.Audio;
import main.java.com.ceng431.G23_CENG431_HW1.Service.IRandomService;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomBuilder implements IRandomService {
    private Random random;
    public RandomBuilder(){
        this.random = new Random();
    }
    public int createRandomInt(int lowerBound, int upperBound) {
        return random.nextInt(lowerBound, upperBound);
    }
    public int createRandomInt(int upperBound) {
        return random.nextInt(upperBound);
    }
    public Audio createRandomAudio(int secondsBound) {
        int tempSeconds = random.nextInt(secondsBound);
        return new Audio(tempSeconds);
    }
    public String createRandomString(int stringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = stringLength;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
        return generatedString;
    }
    public Map<String, String> createRandomStringMap(int wordCount) {
        Map<String, String> tempMap = new HashMap<>();
        int tempWordMatchingCount = random.nextInt(wordCount);
        for (int i = 0; i < tempWordMatchingCount; i++) {
            tempMap.putIfAbsent(createRandomString(random.nextInt(10)), createRandomString(random.nextInt(10)));
        }
        return tempMap;
    }
    public boolean createRandomBoolean(){
        return random.nextInt() % 2 == 0 ? true : false;
    }
}
