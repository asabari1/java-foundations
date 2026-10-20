package io.github.asabari1.foundations;

/** Static helpers for working with text. This class cannot be instantiated. */
public final class TextUtils {

    private TextUtils(){
    }

    /**
     * Returns the text reversed by Unicode code point, so surrogate pairs
     * (such as emoji) stay intact. Characters made of several code points
     * (combining accents, flag emoji, ZWJ sequences) are not treated as one
     * unit and may come out reordered.
     *
     * @param inputString the text to reverse
     * @return a new string with the code points in reverse order
     * @throws IllegalArgumentException if text is null
     */

    public static String reverse(String inputString) {
        if (inputString == null) throw new IllegalArgumentException("Input string cannot be null.");
        int[] inputCharArray = inputString.codePoints().toArray();
        int inputStringLength = inputCharArray.length;
        int midIndex = inputStringLength/2;
        for (int iterator=0;iterator<midIndex;iterator++) {
            int tempChar = inputCharArray[iterator];
            inputCharArray[iterator] = inputCharArray[inputStringLength-iterator-1];
            inputCharArray[inputStringLength-iterator-1] = tempChar;
        }
        return new String(inputCharArray,0,inputCharArray.length);
    }
}
