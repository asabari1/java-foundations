package io.github.asabari1.foundations;

public class Palindrome {
    boolean isPalindrome(String inputString) {
        if (inputString == null) throw new IllegalArgumentException("Input string cannot be null.");
        for(int left=0,right=inputString.codePointCount(0,inputString.length())-1;left<right;left++,right--){
            //ignore non-alphanumeric characters at both ends
            while(!(Character.isLetterOrDigit(inputString.codePointAt(left))) && left<right) {
                left++;
            }
            while(!(Character.isLetterOrDigit(inputString.codePointAt(right))) && left<right) {
                right--;
            }
            //compare both ends ignoring case, return false if not equals
            if (Character.toLowerCase(inputString.codePointAt(left))!=Character.toLowerCase(inputString.codePointAt(right))) {
                return false;
            }
        }
        return true;
    }
}
