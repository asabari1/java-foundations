package io.github.asabari1.foundations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Locale;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WordCounterTest {

    private final WordCounter wordCounter = new WordCounter();

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("empty", "", Map.of()),
                Arguments.of("blank", "   \t\n ", Map.of()),
                Arguments.of("only punctuation", ",.!;", Map.of()),
                Arguments.of("single word", "cat", Map.of("cat", 1)),
                Arguments.of("case-insensitive", "the cat The", Map.of("the", 2, "cat", 1)),
                Arguments.of("mixed delimiters", "the ball.cat. the,BALL",
                        Map.of("the", 2, "ball", 2, "cat", 1)),
                Arguments.of("whitespace runs and newlines", "\n  ball\tcatch  ball\n catch ",
                        Map.of("ball", 2, "catch", 2)),
                Arguments.of("trailing word without delimiter", "a b a", Map.of("a", 2, "b", 1)),
                Arguments.of("digits are word characters", "abc1 abc1 abc2",
                        Map.of("abc1", 2, "abc2", 1)),
                Arguments.of("apostrophe splits words (documented)", "don't",
                        Map.of("don", 1, "t", 1)),
                Arguments.of("hyphen splits words", "well-known", Map.of("well", 1, "known", 1)),
                Arguments.of("non-ASCII letters", "café CAFÉ", Map.of("café", 2)),
                Arguments.of("supplementary letters", "\uD835\uDC9C \uD835\uDC9C",
                        Map.of("\uD835\uDC9C", 2)),
                Arguments.of("emoji is a delimiter", "a\uD83D\uDE00b", Map.of("a", 1, "b", 1)));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void countsWords(String description, String text, Map<String, Integer> expected) {
        assertEquals(expected, wordCounter.count(text), description);
    }

    @Test
    void rejectsNull() {
        assertThrows(IllegalArgumentException.class, () -> wordCounter.count(null));
    }

    @Test
    void ignoresDefaultLocale() {
        Locale original = Locale.getDefault();
        try {
            Locale.setDefault(Locale.forLanguageTag("tr-TR"));
            assertEquals(Map.of("title", 2), wordCounter.count("TITLE title"));
        } finally {
            Locale.setDefault(original);
        }
    }
}