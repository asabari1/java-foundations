package io.github.asabari1.foundations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TextUtilsTest {

    static Stream<Arguments> cases() {
        return Stream.of(
                Arguments.of("empty", "", ""),
                Arguments.of("single char", "a", "a"),
                Arguments.of("odd length", "abc", "cba"),
                Arguments.of("even length", "abcd", "dcba"),
                Arguments.of("palindrome", "TOOT", "TOOT"),
                Arguments.of("spaces kept", "a b", "b a"),
                Arguments.of("emoji at start", "\uD83D\uDE00a", "a\uD83D\uDE00"),
                Arguments.of("emoji in middle", "a\uD83D\uDE00b", "b\uD83D\uDE00a"),
                Arguments.of("two emoji", "\uD83D\uDE00\uD83D\uDE01", "\uD83D\uDE01\uD83D\uDE00"),
                Arguments.of("supplementary letters", "\uD835\uDC9Cb\uD835\uDC9E", "\uD835\uDC9Eb\uD835\uDC9C"));
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("cases")
    void reversesByCodePoint(String description, String input, String expected) {
        assertEquals(expected, TextUtils.reverse(input), description);
    }

    @Test
    void rejectsNull() {
        assertThrows(IllegalArgumentException.class, () -> TextUtils.reverse(null));
    }

    @Test
    void reversingTwiceGivesOriginal() {
        String text = "a\uD83D\uDE00b\uD835\uDC9C c";
        assertEquals(text, TextUtils.reverse(TextUtils.reverse(text)));
    }

    @Test
    void agreesWithStringBuilderReverse() {
        Random random = new Random(42);
        int[] pool = {'a', 'b', 'Z', '1', ' ', 0xE9, 0x1F600, 0x1D49C};
        for (int run = 0; run < 1000; run++) {
            StringBuilder builder = new StringBuilder();
            int length = random.nextInt(8);
            for (int i = 0; i < length; i++) {
                builder.appendCodePoint(pool[random.nextInt(pool.length)]);
            }
            String text = builder.toString();
            assertEquals(
                    new StringBuilder(text).reverse().toString(),
                    TextUtils.reverse(text),
                    "run " + run + ", code points " + Arrays.toString(text.codePoints().toArray()));
        }
    }
}