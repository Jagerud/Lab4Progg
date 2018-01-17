package start;

import java.util.HashMap;

/**
 * Created by Jaeger on 2016-07-26.
 */
public class Test {
    public void test() {
        HashMap<String, String> boxPositionMap = new HashMap<>();

        boxPositionMap.put("a", "b");

        System.out.println(boxPositionMap.get("a"));
        boxPositionMap.put("a", "d");
        boxPositionMap.put("b", "c");

        System.out.println(boxPositionMap.get("a"));

        System.out.println(boxPositionMap.get("a"));


    }
}
