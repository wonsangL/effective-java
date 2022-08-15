package item06;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ImmutableClass {
    public static void main(String[] args) {
        String hello = "hello";

        String copy = hello;

        String hello2 = "hello";

        String newInstance = new String("hello");

        System.out.printf("hello == copy: %b\n", hello == copy); //true
        System.out.printf("hello == hello2: %b\n", hello == hello2); //true
        System.out.printf("hello == newInstance: %b\n", hello == newInstance); //false
    }
}
