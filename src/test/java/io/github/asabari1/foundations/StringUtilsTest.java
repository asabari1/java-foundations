package io.github.asabari1.foundations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringUtilsTest {
    private final StringUtils stringUtils = new StringUtils();
    @ParameterizedTest
    @CsvSource
            ({
                    "'a','a'",
                    "'abc','cba'",
                    "'abcd','dcba'",
                    "'TOOT','TOOT'",
                    "'',''"
            })
    void testMultipleStringReverseScenarios(String inputString,String expectedOutput) {
        String actualOutput = stringUtils.reverse(inputString);
        assertEquals(expectedOutput,actualOutput);
    }
    @Test
    void testNullInputScenario(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> stringUtils.reverse(null));
        assertEquals("Input string cannot be null.",exception.getMessage());
    }
    @Test
    void testWithEmojis_edgeCase(){
        String actualOutput = stringUtils.reverse("\uD83D\uDE00a");
        assertEquals("a\uD83D\uDE00",actualOutput);
    }
}
