# Item 64. 객체는 인터페이스를 사용해 참조하라
> 적합한 인터페이스만 있다면 매개변수뿐 아니라 반환값, 변수, 필드를 전부 인터페이스 타입으로 선언하라.

## 왜 인터페이스 타입을 사용해야하는가?
> 인터페이스 타입을 사용함으로써 '수정에 용이한'(책에서는 '유연한') 프로그램을 구현할 수 있다.

아래와 같이 코드를 작성했다고 가정해보자.
``` java
//ConcreteClass 선언
public class ConcreteClass {
    public void call() {
        System.out.println("this is bad.");
    }
}

//ConcreteClass 호출하는 클라이언트 코드
ConcreteClass bad = new ConcreteClass();
bad.call();
```
이때, `ConcreteClass`보다 좋은 성능의 `NewConcreteClass`를 아래와 같이 구현하였고,

이를 적용한다고 가정해보자.

``` java
//ConcreteClass 선언
public class NewConcreteClass {
    public void apply() {
        System.out.println("this is better, but still bad.");
    }
}
```
이 경우에 우리는 클라이언트 코드 이곳 저곳을 수정해야한다.

(처음 선언하는 부분과 메서드를 call에서 apply로 수정해야한다.)

</br>

하지만 인터페이스를 활용하는 경우, 

책의 예제와 같이 처음 선언 하는 부분만 수정하면 다른 코드는 전혀 손대지 않아도 된다.