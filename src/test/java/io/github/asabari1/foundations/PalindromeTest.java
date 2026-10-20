package io.github.asabari1.foundations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PalindromeTest {
    private final Palindrome palindrome = new Palindrome();
    @ParameterizedTest(name = "n={0}")
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
                    "'\uD835\uDC9Cb\uD835\uDC9E',false",
                    "'\uD83D\uDE00',true",
                    "'\uD835\uDC9C',true",
                    "'ab\uD835\uDC9Cba',true",
                    "'\uD835\uDC9Cb\uD835\uDC9C',true",
                    "'a\uD83D\uDE00b',false",
                    "'\uD835\uDC9C\uD835\uDC9E',false"
            })
    void testMultiplePalindromeScenarios(String inputString,boolean expectedResult) {
        assertEquals(expectedResult,palindrome.isPalindrome(inputString));
    }
    @Test
    void testNullInputScenario(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> palindrome.isPalindrome(null));
        assertEquals("Input string cannot be null.",exception.getMessage());
    }
}
