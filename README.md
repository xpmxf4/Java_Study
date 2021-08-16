# 오답 노트

## CH2 ( 변수 )

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



## CH3 ( 연산자 )

- 산술 변환이란? 

  : 두 연산자의 타입을 같게 일치시킨다. ( 보다  더 큰 타입으로 일치 ).

  : 피연산자의 타입이 int 보다 작은 타입이면 int 로 자동 치환됨.

  ```java
  byte a = 1;
  byte b = 1;
  byte c = a+b; // 오류! + 연산자는 a 와 b를 int 로 자동 치환하고 계산하므로 a+b 는 int 이다. 고로
  byte c = (byte)(a+b); // 이렇게 쓰는 게 옳다.
  ```

- 반올림을 해야 할 때 ( ex. Celcius 를 Fahrenheit 로 바꿔야 할 때 )

  ```java
  // " C = 5/9 * (F - 32)" 이고
  // F = 100 일 때 C 로 치환하기
  // 단, 변환 결과값은 소수점 셋째 자리에서 반올림 하기
  
  public static void main(String[] args){
      int F = 100;
      float C = (int)((5/9f * ( F- 32 )) * 100 + 0.5) / 100f; // 주의! 5/9f * (F - 32) * 100 + 0.5 에서 +0.5 가 double 임을 인지해야 함!
      
      System.out.println("Converted Celcius is " + C)
  }

- float 와 double 을 비교할 때

  ```java
  float f2 = 0.1f;
  double d = 0.1;
  
  boolean same = (float) d == f2; 
  ```

  위 같은 상황에서 (float) 를 안해줘도 된다. 하지만 실수는 근사값으로 표현하기 때문에 정확도가 떨어져 float 로 바꿔준 후에 비교하는 게 더 정확하다.

## CH4 ( 반복문과 조건문 )

- String str = "12345" -> 1+2+3+4+5 로 바꾸는 법

  ```java
  String str = "12345";
  int total = 0;
  for(int i = 0 ; i< str.length() ; i++){
      int num = str.charAt(i) - '0';		// 숫자로 치환
      total += num;
  }
  ```

