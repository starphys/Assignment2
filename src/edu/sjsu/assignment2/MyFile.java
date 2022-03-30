package edu.sjsu.assignment2;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class MyFile {
    public static void writePrimes(String file1, String file2) {
        try (Scanner input = new Scanner(new File(file1)); PrintWriter output = new PrintWriter(file2)) {
            input.useDelimiter(",");
            while (input.hasNext()) {
                System.out.println(input.next() + ",");
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println(file1 + " not found.");
        }
    }
}
