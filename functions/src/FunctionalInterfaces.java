
/*
*
*
*
*
*
* */

import java.util.function.Consumer;

public class FunctionalInterfaces {

    public static void main(String...args) {
        Consumer<? extends Object> consumer = new DoerImpl()::doIt;
        System.out.println(consumer);
    }


    public static class DoerImpl implements Doer {
        @Override
        public <T> void doIt(T x) {
            System.out.println(x);
        }
    }

    @FunctionalInterface
    public interface Doer {
        <T> void doIt(T x);
    }
}
