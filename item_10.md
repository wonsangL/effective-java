# Item 10. `equals`는 일반 규약을 지켜 재정의하라
## `equals` 재정의가 필요 **없는** 상황

### 각 인스턴스가 본질적으로 고유하다.
값을 표현하는 객체가 아닌 경우, `Thread`가 대표적인 예시다.

### 인스턴스의 논리적 동치성을 검사할 일이 없다.
### 상위 클래스에서 재정의한 `equals`가 하위 클래스에도 사용 가능하다.
### 클래스가 `private`이거나 `package-private`이고 `equals`를 호출할 일이 없다.
`equals` 호출을 막고 싶다면 아래와 같이 구현할 것을 책은 제시한다.

```java
@Override
public boolean equals(Object o) {
    throw new AssertionError();
}
```

## `equals` 재정의가 필요한 상황
### 논리적 동치성을 검사해야하지만, 상위 클래스에서 `equals`를 재정의하지 않았을 경우
`equals`를 재정의할 때는 아래와 같은 규약을 따라야한다.
- 반사성(reflexivity) : `null`이 아닌 모든 참조 값 x에 대해, `x.equals(x)`는 `true`이다.
- 대칭성(symmetry) : `null`이 아닌 모든 참조 값 x, y에 대해, `x.equlas(y)`가 `true`면 `y.equals(x)`도 `true`다.
- 추이성(transitivity) : `null`이 아닌 모든 참조 값 x, y, z에 대해, `x.equlas(y)`가 `true`고 `y.equals(z)`가 `true`면, `x.equals(z)`도 `true`다.
- 일관성(consistency) : `null`이 아닌 모든 참조 값 x, y에 대해, 객체를 수정하지 않는 한 `x.equals(y)`를 반복 호출해도 결과는 항상 같아야한다.
- `null` 아님 : `null`이 아닌 모든 참조 값 x에 대해, `x.equals(null)`은 `false`다.

### 좋은 퀄리티의 `equals`를 정의하는 방법
#### 1. `==` 연산자를 이용해 자기 자신의 참조인지 확인한다.
성능 최적화를 위함이며 비교 연산이 복잡할 수록 효과가 있다.

#### 2. `instanceof` 연산자로 입력이 올바르니 타입인지 확인한다.
`instanceof`의 피연산자가 `null`일 경우 `false`를 반환하기 때문에 별도의 `null` 체크는 필요없다.

#### 3. 입력을 올바른 타입으로 형병환한다.

#### 4. 입력 객체와 자기 자신의 대응되는 핵심 필드들이 모두 일치하는지 하나씩 검사한다.
