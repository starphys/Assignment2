package edu.sjsu.assignment2;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * MyFile is a static class that implements a method to find primes and a method write primes from one file to another
 */
public class MyFile {

    /**
     * writePrimes searches a file for prime integers and stores them in a new file
     *
     * @param file1 String - name of the file to search
     * @param file2 String - name of the file to populate with primes
     */
    public static void writePrimes(String file1, String file2) {
        try (Scanner input = new Scanner(new File(file1)); PrintWriter output = new PrintWriter(file2)) {
            while (input.hasNextLine()) {
                // scan the current line
                String line = input.nextLine();
                Scanner lineReader = new Scanner(line);
                lineReader.useDelimiter(",");
                // Write each word in separate lines
                while (lineReader.hasNext()) {
                    String word = lineReader.next();
                    try {
                        int toCheck = Integer.parseInt(word);
                        if (isPrime(toCheck)) {
                            output.println(word);
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println(file1 + " not found.");
        }
    }

    /**
     * isPrime iteratively checks if an integer is prime
     *
     * @param n int - number to check for primeness
     * @return boolean - true if n is prime, otherwise false
     */
    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false; // exit method
        }
        return true;
    }
}
