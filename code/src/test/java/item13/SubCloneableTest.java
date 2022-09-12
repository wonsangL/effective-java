package item13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubCloneableTest {
    @Test
    void cloneTest() throws CloneNotSupportedException {
        List<String> items = new ArrayList<>();
        items.add("item");

        SubCloneable origin = new SubCloneable();
        origin.setName("origin");
        origin.setSubName("sub");
        origin.setItems(items);

        Object clone = origin.clone();

        items.add("new item");

        assertEquals("origin", ((SubCloneable) clone).getName());
        assertEquals("sub", ((SubCloneable) clone).getSubName());

        assertEquals(2, origin.getItems().size());
        assertEquals(1, ((SubCloneable) clone).getItems().size());
    }
}