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

오른쪽과 같이 클래스를 포함관계로 선언하면 iv 접근을 다음과 같이 해야한다.

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



