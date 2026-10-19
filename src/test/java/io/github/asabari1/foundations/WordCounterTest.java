package io.github.asabari1.foundations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordCounterTest {
    public final WordCounter wordCounter = new WordCounter();
    @ParameterizedTest
    @CsvSource
            ({
                    "'the cat The','the:2,cat:1'",
                    "'the ball.cat. the,BALL','the:2,ball:2,cat:1'",
                    "'   ball catch ball  \n catch  ','ball:2,catch:2'",
                    "'   ball;catch  \nBALL.CATCH   ','ball:2,catch:2'",
                    "'   ',''"
            })
    void testMultipleWordCountScenarios(String inputText,String expectedMapString) {
        Map<String,Integer> actualMap = wordCounter.count(inputText);
        Map<String,Integer> expectedMap;
        if (expectedMapString==null || expectedMapString.trim().isEmpty()) expectedMap = Map.of();
        else {
            expectedMap = Arrays.stream(expectedMapString.split(","))
                    .map(pair -> pair.split(":"))
                    .collect(Collectors.toMap(
                            parts -> parts[0].trim(),
                            parts -> Integer.parseInt(parts[1].trim())
                    ));
        }
        assertEquals(expectedMap,actualMap);
    }
    @Test
    void testNullInputScenario(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> wordCounter.count(null));
        assertEquals("Input text cannot be null.",exception.getMessage());
    }
}
