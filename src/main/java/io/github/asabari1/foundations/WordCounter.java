package io.github.asabari1.foundations;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    Map<String, Integer> count(String text) {
        if(text==null) throw new IllegalArgumentException("Input text cannot be null.");
        //System.out.println("Input text:"+text);
        text = text.trim().toLowerCase();
        text = text+".";//Word counter counts words that are followed by a non-alphanumeric character only, so adding a period at the end of text to count the last word.
        Map<String,Integer> wordCounts = new HashMap<>();
        StringBuilder word=new StringBuilder();
        for (int iterator=0;iterator<text.length();iterator++) {
            char charIterator = text.charAt(iterator);
            if (Character.isLetterOrDigit(charIterator)) word.append(charIterator);
            else {
                if (!word.isEmpty()) {
                    //System.out.println("Word: "+word);
                    wordCounts.merge(word.toString(), 1, Integer::sum);
                    word.setLength(0);
                }
            }
        }
        return wordCounts;
    }
}
