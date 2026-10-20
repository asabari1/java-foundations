package io.github.asabari1.foundations;

public class Palindrome {
    boolean isPalindrome(String inputString) {
        if (inputString == null) throw new IllegalArgumentException("Input string cannot be null.");
        for(int left=0,right=inputString.length()-1;left<right;left++,right--){
            //ignore non-alphanumeric characters at both ends
            while(!(Character.isLetterOrDigit(inputString.charAt(left))) && left<right) {
                left++;
            }
            while(!(Character.isLetterOrDigit(inputString.charAt(right))) && left<right) {
                right--;
            }
            //compare both ends ignoring case, return false if not equals
            if (Character.toLowerCase(inputString.charAt(left))!=Character.toLowerCase(inputString.charAt(right))) {
                return false;
            }
        }
        return true;
    }
}
