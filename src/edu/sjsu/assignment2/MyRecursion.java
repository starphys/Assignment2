package edu.sjsu.assignment2;

/**
 * MyRecursion is a static class that implements a recursive indexOf method for Strings
 */
public class MyRecursion {

    /**
     * indexOf searches a string for a substring
     *
     * @param toSearch   String - string to be searched
     * @param searchTerm String - substring to be found
     * @return -1 if not found; index of first occurrence if found
     */
    public static int indexOf(String toSearch, String searchTerm) {
        //This code based on an algorithm I found on stack exchange and modified for this assignment

        //Base case: searchTerm empty, which constitutes a match
        if (searchTerm.length() == 0) {
            return 0;
        }

        //Base case: If toSearch is empty but searchTerm isn't, no possible match
        else if (toSearch.length() == 0) {
            return -1;
        }

        //If first characters match, recursively check if next characters match
        if (toSearch.charAt(0) == searchTerm.charAt(0)) {
            return indexOf(toSearch.substring(1), searchTerm.substring(1));
        }
        //First characters do not match, check next character in toSearch
        else {
            int returnedIndex = indexOf(toSearch.substring(1), searchTerm);
            if (returnedIndex == -1) {
                return -1;
            }
            return returnedIndex + 1;
        }

    }
}
