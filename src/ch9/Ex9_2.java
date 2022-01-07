package ch9;

public class Ex9_2 {
    public static void main(String[] args) {
        Person p1 = new Person(110923890123L);
        Person p2 = new Person(110923890123L);

        System.out.println(p1.equals(p2));

    }
}

class Person {
    long id;

    public boolean equals(Object obj) {
         if(!(obj instanceof Person)) return false;

        Person p = (Person) obj;
        return id == p.id;
    }

    Person(long id){
        this.id = id;
    }
}