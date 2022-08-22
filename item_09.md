# Item 9. try-finally보다는 try-with-resources를 사용하라
## `AutoCloseable`을 구현하여 자원을 닫자
자바 라이브러리에는 `close`를 사용하여 닫아줘야하는 자원들이 있다.

`try-finally`를 사용하여 자원을 닫을 경우, 아래와 같은 단점이 존재한다.
 - `finally` 내부에서 예외가 발생할 경우 `try` 내부에서 발생한 예외를 무시한다.
 - 자원이 많아질수록 `try-finally` 블럭이 중첩되어 코드의 가독성이 떨어진다.

위의 문제를 해결하기 위한 방법 중 하나로 책에서는 `AutoCloseable`을 사용하는 것을 제시한다.

```java
public interface AutoCloseable {
    void close() throws Exception;
}
```



[suppressed exception 예제 코드](code/src/main/java/item09/AutoCloseableTest.java)

