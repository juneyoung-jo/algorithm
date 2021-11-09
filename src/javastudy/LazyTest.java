package javastudy;

import java.util.function.Supplier;

public class LazyTest {

    public static void main(String[] args) throws Exception {

        test1();

    }

    // eager -> Lazy
    static void test1() {
        System.out.println(test2(() -> test3(true), test3(true)));
    }

    static String test2(final Supplier<Boolean> f, boolean c) {
        System.out.println("test2 methods start");
        return f.get() ? "true" : "false";
    }

    private static boolean test3(boolean b) {
        System.out.println("test3  methods start");
        return b;
    }
}
