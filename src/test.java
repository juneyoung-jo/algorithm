import java.util.*;

public class test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1);
        String[] arr = {"gdgd ", " bb"};

        String[] strings = Arrays.stream(arr).map(String::trim).toArray(String[]::new);

    }
}
