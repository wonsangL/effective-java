package item01.flyweight.after;

/**
 * 해당 객체는 백기선님의 <a href="https://www.inflearn.com/course/%EB%94%94%EC%9E%90%EC%9D%B8-%ED%8C%A8%ED%84%B4/dashboard">코딩으로 학습하는 GoF의 디자인 패턴</a>
 * 강의를 참고하여 작성된 코드입니다.
 */
public class Client {
    public static void main(String[] args) {
        Character c1 = new Character('h', "white", FontFactory.getFont("nanum:10"));
        Character c2 = new Character('e', "white", FontFactory.getFont("nanum:10"));
        Character c3 = new Character('l', "white", FontFactory.getFont("nanum:10"));
        Character c4 = new Character('l', "white", FontFactory.getFont("nanum:10"));
        Character c5 = new Character('w', "white", FontFactory.getFont("nanum:10"));
        Character c6 = new Character('o', "white", FontFactory.getFont("nanum:10"));
        Character c7 = new Character('r', "white", FontFactory.getFont("nanum:10"));
        Character c8 = new Character('l', "white", FontFactory.getFont("nanum:10"));
        Character c9 = new Character('d', "white", FontFactory.getFont("nanum:10"));
    }
}
