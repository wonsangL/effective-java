package item13;

public class CloneableClass implements Cloneable {
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object objectClone = super.clone();

        if (objectClone instanceof CloneableClass) {
            CloneableClass clone = (CloneableClass) objectClone;
            clone.name = this.name;
            return clone;
        }

        return objectClone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
