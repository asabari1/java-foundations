package io.github.asabari1.foundations;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    List<String> generate(int numberOfItems) {

        List<String> fizzBuzzList = new ArrayList<String>();
        if (numberOfItems<0) throw new IllegalArgumentException("Number of items in list can not be less than 0.");
        else {
            for (int iterator=1;iterator<=numberOfItems;iterator++) {
                if(iterator%3==0 && iterator%5==0) fizzBuzzList.add("FizzBuzz");
                else if (iterator%3==0) fizzBuzzList.add("Fizz");
                else if (iterator%5==0) fizzBuzzList.add("Buzz");
                else fizzBuzzList.add(String.valueOf(iterator));
            }
        }
        return fizzBuzzList;
    }

}
