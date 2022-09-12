package item13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloneableClassTest {
    @Test
    void cloneTest() throws CloneNotSupportedException {
        CloneableClass origin = new CloneableClass();
        origin.setName("origin");

        Object copy = origin.clone();

        assertEquals("origin", ((CloneableClass) copy).getName());
    }
}