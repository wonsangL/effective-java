# Item 6. 불필요한 객체 생성을 피하라
## 불변 객체의 재사용
불변 객체를 인스턴스화하여 불필요한 객체가 생성되지 않도록 주의하자.

[책에 나온 `String` 예제 코드를 눈으로 확인해보자](code/src/main/java/item06/ImmutableClass.java)

## '비싼 객체'의 재사용
생성 비용이 비싼 객체의 경우 매번 생성하지 말고 캐싱하여 재사용할 수 있는지 고려하자.
```
🤔 Pattern 인스턴스를 필드로 끄집어내면 encapsulation 개념에 반하고, 결합도가 높은 코드가 되는 것은 아닌지? 
🤗 클라이언트 코드에서는 Pattern 인스턴스는 RomanNumerals로 감싸져있어 encapsulation에 반하지는 않는 것으로 보인다.
   하지만 결합도는 올라가는 코드라고 생각된다.
   대부분의 문제가 그렇듯, 여기서 성능과 코드의 결헙도 역시 trade-off관계를 가지며 어느것에 중점을 둘지는
   도메인, 상황 등에 따라 선택해야할 문제라고 생각한다. 
```
```
🤔 Map 인터페이스의 keySet이 동일한 인스턴스를 반환한다면, thread-safe하지 않을 수 있지 않은가? 
🤗 HashMap, ConcurrentHashMap의 keySet 인스턴스가 clear, remove 호출시 map에도 영향을 준다.
   race condition이 발생하지만 않으면 이는 thread-safe 하다고 할 수 있는가?
```
- [`keySet` 예제 코드](code/src/main/java/item06/KeySetTest.java)
```
🤔 finite state machine이란? 
🤗 finite state machine은 유한한 상태를 가지며, 한 번에 오로지 하나의 상태만을 가지게 된다.
   상태는 어떠한 사건(Event)에 의해 다른 상태로 변화할 수 있으며, 이를 전이(Transition)이라 한다.
   참조: https://ko.wikipedia.org/wiki/%EC%9C%A0%ED%95%9C_%EC%83%81%ED%83%9C_%EA%B8%B0%EA%B3%84
🤔 그럼 finite state machine은 왜 쓰는가? 
🤗 직관적으로 상태관리를 하기 위해, 우리 업무에서는 어떤 상황에서 활용할 수 있을지 생각해보자
```

## 오토 박싱의 성능적 이슈
```java
private static long sum() {
    Long sum = 0L;
    for(long i = 0; i <= Integer.MAX_VALUE; i++)
        sum += i;
    return sum;
}
```
위 코드에서 `long` 타입의 `i`를 `Long` 타입의 `sum`으로 바꾸는데 성능적 부하가 발생한다.
