package bullscows;

import java.util.*;
import java.util.stream.Collectors;

public class Grader {
    private final String number;

    public Grader(int length, int symbols) {
        this.number = getRandomNumber(length, symbols);
    }

    private String getRandomNumber(int length, int symbols) {
        Random rng = new Random();
        String str = "0123456789abcdefghijklmnopqrstuvwxyz";

        Set<Character> generated = new LinkedHashSet<>();
        while (generated.size() < length)
        {
            int next = rng.nextInt(symbols);
            generated.add(str.charAt(next));
        }

        return generated.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public int getCows(String guess) {
        int cows = 0;
        for (int i = 0; i < guess.length(); i++) {
            for (int j = 0; j < guess.length(); j++) {
                if (this.number.charAt(j) == guess.charAt(i) && i != j) {
                    cows++;
                }
            }
        }
        return cows;
    }

    public int getBulls(String guess) {
        int bulls = 0;
        for (int i = 0; i < guess.length(); i++) {
            for (int j = 0; j < guess.length(); j++) {
                if (this.number.charAt(j) == guess.charAt(i) && i == j) {
                    bulls++;
                }
            }
        }
        return bulls;
    }

    public String buildGrade(String guess) {
        int cows = getCows(guess);
        int bulls = getBulls(guess);

        StringBuilder result = new StringBuilder();
        String bull = String.format("%d %s", bulls, pluralize(bulls, "bull", "bulls"));
        String cow = String.format("%d %s", cows, pluralize(cows, "cow", "cows"));

        if (bulls > 0 && cows > 0) {
            result.append(bull);
            result.append(" and ");
            result.append(cow);
        } else if (bulls > 0 && cows == 0) {
            result.append(bull);
        } else if (bulls == 0 && cows > 0) {
            result.append(cow);
        } else {
            result.append("None");
        }

        return result.toString();
    }

    private String pluralize(int num, String single, String plural) {
        return num == 1 ? single : plural;
    }

}
