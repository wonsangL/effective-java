# Item 14. `Comparable`을 구현할지 고려하라
알파벳, 숫자 등과 같이 순서가 명확한 값 클래스를 정의한다면

`Comparable` 인터페이스를 구현하는 것을 권장한다.

`Comparable`인터페이스는 `compareTo`라는 메서드 하나가 선언되어 있는 인터페이스로,

`compareTo`는 단순 동치성 비교에 더해 순서까지 비교할 수 있는 메서드이다.

## `compareTo` 메서드의 일반 규약
`compareTo` 메서드는 객체의 순서를 비교한다.

매개변수로 전달되는 객체가 더 크면 음수를, 같으면 0을, 더 크면 양수를 반환한다.

이 외에도 `compareTo`를 구현하기 위해서는 아래와 같은 규약을 지켜야한다.

- 두 객체 참조의 순서를 바꿔 비교해도 예상한 결과가 나와야한다.
  
    객체 x가 y보다 크다고 가정하고 `x.compareTo(y)`의 결과가 양수라면 `y.compareTo(x)`는 음수여야 한다.
- 첫 번째 객체가 두 번째 객체보다 크고, 두 번째 객체가 세 번째 객체보다 크면, 첫 번째 객체는 세 번째 객체보다 커야한다.

    객체 x, y, z에 대해서, `x.compareTo(y)`가 양수고 `y.compareTo(z)`도 양수라면 `x.compareTo(z)`도 양수여야한다.
- 크기가 같은 객체들끼리는 어떤 객체와 비교하더라도 항상 같은 결과가 반환되어야한다.

하지만 `compareTo` 메서드는 `equals` 메서드([item 10](item_10.md))와 마찬가지로 

상속 구조에서 위 규약을 지키기 어려운 문제가 있다.

[상속 구조에서 추이성이 깨지는 예제 코드](/code/src/test/java/item14/ColorPointTest.java)

위의 코드에서는 추이성이 깨지는 간단한 예제와 추이성이 깨지면 정렬과정에서 발생할 수 있는 문제를 간단하게 보여주고 있다.

## Compare construction method
다음과 같이 메서드 연쇄 방식으로 비교자를 생성할 수 있다.

```java
public class ColorPoint extends Point {
    private String color;

    private static final Comparator<ColorPoint> COMPARATOR = 
            Comparator.comparing((ColorPoint point) -> point.getDistance())
            .thenComparing(point -> point.color);
}
```

위 예제의 전체 코드는 [링크](/code/src/main/java/item14/ColorPoint.java)에서 확인할 수 있다.