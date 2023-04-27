import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String args[]){
        HashMap<Integer, String> hash = new HashMap<>();

        hash.put(1, "aaa");
        hash.put(2, "bbb");
        hash.put(1, "ccc");

        System.out.println(hash);
        System.out.println(hash.keySet());
        System.out.println(hash.keySet().contains(1));
        System.out.println(hash.containsKey(1));
    }
}