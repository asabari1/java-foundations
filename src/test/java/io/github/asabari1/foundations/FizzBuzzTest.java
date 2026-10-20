package io.github.asabari1.foundations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class FizzBuzzTest {

    private final FizzBuzz fizzBuzz = new FizzBuzz();

    static Stream<Arguments> sequences() {
        return Stream.of(
                Arguments.of(0, List.of()),
                Arguments.of(1, List.of("1")),
                Arguments.of(2, List.of("1", "2")),
                Arguments.of(3, List.of("1", "2", "Fizz")),
                Arguments.of(5, List.of("1", "2", "Fizz", "4", "Buzz")),
                Arguments.of(15, List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8",
                        "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz")));
    }

    @ParameterizedTest(name = "n={0}")
    @MethodSource("sequences")
    void generatesExpectedSequence(int n, List<String> expected) {
        assertEquals(expected, fizzBuzz.generate(n));
    }

    @ParameterizedTest(name = "n={0}")
    @ValueSource(ints = {-1, -15, Integer.MIN_VALUE})
    void rejectsNegativeInput(int n) {
        assertThrows(IllegalArgumentException.class, () -> fizzBuzz.generate(n));
    }

    @Test
    void followsRulesBeyondFirstCycle() {
        List<String> result = fizzBuzz.generate(100);

        assertEquals(100, result.size());
        assertEquals("1", result.getFirst());
        assertEquals("FizzBuzz", result.get(29));   // 30
        assertEquals("97", result.get(96));         // 97
        assertEquals("Fizz", result.get(98));       // 99
        assertEquals("Buzz", result.get(99));       // 100
    }

    @Test
    void returnsModifiableList() {
        List<String> result = fizzBuzz.generate(3);

        assertDoesNotThrow(() -> result.add("extra"));
    }
}