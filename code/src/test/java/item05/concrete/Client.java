package item05.concrete;

public class Client {
    public static void main(String[] args) {
        SpellChecker spellChecker = new SpellChecker(new Lexicon());
        spellChecker.isValid("hello word");
    }
}
