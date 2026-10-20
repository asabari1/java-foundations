package io.github.asabari1.foundations;

import java.util.ArrayList;
import java.util.List;

/**
 *A utility to generate FizzBuzz sequence
 **/
 public class FizzBuzz {

    /**
     * Returns the FizzBuzz sequence for 1..numberOfItems: "Fizz" for multiples
     * of 3, "Buzz" for multiples of 5, "FizzBuzz" for both, otherwise the number.
     *
     * @param numberOfItems how many entries to produce; 0 gives an empty list
     * @return a new, modifiable list of the entries in order
     * @throws IllegalArgumentException if numberOfItems is negative
     */
    List<String> generate(int numberOfItems) {

        if (numberOfItems<0) {
            throw new IllegalArgumentException("Number of items in list can not be negative:"+numberOfItems);
        }
        List<String> fizzBuzzList = new ArrayList<>(numberOfItems);
        for (int i=1;i<=numberOfItems;i++) {
            if(i%3==0 && i%5==0) fizzBuzzList.add("FizzBuzz");
            else if (i%3==0) fizzBuzzList.add("Fizz");
            else if (i%5==0) fizzBuzzList.add("Buzz");
            else fizzBuzzList.add(String.valueOf(i));
        }
        return fizzBuzzList;
    }

}
