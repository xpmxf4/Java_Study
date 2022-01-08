# CH9-1 Object 클래스

Object 클래스란? 
: 모든 클래스의 최고 조상. 오직 11개의 메서드만을 가지고 있다.
: notify(), wait() 등은 쓰레드와 관련된 메서드이다.

![Object클래스메서드표](C:\Users\xpmxf\Desktop\Java_Study\Object클래스메서드표.jpg)

- 대부분의 메서드는 오버라이딩해서 우리가 처한 상황에 맞게 사용하게 된다. 

- protected 된 애들은 public 으로 오버라이딩 하여 사용하게 된다.`protected void finalize` 는 객체가 GC 에 의해서 없어질 때 발동하는 메서드이다. 

  메모리가 없으니까 GC 가 작동하는 건데, 이 안에 이상한 작업들을 넣으면은 컴퓨터가 역으로 터지니까, 왼만하면 터치하지 말자.

- getClass() 의 Class 객체는 설계도에 대한 정보를 담은 객체이다. 이걸로 새로운 객체도 만들 수 있고 정보를 얻을 수 있다.

  이 설계도를 가지고 객체 생성, 정보를 얻을 수 있는 것을 `Reflection API` 라고 한다!

  이걸 사용할 줄 알면 정말 다양하게 많아지지만, 난이도가 있기 때문에 자바의 정석 3편에서 나올 예정.

# 9-2 equals(Object obj)

- 객체 자신(this)와 주어진 객체 (obj)를 비교한다. 같으면  true, 다르면 false 를 반환함

- Object 클래스의 equlas()는 객체의 주소를 비교한다. (참조변수 값 비교)

  ```java
  public boolean equals(Object obj){
      return (this==obj);
  }
  ```

  ```java
  class Ex9_1{
      public static void main(String[] args){
          Value v1 = new Value(10);
          Value v2 = new Value(10);
          
          System.out.println(v1.equals(v2))	// false
      }
  }
  
  class Value{
      int value;
      
      Value(int value){
          this.value = value;
      }
  }
  ```

  v1, v2 는 같은 value 를 가지고 있어도, 다른 주소값을 가지고 있다. 이를 true 로 나오게 하려면, equals 를 Overriding 해야한다!

  Ex9-1.java 참조

# 9-3 equals(Object obj) 의 오버라이딩

- 인스턴스 변수(iv) 의 값을 비교핟로고 equals() 를 오버라이딩 해야 한다.

  **상황**

  |        IV        |         CV          |
  | :--------------: | :-----------------: |
  | 객체마다 다른 값 | 객체 끼리 모두 공통 |

  그래서 객체의 iv 값이 다 같으면, equals() 가 true 를 반환하도록 오버라이딩 하기 

  ```java
  class Person{
      long id;
      
      public boolean equals(Object obj){
          if(obj instanceof Person)
              return id == ((Person)obj).id;
          else
              return false;
      }
      
      Person(long id){
          this.id = id;
      }
  }
  ```

  Ex9_2.java 참조

# 9-4 hashCode()

- 객체의 해시코드(hash code) 를 반환하는 메서드
  : 해싱 알고리즘. 나중에 11장 컬렉션 프레임웍에서 배울거

- Object 클래스의 hashCode()는 **객체의 주소를 int 로 변환해서 반환**함.

  ```java
  public class Object{
      //...
      public native int hashCode();	// native 메서드, 내용이 없다!
  }
  ```

  `native` 란 네이티브 메서드, 즉 OS의 메서드이다. 그리고 이는 주로 C 언어로 이루어져 있다.

  그리고 이는 이미 작성된 OS의 메서드를 사용하는 것이기 때문에, 내용이 없다.

  따라서 위처럼 native 라고 해두면, 미리 (C로)작성된 OS 의 메서드가 Java 에서 짜진 메서드처럼 사용이 된다. 그리고 미리 작성된 거니까 내용을 알 수 없다.

- **equals() 를 오버라이딩하면, hashCode()도 오버라이딩 해야 한다.**
  : equals() 의 결과가 true 인 두 객체의 해시코드는 같아야 하기 때문에, hashCode() 도 equals() 에 맞춰서 오버라이딩 해야함. ( 이건 규칙이다!! ) --> Ex9_4.java 에서 배움.

  ```java
  String str1 = new String("ABC");
  String str2 = new STring("ABC");
  System.out.println(str1.equals(str2));	// true, equals() 가 오버라이딩 됐다고 생각하자! 
  System.out.println(str1.hashCode());	// 96354
  System.out.println(str2.hashCode());	// 96354
  ```

  ```java
  public int hashCode(){
      return Objects.hash(매개변수1, 매개변수2, 등등)
  }
  ```

  ​	

- System.identityHashCode(Object obj) 는 Object 클래스의 hashCode() 와 동일.

  ```java
  System.out.println(System.identityHashCode(str1));//3526128
  System.out.println(System.identityHashCdoe(str2));//7699183
  ```

  그리고 32bit JVM 에서는 주소가  int 이다. 하지만 64 bit JVM 에서는 주소 단위가 long 이기 때문에, 64 -> 32 로 바뀌게 되면 단순히 반에서 짤리기 때문에 주소가 같아질 수가 있다! (참고)

# 9-5~6 toString(), toString() 의 오버라이딩

- toString() : 객체(**iv집합**)를 문자열(String)으로 변환하기 위한 메서드

  ```java
  public String toString() {
      return getClass().getName()+"@"+Integer.toHexString(hashCode());
  }
  ```

  getClass() 는 설계도 객체, 
  getName()은 클래스 이름, 
  toHexString() 은 16진수 변환,
  hashCode() 는 주소값  

  ```java
  class Card{
      String kind;
      int number;
      
      Card(){
          this("SPADE", 1);
      }
      
      Card(String kind, int number){
          this.kind = kind;
          this.number = number
      }
      
      public String toString(){
          return "kind : " + kind + " number : " + number;
      }
  }
  
  class Ex9_4{
      public static void main(String[] args){
          System.out.println(new Card().toString());
          System.out.println(new Card().toString());
      }
  }
  ```

  toString 은 객체, 즉 iv의 집합을 String 으로 나타낸다는 정의를 생각하면 위처럼 오버라이딩 하는 게 좀 더 정의와 가깝다.

  남궁성님은 이게 옳은 건 아니지만, 이렇게 하는 게 보통 일반적이라고 하셨다.

  참고) Ex9_4.java

# 9-7 String 클래스

- String 클래스 = 데이터(char[ ], 문자열 배열) + 메서드(문자열 관련)

  ```java
  public final class String implements java.io.Serializable, Comparable {
      private char[] value;
     	~
  }
  ```

- 내용을 변경할 수 없는 불변(immutable, 즉 내용을 변경할 수 없는) 클래스

  ```java
  String a = "a";	// a 주소 0x100
  String b = "b";	// b 주소 0x200
  a = a+b;		// a 주소 0x300 즉 메모리 상에서 계속 새로운 문자열이 생성이 된다.-> 비효율
  ```

- 고로, 덧셈 연산자(+) 를 이용한 문자열 결합은 성능이 떨어짐

  문자열의 결합이나 변경이 잦다면, 내용을 변경가능한 StringBuffer 를 사용
  String 클래스와는 다르게, StringBuffer 는 문자열의 변경이 가능하다!

# 9-8 문자열의 비교

- `String str = "abc";` 와 `String str = String("abc")` 의 차이점? 

  ```java
  String str1 = "abc";//문자열 리터럴 "abc"의 주소가 저장
  String str2 = "abc";//위에서 만들어진 문자열 리터럴 "abc"의 주소가 저장
  String str3 = new String("abc");//새로운 인스턴스
  String str4 = new String("abc");//새로우 인스턴스
  ```

  <img src="C:\Users\xpmxf\Desktop\Java_Study\newString().png" alt="newString()" style="zoom:75%;" />

  str1 과 str2 는 하나의 문자열 리터럴의 같은 주소를 바라보게 됨.

  하지만 str3 과 str4 는 각각 new 를 통해 객체 생성을 하기 때문에 같은 내용이라도 다른 객체를 바라보게 된다.

  그리고 두 String 의 **내용을 비교**할 때는 equals 를 써야 한다. 왜냐하면 `==` 는 주소값을 비교하기 때문이다. (위의 그림에서 아랫부분을 참고)

# 9-9 문자열 리터럴

- 문자열 리터럴은 프로그램 실행시 자동으로 생성된다.(constant pool에 어장)

  ```java
  class Ex9_7{
      public static void main(String[] args){
          String s1 = "AAA";
          String s2 = "AAA";
          String s3 = "BBB";
          String s4 = "BBB";
      }
  }
  ```

  우리가 만든 문자열은 모두 자동으로 만들어지고, 이는 constant pool(상수 저장소) 에 저장됨.

- 같은 내용의 문자열 리터럴은 하나만 만들어진다.

  ![문자열리터럴](C:\Users\xpmxf\Desktop\Java_Study\문자열리터럴.png)

  왜냐하면 String 클래스는 immutable 클래스니까!

# 9-10 빈 문자열("", empty string)

- 내용이 없는 문자열. 크기가 0인 char형 배열을 저장하는 문자열

  `String str = "";`

- 크기가 0 인 배열을 생성하는 것은 어느 타입이나 가능

  ```java
  char[] chArr = new char[0]; // 길이가 0인 char 배열
  int[] iArr = {};			// 길이가 0인 int 배열
  ```

  빈 문자열을 어디다가 쓰냐?

  ```java
  "" + 5 -> "5"; //int -> String
  String str = ""; // null로 초기화하기보단, 이게 더 유용!
  ```

- 문자(char) 와 문자열(String) 의 초기화

  ```java
  String s = null;
  char c = '\u0000'; // 이렇게 하기 보단
  
  String s = "";	// 빈 문자열로 초기화
  char c = '';	// 공백으로 초기화
  ```

  ```java
  String str1 = ""; // 이렇게 선언해야 좋은 코드임
  
  String str2 = new String("");	// 이건 구데기다!
  ```

# 9-11 String 클래스의 생성자와 메서드

|          생성자          | 예제                                                         | 결과        |
| :----------------------: | ------------------------------------------------------------ | ----------- |
|     String(String s)     | String s = new String("Hello");                              | s = "Hello" |
|   String(char[] value)   | char[] c = {'h','e','l','l','o'};<br /><br />String s = new String(c); | c = "hello" |
| String(StringBuffer buf) | StringBuffer sb = new StringBuffer("hello");<br />String s = new String(sb); | s = "hello" |

|                            메서드                            |                             예제                             |              결과               |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :-----------------------------: |
|                    char chatAt(int index)                    |       String s = "Hello";<br /> char c = s.charAt(1);        |            c = 'e';             |
|                   int compareTo(String s)                    | int i1 = "aaa".compareTo("bbb");<br />int i2 = "aaa".compareTo("aaa");<br />int i3 = "bbb".compareTo("aaa"); | i1 = -1<br />i2 = 0<br />i3 = 1 |
|                  String concat(String str)                   |        String s1 = "Hello";<br />s1.concat(" World");        |       s1 = "Hello World"        |
| boolean contains(CharSequence s)<br />/ CharSequence interface 를 구현한 모든 클래스들의 인스턴스가 인자로 들어올 수 있다! (다형성!) |   String s = "abcdefg";<br />boolean b= s.contains("bc");    |             b=true              |
|                  booelan endswith(String s)                  | String s = "Hello.txt";<br />boolean b = s.endswith("txt");  |            b = true;            |
|                 boolean equals(Object obj);                  | String s = "Hello";<br />boolean b = s.equals("Hello");<br />boolean b2 = s.equals("hello"); |   b = true;<br />b2 = false;    |
|             boolean equalsIgnoreCase(String str)             | String s = "Hello";<br />boolean b = s.equalsIgnoreCase("heLLo"); |            b = true;            |
| int indexOf(int ch)<br />/매개변수가 int 지만 신경쓰지 말자! | String s = "Hello";<br />boolean b1 = s.indexOf('e');<br />boolean b2 = s.indexOf('c'); |       b1 = 1<br />b2 = -1       |



|                                                              |                             예제                             |                             결과                             |
| :----------------------------------------------------------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
|                 int indexOf(int ch, int pos)                 | String s = "hello";<br />int i1 = s.indexOf(e,0);<br />int i2 = s.indexOf(e,2) |                     i1 = 1<br />i2 = -1                      |
|                   int indexOf(String str)                    |    String s = "ABCDEFG";<br />int idx = s.indexOf("CD");     |                           idx = 2                            |
|                   int lastIndexOf(int ch)                    | String s = "java.lang.Object";<br />int idx1 = s.lastIndexOf('.');<br />int idx2 = s.indexOf('.') |                    idx1 = 9<br />idx2 = 4                    |
|                         int length()                         |      String s = "Hello";<br />int length = s.length();       |                          length = 5                          |
|                 String[] split(String regex)                 | String s = "dog,cat,bear";<br />String[] arr = animals.split(","); |      arr[0]="dog"<br />arr[1]="cat"<br />arr[2]="bear"       |
|           String[] split(String regex, int limit)            | String s = "dog,cat,bear";<br />String[] arr = s.split(",", 2); |             arr[0] = dog<br />arr[1]="cat,bear"              |
| String substring(int begin)<br />String substring(int begin, int end) / begin<= x < end | String s = "java.lang.Object";<br />String c = s.substring(10);<br />String p = s.substring(5, 9); |                  c = "Object"<br />p="lang"                  |
|                     String toLowerCase()                     |    String s = "Hello";<br />String s1 = s.toLowerCase();     |                          s1="hello"                          |
|                     String toUpperCase()                     |     String s ="Hello";<br />String s1 = s.toUpperCase();     |                          s1="HELLO"                          |
|                        String trim();                        |  String s = "   Hello World   ";<br />String s1 = s.trim();  |                      s1 = "Hello World"                      |
| static String valueOf(boolean b)<br />static String valueOf(char c)<br />static String valueOf(int i)<br />static String valueOf(long l)<br />static String valueOf(float f)<br />static String valueOf(double d)<br />static String valueOf(Object o) | String b = String.valueOf(true);<br />String c = String.valueOf('a');<br />String i = String.valueOf(100);<br />String l = String.valueOf(100L);<br />String f = String.valueOf(10F);<br />String d = String.valueOf(10.0);<br />java.util.Date dd = String.valueOf(new java.util.Date()); | b = "true"<br />c = "a"<br />i = "100"<br />l = "100"<br />f = "10"<br />d = "10.0"<br />dd = "Wed Jan 27 21:26 29 KST 2021" |

진짜 개많네

# 9-12 join() 과 StringJoiner

- join( ) 은 여러 문자열 사이에 구분자를 넣어서 결합한다. / join 은 static 메서드이기 때문에 클래스에서 바로 호출함!

  ```java
  String animals = "dog,cat,bear";
  String[] arr = animals.split(",");
  String str = String.join("-", arr);
  String str = String.join("-", "dog", "cat", "bear");
  String str = String.join("-", new String[]{"dog","cat","bear"});
  System.out.println(str);	// dog-cat-bear
  ```

- 숫자를 문자열로 바꾸는 방법

  ```java
  int i = 100;
  String str1 = i + "";							// "100", 이게 더 편하다
  String str2 = String.valueOf(i);	// "100", 이게 더 성능 굿
  ```

- 문자열을 숫자로 바꾸는 방법

  ```java
  int i = Integer.parseInt("100");		// 100, 이건 좀 올드한 방법
  int i2 = Integer.valueOf("100");		// 100, 이건 좀 새로운 방법. 근데 이게 래퍼클래스마다 다 같으니까, 이걸로 외우자! 근데 사실 valueOf 의 반환타입은 Integer, 즉 객체이다. 하지만 반환타입을 int 라고 적어도 된다!
  Integer i2 = Integer.valueOf("100");// 100
  ```

- `숫자 -> 문자열` 이나, `문자열 -> 숫자` 둘 다 valueOf 로 통일된다!