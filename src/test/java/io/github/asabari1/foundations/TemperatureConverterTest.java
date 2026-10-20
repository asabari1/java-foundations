package io.github.asabari1.foundations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemperatureConverterTest {
    private final TemperatureConverter temperatureConverter = new TemperatureConverter();
    @ParameterizedTest
    @CsvSource
            ({
                    "0,32",
                    "100,212",
                    "-40,-40"
            })
    void testCelsiusToFahrenheitScenarios(double input,double expectedOutput) {
        double actualOutput = temperatureConverter.celsiusToFahrenheit(input);
        assertEquals(expectedOutput,actualOutput,0.0001);
    }
    @ParameterizedTest
    @CsvSource
            ({
                    "0,-17.777777",
                    "100,37.777777",
                    "-40,-40"
            })
    void testFahrenheitToCelsiusScenarios(double input,double expectedOutput) {
        double actualOutput = temperatureConverter.fahrenheitToCelsius(input);
        assertEquals(expectedOutput,actualOutput,0.0001);
    }
    @Test
    void testTemperatureBelowAbsoluteZero() {
        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            temperatureConverter.celsiusToFahrenheit(-273.2);
        });
        assertEquals("Provided input temperature is below absolute zero.",exception1.getMessage());
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            temperatureConverter.fahrenheitToCelsius(-459.7);
        });
        assertEquals("Provided input temperature is below absolute zero.",exception2.getMessage());
    }
}
