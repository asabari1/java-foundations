package io.github.asabari1.foundations;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/**A utility to count number of words in a given text*/
public class WordCounter {

    /**
     * Counts word occurrences, ignoring case. A word is a maximal run of letters
     * and digits; every other character (spaces, punctuation, apostrophes,
     * hyphens, emoji) separates words, so "don't" counts as "don" and "t".
     * Blank text gives an empty map.
     *
     * @param text the text to analyse
     * @return a new map from lower-case word to count, in order of first appearance
     * @throws IllegalArgumentException if text is null
     */
    public Map<String, Integer> count(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Input text cannot be null.");
        }
        Map<String, Integer> counts = new LinkedHashMap<>();
        StringBuilder word = new StringBuilder();
        for (int codePoint : text.toLowerCase(Locale.ROOT).codePoints().toArray()) {
            if (Character.isLetterOrDigit(codePoint)) {
                word.appendCodePoint(codePoint);
            } else {
                flush(word, counts);
            }
        }
        flush(word, counts);       // the last word has no delimiter after it
        return counts;
    }

    private static void flush(StringBuilder word, Map<String, Integer> counts) {
        if (!word.isEmpty()) {
            counts.merge(word.toString(), 1, Integer::sum);
            word.setLength(0);
        }
    }
}