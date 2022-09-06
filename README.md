# Effective Java 3/E
해당 Repo는 Effective Java를 학습한 내용을 정리하였습니다.


학습 과정에서 생긴 의문 혹은 자세한 설명이 필요하다고 생각되는 부분, 그리고 해당 내용의 나름의 답변은 아래의 형식으로 작성되었습니다.
```
🤔 학습 과정에서 생긴 의문 혹은 조금 더 자세한 설명이 필요하다고 생각되는 부분

🤗 위 내용에 대한 개인적인 답변
```

또한 정리하는 과정에서 작성한 코드는 [code](/code) 에 작상되었습니다.

잘못된 내용이 있거나 수정하고 싶은 내용을 이슈로 등록해주시면 참고할 수 있도록 하겠습니다. 

감사합니다.

## Contents
### 2장 객체 생성과 파괴
1. [Item 01. 생성자 대신 정적 팩터리 메서드를 고려하라](item_01.md)
2. [Item 02. 생성자에 매개변수가 많다면 빌더를 고려하라](item_02.md)
3. [Item 03. private 생성자나 열거 타입으로 싱글턴임을 보증하라](item_03.md)
4. [Item 4. 인스턴스화를 막으려거든 private 생성자를 사용하라](item_04.md)
5. [Item 5. 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라](item_05.md)
6. [Item 6. 불필요한 객체 생성을 피하라](item_06.md)
7. [Item 7. 다 쓴 객체 참조를 해제하라](item_07.md)
8. [Item 8. `finalizer`와 `cleaner` 사용을 피하라](item_08.md)
9. [Item 9. try-finally보다는 try-with-resources를 사용하라](item_09.md)

### 3장 모든 객체의 공통 메서드
10. [Item 10. `equals`는 일반 규약을 지켜 재정의하라](item_10.md)
11. [Item 11. `equals`를 재정의하려거든 `hashCode`도 재정의하라](item_11.md)
12. [Item 12. `toString`을 항상 재정의하라](item_12.md)