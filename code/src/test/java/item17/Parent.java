package item17;

public class Parent {
    private final String familyName;

    Parent(String familyName) {
        this.familyName = familyName;
    }

    public static Parent from(String familyName) {
        return new Parent(familyName);
    }
}
