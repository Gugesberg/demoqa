package utils;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;


public class RandomData {
    public static int getRandomInt(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to +1);
    }
    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        int index = getRandomInt(0, genders.length - 1);
        return genders[index];
    }
    public static String getRandomHobbie() {
        String[] hobbies = {"Sports", "Music", "Reading"};
        int index = getRandomInt(0, hobbies.length - 1);
        return hobbies[index];
    }
    public static String getRandomSubjects() {
        String[] subjects = {"English", "Biology", "Hindi","Chemistry","History","Physics","Maths"};
        int index = getRandomInt(0, subjects.length - 1);
        return subjects[index];
    }
    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        int index = getRandomInt(0, months.length - 1);
        return months[index];
    }
    public static String getRandomDay() {
        int firsDay = 1;
        int lastDay = 29;
        int[] days = IntStream.rangeClosed(firsDay, lastDay).toArray();
        int index = getRandomInt(0, days.length - 1);
        String result = String.valueOf(days[index]);
        return result;
    }
    public static String getRandomYear() {
        int firsYear = 1970;
        int currentYear = LocalDate.now().getYear();;
        int[] years = IntStream.rangeClosed(firsYear, currentYear).toArray();
        int index = getRandomInt(0, years.length - 1);
        String result = String.valueOf(years[index]);
        return result;
    }
}

