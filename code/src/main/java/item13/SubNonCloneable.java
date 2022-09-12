package item13;

import java.util.List;

public class SubNonCloneable extends CloneableClass {
    private String subName;

    private List<String> items;

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
