package io.github.asabari1.foundations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PalindromeTest {
    private final Palindrome palindrome = new Palindrome();
    @ParameterizedTest
    @CsvSource
            ({
                    "'A man, a plan, a canal: Panama',true",
                    "'ab',false",
                    "'Aaa',true",
                    "'a',true",
                    "'',true",
                    "'    ',true",
                    "'\n',true"
            })
    void testMultiplePalindromeScenarios(String inputString,boolean expectedResult) {
        boolean actualResult = palindrome.isPalindrome(inputString);
        assertEquals(expectedResult,actualResult);
    }
    @Test
    void testNullInputScenario(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            palindrome.isPalindrome(null);
        });
        assertEquals("Input string cannot be null.",exception.getMessage());
    }
}
