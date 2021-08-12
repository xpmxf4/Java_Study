# 오답 노트

## CH2

- 예약어란?

  : 자바에 등록되어 있고, 시스템과 사용자간 약속되어있는 단어를 뜻함.

  : 자바에 예약어로 등록되어 있는 단어는 속성의 변수명, 메소드명으로 사용할 수 없다.

  ex) int, long, final, float 등등

- char + char => int 이다

  ```java
  System.out.println('A'+'B') // 131
  ```

- 어떤 타입의 변수도 문자열과 덧셈 연산을 수행하면, 그 결과는 문자열이 된다. ( 문자열이 아닌 것이 먼저 문자열고 바뀌고 난 뒤에 덧셈 연산이 진행됨 )

  ```java
  System.out.println(true+"") // "true"
  ```

- 기본형 + 참조형 은 성립 x

- System 은 키워드가 아니다!

- 변수 명명 규칙

  1. 대소문자 구분
  2. 예약어 사용 x
  3. 숫자로 시작 x
  4. 특수문자는 $, _ 만 사용 가능

- 참조형 변수의 기본 크기는 4 byte 이지만, null 인 경우 0 byte 이다. 하지만 만약 JVM 이 64 bit 인 경우 8 byte 라고도 하지만, 일반적으로 4 byte 라고 한다.

- 기본형에서 boolean 을 제외한 나머지 타입끼리는 서로 형변환이 가능하다.

  byte -> short -> int -> long -> float -> double

  ​			char -----↑

  화살표 방향대로는 형변환을 생략할 수 있다.

- char 는 초기화 할 때 

  ```java
  char c = ' ';	
  ```

  이와 같이 불가능. 무조건 한 개의 character 가 있어야 한다.

- 참조형의 기본값은 null 이다.

  ```java 
  String - "" (x) 
  ```



## CH3



