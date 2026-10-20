package io.github.asabari1.foundations;

/** Static temperature converter for Celsius and Fahrenheit scales. This class cannot be instantiated. */
public final class TemperatureConverter {

    private static final double ABSOLUTE_ZERO_CELSIUS = -273.15;
    private static final double ABSOLUTE_ZERO_FAHRENHEIT = -459.67;

    private TemperatureConverter() {
        // utility class: no instances
    }

    /**
     * Converts degrees Celsius to degrees Fahrenheit.
     *
     * @param temperatureInCelsius a finite temperature, at or above -273.15
     * @return the temperature in Fahrenheit
     * @throws IllegalArgumentException if the value is NaN, infinite, or below absolute zero
     */
    public static double celsiusToFahrenheit(double temperatureInCelsius) {
        requireValid(temperatureInCelsius, ABSOLUTE_ZERO_CELSIUS);
        return temperatureInCelsius * 9.0 / 5.0 + 32.0;
    }

    /**
     * Converts degrees Fahrenheit to degrees Celsius.
     *
     * @param temperatureInFahrenheit a finite temperature, at or above -459.67
     * @return the temperature in Celsius
     * @throws IllegalArgumentException if the value is NaN, infinite, or below absolute zero
     */
    public static double fahrenheitToCelsius(double temperatureInFahrenheit) {
        requireValid(temperatureInFahrenheit, ABSOLUTE_ZERO_FAHRENHEIT);
        return (temperatureInFahrenheit - 32.0) * 5.0 / 9.0;
    }

    private static void requireValid(double value, double absoluteZero) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Temperature must be a finite number: " + value);
        }
        if (value < absoluteZero) {
            throw new IllegalArgumentException(
                    "Temperature is below absolute zero (" + absoluteZero + "): " + value);
        }
    }
}