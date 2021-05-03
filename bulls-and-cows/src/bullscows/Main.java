package bullscows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the  secret code:");
        int length = 0;
        String str = scanner.nextLine();
        try {
            length = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.printf("Error \"%s\" isn't a valid number", str);
            System.exit(1);
        }

        if (length < 1 || length > 36) {
            System.out.printf("Error: can't generate a secret number with a length of %d because there aren't enough unique digits.\n", length);
            System.exit(1);
        }

        System.out.println("Input the number of possible  symbols in the code:");
        int symbols = 0;
        str = scanner.nextLine();
        try {
            symbols = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.printf("Error \"%s\" isn't a valid number", str);
            System.exit(1);
        }

        if (symbols < 1 || symbols > 36) {
            System.out.printf("Error: can't generate a secret number with a symbols of %d because there aren't enough unique digits.\n", symbols);
            System.exit(1);
        }

        if (symbols < length) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.\n", length, symbols);
            System.exit(1);
        }

        String symbolsStr = getSymbolsStr(symbols);
        System.out.printf("The secret is prepared %s %s.\n", "*".repeat(length), symbolsStr);

        Grader grader = new Grader(length, symbols);
        long counter = 1;
        System.out.println("Okay, let's start a game!");
        System.out.println("Turn 1:");
        String guess = scanner.nextLine();
        while (grader.getBulls(guess) != length) {
            System.out.printf("Grade: %s\n", grader.buildGrade(guess));
            System.out.printf("Turn %d:\n", ++counter);
            guess = scanner.nextLine();
        }
        System.out.printf("Grade: %s\n", grader.buildGrade(guess));
        System.out.println("Congratulations! You guessed the secret code.");

    }

    public static String getSymbolsStr(int symbols) {
        String alphanum = "0123456789abcdefghijklmnopqrstuvwxyz";

        if (symbols < 11) {
            return "(0-9)";
        } else {
            return String.format("(0-9, a-%s)", alphanum.charAt(symbols - 1));
        }
    }
}
