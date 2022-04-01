package edu.sjsu.assignment2;

import java.util.Scanner;

public class InputManager {
    public static int getTime(String prompt) {
        int toReturn = -1;
        boolean endLoop = false;

        Scanner input = new Scanner(System.in);


        while (!endLoop) {
            System.out.print(prompt);

            if (input.hasNext()) {
                String tempInput = input.next();

                //Check if enough characters
                if (tempInput.length() != 4) {
                    badInput(tempInput);
                    continue;
                }

                //If exit, exit application
                if (tempInput.equals("exit")) {
                    return -1;
                }

                //if enough characters, try to parse as int.
                try {
                    toReturn = Integer.parseInt(tempInput);
                    if ((toReturn / 100) < 0 || (toReturn / 100) > 23 || (toReturn % 100) > 59) {
                        notTime(tempInput);
                    } else {
                        endLoop = true;
                    }
                } catch (NumberFormatException e) {
                    badInput(tempInput);
                }
            } else {
                System.out.println("Please enter a military time or exit.");
            }
        }
        return toReturn;
    }

    public static boolean reenterPrompt() {
        String prompt = "Would you like to continue using this program? ";

        Scanner input = new Scanner(System.in);
        System.out.print(prompt);

        while (true) {
            System.out.print("[y/n]: ");

            if (input.hasNext()) {
                String tempInput = input.next();

                if (tempInput.equalsIgnoreCase("y")) {
                    return true;
                } else if (tempInput.equalsIgnoreCase("n")) {
                    return false;
                }
            }
        }
    }

    public static void badInput(String word) {
        System.out.println(word + " is not a valid input.\n" +
                "Please enter a time in military time (must be 4 digits, must be an integer).");
    }

    public static void notTime(String word) {
        System.out.println(word + " is not a valid time.\n" +
                "Military times are 4 digits: two for the hour, two for the minute.\n" +
                "00 <= hours <= 23, 00 <= minutes <= 59");
    }
}
