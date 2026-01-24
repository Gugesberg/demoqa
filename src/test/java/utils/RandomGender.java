package utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGender {
    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }
    public static int getRandomInt(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to +1);
    }

}

