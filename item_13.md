# Item 13. `clone` 재정의는 주의해서 진행하라
`clone` 메서드 가장 적절한 사용법은 해당 메서드를 사용하지 않는 것이다.

말이 조금 이상하지만, 객체를 복사해야하는 상황이라면 `clone` 메서드를 사용하기 보단

**복사 생성자 혹은 복사 팩터리를 활용하는 것이 좋다.**

## 복자 생성자 / 복사 팩터리의 장점
`clone` 메서드와 비교했을 때, 복사 생성자와 복사 팩터리는 아래와 같은 장점이 있다.
즉, `clone` 메서드는 아래 내용과 반대되는 단점이 존재한다.
- 생성자를 호출하지 않고 객체를 생성하는 것이 불가능하다.(`clone` 메서드는 가능하다.)
- 형변환이 필요하지 않다.(`clone` 메서드는 필요하다.)

## `clone` 재정의 해야하는 경우
책에서는 따로 언급하고 있지는 않지만, 85 페이지에서 다음과 같이 이야기한다.

> 요약하자면, `Cloneable`을 구현하는 모든 클래스는 `clone`을 재정의해야한다.

정확하게 이해한 것인지는 모르겠지만, 필자의 생각으로는 `clone`을 재정의 해야하는 경우는

`Cloneable`을 구현하거나, `Cloneable`을 구현한 클래스를 상속받는 경우이다.

아래 코드를 보자

```java
public class CloneableClass implements Cloneable {
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        CloneableClass clone = (CloneableClass) super.clone();
        clone.name = this.name;
        return clone;
    }
}

public class SubNonCloneable extends CloneableClass {
    private List<String> items;
}
```

위 예제에서 `CloneableClass`는 `Cloneable`을 구현하고 `clone`메서드를 재정의하고 있지만

`CloneableClass`를 상속받는 `SubNonCloneableClass`는 객체 참조 필드(`items`)를 하나 가지고 있지만

`clone` 메서드를 재정의하고 있지 않다.

이 경우 아래와 같이 테스트 코드를 수행해보자

```java
class SubNonCloneableTest {
    @Test
    void cloneTest() throws CloneNotSupportedException {
        List<String> items = new ArrayList<>();
        items.add("item");

        SubNonCloneable origin = new SubNonCloneable();
        origin.setItems(items);

        Object clone = origin.clone();

        origin.getItems().add("new item");

        assertEquals(2, origin.getItems().size());
        assertEquals(1, ((SubNonCloneable) clone).getItems().size());
    }
}
```

위 테스트 코드는 원본이 되는 `SubNonCloneable` 인스턴스를 만들어 `items` 리스트를 참조하고

이후에 `clone` 메서드를 호출하여 복사본을 생성하고 원본 `items`에 항목을 추가한다.

우리가 기대하는 결과는 원본 항목만 늘어나고 복사본에는 변경이 없는 것이지만

해당 테스트는 실패하게 된다.

`clone` 메서드가 실행될 때, **얕은 복사**가 일어나, 

원본과 복사본의 `items`는 동일한 객체를 바라보게 되었기 때문이다.

이와 같은 문제를 해결하기 위해서는 `SubNonCloneable` 클래스가 `clone` 메서드를 재정의해야하고

**이 때가 `clone` 메서드를 재정의해야하는 경우라고 생각된다.** 

**하지만 이를 위해서는 클래스를 상속할 때마다 상위 클래스에 `clone` 메서드가 재정의 되어있는지**

**확인해야하기 때문에 현실적으로 가능한지에 대해서는 의문이 생긴다.**

**결국 `clone` 메서드를 처음부터 사용하지 않는게 가장 좋은 방법일 수 있을 것 같다**