package io.github.asabari1.foundations;

public class TemperatureConverter {
    double celsiusToFahrenheit(double tempInCelsius) {
        if (tempInCelsius<-273.15) throw new IllegalArgumentException("Provided input temperature is below absolute zero.");
        return (tempInCelsius*9/5)+32;
    }
    double fahrenheitToCelsius(double tempInFahrenheit) {
        if (tempInFahrenheit <-459.67) throw new IllegalArgumentException("Provided input temperature is below absolute zero.");
        return (tempInFahrenheit -32)*5/9;
    }
}
