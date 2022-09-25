package item13;

import java.util.ArrayList;
import java.util.List;

public class SubCloneable extends CloneableClass {
    private String subName;

    private List<String> items;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object objectClone = super.clone();

        if (objectClone instanceof SubCloneable) {
            SubCloneable clone = (SubCloneable) objectClone;
            clone.subName = this.subName;
            clone.items = new ArrayList<>(items);
            return clone;
        }

        return objectClone;
    }

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
