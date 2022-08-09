package item05.concrete;

public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = dictionary;
    }

    public boolean isValid(String word) {
        return dictionary.isValid(word);
    }
}
