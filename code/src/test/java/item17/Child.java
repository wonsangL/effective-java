package item17;

public class Child extends Parent {
    private final String name;

    Child(String familyName, String name) {
        super(familyName);
        this.name = name;
    }

    public static Child from(String familyName, String name) {
        return new Child(familyName, name);
    }
}
