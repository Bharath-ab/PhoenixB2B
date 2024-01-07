package utils;

import java.util.Random;
import java.util.UUID;

public class TestUtil {
    public static String generateString(int lengthOfString) {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-","").toUpperCase().substring(0,lengthOfString);
    }

    public static String generateNumber(int length) {
        Random random = new Random();
        long nextLong = Math.abs(random.nextLong());
        return String.valueOf(nextLong).substring(0, length);
    }
}
