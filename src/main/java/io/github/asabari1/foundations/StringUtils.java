package io.github.asabari1.foundations;

public class StringUtils {
    /*
    String reverse(String inputString) {
        if (inputString==null) throw new IllegalArgumentException("Input string cannot be null.");
        int inputStringLength = inputString.length();
        int midIndex = inputStringLength/2;
        char[] inputCharArray = inputString.toCharArray();
        for (int iterator=0;iterator<midIndex;iterator++) {
            char tempChar = inputCharArray[iterator];
            inputCharArray[iterator] = inputCharArray[inputStringLength-iterator-1];
            inputCharArray[inputStringLength-iterator-1] = tempChar;
        }
        return new String(inputCharArray);
    }
    */
    String reverse(String inputString) {
        if (inputString == null) throw new IllegalArgumentException("Input string cannot be null.");
        int[] inputCharArray = inputString.codePoints().toArray();
        int inputStringLength = inputCharArray.length;
        int midIndex = inputStringLength/2;
        for (int iterator=0;iterator<midIndex;iterator++) {
            int tempChar = inputCharArray[iterator];
            inputCharArray[iterator] = inputCharArray[inputStringLength-iterator-1];
            inputCharArray[inputStringLength-iterator-1] = tempChar;
        }
        StringBuilder reverseString = new StringBuilder();
        for (int i : inputCharArray) reverseString.append(Character.toString(i));
        return reverseString.toString();
    }
}
