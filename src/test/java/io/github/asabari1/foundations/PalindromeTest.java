package io.github.asabari1.foundations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PalindromeTest {
    private final Palindrome palindrome = new Palindrome();
    @ParameterizedTest(name = "[{index}] {0}")
    @CsvSource
            ({
                    "'A man, a plan, a canal: Panama',true",
                    "'ab',false",
                    "'Aaa',true",
                    "'a',true",
                    "'',true",
                    "'    ',true",
                    "'\n',true",
                    "'race a car',false",
                    "'12321',true",
                    "'a1b2',false",
                    "',.!',true",
                    "'été',true",
                    "'a\uD83D\uDE00a',true",
                    "'\uD835\uDC9Cb\uD835\uDC9E',false"
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
