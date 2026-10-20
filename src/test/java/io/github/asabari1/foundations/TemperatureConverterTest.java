package io.github.asabari1.foundations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TemperatureConverterTest {

    private static final double DELTA = 1e-9;

    @ParameterizedTest(name = "{0} C = {1} F")
    @CsvSource({
            "0, 32",
            "100, 212",
            "-40, -40",
            "37, 98.6",
            "1000, 1832",
            "-273.15, -459.67"          // exactly absolute zero is valid
    })
    void convertsCelsiusToFahrenheit(double celsius, double expected) {
        assertEquals(expected, TemperatureConverter.celsiusToFahrenheit(celsius), DELTA);
    }

    @ParameterizedTest(name = "{0} F = {1} C")
    @CsvSource({
            "32, 0",
            "212, 100",
            "-40, -40",
            "0, -17.77777777777778",
            "98.6, 37",
            "-459.67, -273.15"          // exactly absolute zero is valid
    })
    void convertsFahrenheitToCelsius(double fahrenheit, double expected) {
        assertEquals(expected, TemperatureConverter.fahrenheitToCelsius(fahrenheit), DELTA);
    }

    @ParameterizedTest(name = "{0} C is rejected")
    @ValueSource(doubles = {-273.16, -300, -1e9,
            Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN})
    void rejectsInvalidCelsius(double celsius) {
        assertThrows(IllegalArgumentException.class,
                () -> TemperatureConverter.celsiusToFahrenheit(celsius));
    }

    @ParameterizedTest(name = "{0} F is rejected")
    @ValueSource(doubles = {-459.68, -500, -1e9,
            Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN})
    void rejectsInvalidFahrenheit(double fahrenheit) {
        assertThrows(IllegalArgumentException.class,
                () -> TemperatureConverter.fahrenheitToCelsius(fahrenheit));
    }

    @ParameterizedTest(name = "round trip {0} C")
    @ValueSource(doubles = {-273.15, -40, 0, 36.6, 100, 5000})
    void roundTripReturnsOriginal(double celsius) {
        double back = TemperatureConverter.fahrenheitToCelsius(
                TemperatureConverter.celsiusToFahrenheit(celsius));
        assertEquals(celsius, back, DELTA);
    }
}