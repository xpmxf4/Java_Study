

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
- 따라서 자손의 멤버 갯수는 항상 조상의 멤버 갯수보다 같거나 많다. (자식의 멤버 갯수 >= 조상의 멤버 갯수)

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

**클래스의 관계는 크게 2가지로 나눈다. (물론 세부적으로 나누라고 하면 더 있긴 함)

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

Circle c = new Circle();
```

- 위 코드블록에서 마지막 포함관계의 경우 

  |   c   | 0x100 |      |
  | :---: | :---: | :--: |
  | 0x100 | Null  |  p   |
  |       |   0   |  r   |

  먼저 이렇게 p에 null 로 자동 초기화가 되고, 그 다음에 new Point() 가 실행되면서 새롭게 객체가 생성됨. 말이 좀 이상할 수도 있는 데, 그 객체 생성 될때 일일히 그려서 주소 넣고 하는거 설명하는 거임. 모르겠으면 유튭 ㄲ

  

- 이렇게 했을 때 

<img src="C:\Users\xpmxf\Desktop\asd.png" alt="asd" style="zoom:75%;" />

오른쪽과 같이 클래스를 포함관계로 선언하면 iv 접근을 다음과 같이 해야한다. ( 객체안에 객체 느낌! ==> 아마 이게 맞는 듯 )

```java
Circle circle = new Circle();

circle.c.x;	// x좌표
circle.c.y;	// y좌표
circle.r	// 반지름
```

 

- 작은 단위의 클래스를 만들고, 이 들을 조합해서 클래스를 만든다. 

  이렇게 함으로써 

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

상속을 하게 되면 제약이 되게 많이 생기기 때문에, 그냥 왼만하면 포함으로 하는 게 좋다!



**프로그래밍이란? == 설계 + 코딩**

## 7-5,6 단일 상속, Object 클래스

- Java 는 단일상속만을 허용한다. ( C++ 은 다중상속 허용 )

- 단일상속이란?

  : 하나의 부모만 상속받는 것을 말한다.

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
  
  class TvDVD extends Tv, DVD{	// c++ 은 다중상속 허용!
      //...
  }
  
  // 이런 경우에 TvDVD 의 인스턴스들은 power 라는 메서드가 두개가 존재하니까 혼선이 오게 된다.
  // 이게 2 개의 클래스니까 안 그럴수도 있다고 생각할 수 있지만, 상속을 여러개에서 받으면 잘 터짐
  ```

  이를 해결하려면 **비중이 높은 클래스 하나만 상속관계**로, 나머지는 포함관계로 하면 된다!

  ```java
  class Tv
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

     선언은 그대로, 안에 내용만 변경이 가능하다!

     

  2. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없다. 

     접근 제어자란? ==> public, protected, (default), private  

      접근 제어자 지금 모르는 건 ㄱㅊ음.	==> 복습하는 시점인데 까먹음... ^^*

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

  ​										이름이 같은 데 매개변수의 갯수 or 타입이 다른 거.

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

- super 란?  ≒ this , this 는 lv 와 iv 구별할 때 사용한다.

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

| c ---> |  0x100   |                        |
| :----: | :------: | :--------------------: |
|        |    10    | x 얘는 super.x 로 구별 |
|        |    20    | x 얘는 this.x 로 구별  |
|        | method() |                        |





-  super() - **조상의 생성자**, 참조변수 super 와는 아얘 다른 것!

  : 조상의 생성자를 호출할 때 사용 ==>  ∵ 상속 받을 때 **코드블럭하고 생성자는 상속되지 않음!**

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
      	// 여기에 super() 나 this() 가 없어서, 컴파일러가 super() 를 강제로 삽입시킴
     		// 이 경우에는 Object() 가 알아서 넣어짐.
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
        // 여기에 원래 생성자가 있어야 한다. 하지만 없어서 컴파일러가 대신 super() 를 넣어줌. 근데 여기서 super() == Point() 인데, Point 클래스에는 기본 생성자가 없고 두 개의 int 를 받는 생성자만 존재함. 그래서 super() 는 없는 생성자를 호출하는 거라 에러가 됨!!!
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

  : rt.jar 는 클래스들을 압축한 파일 ( JDK 설치 경로\jre\lib 에 위치 ) ==> Java9 부터 사라짐 (∵ rt.jar 파일이 너무 큼, module 개념이 나오면서 작은 module 들로 쪼개놓음 )

  여기서 rt 는 runtime(실행할 때, 실행중), 자바 실행시에 필요한 클래스들의 모음이 rt.jar(클래스 파일 묶어놓은 것) 이다
  
  
  
- 패키지의 선언

  : 패키지는 소스파일의 첫 번째 문장으로 단 한번 선언

  : 같은 소스 파일의 클래스들은 모두 같은 패키지에 속하게 된다.

  : 패키지 선언이 없으면 이름없는 (unnamed) 패키지에 속하게 된다.

  ```java
  // PackageTest.java
  package com.codechobo.book;
  
  public class packageTest{
      public static void main(String[] args){
          System.out.println("Hello, World");
      }
  }
  
  class PackageTest2{}
  ```

  이 클래스를 컴파일하게 되면 com 폴더 아래, codechobo 폴더 아래, book 폴더 아래 packageTest.class 가 위치하게 된다.

  

- 클래스 패스(classpath)

  : 클래스 파일(*.class) 의 위치를 알려주는 경로(path)

  : 환경변수 classpath 로 관리하며, 경로간의 구분자는 ' ; ' 를 사용

  : classpath(환경변수) 에 패키지의 루트를 등록해서 사용 가능함

  환경변수에 넣어두면, 터미널에서 

  ```java
  java com.codechobo.book.PackageTest
  ```

  라고 했을 때, 환경변수를 먼저 뒤져본다. 그래서 위의 스크립트가 잘 실행됨!

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
      Date today  = new Date();
  }
  ```

  

- java.lang 패키지는 기본 패키지라서 java.lang 의 클래스들은 import 하지 않고도 사용할 수 있다.

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
  import static java.lang.System.out;	// out 이라는 객체를 사용할 수 있게 되는 거랑 느낌 비슷 ( out 은 System 클래스에서 static 멤버임. 나중에 15장에서 이 내용 다룰 것!)
  import static java.lang.Math.*;			// Math 클래스의 모든 static 멤버를 변수처럼 쓸수 있게됨
  
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

  : 제어자를 쉽게 생각하면 **형용사**라고 생각하면 된다.

  : 형용사 +(->) 명사

  1. **접근 제어자 ( 4개 중 하나만 붙일 수 있음 )**

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
  |  메서드  | - 인스턴스를 생성하지 않고도 호출이 가능한 static 메서드가 된다.<br />-static 메서드 내에서는 인스턴스 멤버들을 직접 사용할 수 없다. |

  ```java
  class StaticTest{
    static int width = 200;	// 간단 초기화
    static int height = 120;
    
    static {		// 클래스 초기화 블럭
      // static 변수의 복잡한 초기화 수행
    }
    
    static int max(int a, int b){ //클래스 메서드(static 메서드)
      // iv 사용 불가능
      // im 사용 불가능
      // ==> 인스턴스 멤버들을 사용할 수  없다.
      return a>b? a:b;
    }
  }
  ```

  // static 변수 다시 한번 보자

  static 은 객체 생성 없이 사용이 가능 --> iv, im 사용 불가능



- final - 마지막의, 변경될 수 없는

  |   대상    |                             의미                             |
  | :-------: | :----------------------------------------------------------: |
  |  클래스   | 변경될 수 없는 클래스, 확장될 수 없는 클래스가 된다.<br />그래서 final로 지정된 클래스는 다른 클래스의 조상이 될 수 없다.<br />Ex) String - 보안 문제 때문에 final, 패스워드 같은 경우 문자열로 저장할 수도 있는데, 이게 상속이 가능하면 자식에서 조회가 가능하기 때문에 밴 <br />Math - static 메서드 집합이니까 굳이 이 클래스를 상속받아 쓸 일이 없어서 |
  |  메서드   |      변경될 수 없는 메서드. <br />오버라이딩이 안 된다!      |
  | 멤버 변수 |  변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.  |
  | 지역변수  |  변수 앞에 final이 붙으면, 값을 변경할 수 없는 상수가 된다.  |

  ```java
  final class FinalTest{	// 조상이 될 수 없는 클래스
    final int MAX_SIZE = 10;	// 값을 변경할 수 없는 멤버변수(상수)
    
    final int getMaxSize(){	// 오버라이딩 할 수 없는 메서드(변경불가)
      final int LV = MAX_SIZE;	// 값을 변경할 수 없는 지역변수(상수)
      return LV;
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




## 7-21 접근 제어자(access modifier)

1. private : 같은 클래스 내에서만 접근이 가능하다
2. (default) : 같은 패키지 내에서만 접근이 가능하다.
3. protected : 같은 패키지 내에서, 그리고 다른 패키지의 자손클래스에서 접근이 가능하다.
4. public : 접근 제한이 전혀 없다.

이 중 한개만 가능하다! 

|     접근 제어자      | 같은 클래스 | 같은 패키지 | 자손 클래스 | 전체 |
| :------------------: | :---------: | :---------: | :---------: | :--: |
|  public (클래스 o)   |      O      |      O      |      O      |  O   |
| protected (클래스 x) |      O      |      O      |      O      |  X   |
| (default) (클래스 o) |      O      |      O      |      X      |  X   |
|  private (클래스 x)  |      O      |      X      |      X      |  X   |



```java
접근제한 없음						 같은 패키지+자손						    같은 패키지								 같은 클래스
public ========================> protected ========================> (default) ========================> private
```

<img src="C:\Users\xpmxf\AppData\Roaming\Typora\typora-user-images\image-20210831170809636.png" alt="image-20210831170809636" style="zoom:50%;" />

 

- class 에만 붙일 수 있는 접근 제어자 => public, (default)
- class 와 iv, cv 다 붙일 수 있는 접근 제어자 => public, protected, (default), private



만약 이해가 잘 안간다면 ch7.pkg1, ch7.pkg2 의 주석처리를 풀었다 안 풀었다 반복하면서 깨닫길...

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

   : **접근 제어자는 좁을 수록 좋다!**

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



## 7-23 다형성(polymorphism) - 개 중요

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
  
  Tv t = new SmartTv();	// 이런 게 타입 불일치를 얘기하는 거임!! 이것이 바로 다형성 그 자체
  ```

  

- 일치하는 게 일반적인데 불일치 할때의 2 가지 장점이 있어서 다형성이 중요하고, 객체지향개념에 **유연성**을 준다!

  

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

- **사용할 수 있는 멤버의 갯수를 조절하는 것!!**

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
  
  Car c = (Car) f;					// 생략 가능, 조상 = 자손
  FireEngine f2 = (FireEngine) c;    // 자손 = 조상
  Ambulance a = (Ambulance) f;	// 에러, 형제끼리 안됨
  ```

  **근데 여기서 생략이 되냐 안되냐는 중요하지가 않고, 조상, 자손 관계가 서로 참조변수의 형변환이 가능하다는 것이다.**
  
  여기서 c 가 가능한건 c.color, c.door, c.drive(), c.stop() 이 4개만 가능함. 
  
  f2 는 다시 5개 다 가능함.
  
  
  
  ```java
  Car car = null;
  FireEngine fe = null;
  FireEngine fe = (FireEngine) car;	
  fe.water();	// 컴파일 에러 없음
  ```
  
  이렇게 하면 컴파일 에러는 안 뜬다. 
  
  하지만 실행시키게 되면 에러가 뜨게 된다. 왜냐하면 만들어진 실객체가 없기 때문!! 
  
  그래서 중요한 것
  
  **참조변수가 실제로 가리키는 객체가 무엇이냐? 를 아는 것** 
  
  
  
  ```java
  Car c = new Car();
  FireEngine fe = (FireEngine) c;	// Exception in thread "main" java.lang.ClassCastException
  // 이렇게 하면 컴파일시에는 에러가 나지 않는 다. 하지만 실행하게 되면 틀림. 왜냐하면 실객체 안에는 water()가 없음!
  fe.water() 
  ```
  
  2번째 줄아 안되는 건 어째보면 당연하다. 왜냐하면 부모의 객체를 자손의 참조변수로 가리키는 꼴이 되니까!
  
  

## 7-26 instanceof 연산자

- 참조변수의 형변환 가능여부 확인에 사용. 가능하면 true 반환

  : 참조변수의 형변환은 조상 < == > 자손 에서만 가능

  1. 먼저 instanceof 로 형변환 확인하기!
  2. 그리고 나서 형변환 하기!

  

- 형변환 전에 반드시 instanceof로 확인해야함!

  ```java
  void doWork(Car c){	// 여기에는 new Car(), new FireEngine(), new Ambulance() 모두 다 들어올 수 있다. 왜? 다형성이 되기 때문이다.
    if(c instanceof FireEngine){			// 1. 형변환이 가능한지 확인 (인자로 받은 c 가 FireEngine이 될 수 있는 얘냐라고 묻는 것)
      FireEngine fe = (FireEngine) c;	// 2. 형변환, 여기서 (FireEngine) c 를 하는 이유는 바로 밑줄에서 fe.water() 를 했기 때문이다. 만약 하지 않았다면 fe 에 Car 타입인 참조변수 c 리모콘이 할당되어 water() 를 사용할 수 없다!
      fe.water();
    }else if(c instanceof Ambulance){
      Ambulance a = (Ambulance) c;
      // a.something()
    }
  }
  ```

  형변환을 하는 이유는 인스턴스의 원래 기능을 모두 사용하려고!

  Car타입의 리모콘인 c로는 water()를 호출할 수 없기에 형변환을 해준다.

  리모콘을 FireEngine 타입으로 바꿔서 water() 로 호출.

  ```java
  Object
  ↑
  Car
  ↑
  FireEngine
  
  FireEngine fe = new FireEngine();
  System.out.println(fe instanceof Object);	// true, "Object 타입의 참조변수로 객체사용이 가능하냐?" 라고 이해하자.
  System.out.println(fe instanceof Car);	// true
  System.out.println(fe instanceof FireEngine);	// true
  
  Object obj = (Object) fe;	// 가능
  Car car = (Car) fe;				// 가능
  ```

  

  1. Instanceof 로 형변환이 가능한지 확인
  2. 형변환

  

- **Q. 참조변수의 형변환은 왜 하나요?**

  A. 참조변수(리모콘)을 변경함으로써 사용할 수 있는 멤버의 갯수를 조절하기 위해서!

  ```java
  FireEngine f = new FireEngine();
  Car c = (Car) f;	// 사실 형변환은 별거 아님. 대입연산자는 양쪽이 같은 타입이어야 하니까 참조변수의 타입을 변환을 해주는 것임.
  ```



- **Q.instanceof 연산자는 언제 사용하나요?**

  A. 참조변수를 형변환 하기 전에 형변환 가능여부를 확인할 때

  ```java
  void doWork(Car c){
    if(c instanceof FireEngine){
      FireEngine fe = (FireEngine) c;
      fe.water();
    }
  }
  ```

  

## 7-27,28 매개변수의 다형성

- 다형성의 장점이란?

  1. **다형적 매개변수** ==> 이번 단원은 이것에 대해 배운다!
  2. 하나의 배열로 여러 종류 객체 다루기

  이번 강에서는 **다형적 매개변수** 를 배울 거



- 다형성이란?
  	1. Tv t = new SmartTv(); => 조상 타입의 참조변수로 자손 객체 가르킴.
   	2. 참조변수의 형변환 ==> 리모콘 바꾸기, 왜? 사용할 수 있는 멤버의 갯수 조절
   	3. Instance 연산자 ==> 형변환 가능여부 체크



- 매개변수의 다형성

  : 참조형 매개변수는 메서드 호출시, **자신과 같은 타입 또는 자손타입의 인스턴스를 넘겨줄 수 있다**.

  ```java
  class Product{		// 부모
    int price;			// 제품가격
    int bonusPoint;	// 보너스점수
  }
  
  class Tv extends Product{}				// 자손
  class Computer extends Product{}	// 자손
  class Audio extends Product{}			// 자손
  
  class Buyer {	// 소비자
    int money = 1000;		// 소유금액
    int bonusPoint = 0;	// 보너스점수
  }
  ```

  Buyer 클래스에다가 다음 코드를 추가하고 싶다고 해보자

  ```java
  void buy(Tv t){
    money -= t.price;
    bonusPoint += t.bonusPoint;
  }
  ```

  이렇게 되면 우리는 Tv 뿐만이 아니라 Computer, Audio 클래스 까지 고려해야 하므로 일단 배웠던 오버로딩을 생각해볼 수 있다.

  ```java
  void buy(Tv t){
    money -= t.price;
    bonusPoint += t.bonusPoint;
  }
  
  void buy(Audio a){
    money -= a.price;
    bonusPoint += a.bonusPoint;
  }
  
  void buy(Computer c){
    money -= c.price;
    bonusPoint += c.bonusPoint;
  }
  ```

  보면 알겠지만 심각한 중복이 일어나게 된다... 이때 다형성의 장점이 나오게 된다.

  ```java
  void buy(Product p){
    money -= p.price;
    bonusPoint += p.bonusPoint;
  }
  ```

  매개변수 p 는 Product 타입의 참조변수인데 다형성 때문에 매개변수에는 Product 의 자손인 Computer, Audio, Tv 3 가지가 모두 들어갈 수 있다.



```java
class Product{
    int price;
    int bonusPoint;

    Product(int price){
        this.price = price;
        bonusPoint = (int)(price/10.0);
    }
}

class Nintendo extends Product{
    Nintendo(){
        super(100);
    }
    public String toString(){
        return "Nintendo";
    }
}
class Computer extends Product {
    Computer(){
        super(200);
    }

    public String toString() {
        return "Computer";
    }
}
class Audio extends Product{
    Audio(){
        super(100);
    }
    public String toString(){
        return "Audio";
    }
}

class Buyer{
    int money = 1000;
    int bonusPoint = 0;

    void buy(Product p ){
        if(money < p.price){
            System.out.println("돈이 부족하여 물건을 구입할 수 없습니다!");
            return;
        }

        money -= p.price;
        bonusPoint += p.bonusPoint;
        System.out.println(p + "을/를 구입하셨습니다");
    }
}

public class Ex7_8 {
    public static void main(String[] args) {
        Buyer b = new Buyer();

        // 이 아래 코드가 조금 헷갈렸는데, 아니다 다를까 갓궁성님 바로 집어주심
        b.buy(new Nintendo());  // 이렇게 해도 상관이 없다. 대신 참조변수를 선언을 안해주니까 이 클래스 안에서는 사용못하고, buy 메서드 안에서는 참조변수로 객체를 받기 때문에 객체를 사용할 수 있다!
        b.buy(new Computer());
        b.buy(new Audio());

        int i = 10;
        System.out.println(i);
        // 이거랑 다를 게 없는 코드임!


        System.out.println(b.money+"남았습니다!");
        System.out.println(b.bonusPoint+"가 현재 보너스 포인트입니다!");
    }
}
```



## 7-29 여러 종류의 객체를 배열로 다루기

저번 시간 초입부에 말했던 다형성의 장점에는 2가지가 있다.

1. 다형적 매개변수
2. **하나의 배열에 여러 종류 객체 저장 ** 

이번에는 2번의 대해서 배워본다.

2번에서 보면 배열이란 같은 타입밖에 저장이 안된다.

다형성을 이용하면 하나의 배열에 여러 종류의 객체를 저장할 수 있게 된다!!



- 조상타입의 배열에 자손들의 객체를 담을 수 있다.

  ```java
  Product{
    int price;
  }
  Tv extends Product{}
  Computer extends Product{}
  Audio extends Product{}
  
  Product p1 = new Tv();
  Product p2 = new Computer();
  Product p3 = new Audio();
  // 위처럼 쓴걸 다음과 같은 코드로 바꿀 수 있다. 뭐 같긴 함
  // 근데 밑의 코드는 묶어놓은 거고, 위는 안 묶어 놓은 것
  
  Product[] p = new Product[3];	// 이거 그려보자
  p[0] = new Tv();							// Product 객체만 올수 있을 거 같지만, 다형성 때문에 Product의 자손인 Tv 도 가능함.
  p[1] = new Computer();
  p[2] = new Audio();
  ```

  ```java
  class Buyer = {
    int money = 1000;
    int bonusPoint = 0;
    
    Product[] cart = new Product[10];
    
    int i = 0;
    
    void buy(Product p){
      if(money < p.price){
        System.out.println("잔액부족입니다.");
        return;
      }
      money -= p.price;
      bonusPoint += p.bonusPoint;
      cart[i++] = p;
    }
  }
  ```

  - 여담으로 Vector 라는 클래스 안에는 Object[] 라는 가변 배열이 존재한다. 그래서 위 코드처럼 new Product[10] 처럼 배열의 크기가 고정되고, 나중에 추가해야될 상품이 100개나 되는 대처하기 힘든 경우를 대처할 수 있음. 나중에 11장에서 배울 예정이다.

  

  

  ## 7-34 추상클래스의 작성

  1. 미완성 설계도임. 미완성 클래스는 미완성 메서드, 즉 **몸통이 없는 메서드를 가지고 있는 클래스.**
  2. **목적**은 다른 클래스 작성에 도움을 주기 위한 것임. 미완성 클래스로는 인스턴스 생성 불가능.
  3. 상속을 통해 **모든** **추상 메서드**를 완성해야만 인스턴스 생성 가능.

  

  - 여러 클래스에 공통적으로 사용될 수 있는 추상 클래스를 바로 작성하거나, 기존 클래스의 공통 부분을 뽑아서 추상클래스를 만든다.

    ```java
    class Marine {
      int x, y;
      void move(int x, int y){ /*지정된 위치로 이동*/}
      void stop() {/*현재 위치에 정지*/}
      void stimPack() {/*스팀팩 사용*/ }
    }
    
    class Tank{
      int x,y;
      void move(int x, int y){ /*지정된 위치로 이동*/}
      void stop() {/*현재 위치에 정지*/}
    	void changeMode() {/* 공격모드로 전환 */ }
    }
    
    class Dropship{
      int x, y;
      void move(int x, int y){ /*지정된 위치로 이동*/}
      void stop() {/*현재 위치에 정지*/}
    	void load()	{/*선택된 대상을 태운다 */}
      void unload() {/*선택된 대상을 내린다 */}
    }
    ```

    위 코드를 보면 중복이 있다! 그래서 이를 추상클래스를 이용해서 코드를 바꾸면

    ```java
    abstract class Unit {
      int x,y;
      abstract void move (int x, int y);	// 이동하는 게 공중, 지상 유닛에 따라 다르기 때문에 몸통 부분이 다를 것 ==> 추상 메서드로 남겨둠, 자손 클래스들이 직접 작성해야 사용 가능함. 근데 사실 몸통만들어서 추상메서드로 안 만들어도 되긴 함. 근데 추상메서드로 남김으로써 자손들이 강제로 만들도록 함.
      void stop() {/* 현재 위치에 정지 */}
    }
    
    class Marine extends Unit {
      void move(int x, int y){ /*지상 유닛 무빙 */ }
      void stimPack() {/* 스팀팩 사용 */ }
    }
    
    class Tank extends Unit {
      void move(int x, int y){ /*지상 유닛 무빙*/}
      void changeMode() {/* 공격모드로 전환 */ }
    }
    
    class Dropship extends Unit {
      void move(int x, int y){/*공중 유닛 무빙*/}
      void load()	{/*선택된 대상을 태운다 */}
      void unload() {/*선택된 대상을 내린다 */}
    }
    
    Unit[] group = new Unit[3];
    group[0] = new Marine();
    group[1] = new Tank();
    group[2] = new Dropshop();
    
    for(int i = 0 ; i < group.length; i++)
      group[i].move(100,200); // 이렇게 하면 뭐가 실행이 될까? ==> 각각의 실객체, 즉 Marine, Tank, Dropship 각각의 실객체의 메서드가 호출되는 거지, 추상 클래스의 메서드가 불러와져서 실행되는 게 아니다.
    ```

    근데 만약 위에서 Unit[] group 이 Object[] group 으로 되어 있으면 어떻게 되냐?

    ```java
    Object[] group = new Unit[3];
    group[0] = new Marine();
    group[1] = new Tank();
    group[2] = new Dropship();
    // 여기 까진 넣어짐. 다형성 때문에
    
    for(int i = 0 ; i < group.length ; i++){
      group[i].move(); // 이 부분에서 에러가 남. 왜냐하면 지금 group 객체 안에 있는 각각의 참조 변수, 즉 리모콘은 Object 형 참조변수임. 그래서 move 메서드를 이 참조변수들이 사용할 수가 없음. 사용하려면 형변환을 하던가 해야함.
    }
    ```

    

## 7-33,34 추상클래스의 작성(2)

추상 클래스를 왜 쓰냐?

1. 관리가 용이해진다.

2. 한번 만들고 나면 쉽게 작성할 수 있다.
3. 중복도 제거
4. 변경도 쉬움. ==> 추상 클래스를 의미 있는 단계로 쪼개서 진화시키게 되면, 나중에 굳이 최종버전으로 구체화를 하지 않아도 됨. ==> 중간 단계로 만들어버림



- 추상화(불명확, 구체적이지 않음) <==> 구체화 (명확, 구체적인것)

  무조건 구체화, 즉 명확한 게 좋은 것이 아니냐? 라고 생각할 수 있다. 근데 사실 애매하게 하면 피해나갈 구멍이 있기 때문에...ㅎㅅㅎ

  ==> **추상화된 코드는 구체화된 코드보다 유연하다 라는 장점이 있음.** ==> 변경에 유리하다는 소리!

  ```java
  (1) GragorianCalendar cal = new GregorianCalendar();	// 구체적
  (2) Calendar cal = Calendar.getInstance();	// Calendar 의 자손객체를 반환. 
  
  //Calendar.getInstance 함수 내에 return 하는 것을 보면 createCalendar(~) 로 되어 있고, 
  //createCalendar를 보면 
  private static Calendar createCalendar(TimeZone zone, Locale aLocale){
    // ...
    if (caltype != null){
      switch(caltype){
        case "buddhist":
          cal = new BuddhistCalendar(zone, aLocale);	// Calender 의 자손
          break;
        case "japanese":
          cal = new JapaneseImperialCalendar(zone, aLocale);	// Calender 의 자손
          break;
        case "gregory":
          cal = new GregorianCalendar(zone, aLocale);	// Calender 의 자손
          break;
      }
    }
  }
  ```
  
  (1) 의 경우 구체화된 코드라서, 그만큼 명확하다고 할 수 있다. 하지만 동시에 그레고리안력만 생성할 수 밖에 없다. 
  
  (2) 의 경우는 추상화된 코드라서, 불분명하다. 하지만 Calendar 라는 추상클래스를 사용해서, 저 코드만 사용하면 사용자의 위치에 맞는 달력을 얻을 수 있다.
  
  
  
  이러한 장점을 말한 예시임.


## 7-35~37 인터페이스의 선언, 상속, 구현

- **인터페이스(interface) 란? == 추상 메서드의 집합!** 이게 결론임 

  근데 이건 프로그래밍 관점에서 설명하는 거고, 일반적인 의미에서의 인터페이스 의미는 조금 이따가 알게 될 것. + 부수적인 것들(static 메서드, default 메서드, 상수) 근데 부수적인 것들은 진짜 부수적인 것들이니까 추상 메서드에 집중하자!
  
  
  
- **구현된 것이 전혀 없는 설계도. 껍데기 ( 모든 멤버가 public )** ==> 이게 핵심임!!!

  캡슐화.... 다시 한번 보자

  Q. 추상 클래스와 인터페이스의 차이가 뭐냐? 라는 면접 질문이 나오기도 함

  A. 추상 클래스는 일반 클래스 이지만 추상 메서드를 가지고 있는 것임. 그 외에 생성자, iv 등등 있음

  ​	**반면 인터페이스는 완전히 아무것도 없는, 추상 메서드만** 가지고 있는 것임. 인터페이스는 iv 나 생성자를 가질 수 없다.

  ​	이게 핵심임.

  ​	추상 클래스는 일부가 미완성이고, 인터페이스는 ㄹㅇ 아무것도 없는 것이다!

  ​	정팔각형의 모형에서 속에는 iv 가 있고, 그걸 둘러싼 두꺼운 껍질은 메서드. 그리고 그 두꺼운 껍질의 표피가 추상 메서드라고 생각하면 된다.

  ```java
  interface 인터페이스이름{
    	public static final 타입 상수이름 = 값;	// 상수, 클래스처럼 변수는 안된다! iv, cv 불가능! 그래서 final 임!
    	public abstract 메서드이름(매개변수목록);	// 추상메서드
  }
  // 모든 인터페이스의 멤버는 public 이다. 이게 기본임.
  ```

  ```java
  interface PlayingCard {
    // 상수
    public static final int SPADE = 4;
    final int DIAMOND = 3;	// public static final int DIAMOND = 3;
    static int HEART = 2;		// public static final int HEART = 2;		
    int CLOVER = 1;					// public static final int CLOVER = 1;
    
    // 추상 메서드
    public abstract String getCardNumber();
    String getCardKind();	// public abstract String getCardKing(); 이어야 하지만, 인터페이스는 원래 모든 메서드가 public 이자 abstract 이기 때문에 생략이 가능하다.
  }
  ```



- 인터페이스의 조상은 인터페이스만 가능 ( Object 가 최고 조상이 아님! )

- 인터페이스는 다중 상속이 가능( 추상메서드는 충돌해도 문제 없음, 왜냐하면 전에 충돌이 문제라고 했던 이유는 메서드의 선언부는 같은 데 **구현부가 달라서 충돌이 생기던 거임**. 하지만 추상 메서드 이기 때문에 선언부만 있고 구현부가 없음 ==> 충돌 날 일이 없다! )

  ```java
  interface Fightable extends Movable, Attackable {}	// 2개
  
  interface Movable {
    /** 지정된 위치로 (x,y) 로 이동하는 기능의 메서드 */
      void move(int x, int y); 
  }
  
  interface Attackable{
    /** 지정된 대상(u) 를 공격하는 기능의 메서드 */
    void attack(Unit u);
    void move(int x, int y);
  }
  ```



- 인터페이스의 구현이란? ( 미완성 설계도니까 완성을 해서 써야 한다. 즉 설계도를 완성 시키는 것을 구현이라고 한다! )

  ==> 인터페이스에 정의된 추상 메서드를 완성하는 것!

  ```java
  class 클래스이름 implements 인터페이스이름{
    //	인터페이스에 정의된 추상메서드를 모두 구현해야 한다.
  }
  
  interface Fightable {
    void move(int x, int y);	// public abstract 생략
    void attack(Unit u);	// 위와 동일
  }
  
  class Fighter implements Fightable{ // 이렇게 하면 Fighter클래스느 Fightable 인터페이스를 구현했다.
    public void move(int x, int y){ /*내용 생략 */}
    public void attack(Unit u){/*내용 생략 */}
  }
  
  //일부만 구현하는 경우, 클래스 앞에 abstract를 붙여야 함.
  abstract class Fighter implements Fightable{
    public void move(int x, int y) {/*내용 생략 */}
    // public abstract void attack(Unit u)
  }
  ```



- Q. 인터페이스란?

  A. **추상메서드의 집합.** + 상수, static 메서드, 디폴트 메서드.

- Q. 인터페이스의 구현이란?

  A. 인터페이스의 추상메서드 몸통{} 만들기 ( 미완성 설계도 구현하기 )

  ```java
  class AudioPlayer extends Player{	// 추상 클래스 구현!
    void play(int pos) {/*내용 생략 */}
    void stop(){/*내용 생략 */}
  }
  
  class Fighter implements Fightable{	// 인터페이스 구현!
    public void move(int x, int y){/*내용 생략 */}
    public void attack(Unit u){/*내용 생략 */}
  }
  ```
  
  
  
- Q. 추상 클래스와 인터페이스의 공통점은?

  A. 추상 메서드를 가지고 있다. (미완성 설계도)

- Q. 추상 클래스와 인터페이스의 차이점은?

  A. **멤버 변수의 유무**. 

  명품답. 인터페이스는 iv 를 가질 수 없다.

  ```java
  abstract class Player{
    boolean pause; 	// iv
    int currentPos;	// iv
    
    Player(){	// 생성자
      /*내용 생략 */
    }
    
    abstract void play(int pos);	// 추상 메서드
    
    abstract void stop();					// 추상 메서드
    
    void play(){									
      play(currentPos);	// 추상 메서드 사용할 수 있다.
    }
  }
  // 위를 보면 추상클래스는 추상 메서드 뿐만 아니라 iv 도 가지고 있다.
  // 하지만 반면 인터페이스는 iv 를 가질 수 없기에 추상 메서드만 가지고 있다.
  
  interface Fightable{
    void move(int x, int y);
    void attack(Unit u);
  }
  ```

  

## 7-38 인터페이스와 다형성

- 인터페이스도 다형성이 통함!

- 인터페이스도 구현 클래스의 부모? Yes , 근데 엄밀히 말하면 부모가 아님. 부모라는 개념은 클래스만 되니까!

  ```java
  class Fighter extends Unit implements Fightable{
    public void move(int x, int y){ /*내용 생략 */ }
    public void attack(){ /*내용 생략 */ }
  }
  
  interface Fightable{
    void move(int x, int y);
    void attack(Fightable f);	// 매개변수의 타입이 인터페이스인 경우!!!! Fightable 인터페이스를 구현한 클래스의 인스턴스만 가 능하다라는 의미!
  }
  
  Unit u = new Fighter();
  Fightable f = new Fighter();
  // 개 신기하네. 대신 Fightable 인터페이스에 선언된 메서드만 사용 가능. 
  // f.move(1,2)
  // f.attack(new Fighter()) 이렇게!
  ```



- 인터페이스를 메서드의 리턴타입으로 지정할 수 있다.

  ```java
  Fightable method(){	// 보면 method() 의 리턴타입을 인터페이스 Fightable 로 지정함. 이 말은 Fightable 인터페이스를 구현한 클래스의 인스턴스를 반환한다는 말임.
     /*내용 생략 */ 
    // Figther f = new Fighter();
    // return f;	
    return new Fighter();	
  }
  
  //그래서 
  Fightable f = method(); // 인걸
  Fightable f = new Fighter(); // 라고 써도 된다.
  
  class Fighter extends Unit implements Fightable{
    public void move(int x, int y) { /*내용 생략 */ }
    public void attack(Fightable f) { /*내용 생략 */ }
  }
  ```

  

- 어떤 메서드의 반환 타입이 인터페이스다? 

  그러면 이 인터페이스를 구현한 클래스의 인스턴스를 반환해준다 라는 의미이다! 

  그리고 이렇게 되면 이러한 인스턴스를 받는 쪽, 즉 참조 변수의 타입을 메서드의 반환 타입의 참조변수로 받아야 한다!

  ```java
  Fightable method(){
    return new Fighter();
  }
  
  Fightable f = method() // 이렇게 해야 한다. FightableTest.java 의 42번째 줄을 보면, f.getFightable() 의 리턴값은 (Fightable) f 이다. 그래서 보면
  // Fightable f2 = f.getFightable() 로 해둠.
  ```
  
  (말이 어렵네...)
  
  이건 실습 위주로 다시 한번 해보는 게 더 도움이 될 거다.
  
  

# 7-39 인터페이스의 장점 (1)

- **1. 두 대상(객체) 간의 "연결", "대화", "소통" 을 돕는 "중간 역할"을 한다.**

  interface = inter ( ~사이 ) + face ( 얼굴, 대상 )

  

  기계의 껍데기를 생각하면 된다. ( 실제 하드웨어가 아님 )

  Ex1) 자판기에서 우리는 누르기만 하면 되는 그 판때기

  Ex2) 컴퓨터도 직접 쓰기 힘들다. 그래서 윈도우, 즉 GUI (Graphic User Interface) 라는 것이 나옴.

  ​		여기서 GUI 는 우리 <========> 컴퓨터 간에 연결, 대화, 소통을 해줌.

  

​	여기서 공통점은 중간에 껍데기가 있으면? 

​	=> 하드웨어가 바뀌더라도 우리가 느끼기엔 차이가 없다. 뭐 하나 바뀌었다고 일일히 다 바뀐다? ㄹㅇ 개극혐임.

​	**컴퓨터 본체가 바뀌었다 한들, 윈도우 화면이라는 interface 가 그대로면 사용자는 영향을 안 받음!!!**

​		

- **2. 선언(설계) ( == 껍데기 ) 과 구현 ( == 알멩이 ) 을 분리시킬 수 있게 한다.**

  ```java
  // 껍데기 + 알멩이
  class B {	
    public void method(){
      System.out.println("method in B");
    }
  }
  ```

  위와 같은 클래스를 다음과 같이 분리가 가능하다

  ```java
  // 껍데기 & 알멩이 분리
  interface I {
    public void method();	// 선언부(껍데기)만 떼어내기!
  }
  
  class B implements I {
    public void method(){	// 알멩이
      System.out.println("method in B");
    }
  }
  
  class C implements I {
    public void method(){
      System.out.println("method in C");
    }
  }
  ```

  

- 인터페이스 덕분에 B가 변경되어도 A는 안 바꿀 수 있게 된다. (느슨한 결합  )

  만약 껍데기+알멩이 버전으로 되어 있으면, A 가 B 쓰다가 C 로 바꾸려면 A의 코드를 아얘 다 바꿔야 한다.
  
  하지만 껍데기 & 알멩이 분리 버전으로 되어 있으면, A 는 인터페이스 I 를 통해 B 를 사용하기 때문에 C 쓰려고 할때 A 에 변경을 가할 필요가 없다!
  
  ```java
  class A {
    public void methodA(B b){
      b.methodB();
    }
  }
  
  //
  class B{	// 이건 껍데기+알멩이 버전임. 그래서 이걸 분리하면 바로 아래 코드와 같다.
  	public void methodB(){
      System.out.println("methodB()");
    }
  }
  //
  interface I{
    public void methodB();
  }
  
  class B implements interfaceB{
    public void methodB(){
  		System.out.println("methodB()")
    }
  }
  //
  
  class InterfaceTest{
    public static void main(String[] args){
      A a = new A();
      a.methodA();
    }
  }
  ```
  
  즉, A 와 B(껍데기 + 알멩이) 가 직접적으로 연결이 되어 있던 걸, A 와 I (껍데기) 의 연결로 만들어, 나중에 수정을 가해야 할때 A 에 영향이 안 가도록 한다가 포인트이다!
  
  

# 7-39 인터페이스의 장점 (2)

- **개발시간을 단축할 수 있다.**

  A--------사용------->I--------구현-------->B

  이렇게 하면 A 는 B 클래스가 다 완성이 안 되어도, 인터페이스를 보고 사용하는 코드만 짜면 됨 ==> 시간 단축

  

- **변경에 유리한 유연한 설계가 가능하다**

  I (껍데기) + B(알멩이) 구조로 만들어, 나중에 구현 파트에서 변경점이 생기게 되면  A (사용자) 에 변화를 안 줘도 되고 알멩이 파트만 갈아끼면 됨!

- **표준화가 가능하다**

  Java Application 과 기존의 데이터베이스( MySQL, Oracle ) 사이에 JDBC 라는 인터페이스 집합을 넣어, 표준화를 구현함.

- **서로 관계 없는 클래스들을 관계를 맺어줄 수 있다!**

  <img src="/Users/xpmxf4/Desktop/스크린샷 2021-11-06 오후 4.42.49.png" alt="스크린샷 2021-11-06 오후 4.42.49" style="zoom:50%;" />



# 7-40 디폴트 메서드와 static 메서드

- 인터페이스에 디폴트 메서드, static 메서드 추가 기능. (JDK 1.8부터)

  원래는 추상 메서드만 가능하다고 우린 배웠었다!

- 인터페이스에 새로운 메서드(추상 메서드)를 추가하기 어려움

  예를 들면 

  1. 복잡한 상속계층도를 가진 코드가 있다고 해보자.

  2. 그리고 이러한 상속계층도에서 몇개몇개가 같은 인터페이스를 구현했다고 해보자.

  3. 이랬을 때, 이 인터페이스에 추상 메서드를 하나 추가시키게 되면, 이 인터페이스를 구현한 모든 클래스는
     새롭게  추가된 추상 메서드를 일일히 다 구현을 해야 한다. 이게 ㄹㅇ 번거롭다.

  4. ```java
     interface MyInterface{
       void method();
       void newMethod();
     }
     ```

     를 밑에처럼 바꿔버림

     ```java
     interface MyInterface{
       void method();
       default void newMethod(){}; // 인터페이스 원칙 위반임!! 몸통이 존재하니까!! 여기서는 default 꼭 붙여야 한다!!
     }
     ```

     근데 인터페이스가 다중 상속이 가능했던 이유는, 추상메서드의 집합 즉 구현부가 없으니까 이름이 겹쳐도 상관이 없는 데, 이제는 충돌 문제가 생긴다.

  5. 디폴트 메서드가 기존의 메서드와 충돌할 때의 해결책

     1. 여러 인터페이스의 디폴트 메서드 간의 충돌
        - 인터페이스를 구현한 클래스에서 디폴트 메서드를 오버라이딩 해야 한다.
     2. 디폴트 메서드와 조상 클래스의 메서드 간의 충돌
        - 조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시된다.

  6. 근데 사실 5번 같은 규칙 잘 모르겠으면 우리가 직접 오버라이딩 하면 해결 끝이다!!





여기까지 객체지향!

----------



# 7-42 내부 클래스(inner class)

- 클래스 안의 클래스

  ```java
  class Outer {	// 외부 클래스
    class Inner{	// 내부 클래스
    }
  }
  ```

- 내부 클래스의 **장점**

  1. **내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다!**

  => 클래스B가 클래스A의 멤버에 접근하려면 객체를 선언해서 사용해야 한다. 하지만 위처럼 내부 클래스로 선언하면 **객체 생성 없이도 Outer 의 멤버에 접근 가능**

  

  2. **코드의 복잡성을 줄일 수 있다.** (**캡슐화**) => A 클래스 안에서만 쓸 클래스면, 안에서 선언하고 안에서만 씀!

  

- 내부 클래스의 종류와 유효범위(scope) 는 변수와 동일

  ```java
  class Outer{
    int iv = 0;
    static int cv = 0;
    
    void myMethod(){
      int lv=0;
    }
  }
  
  class outer{
    class InstanceInner{}				// iv 랑 특징 같음, 인스턴스 클래스
    static class StaticInner{}	// cv 랑 특징 같음, 스태틱 클래스
    
    void myMethod(){
      class LocalInner{};				// lv 랑 특징 같음, 지역 클래스
    }
  }
  
  이거 말고 "익명 클래스" 라고 있는 데, 이건 이벤트 처리기등 일시적으로만 쓸 애들에 사용하는 데 거의 안씀.
  ```
  
  

# 7-45~50 내부 클래스의 제어자와 접근성

```java
class outer{														// 원래 클래스에는 (default) 아니면 public 만 가능했었다.
  private int iv = 0;
  protected static int cv = 0;
  
  void myMethod(){
    int lv = 0;
  }
}

class Outer{
  private class InstanceInner{}					// 여기 내부클래스에는 
  protected static class StaticInner{}	// private,(default),protected,public 다 가능하다!
  
  void myMethod(){
    class LocalInner{} 
  }
}
```

내부 클래스는 iv, cv, lv 랑 다를 거 없다! 어렵게 생각하지 말자!

```java
public class Ex7_12 {
    class InstanceInner{
        int iv = 100;
        //        static int cv = 100;
        final static int CONST = 100;   // 상수인 경우 static 이 가능하다.
    }

    static class StaticInner{ // 내부 클래스 안에 static 멤버가 필요하면,
        // static 내부 클래스를 사용해야 한다!
        // 사실 static 멤버면 객체 생성 없이 사용할 수 있어야 한다.
        // 근데 instance 내부 클래스 안에 static 멤버가 있으면, 클래스가
        // static 이 아니라 사용하지 못한다는 모순이 생김.
        // 따라서 이렇게 이러한 규칙이 존재하는 거
        int iv = 100;
        static int cv = 100;
        // static 내부 클래스에서는 외부 클래스의 인스턴스
        // 멤버에 접근할 수 없다.
    }

    void meMethod(){
        class LocalInner{
            int iv = 300;
            final static int CONST = 300;    // 보통 상수에 final static 둘이 같이 붙인다.
            // 근데 항상 그러지는 않음!! 밑 Card 확인
            // 근데 사실 Card 가 좀 예외기는 함
            // 그때그때 마다 경우 따라서 제어자 잘 붙이기!
        }
        
        int i = LocalInner.CONST;	// 지역클래스의 상수를 사용하려면, 이 방법이 유일하다!
    }

    public static void main(String[] args) {
        System.out.println(InstanceInner.CONST);
        System.out.println(StaticInner.cv);
    }
}


```

- 상수마다 `final static` 과 `final` 가 달라지는 예시

  ```java
  class Card{
      final String  kind="heart";
      final int number = 3;
   	final static int number = 52;	// 총 카드의 수, 이건 항상 안 변하니까!
  }
  ```

  

```java
class Ex7_13{
  class InstanceInner{}
  static class StaticInner{}
  
  InstanceInner iv = new InstanceInner(); // 가능
  StaticInner cv = new StaticInner();	// 가능
  //StaticInner cv = new InstanceInner(); 이건 안됨. 왜냐하면 Static 멤버로 Instance 객체 가리키려 하니
  
  static void staticMethod(){
    StaticInner obj2 = new StaticInner(); // 가능
    InstanceInner obj1 = new InstanceInner(); // 가능x. static 멤버 안에서는 외부 클래스의 instance member 사용할 수 없으니까! 접근할 수 없으니까!
    
  	// 굳~~~~~~이 InstanceInner 클래스를 사용하고 싶으면 다음과 같이 하면 된다.
    Ex7_13 outer = new Ex7_13();
		InstanceInner obj1 = outer.new InstanceInner();
  }
  
  void instanceMethod(){
    StaticInner obj2 = new StaticInner();	
    InstanceInner obj1 = new InstanceInner();
  }
  
  void myMethod(){
		class LocalInner{}
    LocalInner lv = new LocalInner();
  }
}
```

인스턴스 내부 클래스, static 내부 클래스를 **어디서 쓸 수 있고, 어디에서 못 쓴다는 게 iv, cv 랑 똑같다는 게 포인트**!!



```java
// 예제 7-14
내부 클래스는 외부 클래스의 private 멤버에 접근 가능하다.
지역 내부 클래스 에서는 final 이 붙은 변수, 즉 상수만 접근 가능하다!
근데 jdk1.8 부턴 에러가 아님!
class Outer{
  private int outerIv = 0;
  static int outerCv = 0; // 이거 private 이여도 StaticInner 에서 조회 가능!
  
  class InstanceInner{
    int iiv = outerIv;
    int iiv2 = outerCv;
  }
  
  static class StaticInner{
//  int siv = outerIv; 불가능!  
    static int scv = outerCv;
  }
  
  void myMethod(){
    int lv = 0;				// 지역 변수
    final int LV = 0;	// 상수
    
    class LocalInner{
      int liv = outerIv;
      int liv2 = outerCv;
      int liv3 = lv; // 원래 이건 오류임. 왜냐하면 내부 클래스의 객체가 meMethod() 보다 오래 살아남음. 그러면 내부 클래스의 객체는 살아있는 데, myMethod() 는 죽어서 lv 를 조회할 수가 없음. 근데 jdk 1.8 부턴 가능하다! jdk1.8은 final 선언안해도, 안 변하는 값들을 상수 취급 하기 때문에 lv 인거임.
      int liv4 = LV;	// 얘는 상수라서 가능함!
    }
  }
}
```

1. 내부 클래스는 외부 클래스의 private 멤버에 접근 가능하다.
2. 지역 내부 클래스에서는 외부 메서드의 iv 중 상수만 접근 가능함.

2-2. jdk1.8부터 오류는 아니다. 왜냐하면 jdk1.8은 final 없이 바뀌지 않는 값도  상수로 취급함. 그래서 갓궁성이 얘기한 건, 그냥 외부 메서드에 다 final 붙이라고 하심.



```java
class Ex7_15{
  public static void main(String[] args){
    Outer2 oc = new Outer2();
    Outer2.InstanceInner ii = oc.new InstanceInner();		// 이거 생긴 건 그냥 받아들이자. 문법임.
    
    System.out.println(ii.iv);
    System.out.println(Outer2.StaticInner.cv);
    
    Outer2.StaticInner si = new Outer2.StaticInner();
    System.out.println(si.iv)
  }
}

class Outer2{
  class InstanceInner{
    int iv = 100;
  }
  static class StaticInner{
		int iv = 200;
    static int cv = 300;
  }
  void myMethod(){
    class LocalInner{
      int iv = 400;
    }
  }
}
```

1. 내부 클래스의 참조변수 만들기



```java
class Outer3{
  int value = 10;
  
  class Inner{
    int value = 20;
    
    void method1(){
      int value = 30;
      System.out.println(value);							//30
      System.out.println(this.value);					//20
      System.out.println(Outer3.this.value);	//10, 이 지랄 하는 거 드물긴 한데 참조는 할 수 있다 정도로만 말자.
    }
  }
}
```



# 7-51 익명 클래스(anonymous class)

- 이름이 없는 일회용 클래스. 정의와 생성을 동시에 함!

  ```java
  // 문법
  new 조상클래스이름(){
    //클래스 내용, 멤버 선언
  }
  
  			또는
  new 구현인터페이스이름(){
   	//클래스 내용, 멤버 선언
  }
  ```



```java
//예제
class Ex7_17{
  Object iv = new Object(){ void method(){} };
  static Obejct cv = new Object(){ void method(){} };
  
  void myMethod(){
    Object lv = new Object(){ void method(){} };
  }
}
```



```java
//AWT (Java 의 윈도우 프로그래밍 도구)
import java.awt.*;
import java.awt.event.*;

class Ex7_18{
  public static void main(String[] args){
    Button b = new Button("Start");
    b.addActionListener(new EventHandler());
  }
}

class EventHandler implements ActionListener{ // 근데 이거 일회성인데 클래스 선언해주는건 낭비다. 
  public void actionPerformed(ActionEvent e){
    System.out.println("ActionEvent occurred!!");
  }
}
```

하도 비효율적이다 보니, 아래와 같이 익명 클래스로 진행한다.

```java
class Ex7_18{
  public static void main(String[] args){
    Button b = new Button("Start");
    b.addActionListener(new ActionListener(){	// 클래스의 정의와 객체 생성을 동시에 진행함!
      public void actionPerformed(ActionEvent e){
    		System.out.println("ActionEvent occurred!!");
  		}
    })
  }
}
```





