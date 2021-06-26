
/*
* What are streams?
*
* Streams are a programming abstraction that decouples the iteration logic from
* the computational logic.
*
* Streams are modeled after the functional programming paradigm.
*
* In java we typically use an imperative style of programming, in which we tell the computer
* the operations to perform step by step. It is also often the case that the system maintains state,
* often lots of states.
*
* The functional programming paradigm does not maintain state, but instead focuses on the input and
* output of functional operations. A major benefit to function programming, is that associative
* stateless functions can be greatly optimized through parallelization.
*
* */

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class StreamIntro {

    public static void main(String...args) {
        int probsize = 10000;
        warmup(probsize);

        // Generating an array of 1000 int elements in an Imperative function
        long impStartTime = System.currentTimeMillis();
        Random rand = new Random();
        int[] imp1000 = new int[probsize];
        for (int i = 0; i < imp1000.length; i++) {
            imp1000[i] = rand.nextInt();
        }
        long impEndTime = System.currentTimeMillis();

        // Generating an array of 1000 int elements semi-functionally
        long funStartTime = System.currentTimeMillis();
        int[] fun1000 = IntStream.generate(() -> rand.nextInt()).limit(probsize).toArray();
        long funEndTime = System.currentTimeMillis();


        long impTime = impEndTime - impStartTime;
        System.out.println("The Imperative way took " + impTime + " milli secs!");
        System.out.println("Generated arr: " + imp1000);

        long funTime = funEndTime - funStartTime;
        System.out.println("The functional way took " + funTime + " milli secs!");
        System.out.println("Generated arr: " + fun1000);
    }

    public static void warmup(int probsize) {
        // Generating an array of 1000 int elements in an Imperative function
        Random rand = new Random();
        int[] imp1000 = new int[probsize];
        for (int i = 0; i < imp1000.length; i++) {
            imp1000[i] = rand.nextInt();
        }

        // Generating an array of 1000 int elements semi-functionally
        int[] fun1000 = IntStream.generate(() -> rand.nextInt()).limit(probsize).toArray();
    }

}
