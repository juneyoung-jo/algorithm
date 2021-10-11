import java.util.*;

public class test {

    static Map<String, List<String>> map = new HashMap<>();
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {

        map.put("a", new ArrayList<String>(Arrays.asList("b")));

        map.merge("a", new ArrayList<String>(Arrays.asList("c")), (v, pv) -> {v.add("c"); return v;});


//        if(map.get("a") == null) map.put("a",Arrays.asList("c"));
//        else map.get("a").add("c");

//        map.forEach((k, v) -> System.out.println("v = " + v));

//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//
//        list.forEach((v) -> System.out.println(list.indexOf(v)));

        String str = "12.345-6.A";
        System.out.println(Arrays.toString(str.split(".")));



    }

}
