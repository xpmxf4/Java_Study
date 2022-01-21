package ch11;

import java.util.*;

public class Ex11_11 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person("David", 10));
        set.add(new Person("David", 10));   // equals(), hashCode() 실행

        System.out.println("set = " + set);
    }
}

class Person{
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return name + " : " + age;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Person)) return false;

        Person tmp = (Person)obj;

        return this.name.equals(tmp.name) && this.age == tmp.age;
    }

    public int hashCode(){
//        return (name+age).hashCode()	// 옛날 방식
        return Objects.hash(name,age);	// 최신 방식 (추천!)
    }
}