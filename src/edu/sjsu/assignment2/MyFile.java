package edu.sjsu.assignment2;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyFile {
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

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false; // exit method
        }
        return true;
    }
}
