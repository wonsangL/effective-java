package item01.flyweight.before;

/**
 * 해당 객체는 백기선님의 <a href="https://www.inflearn.com/course/%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4/dashboard">코딩으로 학습하는 GoF의 디자인 패턴</a>
 * 강의를 참고하여 작성된 코드입니다.
 */
public class Character {
    private char value;
    private String color;
    private String fontFamily;
    private int size;

    public Character(char value, String color, String fontFamily, int size) {
        this.value = value;
        this.color = color;
        this.fontFamily = fontFamily;
        this.size = size;
    }
}
