package item17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ImmutableClassTest {
    @Test
    void stringTest() {
        String origin = "hello";
        String copy = origin;

        origin = origin + " world";

        String newString = new String("hello");

        System.out.println(origin == copy);
        System.out.println(copy == newString);
    }
}
