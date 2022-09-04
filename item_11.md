# Item 11. `equals`를 재정의하려거든 `hashCode`도 재정의하라
책에서 설명한 `Object` javadoc 원문은 아래와 같다.
> The general contract of hashCode is:
> - Whenever it is invoked on the same object more than once during an execution of a Java application, 
>   the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified. 
>   This integer need not remain consistent from one execution of an application to another execution of the same application.
> - If two objects are equal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce the same integer result.
> - It is not required that if two objects are unequal according to the equals(Object) method, then calling the hashCode method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.

## `hashCode`를 작성하는 요령
### 1. `int`변수 `result`를 초기화한다.
### 2. 해당 객체는 핵심 필드들에 대해서 다음 작업을 수행한다.
#### a. 해당 필드의 해시코드를 계산한다.
- 해당 필드가 기본 타입이라면 `Type.hashCode`를 수행한다. 여기서 `Type`이란, 해당 타입의 박싱 클래스다.
- 참조 타입이면서 클래스의 `equals` 메서드가 내부에서 필드의 `equals`를 호출한다면, `hashCode`에서도 필드의 `hashCode`를 호출한다.
- 필드가 배열이라면, 핵심 원소 각각을 별도의 필드처럼 다룬다.
  - 배열에 핵심 원소가 없다면 상수 0을 사용한다.
  - 배열에 모든 원소가 핵심 원소라면 `Arrays.hashCode`를 사용한다.
#### b. 단계 2.a 에서 계산한 해시코드로 `result`를 갱신한다.
$ result = 31 * result + {계산한 해시코드} $

31을 곱해주는 이유는 31이 홀수이면서 소수(prime)이기 때문이다.
### 3. `result`를 반환한다.

다른 필드로부터 계산해 낼 수 있는 필드는 모두 무시해도된다.

또한, `equals` 비교에서 사용되지 않은 필드는 **반드시** 제외해야 한다.