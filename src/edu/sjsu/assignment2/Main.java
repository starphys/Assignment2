package edu.sjsu.assignment2;

import static edu.sjsu.assignment2.MyRecursion.indexOf;

public class Main {

    public static void main(String[] args) {
        boolean userExit = false;
        String firstPrompt = "Please enter the first time: ", secondPrompt = "Please enter the second time: ";

        //Greet user, brief explanation of tool
        System.out.println("This is the Time Difference Program.");

        while (!userExit) {
            System.out.println("Enter two times in military format and get the hours and minutes from the first\n" +
                    "time until the second time. (Valid input is a 4 digit integer that is a valid\n" +
                    "time. Input exit to end the program.)");

            //prompt and return valid integer or -1 for userExit.
            int firstTime = InputManager.getTime(firstPrompt);
            if (firstTime == -1) {
                userExit = true;
                continue;
            }

            //prompt and return valid integer or -1 for userExit.
            int secondTime = InputManager.getTime(secondPrompt);
            if (secondTime == -1) {
                userExit = true;
                continue;
            }

            MyTime.printTimeDifference(Integer.toString(firstTime), Integer.toString(secondTime));

            userExit = !(InputManager.reenterPrompt());
        }

        System.out.println("Thank you for using this program. Goodbye!");
    }
}
