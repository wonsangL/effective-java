# Item 03. private 생성자나 열거 타입으로 싱글턴임을 보증하라
## 싱글턴 객체를 생성하는 방법
- 생성자를 `private`로 감추고 `public static final` 멤버를 정의한다.
  ```java
  public class Elvis {
    public static final Elvis INSTANCE = new Elvis();
   
    private Elvis() { ... }
  }
  ```
- 위의 멤버 변수를 [정적 팩터리 메소드](item_01.md)로 제공한다.
    ```java
    public class Elvis {
        private static final Elvis INSTANCE = new Elvis();
   
        private Elvis() { ... }
   
        public static Elvis getInstance() { return INSTANCE; }
    }
    ```

```
🤔 싱글턴 패턴에서 위와 같이 정적으로 정적 멤버 변수를 생성하는 것(eager initialization) 외에 해당 객체에 접근할 때 생성하는 방법을 주로 이야기한다.
```
```java
public class Elvis {
   private static Elvis INSTANCE;
   
   public static Elvis getInstance() {
       if (INSTANCE == null) {
           INSTANCE = new Elvis();
           return INSTANCE;
       }
       return INSTANCE;
   }
}
```
```
🤗 동적으로 객체를 생성하는 방식은 객체를 사용할때에만 생성하여 메모리를 아낄 수 있다는 것이다.
   하지만 개인적으로 위와 같은 주장이 의미가 있기 위해서는 해당 객체가 생성되지 않는 케이스에 국한된다고 생각한다.
   어차피 이후에 생성된다면 생성하는 타이밍을 미룬 것과 다를게 없다고 느껴지기 때문이다.
   그렇다고 객체가 생성되지 않는다면 애초에 구현할 필요가 있을까라는 의문 역시 들기때문에
   오히려 책에서 이야기하는 정적 멤버 방식을 선호한다.
   이 외에도 동적으로 객체를 생성하는 방법은 동시성 문제 또한 무시할 수 없다. 
```

## 싱글턴 객체의 직렬화(serialization)와 역직렬화(Deserialization)
위의 예제 코드들의 객체는 역직렬화시에 새로운 객체가 생성되기 때문에 싱글턴을 보장하지 않는다.

위 문제를 해결하기 위해서는 모든 인스턴스는 필드를 일시적(transient)이라고 선언하고 [`readResolve` 메서드를 제공](item_89.md)해야한다.
```
🤔 인스턴스 필드를 일시적(transient)이라고 선언한다는 것은 무슨 의미인가?
🤗 transient는 serialize 과정에서 해당 필드를 제외하고 싶을때 사용한다.
   참조: https://nesoy.github.io/articles/2018-06/Java-transient
```