package edu.sjsu.assignment2;

public class MyRecursion {

    public static int indexOf(String toSearch, String searchTerm) {

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
            int returnedIndex = indexOf(toSearch.substring(1), searchTerm.substring(1));
            if (returnedIndex == -1) {
                return -1;
            }
            return returnedIndex;
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
