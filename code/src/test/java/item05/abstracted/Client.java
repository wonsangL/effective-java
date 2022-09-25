package item05.abstracted;

public class Client {
    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker(new EnglishLexicon());
        spellChecker.isValid("hello word");
    }
}
