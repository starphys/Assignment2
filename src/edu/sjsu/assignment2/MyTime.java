package edu.sjsu.assignment2;

public class MyTime {
    public static void printTimeDifference(String earlierTime, String laterTime) {
        //Convert Strings to ints in minutes
        int earlierMinutes = convertToMinutes(earlierTime);
        int laterMinutes = convertToMinutes(laterTime);

        //If later time is smaller than earlier time, add 24 hours in minutes
        if (laterMinutes < earlierMinutes) {
            laterMinutes += 24 * 60;
        }

        //Subtract times
        int timeDifference = laterMinutes - earlierMinutes;

        //Convert minutes to hours and minutes for printing
        int hours = timeDifference / 60;
        int minutes = timeDifference % 60;
        //Print time from earlier time to later time
        System.out.println(hours + " hour(s) " + minutes + " minute(s)");
    }

    private static int convertToMinutes(String timeToConvert) {
        //Extract get integer from string
        int militaryTime = Integer.parseInt(timeToConvert);

        //Extract hours and minutes from military time
        int hours = militaryTime / 100;
        int minutes = militaryTime % 100;

        //Return total minutes
        return hours * 60 + minutes;
    }
}
