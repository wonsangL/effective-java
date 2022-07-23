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
    🤗 Singleton은 오로지 하나의 객체를 생성하고 이를 재활용하여 메모리를 절약하는 디자인 패턴이지만, flywegith은 객체가 여러개 생기더라도 문제가 되지 않는다.
        참조: https://stackoverflow.com/questions/16750758/what-are-the-practical-use-differences-between-flyweight-vs-singleton-patterns
    ```
  - [flyweight pattern 예제 코드](code/src/main/java/item01/flyweight)
- 반환 타입을 하위 타입 객체로 반환할 수 있는 능력이 있다.
- 입력 매개변수에 따라 매번 다른 클래스의 객체를 반환할 수 있다.
- 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.

## 단점은 무엇이 있는가?
- 정적 팩터리 메서드만 제공할 경우, 생성자가 없기 때문에 하위 클래스를 만들 수 없다.
- 프로그래머가 찾기 어렵다.
  - 생성자와 같이 명확하게 들어나지 않기 때문에 인스턴스화할 방법을 프로그래머가 직접 찾아야한다.
  - 흔히 사용하는 정적 팩터리 메서드 명명 방식
    - `from`: 매개변수를 하나 받아서 해당 타입의 인스턴스를 반환하는 형변환 메서드
    - `of`: 여러 매개면수를 받아 적합한 타입의 인스턴스를 반환하는 메서드
    - `valueOf`: `from`과 `of`의 더 자세한 버전?
    - `instance` 혹은 `getInstance`: 매개변수로 명시한 인스턴스를 반환하지만, 같은 인스턴스임을 보장하지는 않는다.
    - `create` 혹은 `newInstance`: 매번 새로운 인스턴스를 생성하여 반환하는 메서드
    - `get{Type}`: `Type` 객체를 반환하는 메서드, `getInstance`와 마찬가지로 같은 인스턴스임을 보장하지 않는다.
    - `new{Type}`: `Type` 객체를 반환하는 메서드, `newInstance`와 마찬가지로 매번 새로운 인스턴스를 생성한다.
    - `{type}`: `get{Type}`과 `new{Type}`의 간결한 버전