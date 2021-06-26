
/*
* There are many ways to obtain a stream. Refer to the code below.
* */

package practical;

import java.util.Arrays;
import java.util.stream.Stream;

public class ObtainingAStream {

    public static void main(String...args) {
        /*
        * The static methods in the Stream interface
        * */

        // Takes an object and returns the same object
        Stream.of(5);

        // Same as above, but accepts null as an argument
        Stream.ofNullable(null);

        // Variadic method that accepts either an array of a comma seperated list of arguments
        Stream.of(1, 2, 3, 4, 5);
        Stream.of(new int[] {1, 2, 3, 4, 5});

        /*
        * The static methods of the Arrays class
        *  (only works on arrays)
        * */
        Arrays.stream(new int[] {1, 2, 3, 4, 5});

        /*
        * The instance method stream on all standard library objects that implement iterable
        * */
        Arrays.asList(new int[] {1, 2, 3, 4, 5}).stream();

        /*
        * The generational methods in in the Stream class
        * */
        Stream.generate(() -> 3);
        Stream.iterate(2, x -> x * 2);
    }

}
