package io.github.asabari1.foundations;

public class Palindrome {
    boolean isPalindrome(String inputString) {
        if (inputString == null) throw new IllegalArgumentException("Input string cannot be null.");
        int left=0;
        int right=inputString.length();
        while(left<right) {
            int leftCodePoint = inputString.codePointAt(left);
            if(!Character.isLetterOrDigit(leftCodePoint)) {
                left+=Character.charCount(leftCodePoint);
                continue;
            }
            int rightCodePoint = inputString.codePointBefore(right);
            if(!Character.isLetterOrDigit(rightCodePoint)) {
                right-=Character.charCount(rightCodePoint);
                continue;
            }
            if(Character.toLowerCase(leftCodePoint) != Character.toLowerCase(rightCodePoint)) {
                return false;
            }
            left+=Character.charCount(leftCodePoint);
            right-=Character.charCount(rightCodePoint);
        }

        return true;
    }
}
