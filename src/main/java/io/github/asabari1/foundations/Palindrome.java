package io.github.asabari1.foundations;
/**
 * A utility to check if a reads the same in both directions
 */

public class Palindrome {

    /**
     * Returns true if the letters and digits of the text read the same forwards
     * and backwards, ignoring case and every other character. A text with no
     * letters or digits is a palindrome.
     *
     * @param inputString the text to check
     * @return true if the text is a palindrome under the rules above
     * @throws IllegalArgumentException if {@code inputString} is null
     */

    public boolean isPalindrome(String inputString) {
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
