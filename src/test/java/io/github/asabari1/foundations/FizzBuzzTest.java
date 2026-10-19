package io.github.asabari1.foundations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FizzBuzzTest {
    private final FizzBuzz fizzBuzz = new FizzBuzz();
    @ParameterizedTest
    @CsvSource({
            "1,'1'",
            "3,'1,2,Fizz'",
            "5,'1,2,Fizz,4,Buzz'",
            "15,'1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz'",
            "0,''"
    })
    void testMultipleFizzBuzzScenarios(int input,String expectedOutputString) {
       List<String> actualList = fizzBuzz.generate(input);
       List<String> expectedList;
       if (expectedOutputString==null || expectedOutputString.trim().isEmpty())
           expectedList=List.of();
       else
           expectedList= Arrays.asList(expectedOutputString.split(","));
       assertEquals(expectedList, actualList);
    }
    @Test
    void testNegativeInput(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            fizzBuzz.generate(-1);
        });
        assertEquals("Number of items in list can not be less than 0.", exception.getMessage());
    }
}
