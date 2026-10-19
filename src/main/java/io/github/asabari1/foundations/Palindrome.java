package io.github.asabari1.foundations;

import java.util.ArrayList;

public class Palindrome {
    boolean isPalindrome(String inputString) {
        boolean isPalindrome = false;
        if (inputString == null) throw new IllegalArgumentException("Input string cannot be null.");
        inputString = inputString.trim();
        if (inputString.isEmpty()) isPalindrome=true;
        else {
            ArrayList<Character> inputCharArray = new ArrayList<>();
            ArrayList<Character> reverseCharArray = new ArrayList<>();
            for (int iterator=0;iterator<inputString.length();iterator++) {
                char charIterator=Character.toLowerCase(inputString.charAt(iterator));
                if(Character.isLetterOrDigit(charIterator)) {
                    inputCharArray.add(charIterator);
                    reverseCharArray.addFirst(charIterator);
                }
            }
            if (inputCharArray.equals(reverseCharArray)) isPalindrome=true;
            //System.out.println("Input string:"+inputString+"\nInput Char Array:"+inputCharArray+"\nReverse Char Array:"+reverseCharArray+"\nIs Palindrome:"+isPalindrome);
        }
        return isPalindrome;
    }
}
