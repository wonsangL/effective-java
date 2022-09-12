package item13;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubNonCloneableTest {
    @Test
    void cloneTest() throws CloneNotSupportedException {
        List<String> items = new ArrayList<>();
        items.add("item");

        SubNonCloneable origin = new SubNonCloneable();
        origin.setName("origin");
        origin.setSubName("sub");
        origin.setItems(items);

        Object clone = origin.clone();

        origin.getItems().add("new item");

        assertEquals("origin", ((SubNonCloneable) clone).getName());
        assertEquals("sub", ((SubNonCloneable) clone).getSubName());

        assertEquals(2, origin.getItems().size());
        assertEquals(1, ((SubNonCloneable) clone).getItems().size());
    }
}