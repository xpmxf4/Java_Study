# CH6 - 객체지향 ( OOP )

## 6-1 객체지향언어

- 80년 초 소프트웨어 ( C 언어, Fortran, Cobol 등 절차적 언어들 ) 의 위기 - 세상의 빠른 변화를 못 쫓아감, 시대의 흐름에 따라 계속 발전해 가면서 바뀌어야 하는 데 이게 안되고 있었음. 

  이를 해결하기 위해 해결책으로 객체지향 언어 ( 1960년 에 simula -> smalltalk 등등이 나옴. 근데 안 쓰임. 하드웨어가 이를 뒷받침 해줄만한 성능이 되지 못했기 때문에 )를 도입 ( 절차적 -> 객체지향 )

  그래서 C언어 에서 객체지향 개념을 추가한게 C++ 이다. 하지만 C++ 이 배우기가 너무 어려워서 객체지향 개념이 널리 퍼지지 못함.

  

- JAVA 는 C++ 단점도 보완하고, 잘 안 쓰는 기능들을 떼고 만든 것이다. JAVA 를 통해 '객체지향' 이라는 개념이 널리 퍼짐.

  객체지향개념을 사용함으로써 

  1. **코드의 재사용성이 높고, **
  2. **유지보수가 용이, **
  3. **중복 코드 제거**

- **객체지향 언어 = 프로그래밍 언어 ( 기존의 언어 ) + 객체지향개념 ( 규칙 )** = 기존의 언어 + 몇가지의 개념 & 규칙 이라고 생각하면 된다. 이러한 규칙이 왜 생겼다? 

  => 코드의 재사용성 높, 유지보수 용이, 중복 코드 제거

  **규칙은 그냥 외우자.** 이해가 아닌 외우라고 생각하면 갸우뚱 할 수도 있다. 하지만 축구를 할 때 규칙들이 존재하고, 이 규칙들은 플레이 하면서 당연히 지키면서 하는 거지 이 규칙이 왜 있냐? 라는 질문은 축구에 대한 이해를 조금 높일 수 있을지언정 그닥 도움은 안될 것이니 그냥 닥치고 하자.

- OOP (Object-oriented programming) 의 4가지 핵심 개념
  1. 캡슐화
  2. 상속
  3. 추상화
  4. **다형성 ( 남궁성님 가장 중요한 픽 !)**  

## 6-2~4 클래스와 객체

- 클래스의 정의 : 클래스란 **객체를 정의**해 놓은 것
- 클래스의 용도 : 클래스는 **객체를 생성**하는 데 **사용** 

- 객체의 정의 : **실제로 존재하는 것**. 사물 또는 개념
- 객체의 용도 : **객체**가 가지고 있는 **기능과 속성**에 따라 **다름**

|   클래스    |  객체  |
| :---------: | :----: |
| 제품 설계도 |  제품  |
|  TV 설계도  |   TV   |
|  붕어빵 틀  | 붕어빵 |

( 이렇게 비유하는 것을 틀렸다고 말하는 사람들도 있음. 그냥 느낌만 받아가자! )

- 실제세계(하드웨어) 를 어떻게 하면 컴퓨터 안(소프트웨어) 으로 옮길 수 있을까? 라는 고민에서 비롯함. 

  미사일 발사에 대한 실험을 컴퓨터 안에서 미리 몇 번 돌려보면 시행착오를 굉장히 줄일 수 있다 라는 군사 목적에서 시작됨. 

  미사일 뿐만이 아니라 TV, 오디오 플레이어, 비디오 플레이어 등의 하드웨어를 소프트웨어화 (프로그램화 한다 = 코드로 만든다.) 했기 때문에 요즘 날 컴퓨터에서 이것 저것 할수 있는 것.

- **사물 (객체) = 속성 (변수) + 기능 (메서드)**

  TV 라는 사물(객체) 를 분석해봤을 때 다음 표와 같이 정리할 수 있다.

  |                 속성                  |                          기능                          |
  | :-----------------------------------: | :----------------------------------------------------: |
  | 크기, 길이, 높이, 색상, 볼륨, 채널 등 | 켜기, 끄기 ,볼륨 높이기, 볼륨 낮추기, 채녈 변경하기 등 |

- 위 표를 코드로 바꾸면 다음과 같은 코드로 치환할 수 있다.

  ```java
  class Tv {
      String color;
      boolean power;
      int channel;
      
      void power()		{power = !power;}
      void channelUp()	 {channel++;}
      void channelDown()   {channel--;}
  }
  ```



- 객체와 인스턴스의 차이 

  객체 : 모든 인스턴스를 대표하는 일반적 용어

  인스턴스 : 특정 클래스로부터 생성된 객체 ( 예: TV 인스턴스 )

  둘이 그냥 같은 용어다 라고 생각하면 된다.

  ```java
  (설계도)								인스턴스화 - (제품생성) 				   (제품) - 사용
   클래스  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ> 인스턴스(객체)
  ```

**정리**

Q. 클래스가 왜 필요한가?
A. 객체(제품)를 생성하기 위해

Q. 객체가 왜 필요한가?
A. 객체(제품)를 사용하기 위해

Q. 객체를 사용한다는 것은?
A. 객체가 가진 속성과 기능을 사용한다 라는 의미와 같다.

## CH6-5 하나의 소스파일에 여러 클래스 작성

```java
//Hello2.java
public class Hello2{}
class Hello3 {}
```

public class 가 있는 경우, 소스파일의 이름은 반드시 public class 의 이름과 일치해야한다.

```java
//Hello2.java
class Hello2{}
class Hello3{}
```

위의 경우 public class 가 없으니 소스 파일의 이름은 Hello2, Hello3 둘다 가능하다.

- 규칙 

  1. 하나의 소스파일에 둘 이상의 public class 가 있으면 안 된다.

     ```java
     //Hello2.java
     public class Hello2{}
     public class Hello3{}
     ```

  2. 소스파일의 이름은 public class 의 이름과 일치해야 한다.

     ```java
     //Hello3.java -> public 이 Hello2 클래스에 있으니까 Hello2.java 여야 한다.
     public class Hello2{}
     class Hello3{}
     ```

  3. 자바는 대소문자를 구분하기 때문에, public class 의 이름과 대소문자까지 다 동일해야 한다.

     ```java
     //hello2.java -> hello2 랑 Hello2 랑은 엄연히 다르다. Hello2.java 여야 한다.
     public class Hello2{}
     class Hello3{}
     ```

  4. main 메서드가 있는 클래스의 이름을 소스 파일과 동일하게 해야 한다.

     ```java
     // Hello3.java (x) -> main 메서드는 Hello2 에 있으니까 Hello2.java 여야 한다.
     
     class Hello2{
         public static void main(String[] args){
             System.out.println("Hello2")
         }
     }
     
     class Hello3{}
     ```

     

## CH6- 6, 7 객체의 생성과 사용

- 객체의 생성

  ```java
  클래스명 변수명;
  변수명 = new 클래스명();
  
  Tv t;	// 참조변수(리모콘)
  t = new Tv();	// new Tv() 로 객체(Tv)를 만들고, 참조변수 t 에다가 Tv인스턴스의 주소를 할당(Tv와 리모콘을 연결)
  ```

- 객체의 사용 - **꼭 참조변수를 통해서만 접근해야함! 참조변수 없이 인스턴스를 다룰 순 없다!**  

  ```java
  t.channel = 7;		// Tv 인스턴스의 멤버변수 channel의 값을 7로 한다.
  t.channelDown();	// Tv 인스턴스의 메서드 channelDown() 을 호출한다.
  System.out.println("현재 채널은 "+ t.channel + " 입니다. ")
  ```

- 객체 생성과 사용의 과정 정리

  1. 클래스 작성 ( 설계도 작성 )
  2. 객체 생성 ( 제품 생성)
  3. 객체의 사용 (제품 사용)

  ```java
Tv t;	// Tv 클래스 타입의 참조변수 t를 선언
  t = new Tv(); // Tv 인스턴스를 생성한 후, 생성된 Tv 인스턴스의 주소를 t에 저장
  
  t.channel = 7 // Tv 인스턴스의 멤버변수 channel의 값을 7로 한다
  t.channelDown(); //	Tv 인스턴스의 메서드 channelDown 을 실행시킨다.
  System.out.println("현재 채널은 " + t.channel + " 입니다.")
  ```
  
  ```java
현재 채널은 6 입니다.
  ```
  
  

- 예제 (객체를 2개 만들 때의 예시, GC에 대한 개념 나옴)

  ```java
  Tv t1 = new Tv();	// 0x100
  Tv t2 = new Tv();	// 0x200
  t1.channel = 7;
  // 이러면 t1 의 channel 은 7이지만, t2 는 channel 는 0 이다. 
  // 이름만 같지, 같은 변수가 아니기 때문이다.
  
  System.out.println("t1 의 channel 값은 " + t1.channel + "입니다.")	// 7
  System.out.println("t2 의 channel 값은 " + t2.channel + "입니다.")	// 0
      
  // 만약 t2 = t1 이라고 하면?
  // t2 에 0x100 이 할당되기 때문에, t2 와 0x200 의 연결은 끊기게 된다.
  // t2.channel 은 7이 된다.
  // 그리고 0x200 은 GC 메모리에 불필요 하게 있다고 판단되어 없어진다.
  // 원래는 불필요하게 메모리에 할당된 객체를 알아서 지워줘야 하는 데, Java 는 GC(garbage collector) 가 사용할 수 없는 객체라고 판단해서 메모리에서 지워버린다!
  ```




- 하나의 인스턴스를 여러 개의 참조변수가 가르킨다 (o)

  여러 인스턴스를 하나의 참조변수가 가르킨다 (x)
  
  ==> 변수는 한번에 하나의 값만 할당이 가능함. 즉 하나의 참조변수에는 하나의 객체 주소만 할당이 가능하기에 위처럼 같은 얘기가 나옴.

## CH6-8 객체배열 == 참조변수배열

- 객체 배열 == 참조변수 배열 이라고 한다!

```java
Tv tv1, tv2, tv3; 

Tv[] tvArr = new Tv[3];	// Tv[] tvArr = { new Tv[], new Tv[], new Tv[] }
												// 아 여기서 했네 ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ 복습의 중요성....
```

```java
Tv t1 = new Tv();
Tv t2 = new Tv();
Tv t3 = new Tv();

Tv[] tvArr = new Tv[3];
tvArr[0] = new Tv();	// 새로운 객체가 생성되고, 이 객체의 주소가 tvArr[0] 에 담기게 된다.
tvArr[1] = new Tv();
tvArr[2] = new Tv();
```

- 객체배열 or 참조변수 배열 에서 많이 받는 질문

  ```java
  Tv[] tvArr = new Tv[3];
  tvArr[0] = new Tv();	// 새로운 객체가 생성되고, 이 객체의 주소가 tvArr[0] 에 담기게 된다.
  tvArr[1] = new Tv();
  tvArr[2] = new Tv();
  ```

  여기서 밑에 

  ```java
  tvArr[0] = new Tv();	// 새로운 객체가 생성되고, 이 객체의 주소가 tvArr[0] 에 담기게 된다.
  tvArr[1] = new Tv();
  tvArr[2] = new Tv();
  ```

  이렇게 일일히 객체를 생성해줘야 한다!

  

## CH6-9, 10 클래스의 정의

- 클래스의 정의란?
  1. 설계도
  2. **데이터 + 함수 의 결합 ( 9 단원에서는 이 부분에 대해서 설명할 것! )**
  3. 사용자 정의 타입

- **클래스 == 데이터 + 함수**

  데이터의 저장공간의 발전 과정을 보자면 

  1. 처음에 **변수( 하나의 데이터를 저장할 수 있는 공간 )** 가 있었다.

  2. 변수가 발전해서 **배열(같은 종류의 여러 데이터를 하나로 저장할 수 있는 공간 )** 이라는 게 생김.

  3. 하지만 배열은 같은 종류밖에 저장할 수 없다는 한계가 있음

  4. 그래서 **구조체( 서로 관련된 여러 데이터( 종류 관계x ) 를 하나로 저장할 수 있는 공간 )** 라는 개념이 나옴.

     왜 굳이 다른 종류끼리 묶나? -> 서로 관계가 있는 변수니까!

  5. 구조체에서 더 발전한 게 **클래스( 데이터와 함수의 결합(구조체+ 함수) )** 이다.

     왜 데이터와 함수를 묶나? -> 데이터 뿐만이 아니라,  서로 관련이 있는 함수 까지도 같이 묶자! 라는 개념

     함수란(or 메서드란)? -> 명령문을 묶어 놓은 것이다.

     근데 함수는 어떤 작업or계산을 하는 데, 뭘 가지고 작업을 함? -> 데이터(숫자,문자) 를 가지고 작업을 함( 항상 그러지는 않지만, 주로 데이터를 가지고 작업을 한다. ) -> 그래서 이런 데이터와 관련이 있는 함수는 같이 묶어놓는 것이 편리하다. 

- **클래스의 마지막 정의 - 사용자 정의 타입 == 원하는 타입을 직접 만들 수 있다.** 

  ```java
  // 예를 들면 시간이라는 단위가 필요한 데 자바에는 기본형 8개 밖에 없어 내가 직접 클래스를 만든다고 해보자
  // ( 물론 자바에 시간을 다루기 위한 클래스가 있긴 함 )
  
  int hour;			//시
  int minute;		//분
  int second;		//초
  
  //3개의 시간을 만들어야 한다고 해보자.
  int hour1, hour2, hour3;
  int minute1, minute2, minute3;
  int second1, second3, second3;
  
  //너무 거지 같으니까 배열로
  int[] hour = new int[3];
  int[] minute = new int[3];
  int[] second = new int[3];
  //하지만 배열로 하게 되면 시간끼리 묶이게 된다.
  
  //그래서 클래스로 정의
  class Time{
      int hour;
      int minute;
      int second;
  }
  Time t1 = new Time();
  Time t2 = new Time();
  Time t3 = new Time();
  //or
  
  Time[] t = new Time[3];
  t[0] = new Time();
  t[1] = new Time();
  t[2] = new Time();
  ```

- 저장공간에서의 클래스와 변수의 차이

  <img src="C:\Users\xpmxf\Desktop\클래스와변수차이.png" alt="클래스와변수차이" style="zoom:75%;" />

  변수 3개로 선언을 하든, 클래스안에 멤버 변수 3개 선언하든 3개의 변수( 하나의 데이터를 담기 위한 저장 공간 ) 이 생긴다는 것은 동일하다.

  하지만 클래스는 (시,분,초) 가 하나로 묶여 있어 객체지향적인 코드라고 말할 수 있지만, 좌측은 비객체지향적인 코드이다.

## CH6-11 선언 위치에 따른 변수의 종류

-------

- **클래스에서는 변수의 선언문만 가능!**

- 지금까지는 변수의 타입만 얘기했지만, 이제는 변수의 종류에 대해서 얘기할 것

  변수의 종류는 어디에서 선언이 되었느냐에 따라서 종류가 다름

```java
 class Variables{
     int iv;				// 인스턴스 변수
     static int cv;		// 클래스 변수(static 변수, 공유 변수)
 					   // iv, cv 는 클래스 범위 안에서 다 사용 가능
     				  
     void method(){
         int lv = 0;		// 지역변수
         			   // 범위(scope) 는 method() 중괄호 안, 메서드가 종료시 지역 변수는 자동 제거된다.
     }
 }
```



|            변수의 종류            |                      선언 위치                      |                          생성 시기                           |
| :-------------------------------: | :-------------------------------------------------: | :----------------------------------------------------------: |
|   클래스 변수(class variables)    |                     클래스 영역                     | 클래스가 메모리에 올라갈 때( 이게 가장 중요함!, 즉 객체가 생성이 안되어도 가능함! ) |
| 인스턴스 변수(instance variables) |                     클래스 영역                     |              **인스턴스(객체)가 생성되었을 때**              |
|     지역변수(local variables)     | 메서드 영역<br />(메서드, 생성자, 초기화 블럭 내부) |                 변수 선언문이 수행되었을 때                  |

- **객체 == iv 를 묶어놓은 것, 변수를 여러개 묶어놓은 것 ( 엄밀히 얘기하면 틀릴 수도 있는 데, 프로그래밍 관점에서 이렇게 그냥 느낌을 받아가자 )**

- 클래스 변수는 언제 생긴다? -> 클래스가 메모리에 올라갈 때 인데( 클래스가 필요할 때 ), 이게 대체 무슨 말?

  클래스가 필요할 때! 이다. 클래스는 설계도이고, 설계도는 객체가 만들 때 필요하다.

  객체를 만들기 전에, 설계도가 먼저 메모리에 올라가야 컴퓨터가 그 설계도를 보고 객체를 생성할 수 있는 것이다.

  ```java
  															<-- 로딩 (이때 cv가 생성, 즉 아무때나 사용 가능함)
  CPU <===============> RAM <===============> SSD / HDD
                                --> 세이브  
  ```

  

- cv 는 객체생성이 필요없다. -> 아무때나 사용이 가능하다.

- iv 는 객체생성이 필요하다. -> 객체행성을 무조건 해야만 사용이 가능하다.

- 정리하자면 영역은 
  1. 클래스 영역
     - iv (instance variable) -> 객체(인스턴스) 생성시 생성, 그리고 참조변수가 없어지면 GC 에 의해서 iv 는 없어진다.
     - cv (class variable)-> iv 에 static 붙인거, 클래스가 메모리에 올라갈 때
  2. 메서드 영역
     - lv (local variable) -> 변수 선언문이 수행되었을 때



## CH6-12, 13 클래스 변수와 인스턴스 변수

선언 위치로 변수를 구분 할때 다음과 같이 할 수 있겠다.

1. 클래스 영역
   - iv
   - cv
2. 메서드 영역
   - lv

이번 강의에서는 iv 와 cv 의 차이점에 대해 설명할 것.

![cv와iv카드사진](C:\Users\xpmxf\Desktop\cv와iv카드사진.png)

트럼프 카드를 예시로 들자.

카드라는 객체의 기능을 제외한 속성을 분석하면 2가지로 나누어 진다.

1. 모든 카드가 같은 값을 가지는 가로, 세로 길이	------------------>  cv
2. 카드마다 다른 값을 가지는 숫자, 모양    ----------------------------->  iv

그리고 이러한 cv,iv 를 다루는 방법은 다르다.

```java
public class Ex6_3 {
    public static void main(String[] args) {
        System.out.println("Card width  = " + Card.width);	// 객체 생성 없이 사용 가능!
        System.out.println("Card height  = " + Card.height);	// 위와 동일

        Card c1 = new Card();
        c1.kind = "Heart";
        c1.number = 7;

        Card c2 = new Card();
        c2.kind = "Spade";
        c2.number = 4;

        System.out.println("c1은 " + c1.kind + c1.number + "이며, 크기는 " + Card.width + "x" + Card.height);
        System.out.println("c2은 " + c2.kind + c2.number + "이며, 크기는 " + Card.width + "x" + Card.height);

//        c1.width = 50;
//        c1.height = 70; // 이 줄과 위에 줄처럼 해도 되긴 한다. 하지만 이렇게 쓰면 cv 가 iv 처럼 보임. 그래서 밑처럼 바꿔야 함
//      	c1.width = 999; // 이렇게 해도 c2 의 width 도 999로 바뀜! 이래서 밑처럼 Card.width 로 쓰는 게 좋다고 하는 거!
      	Card.width = 50;
        Card.height = 80;
      

        System.out.println("c1은 " + c1.kind + c1.number + "이며, 크기는 " + Card.width + "x" + Card.height);
        System.out.println("c2은 " + c2.kind + c2.number + "이며, 크기는 " + Card.width + "x" + Card.height);
    }
}
```



## CH6- 14~ 16 메서드란? 메서드의 선언부와 구현부

-----

메서드란?

1. 문장들을 { } 로 묶어놓은 것 ( 작업 단위 )

```java
public static void main(String[] args){
    for(int i=0; i<10; i++){
        numArr[i] = (int)(Math.random() * 10)
    }
    for(int i=0; i<10; i++)
        System.out.printf("%d", numArr[i])	// 1
			...중간생략
    for(int i=0; i<10; i++)
        System.out.printf("%d", numArr[i])	// 2
}
```

​	위 코드에서 1 과 2는 배열의 요소들을 출력하는 반복문이다.

​	근데 이렇게 똑같은 코드가 여러분 들어가는 것을 **코드의 중복**이라고 하고, 프로그래밍에서는 코드의 중복을 굉장히 안 좋게 본다.

```java
static void printArr(int[] numArr){
   for(int i=0; i<10; i++)
        System.out.printf("%d", numArr[i]);
   System.out.println();
}

public static void main(String[] args){
    for(int i =0 ; i< 10 ; i++)
        numArr[i] = (int)(Math.random()* 10);
    
    printArr(numArr);	// 메서드 호출(사용)
    	... 중간생략 ...
    printArr(numArr);
}
```

​	그래서 중복되는 부분을 이처럼 메서드를 사용해서 중복을 줄여 코드를 더 깔끔하게 짤 수 있다.

​	**즉, 메서드란 작업 단위로 문장들을 작업 단위로 묶어서 이름 붙인 것.**



2. 값(입력 == 작업에 필요한or사용할 값)을 받아서 처리하고, 그 결과를 반환 ( 출력 )

```java
int add(int x, int y){
    int result = x+y;
    
    return result;	//결과를 반환
}
```

**메서드와 함수의 차이?

-> 거의 비슷하다. 차이점이라면, 메서드는 클래스에 종속되어 있어야 하고, 함수를 그럴 필요가 없다. ( 가볍게만 알자 )



- 메서드의 장점
  1. 중복코드제거
  2. 관리 용이
  3. 재사용가능
  4. 코드가 간결해서 -> 이해하기 쉬워진다.

  
  
- 메서드의 작성

  1. 반복적으로 수행되는 여러 문장을 메서드로 작성

  2. 하나의 메서드는 한 가지 기능만 수행하도록 작성 ==> 나중에 코드 유지보수 하는 데 유리하고, 코드를 최소의 의미있는 작업 단위로 나눠놔야 재사용성이 높아진다!

  

- 메서드 = 선언부 + 구현부

  ```JAVA
  반환타입 메서드이름 ( 타입 변수명, 타입 변수명, ... )	// 선언부
  {												//  
  	// 메서드 호출시 수행될 코드    				 // 2 ~ 3 번째 줄까지 구현부
  }											     
  
  int add (int a, int b ){
      int result = a + b;
      return result;
  }
  ```

  **입력은 0 ~ 무한 개 가능. but 출력은 0 ~ 1 개이다. 만약 출력해야 되는 게 2가지 이상이다? -> 객체에 담아서 주면 됨. 왜냐하면 객체는 변수를 묶어놓은 것이니까!**

  만약 반환하는 게 없으면, 반환타입에 void 라고 적기

  

- 지역변수(lv) : 메서드 내에 선언된 변수

  ```java
  int add (int x, int y){		// 여기서 지역변수는 매개변수 x,y 그리고 result 이다. 메서드가 종료되면 모두 사라진다.
      int result = x + y ;
      return result
  }
  
  
  int multiply(int x, int y){	// 여기서 지역변수는 x,y 그리고 result 이다. 메서드가 종료되면 모두 사라진다.
      int result = x * y;
      return result;
  }
  ```

  add 와 multiply 의 지역변수의 이름은 같다. 하지만 scope 가 겹치치 않기 때문에 이름이 같아도 상관이 없다.

  **매개변수도 지역변수이다!**
  
  

## CH6-17 메서드의 호출(call)

메서드를 호출하는 방법은 다음과 같다.

```java
메서드이름(값1, 값2, ...);		// 값에다가는 작업에 필요한 값들을 넣어주면 된다.

print99danAll();			// void print99danAll() 을 호출
int result = add(3,5);		// int add(int x, int y)를 호출하고, 결과를 result 에 저장
						  // 굳이 변수에 저장안해도 상관은 없다. 하지만 변수에 저장하지 않으면, 메서드의 결과값을 
						  // 우린 이용할수 없을 것이다.
```

```java
public static void main(String[] args){
    MyMath mm = new MyMath();		// 객체 생성
    
    long value = mm.add(1L, 2L);	// 메서드 호출 -> 1L, 2L 이 복사가 되어서 ↓ , 그리고 다시 돌아오면 이후의 문장 수행
}								 //									   ↓					↑
								 //   <------------------------------------   				    ↑
								 //	  ↓														↑
class MyMath{					  //   ↓													 ↑
    long add (long x, long y) {		// 여기로 옴 -> 작업이 끝나면 return 값을 가지고 호출된 곳으로 다시감. 
        long result = x + y;
        return result;
        // return x + y; 라고 더 간단하게 표현할 수 있다.
    }

    long subtract(long x, long y){
        long result = x - y;
        return result;
    }

    long multiply(long x, long y ) {
        long result = x *y;
        return result;
    }

    long max(long x, long y ) {
        return x > y ? x : y;
    }

    double divide(long x, long y) {
        double result = x/(double)y;
        return result;
    }
}
```

- 메서드는 클래스 영역에만 정의 가능.



## CH6-20 return 문

- return 문이란?

  : 실행 중인 메서드를 종료하고, 호출한 곳으로  돌아간다.


```java
void printGugudan(int dan) {
    if(!(2 <= dan && dan <= 9))
        return;
    
    for(int i =1 ; i <=9 ; i++){
        System.out.printf("%d * %d = %d%n", dan, i , dan*i);
    }
    // return 원래는 써줘야 하지만 printGugudan 함수는 반환값이 void 이므로 생갹이 가능하다. 컴파일러가 자동으로 추가한다. 
}
```

--> 그래서 반환타입이 void 가 아니라면, 메서드 안에 return 문은 반드시 필요하다!!

```java
int multiply(int x, int y ){
    int result = x * y;
    return result;		// 여기서 result 와 반환타입(이 경우에는 int) 가 일치해야 한다. 아니면 적어도 자동형변환이 되는 관계여야 함! result 가 반환타입보다 작은 타입이어야 함!
}

int max(int a, int b){
    if(a>b)
        return a;		// 이렇게 하면은 a>b 일때만 return 문이 존재하는 거라 에러가 생김. 
}
```



## CH6-22 호출 스택 (call stack)

---

##### **모든 프로그래밍에서 공통된 개념이니 꼭 잘 이해하자!

- 먼저 스택(stack)이란?

  : 밑이 막힌 상자. 위에 차곡차곡 쌓인다.

  ![image-20210820155613136](C:\Users\xpmxf\AppData\Roaming\Typora\typora-user-images\image-20210820155613136.png)

  : 메서드 수행에 필요한 메모리 공간 (정확한 정의)

  : 메서드가 호출되면 호출스택에 메모리 할당, 종료되면 해제 

  ```java
  public static void main(String[] args){
      System.out.println("Hello World")
  }
  ```

  이와 같은 경우, 

  1. 스택에 먼저 main() 가 호출되어  쌓임
  2. 그 그리고 println() 메서드가 호출되어 println() 이 쌓임
  3. println() 메서드가 끝나고 나면 해제되고, 호출 스택에는 main() 만 남음
  4. main() 메서드의 실행이 끝나면 해제 됨 -> 호출 스택에는 아무것도 없어짐
  5. 프로그램 종료

  

  - 메모리 스택에서 위 메서드와 아래 메서드의 관계 :스택에서 아래에 있는 메서드가 위의 메서드를 호출한 것이다.
  - 무조건 스택에서는 가장 위의 메서드가 실행되고 나머지는 대기 중이다.

  ## CH6-23 기본형 매개변수

  매개변수의 타입에는 2가지가 있다. 그리고 그 차이는 다음과 같다.

  1. **기본형 매개변수** ( 변수의 값을 읽기, read only )
  2. 참조형 매개변수 ( 변수의 값을 읽고 , 변경할 수 있다. == read & write )

  이번 강의와 6-24 강의를 보고, 그 둘의 차이점을 인지하여 여기에다가 써보자!

  -----> 기본형 매개변수는 진짜 말 그대로 값, 즉 기본형 값을 넘긴거라서, 넘겨받은 값을 가지고 연산을 수행해도 그 어딘 가에 영향을 미치지 않는 다. 하지만 참조형 매개변수는 기본형 매개변수와는 다르게 메모리 상의 주소를 넘긴 것이다. 그래서 참조형 매개변수를 조작하게 되면, 조작을 가한 것들이 남게 된다.

  ```java
  //Ex6_6.java
  
  class Data{ int x ;}
  
  public class Ex6_6{
      public static void main(String[] args){
          Data d = new Data();
          d.x = 10;
          System.out.println("main() : x = "+ d.x);
          
          change(d.x);	// change 메서드에 d.x, 즉 10이라는 기본형 값을 넘긴 것이다.
          System.out.println("After changed(d.x)");
          System.out.println("main() : x = " + d.x);
      }
      
      static void change(int x ){		//이건 기본형 매개변수 이자 lv이다. 
          x = 1000;	// 넘겨받은 매개변수 x 에는 처음에 10 이 있었다가 1000을 할당함. x는 lv이기에 d의 x 에는 영향이 가지 않는 다.
          System.out.println("variable x in change() is " + x);
      }
  }
  ```

  

## CH6-24,25 참조형 매개변수,참조형 반환타입

---

매개변수에는 2가지 타입이 있다.

1. 기본형 매개변수 - 값을 읽기만 할 수 있다.
2. **참조형 매개변수 - 변수의 값을 읽고, 수정할 수 있다.**

```java
// Ex 6_8.java
class Data3 {
    int x;
}

class Ex6_8{
    public static void main(String[] args){
        Data3 d = new Data();
        d.x = 10;
        
        Data3 d2 = copy(d);
        System.out.println("d.x = " + d.x);	// 15
        System.out.println("d2.x = " + d2.x); // 15
    }
    
    static Data3 copy(Data3 d){
        Data3 tmp = new Data3();
        d.x = 15;
        tmp.x = d.x;
        return tmp;	// 주소값을 반환
    }
}

```

- 기본형 매개변수와 다르게, 이번에는 매개변수에 참조형 데이터를 보낸다.

  이 경우에 기존의 참조형 데이터(인스턴스) 의 변수 x 를 수정할 수 있다.

  즉, 기본형 매개변수의 case 와 다른 점은, 보내진 매개변수를 통해 **기존의 값이 수정 가능**하다는 점이다. 



## CH6-26~29 static 메서드와 인스턴스 메서드

- 인스턴스 메서드와 static 메서드의 차이 ==> iv(or 인스턴스 메서드) 를 사용할 수 있냐 없냐의 차이

```java
class MyMath2{
    long a,b;
    
    long add(){		// 인스턴스 메서드, 여기서 a,b 는 iv
        return a+b;
    }
    
    static long add(long a, long a){	// 클래스 메서드(static 메서드), 여기서 a,b 는 lv 
        return a+b;
    }
}
```

```java
class Test{
    void instanceMethod();
    static void classMethod();
    
    void instanceMethod2(){
        instanceMethod();	// 가능
        classMethod();		// 가능
    }
    
    static void classMethod2(){
        instanceMethod();	// 불가능
        classMethod();		// 불가능
    }
}
```



## CH 6-30~31 오버로딩

- 한 클래스 안에 같은 이름의 메서드 여러 개 정의하는 것

  ```java
  void println();
  void println(boolean x);
  void println(char x);
  void println(char[] x);
  void println(double x);
  void println(int x);
  void println(long x);
  void println(Object x);
  ```

  하지만 무지성으로 이름만 같다고 다 오버로딩이 아니고 다음과 같은 조건을 가진다

- 오버로딩이 성립하기 위한 조건

  1. 메서드의 이름이 같다
  2. 매개변수의 개수 or 타입이 달라야 한다.
  3. 반환 타입은 영향 x ==> 매개변수가 달라지는 시점에서 리턴타입이 당연히 달라지는 거라고 생각했는 데, 꼭 당연하지는 않은 듯. 매개변수가 리턴타입에 영향을 안 끼칠 수도 있으니.

**좀 의외의 오버로딩

```java
long add(int a, long b){ return a+b; }
long add(long a, int b){ return a+b; }
	  ①        ② 위 두 가지의 메서드가 타입이 다르다고 본다.
```



## CH 6-32~35 생성자(constructor), 기본 생성자

- 인스턴스가 생성될 때마다 호출되는 인스턴스 초기화 메서드
- 인스턴스 생성시 수행할 작업(iv 초기화)에 사용 
- 즉, **생성자 = iv 초기화 메서드**

```java
Time t = new Time();
t.hour = 12;
t.minute = 34;
t.second = 56;
```

```java
Time t = new Time(12,34,56)	//Time(12,34,56)이 생성자 이고, 이 문장은 생성자를 호출한 것
```



- 이름이 클래스 이름과 같아야 한다.
- 리턴값이 없다.(void 안 붙임)
- 모튼 클래스는 반드시 생성자를 가져야 한다.

```java
클래스이름(타입 변수명, 타입 변수명){
    // 인스턴스 생성시 수행될 코드
    // 주로 인스턴스 변수의 초기화 코드를 적는 다
}
```



- 기본 생성자

  : 매개변수가 없는 생성자

  ```java
  클래스이름() {} // 기본 생성자
  Point() {}	// Point 클래스의 기본 생성자
  ```

  : **클래스 마다 하나의 생성자를 무조건 만들어야 한다**. 근데 만약 사용자가 생성자를 하나도 안 만들면, 컴파일러가 알아서 기본 생성자 하나를 만들어준다.

  : 근데 다음과 같이

  ```java
  class Point(){
      int a = 1;
      
      Point(int b){
          b;
      }
  }
  ```

  이렇게 있으면 에러가 난다. ==> ??? 뭔 소리냐 에러 안남 갓궁성님이 얘기했던건 왠만하면 기본 생성자는 클래스 만들 때 항상 만들라고 했고, 안 이러면 자주 에러가 난다고 했었다. 컴파일러 믿지 말고 애진작 습관들이자가 key였다. 위처럼 썼을 때 에러가 나는 경우는 다음과 같을 때이다.
  
  ```java
  Point p = Point();	// Point 클래스는 생성자를 하나 선언했기 때문에 컴파일러가 기본 생성자를 안 만들어주기에, 이 코드는 에러가 나게 된다.
  ```
  
  

## CH 6-36~37 생성자 this(), 참조변수 this

- 생성자 this() 란?

  : 생성자에서 다른 생성자 호출할 때 사용

  : 다른 생성자 호출시 첫 줄에서만 사용가능

  : this 를 사용하는 이유? ---> 코드의 중복을 제거하기 위해서!

  ```java
  class Car{
      String color;
      String geartype;
      int door;
      
      Car(){
          color = "blue";
          geartype = "auto";
          door = 4; 
      }
      
      Car(String c, String g, int d){
          color = c;
          geartype = d;
          door = d;
      }
  }
  ```

  위 코드에서  기본 생성자 Car 와 3가지 매개 변수를 받는 생성자 Car 의 코드는 중복이 된다

  ----> 질 나쁜 코드

  그래서 이러한 중복을 아래와 같이 this 로 제거할 수 있다.

  ```java
  class Car{
      String color;
      String geartype;
      int door;
      
      Car(){
          this("blue","auto",4);
      }
      
      Car(String c, String g, int d){
  				color = c;
          geartype = g;
          door = d;
      }
  }
  ```



- 참조변수 this 란? <---------------------------> this() 생성자, **this() 생성자랑 연관이 아얘 없다!!!**

  : 인스턴스 자신을 가리키는 참조변수

  : 인스턴스 메서드(생성자 포함) 에서 사용가능

  : 지역변수(lv) 와 인스턴수 변수(iv) 를 구별할 때 사용 ( 다른 용도도 있지만, 일단은 이것만 알고 있자! 차차 알게 된다 )

  ```java
  //위에서 color = c 이렇게 했는 데,lv 하고 iv 의 이름이 같을 경우 참조변수 this 를 사용해 아래처럼 할 수 있다.
  
  Car(String color, String geartype, int door){
      this.color = color;			// iv = lv
      this.geartype = geartype;	// iv = lv
      this.door = door;			// iv = lv
  }
  ```

  

**정리**

- this 란?

  : (인스턴스 자기 자신을 가르키는 ) 참조변수 

  : 고로 this 안에는 인스턴스의 주소가 담겨 있음

  : **모든 인스턴스 메서드에 지역변수로 숨겨진 채 존재한다**

  : im, 생성자에서는 사용 가능, static( 클래스 ) 메서드에서는 사용 못함.

- this(), this(매개변수) 란?

  : 생성자

  : 같은 클래스의 다른 생성자를 호출하기 위해 사용

```java
class MyMath2{
    long a,b; // iv
    
    MyMath2(int a, int b){
        this.a = a;	// iv = lv
        this.b = b;	// iv = lv
    }
	
    long add(){	//im
        return a+b;	//iv + iv 리턴함. 원래는 this.a + this.b 인데, 같은 클래스니까 생략됨.
    }
    
    static long add(long a, long b){ // cm
        return a+b;	// lv+lv 임. this 사용 불가능
    }
}
```



## CH6-38~41 변수의 초기화, 멤버 변수(iv, cv)의 초기화

**지역변수(lv) 는 꼭 수동 초기화 해야함!!!!!(사용전 꼭!!!) ----> 우리가 직접 초기화 해야한다는 소리!**

```java
class InitTest{
	int x;	// iv
  int y = x;	// iv

  void method1(){
      int i;	// lv
      int j = i;	// lv, 에러. 지역변수를 초기화하지 않고 사용.
  }
}
```

- 위 코드블럭을 보면, `int j = i` 에서 에러가 나타난다.

  그 이유는 **i 는 lv(지역변수)  자동 초기화가 되지만 지역 변수는 자동 초기화가 되지 않는 다.**	==> ?????? 먼 개솔

- lv / iv, cv 의 자동 초기화의 일어나도 안 일어나는 이유

  lv 는 지역변수, 즉 메서드의 변수이다. 

  메서드 특성상 스택에서의 생명 주기가 짧은 편이기 때문에 스택이 쌓일 때 일일히 0 으로 자동 초기화 해주면 **성능이 낮아지기 때문에 스택에 쌓일 때마다 새로운 값을 일일히 덮어 씌우는 방법으로 변수를 초기화 한다.**



1. 명시적 초기화(=) <ㅡㅡ 선언시에 대입연산자를 통해서 초기화, 간단 초기화

   ```java
   class Car{
       int door = 4;	// iv, 기본형 변수의 초기화
       Engine e = new Engine();	// iv, 참조형 변수의 초기화
   								// 이 부분을 어려워 하는 사람들이 있는 데, 참조형 변수는 가질 수 있는 값은 1. null 2. 객체주소이다. 이렇게 참조변수는 객체를 만들어서 넣어야 한다 기본적으로! new 연산자를 통해서 객체가 생성, 즉 주소가 생기는 거라 Engine e 만하면 그냥 참조형 변수 하나만 덩그러니 있는 거다.
   }
   ```



2. 초기화 블럭( {} ) ㅡㅡㅡㅡ> 복잡한 초기화, 괄호안에 여러 문장 넣기
   - *인스턴스 초기화 블럭(iv) : {}*
   - *클래스 초기화 블럭(cv) : static {}*

3. 생성자 ㅡㅡㅡㅡ > iv 초기화, 복잡한 초기화에 사용

   ```java
   Car(String color, String geartype, int door){
       this.color = color;
       this.gearType = gearType;
       this.door = door;
   }
   ```

   

- 정리하면 초기화 에는 3가지 방법이 있다.

  1. 자동 초기화 ==> 0
  2. 간단 초기화 ==> =
  3. 복잡 초기화
     1. {} - iv, cv ( 이거 잘 안씀. 시험에나 좀 나오지 거의 안 씀 )
     2. **static {} - cv**
     3. **생성자 - iv**

  복잡 초기화에선 2 3 만 기억하고 있자! 나중에 1 이 나오긴 하지만 지금 당장은 필요없다고 한다.



- cv 의 복잡 초기화 한 예시

  ```java
  class StaticBlockTest{
      static int[] arr = new int[10];	// 명시적 초기화
  	
      static {	// 클래스 초기화 블럭 - 배열 arr 을 난수로 채운다
          for(int i = 0 ; i < arr.length ; i++){
              arr[i] = (int)(Math.random()*10)+1;
          }
      }
  }
  ```



- 클래스 변수 초기화 시점 : 클래스가 처음(메모리에 올라갈 때) 로딩될 때 단 한번
- 인스턴스 변수 초기화 시점 : 인스턴스가 생성될 때 마다

```java
class initTest{
    static int cv = 1;	// cv 명시적 초기화
    int iv = 1; 		// iv 명시적 초기화
    
    static { cv = 2; }	// 클래스 초기화 블럭 ---> cv 복잡한 초기화
    { iv = 2; }			// 인스턴스 초기화 블럭 ---> iv 복잡한 초기화
    
    InitTest(){			// 생성자, iv 복잡한 초기화
        iv = 3;
    }
}
```



- 초기화 과정을 정리하면 다음과 같다.

  ```java
  자동 초기화 --------------> 명시적 초기화 --------------> 복잡한 초기화
      0							=						 static {}
  														  생성자
  ```

  ​	
