# CH7 



## 7-1~2 상속(Inheritance)

- 상속이란, 기존의 클래스로 새로운 클래스를 작성하는 것. ==> 코드의 재사용!
- 두 클래스를 부모와 자식으로 관계를 맺어주는 것

```java
class 자식클래스 extends 부모클래스 {
    // ...
}
```

```java
class Parent{}
class Child extends Parent{	// 이때 Child 와 Parent 클래스는 상속관계에 있다고 한다!
    // ...
}
```



- 자손은 조상의 모든 멤버를 상속받는다. (생성자, 초기화 블럭 제외) ==> 조상이라고 칭하는 이유는 부모의 부모까지 다 포함해서 상속을 받기 때문에!!
- 따라서 자손의 멤버 개수는 조상보다 적을 수 밖에 없다. (자식 <= 조상)

```java
class Parent{	// 멤버 1개
    int age;
}

class child extends Parent{} // 멤버가 0개이지만, 실제로는 부모에서 상속받았기 때문에 1개!
```



- 자손의 변경은 조상에 영향을 미치지 않는 다.

```java
class Parent{
    int age;
}

class Child extends Parent{
    	void play(){		// 새로운 멤버가 추가됨. 하지만 이렇게 추가했다고 해서 Parent 클래스는 전혀~ 영향을 받지 않는 다.
        System.out.println("놀자~");
    }
}
```



- 상속을 받는 경우와 안 받는 경우의 차이!

```java
class Point{	// 2차원 좌표의 한점 (x,y) 을 나타내기 위한 클래스
    int x;
    int y;
}

class Point3D{	// 3차원 좌표의 한점 (x,y,z), Point 클래스와 아무런 관계 없음 => Point 클래스의 변화에 아무런 영향 받지 않음
    int x;
    int y;
    int z;
}

//또는

class Point3D extends Point{	// Point 클래스와 상속관계 ==> Point 클래스를 상속받기 때문에 Point 클래스에 영향을 받음 
    int z;
}
```



<img src="C:\Users\xpmxf\Desktop\7-1.png" alt="7-1" style="zoom:75%;" />

- 상속받았다고 해도 위 그림의 0x200 처럼 그냥 하나의 주소에 3개의 변수가 묶인다!



## 7-3 포함 관계

** 클래스의 관계를 크게 2가지로 나눈다. (물론 세부적으로 나누라고 하면 더 있긴 함)

1. 상속

2. 포함 ==> 이번 단원에 배울 것

   

- 포함(composite)이란?

  : 클래스의 멤버로 참조변수를 선언하는 것

```java
// 원이라는 클래스를 나타낸다고 해보자
// 1
class Circle {
    int x;
    int y;
    int z;
}

// 2
class Point {
    int x;
    int y;
}

class Circle {
    Point p = new Point();
    int z;
}
```

- 이렇게 했을 때 

<img src="C:\Users\xpmxf\Desktop\asd.png" alt="asd" style="zoom:75%;" />

오른쪽과 같이 클래스를 포함관계로 선언하면 iv 접근을 다음과 같이 해야한다. ( 객체안에 객체 느낌! )

```java
Circle circle = new Circle();

circle.c.x;	// x좌표
circle.c.y;	// y좌표
circle.r	// 반지름
```



주로 쓰는 포함관계의 예시)

```java
class Car{
    Engine e = new Engine();
    Door[] door = new Door[4];
}
```



- 클래스 간의 관계 결정하기

1. 상속 관계 ==> A 는 B 이다
2. 포함 관계 ==> A는 B를 가지고 있다

```java
// 1
class Circle{
    Point c = new Point();
    int r;
}

// 2
class Circle extends Point{
    int r;
}
```

​	이를 봤을 때 두 가지의 문장으로 만들 수 있다.

	- Circle 은 Point 를 가지고 있다 (1)
	- Circle은 Point 이다 (2)

이렇게 보면 논리적으로 (1) 이 맞다. 그래서 **포함**

근데 보통 대부분 포함관계라고 한다.



## 7-5,6 단일 상속, Object 클래스

- Java 는 단일상속만을 허용한다. ( C++ 은 다중상속 허용 )

- 단일상속이란?

  : 하나의 부모만 상속

  ```java
  classs TvDVD extends Tv,DVD { // 이렇게 상속 한번에 여러 개 받는 거 안됨!!
      // ...
  }
  ```

  다중상속을 받음으로써 가지는 장점이 분명히 있지만, 이를 허용함으로써 오는 단점이 크기에 Java 는 단일 상속하게 함

  ```java
  class Tv{
      // ...
      void power(){};
  }
  
  class DVD{
      // ...
      void power();
  }
  
  class TvDVD extends Tv, DVD{
      //...
  }
  
  // 이런 경우에 TvDVD 의 인스턴스들은 power 라는 메서드가 두개가 존재하니까 혼선이 오게 된다.
  // 이게 2 개의 클래스니까 안 그럴수도 있다고 생각할 수 있지만, 상속을 여러개에서 받으면 잘 터짐
  ```

  이를 해결하려면 비중이 높은 클래스 하나만 상속관계로, 나머지는 포함관계로 하면 된다!

  ```java
  class Tv{
     boolean power;
     int channel;
     
     void power() { power = !power; }
     void channelUp() { ++channel; }
     void channelDown() { --channel; }
  }
  
  class DVD {
      boolean power;
      
      void power() { power = !power }
      void play() { ~ }
      void stop() { ~ }
      void rew() { ~ }
  }
  
  class TvDVD extends TV{	// 이렇게 안에서 객체를 포함시킨다음 따로 선언해주면 된다!
      DVD dvd = new DVD();
      
      void play(){
          dvd.play();
      }
      
      void stop(){
          dvd.stop();
      }
      
      void rew(){
          dvd.rew();
      }
  }
  ```

  

- Object 클래스 - 모든 클래스의 조상

  : 부모가 없는 클래스는 자동적으로 Object 클래스를 상속받게 된다.

  ```java
  class Tv{	// 부모가 없음
      // ...
  }
  
  class SmartTv extends Tv{	// 부모 == Tv 
      // ...
  }
  ```

  이렇게 코드가 쓰여져 있으면 다음과 같이 컴파일러가 자동으로 다음과 같이 추가해준다.

  ```java
  class Tv extends Object{
      // ...
  }
  
  class SmartTv extends Tv {
      // ....
  }
  ```

  : 모든 클래스는 Object 클래스에 정의된 11개의 메서드를 상속받는다.

  ex) toString(), equals(Obejct obj), hashCode(), ...

  ```java
  Object
    ↑
    Tv					// 이런 표를 상속계층도 라고 한다.
    ↑
  SmartTv
  ```

  

```java
public class InheritanceTest {
    public static void main(String[] args) {
        Circle c = new Circle();
        Circle c2 = new Circle();
        System.out.println(c.toString());	//ch7.Circle@58ceff1
        System.out.println(c2);				//ch7.Circle@7c30a502
        									//둘다 주소가 찍힌다. 이는 println 이 파라미터로 들어온 객체의 toString() 메서드를 호출하고 이를 print 찍기 때문!
    }
}
```



## 7-7 (메서드) 오버라이딩 (Overriding - 덮어쓰다)

- 상속받는 조상의 메서드를 자신에 맞게 변경하는 것

```java
class Point {
    int x;
    int y;
    
    String getLocation(){
        return "x : " + x + ", y : " + y;
    }
}

class Point3D extends Point{
    int z;
    
    String getLocation(){	// 오버라이딩, 선언(선언부)은 못 바꾸고 내용만 바꿈 == 구현부만 변경 가능
        return "x : " + x + ", y : " + y + ", z :" + z;
    }
}
```



- 오버라이딩의 조건

  1. 선언부가 조상 클래스의 메서드와 일치해야 한다.

     ```java
     class Point {
         int x;
         int y;
         
         public String toString(){	// Object 클래스에서 이렇게 선언되어 있으니까 그와 동일하게 선언부를 적어야 함.
             return "x: " + x + ", y: " + y;
         }
     }
     ```

     

  2. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다.

     접근 제어자란? ==> public, protected, (default), private  

     접근 제어자 지금 모르는 건 ㄱㅊ음.

     하지만 2번 항목을 외워는 두자!

     

  3. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없다.

     ```java
     class Parent{
         void parentMethod() throws IOException, SQLException{
             // ...
         }
     }
     
     //class Child extends Parent{
     //    void parentMethod() throws IOException, SQLExeption, SomethingException{	이렇게 부모보다 많은 예외처리 불가능!!
     //        // ...
     //    }
     //}
     
     class Child extends Parent{
         void parentMethod() throws IOException{	// 이렇게 부모이하(이 경우에는 2개 이하) 
             // ...
         }
     }
     ```



- 오버로딩 vs 오버라이딩 ( 근본적으로 이 둘은 아무 관계가 없지만, 질문이 자주 들어와서 정리해준다고 함 )

  오버로딩(Overloading) : 기존에 없는 새로운 메서드를 정의하는 것 (new) ==> 상속과 연관이 없음!

  오버라이딩(Overriding) : 상복받은 메서드의 내용을 변경하는 것 (change, modify) ==> 상속과 연관 있음!

  ```java
  class Parent {
      void parentMethod() {}
  }
  
  class Child extends Parent {
      void parentMethod() {}			// 오버라이딩
      void parentMethod(int i) {}		// **** 오버라이딩 이라고 했는 데, 오버로딩임!!!!!
      
      void childMethod() {}			// 그냥 메서드 정의
      void childMethod(int i) {}		// 오버로딩
      void childMethod() {}			// **** 오버로딩이라고 했는 데, 그냥 중복정의임 ==> 에러임!
  }
  ```

  

## 7-10~11 참조변수 super, 생성자 super() ==> 이번 단원 중요!

- super 란?  ≒ this , this 는 lv 와 iv 구별할 때 사용

  : 객체 자신을 가리키는 참조변수. 인스턴스 메서드(생성자) 내에만 존재 ==> static 메서드 내에서 사용 불가\

  : 조상의 멤버를 자신의 멤버와 구별할 때 사용

```java
class Ex7_2{
    public static void main(String[] args){
        Child c = new Child();
        c.method();
    }
}

class Parent {int x = 10; }

class Child extends Parent{
    int x = 20;
    
    void method(){
        System.out.println("x = "+ x);
        System.out.println("this.x = "+ this.x);
        System.out.println("super.x = "+ super.x);
    }
}
```

​	: 즉, 상속이 될 때 변수의 이름이 같아도 상속은 잘 된다. 구분을 super 와 this 로 함!



-  super() - **조상의 생성자**, 참조변수 super 와는 아얘 다른 것!

  : 조상의 생성자를 호출할 때 사용 ==>  ∵ 상속 받을 때 코드블럭하고 생성자는 상속되지 않음!

  : 조상의 멤버는 조상의 생성자를 호출해서 초기화.

```java
class Point {
    int x,y;
    
    Point(int x, int y ){
        this.x = x;
        this.y = y;
    }
}

class Point3D extends Point{
    int z;
    
    Point3D(int x, int y, int z){
        this.x = x;	// 조상의 멤버를 초기화, 이렇게 하는 게 오류는 나지 않는 다. 하지만 자손의 생성자(이 경우에는 Point3D) 는 자기가 선언한 것만 초기화 해야한다. 그래서 z 만 하는 게 맞음
        this.y = y;	// 조상의 멤버를 초기화
        this.z = z;
    }
}

// 그래서 이렇게 하는 게 맞음

Point3D(int x, int y,int z){
    super(x,y);
    this.z = z;
}
```



: **생성자의 첫 줄에 반드시 다른 생성자를 호출해야 한다.** ====> **매우매우매우매우매우 중요함!!**

그렇지 않으면 컴파일러가 생성자의 첫 줄에 super() (=조상의 기본 생성자) 를 삽입해버림

```java
class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    String getLocation(){
        return "x: " + x + ", y: " + y;
    }
}

class Point3D extends Point4{
    int z;

    Point3D(int x, int y, int z){
        // 여기에 원래 생성자가 있어야 한다. 하지만 없어서 컴파일러가 대신 super() 를 넣어줌. 근데 여기서 super() == Point() 인데, Point 클래스에는 기본 생성자가 없고 두 개의 int 를 받는 생성자만 존재함. 그래서 super() 는 없는 생성자를 호출하는 것이 됨으로 에러임!!!
        // 그래서 항상 기본 생성자를 넣으라는 규칙을 외워야 한다!!!!!!!!!!!!!!!!!
        this.x = x;
        this.y = y;
        this.z = z;
    }

    String getLocation(){
        return "x: " + x + ", y: " + y + ", z: " + z;
    }
}

public class PointTest {
    public static void main(String[] args) {
        Point3D p3 = new Point3D(1, 2, 3);
        System.out.println(p3.getLocation());
    }
}

// 아니면
Point3D(int x, int y, int z){
    super(x,y);
    this.z = z; // 하지만 어쨌든 기본 생성자는 항상 넣자!!
}
```

- **(조건)그래서 항상 기본 생성자를 넣으라는 규칙을 외워야 한다!!!!!!!!!!!!!!!!!**

- **모든 생성자는 첫 줄에 다른 생성자를 호출해야 한다!!!**



## 7-12 패키지(package)

- 서로 관련된 클래스들의 묶음

  : Java8 은 약 4000개의 클래스들이 있음. 이것들을 관리하기 위해 묶음!

  : 클래스는 클래스 파일(*.class), 패키지는 폴더. 하위 패키지는 하위 폴더

  : 클래스의 실제 이름(full name)은 패키지를 포함.(java.lang.String)

  : rt.jar 는 클래스들을 압축한 파일 ( JDK 설치 경로\jre\lib 에 위치 ) ==> Java9 부터 사라짐 (∵ rt.jar 파일이 너무 큼, module 개념이 나오면서 module 로 쪼개놓음 )

  여기서 rt 는 runtime(실행할 때, 실행중), 자바 실행시에 필요한 클래스들의 모음이 rt.jar(클래스 파일 묶어놓은 것) 이다



- 패키지의 선언

  : 패키지는 소스파일의 첫 번째 문장으로 단 한번 선언

  : 같은 소스 파일의 클래스들은 코두 같은 패키지에 속하게 된다.

  : 패키지 선언이 없으면 이름없는 (unnamed) 패키지에 속하게 된다.

  ```java
  package com.codechobo.book;
  
  public class packageTest{
      public static void main(String[] args){
          System.out.println("Hello, World");
      }
  }
  
  class PackageTest2{}
  ```



- 클래스 패스(classpath)

  : 클래스 파일(*.class) 의 위치를 알려주는 경로(path)

  : 환경변수 classpath 로 관리하며, 경로간의 구분자는 ' ; ' 를 상요

  : classpath(환경변수) 에 패키기의 루트를 등록해서 사용 가능함

  : 제어판에서 환경변수 편집하기!! ==> 우리가 지금까지 IntelliJ 가 알아서 다 해줬지만, 알아서 이렇게 다 할줄 알아야 한다.



## 7-15~16 import 문, static import 문

- 클래스를 사용할 때 패키지 이름을 생략할 수 있다.

  ```java
  class ImportTest{
      java.util.Date today = new java.util.Date();
  }
  
  // 다음과 같이 변경
  
  import java.util.Date;
  
  class ImportTest{
      Date today = new Date();
  }
  ```

  

- java.lang 패키지의 클래스는 import 하지 않고도 사용할 수 있다.

  String, Object, System, Thread ...

  ```java
  import java.lang.*;	// java.lang 에 있는 모든 클래스를 import 함
  
  class ImportTest2{
      public static void main(String[] args){
          System.out.println("Hello");
      }
  }
  
  // 만약 import 문이 없었거나, java.lang 이 알아서 import 가 되지 않았더라면...
  
  class ImportTest2{
      public static void main(java.lang.String[] args){
          java.lang.System.out.println("Hello");
      }
  }
  ```



- import 문을 선언하는 방법은 다음과 같다.

  ```java
  import 패키지명.클래스명;
  
  or
      
  import 패키지명.*;
  ```

  

- import 문은 패키지문과 클래스선언의 사이에 선언한다.

  ```java
  package ch7;	// 패키지문
  
  import java.util.*;	// import 문
  
  public class PointTest{	// 클래스 선언
      public static void main(String[] args){
          Date date = new Date();
          System.out.println(date);
      }
  }
  ```

  

- import 문은 컴파일 시에 처리되므로 프로그램의 성능에 영향없음.

  ```java
  import java.util.Calendar;
  import java.util.Date;
  import java.util.ArrayList;
  
  // 아래처럼 쓰면 프로그램의 성능이 느려지는 것이 아니냐 라고 말할 수도 있다. 하지만 전혀 그렇지 않다. 다만 컴파일시 조금 느려질 수는 있다.
  
  import java.util.*;
  ```

  

- 다음의 두 코드는 서로 의미가 다르다.

  ```java
  import java.util.*;
  import java.text.*;
  
  과
  
  import java.*;
  ```

  

- 이름이 같은 클래스가 속한 두 패키지를 import 할 때는 클래스 앞에 패키지명을 붙여줘야 한다.

  ```java
  import java.sql.*;	//java.sql.Date 가 있음
  import java.util.*;	//java.util.Date 가 있음
  
  public class ImportTest{
       public static void main(String[] args){
           java.util.Date today = new java.util.Date();	// 그래서 여기에서 그냥 Date 라고만 하면 컴파일러가 누구의 패키지에서 Date 클래스를 가져오는 지 모름. ==> 이렇게 명시적으로 해야함.
       }
  }
  ```

  

- static 멤버를 사용할 때 클래스 이름을 생략할 수 있게 해준다.

  ```java
  import static java.lang.Integer.*;	// Integer클래스의 모든 static 메서드
  import static java.lang.Math.random;// Math.random()만 ==> random() 이렇게 사용 가능
  import static java.lang.System.out;	// System. 중 out만 ==> out() 이렇게 사용 가능
  ```

  ```java
  import static java.lang.System.out;
  import static java.lang.Math.*;
  
  class Ex7_6{
      public static void main(String[] args){
          //System.out.println(Math.random());
      	out.println(random());
          
          //System.out.println("Math.Pi : " + Math.PI);
          out.println("Math.Pi : " + Math.PI)
      }
  }
  ```

  : static import 문을 사용하는 이유?

  ==> 클래스 이름 일일히 붙여가면서 사용하면 코드가 너무 길어진다. 그래서 줄일려고 나중에 static import 가 생기긴 했는 데, 그래도 일일히 써주는 게 명시적이니까, 앵간하면 일일히 쓰자!



## 7-17 제어자(modifier)

- 클래스와 클래스의 멤버(멤버 변수, 메서드) 에 부가적인 의미 부여

  : 제어자를 쉽게 생각하면 형용사라고 생각하면 된다.

  : 형용사 +(->) 명사

  1. **접근 제어자**

     **: public, protected, (default), private**

  2. 그 외

     : **static, final, abstract,** native, transient, synchronized, volatile, strictfp

  여기서 볼드체들만 배울 거고, 나머지는 일단 이런 게 있다고만 알고 있자



- 하나의 대상에 여러 제어자를 같이 사용가능(접근 제어자는 하나만!)

  ```java
  public class ModifierTest{
    //접근 제어자는 관례적으로 가장 먼저, 그 외는 순서는 상관 없다만 주로 static 이 final 보다 먼저 나옴
    public static final int WIDTH = 200;
    
    public static void main(String[] args){
      System.out.println("WIDTH = " + WIDTH);
    }
  }
  ```



- static - 클래스의, 공통적인

  |   대상   |                             의미                             |
  | :------: | :----------------------------------------------------------: |
  | 멤버변수 | - 모든 인스턴스에 공통적으로 사용되는 클래스 변수가 된다.<br />- 클래스 변수는 인스턴스를 생성하지 않고도 사용 가능하다. <br />- 클래스가 메모리에 로드될 때 생성된다. |
  |  메서드  | - 인스턴스를 생성하지 않고도 호출이 가능한 static 메서드가 된다.<br /><br />-static 메서드 내에서는 인스턴스 멤버들을 직접 사용할 수 없다. |

  ```java
  class StaticTest{
    static int width = 200;
    static int height = 120;
    
    static {		// 클래스 초기화 블럭
      // static 변수의 복잡한 초기화 수행
    }
    
    static int max(int a, int b){ //클래스 메서드(static 메서드)
      // iv 사용 불가능
      // im 사용 불가능
      // ==> 인스턴스 멤버들을 사용할 수 없다.
      return a>b? a:b;
    }
  }
  ```

  // static 변수 다시 한번 보자

  static 은 객체 생성 없이 사용이 가능 --> iv, im 사용 불가능



- final - 마지막의, 변경될 수 없는

  |   대상    |                             의미                             |
  | :-------: | :----------------------------------------------------------: |
  |  클래스   | 변경될 수 없는 클래스, 확장될 수 없는 클래스가 된다.<br />그래서 final로 지정된 클래스는 다른 클래스의 조상이 될 수 없다.<br />Ex) String(보안 문제 때문에 final, 패스워드 같은 경우 문자열로 저장할 수도 있는데, 이게 상속이 가능하면 자식에서 조회가 가능하기 때문에 밴) , Math(static 메서드 집합이니까 굳이 이 클래스를 상속받아 쓸 일이 없어서) |
  |  메서드   | 변경될 수 없는 메서드. <br />final로 지정된 메서드는 오버라이딩을 통해 재정의 될 수 없다. |
  | 멤버 변수 |  변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.  |
  | 지역변수  |  변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.  |

  ```java
  final class FinalTest{	// 조상이 될 수 없는 클래스
    final int MAX_SIZE = 10;	// 값을 변경할 수 없는 멤버변수(상수)
    
    final void getMaxSize(){	// 오버라이딩 할 수 없는 메서드(변경불가)
      final int LV = MAX_SIZE;	// 값을 변경할 수 없는 지역변수(상수)
      return MAX_SIZE;
    }
  }
  ```



- abstract - 추상의, 미완성의 (추상화)

  | 대상   | 의미                                                         |
  | ------ | ------------------------------------------------------------ |
  | 클래스 | 클래스 내에 추상 메서드가 선언되어 있음을 의미한다.          |
  | 메서드 | 선언부만 작성하고 구현부는 작성하지 않은 추상 메서드임을 알린다. |

  ```java
  abstract class AbstractTest{	// 추상클래스(추상 메서드를 포함한 클래스) ==> 미완성 클래스 ==> 미완성 설계도이기 때문에 제품 생성 불가능 ==> 객체 생성이 안됨
    abstract void move();				// 추상메서드(구현부가 없는 메서드) ==> 미완성 메서드
  }
  
  AbstractTest a = new AbstractTest(); // 에러. 추상 클래스의 인스턴스는 생성불가!
  ```

  추상 클래스는 미완성이기 때문에 추상 클래스를 상속 받아서 완전한 클래스(구상클래스, 구체클래스 라고도 함!) 를 만든 후에 객체 생성 가능.

  그래야 객체생성이 가능해진다!




## 7-12 접근 제어자(access modifier)

1. private : 같은 클래스 내에서만 접근이 가능하다
2. (default) : 같은 패키지 내에서만 접근이 가능하다.
3. protected : 같은 패키지 내에서, 그리고 다른 패키지의 자손클래스에서 접근이 가능하다.
4. public : 접근 제한이 전혀 없다.

이 중 한개만 가능하다! 

|  제어자   | 같은 클래스 | 같은 패키지 | 자손 클래스 | 전체 |
| :-------: | :---------: | :---------: | :---------: | :--: |
|  public   |      O      |      O      |      O      |  O   |
| protected |      O      |      O      |      O      |  X   |
| (default) |      O      |      O      |      X      |  X   |
|  private  |      O      |      X      |      X      |  X   |

```java
접근제한 없음						 같은 패키지+자손						    같은 패키지								 같은 클래스
public ========================> protected ========================> (default) ========================> private
```

<img src="C:\Users\xpmxf\AppData\Roaming\Typora\typora-user-images\image-20210831170809636.png" alt="image-20210831170809636" style="zoom:50%;" />





## 7-23 캡슐화 & 접근 제어자

접근 제어자를 사용하는 이유?

1. 외부로부터 데이터를 보호하기 위해서 ==> 이걸 캡슐화라고 한다!

```java
public class Time{
    public int hour;
    public int minute;
    public int second;
}

// 위처럼 세팅 되어 있으면

Time t = new Time();
t.hour = 25;	// 멤머변수에 직접 접근, 근데 이렇게 hour 는 0~24 여야 하는 데, 이렇게 하면 hour 라는 변수에 아무 값이나 집어넣을 수 있게 된다. ==> 데이터가 보호가 안된다
```

그래서 다음과 같이 해서 보호해야 한다.

```java
public class Time{
    private int hour;
    private int minute;
    private int second;		// 접근 제어자를 private 으로 하여 외부에서 직접 접근하지 못하게 한다.
    
    public int getHour(){ return hour;}
    public void setHour(int hour){		// 이렇게 메서드로 간접 접근하게 해야 함. 이런 식으로 코딩해야 함!
        if( hour < 0 || hour > 23) return;
        this.hour = hour;
    }
}

Time t = new Time();
t.setHour(25); // 범위를 벋어나므로 return 을 만나 hour 값이 25로 안 바뀜 ==> if 문으로 개같은 경우를 걸러 값을 보호함
t.setHour(11); // t 의 hour 가 11로 세팅이 됨
```

2. 외부에는 불필요한, 내부적으로만 사용되는, 부분을 감추기 위해서!

   : 접근 제어자는 좁을 수록 좋다!

```java
class Time{
    private int hour;
    private int minute;
    private int second;

    public void setHour(int hour){
        if(isNotValidHour(hour)) return;
        this.hour = hour;
    }

    public int getHour(){
        return hour;
    }

    private boolean isNotValidHour(int hour){   // 내부에서만 쓸 메서드라 private 로 선언해서 씀. 만약 메서드를 변경하면 테스트를 다시 해야되는데,
                                                // private 인 테스트는 그 클래스 안에서만 테스트를 하면 된다는 걸 알 수 있다.
                                                // ==> 테스트의 범위를 줄일 수 있다 !!!!!
        return hour < 0 || hour > 24;
    }
}

public class TimeTest {
    public static void main(String[] args) {
        Time t = new Time();
//        t.hour = 22;
        t.setHour(22);  //  hour 의 값을 22로 변경.
        System.out.println(t.getHour());
        t.setHour(100);
        System.out.println(t.getHour());
    }
}
```



## 7-23 다형성(polymorphism) - 개 중요, 

##### 이걸 이해 못하면 뒤에 나오는 추상 클래스 등 뒤의 진도를 할 필요가 없다!!! 매우 중요!



- 여러 가지 형태를 가질 수 있는 능력 == 사전적 정의

- 조상 타입 참조 변수로 자손 타입 객체를 다루는 것. == 만약 다형성이 뭐냐고 질문 받았을 때 나와야 하는 답!

  ```java
  class Tv{
      boolean power;
      int channel;
      
      void power() {power = !power;}
      void channelUp() { ++channel; }
      void channelDown() { --channel; }
  }
  
  class SmartTv extends Tv{
      String text;
      void caption();
  }
  
  Tv t = new SmartTv();	// 이런 게 타입 불일치를 얘기하는 거임!!
  ```

  

- 일치하는 게 일반적인데 불일치 할때의 2 가지 장점이 있어서 다형성이 중요하고, 객체지향개념에 유연성을 준다!



- 객체와 참조변수의 타입이 일치할 때와 일치하지 않을 때의 차이?

- 부모 타입의 참조변수로 자식 타입의 객체를 가리킬 순 있다.

  ```java
  SmartTv s = new SmartTv();	// 참조 변수와 인스턴스의 타입이 일치
  Tv t = new SmartTv();		 // 조상 타입 참조변수로 자손 타입 인스턴스 참조
  ```

  기능이 7개 있는 데 사용을 2개 안하는 건 ok!



- 하지만 자손 타입의 참조변수로 부모 타입의 객체를 가리킬 순 없다.

  ```java
  Tv t = new SmartTv();	// 이건 됨.
  SmartTv s = new Tv();	// 이건 안됨
  ```

  그런데 기능이 5개 밖에 없는 데 5개에 없는 기능을 사용하려고 하면 그건 Trouble!



- Q. 참조변수의 타입은 인스턴스의 타입과 반드시 일치해야 하나요?

  : No! 일치하는 것이 보통이지만, 일치 하지 않을 수도 있다!

  ```java
  SmartTv t = new SmartTv();	// ㄱㅊ
  Tv t = new SmartTv();	// ㄱㅊ
  ```



- Q. 참조변수가 조상타입일 때와 자손타입일 때의 차이?

  : 참조변수로 사용할 수 있는 멤버의 갯수가 달라진다!

  

- 자손 타입의 참조변수로 조상 타입의 객체를 가리킬 수 있나요?

  : No! 

  ```java
  Tv t = new SmartTv();	// 가능
  SmartTv s = new Tv();	// 불가능!
  ```

  

  

## 7-24,25 참조변수의 형변환 (1)

- 결론 ! : 사용할 수 있는 멤버의 갯수를 조절하는 것!!

  ==> 주소값, 참조변수 값, 객체 이런 거 하나도 안 바뀜!

  ==> 뭐만 바뀐다? 멤버 갯수만 바뀐다!



- 조상, 자손 관계의 참조변수는 서로 형변환 가능!

  

  ![image-20210901174448009](C:\Users\xpmxf\AppData\Roaming\Typora\typora-user-images\image-20210901174448009.png)

  FireEngine 과 Car, Ambulance 와 Car 끼린 서로 형변환이 가능하다. 

  하지만 FireEngine 과 Ambulance 끼리는 불가능!

  ```java
  class Car {
      String color;
      int door;
      
      void drive() {
          System.out.println("drive, Brrrr~")
      }
      
      void stop() {
          System.out.println("stop. Beep")
      }
  }
  
  class FireEngine extends Car{
      void water(){
          System.out.println("water!!!")
      }
  }
  
  FireEngine f = new FireEngine();
  
  Car c = (Car) f;					//
  FireEngine f2 = (FireEngine) c;    //
  Ambulance a = (Ambulance) f;	//
  ```

  

