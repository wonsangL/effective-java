# Item 01. 생성자 대신 정적 팩터리 메서드를 고려하라

> 클래스는 생성자와 별도로 정적 팩터리 메서드(static factory method)를 제공할 수 있다.

## 왜 정적 메서드를 사용해야 하는가?
- 이름을 가질 수 있다.
    - 의미 전달이 용이한 코드를 작성할 수 있다.
    ```
    🤔 이름을 정의하기 어려운 케이스도 존재하지 않을까?
    🤗 필드가 여러 개일 경우는 Builder를 활용
    ```
- 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
    ```
    🤔 Flyweight pattern VS Singleton pattern?
    🤗 Flyweight pattern은 Sigleton pattern의 한 방법으로 이해하자
        참조: https://stackoverflow.com/questions/16750758/what-are-the-practical-use-differences-between-flyweight-vs-singleton-patterns
    ```
- 반환 타입을 하위 타입 객체로 반환할 수 있는 능력이 있다.
- 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
  
- 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.

## 단점은 무엇이 있는가?
- 하위 클래스를 만들 수 없다.
- 프로그래머가 찾기 어렵다.