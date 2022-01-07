package ch9;

import java.util.Objects;

public class Ex9_4 {
    public static void main(String[] args) {
        Card c1 = new Card();
        Card c2 = new Card();

        System.out.println("c1 = " + c1.hashCode());
        System.out.println("c2 = " + c2.hashCode());
    }
}

class Card{
    String kind;
    int num;

    Card(){
        this("SPADE", 1);
    }

    Card(String kind, int num){
        this.kind = kind;
        this.num = num;
    }

    public String toString(){
        return "kind : " + kind + ", num : " + num;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Card)) return false;
        Card c = (Card) obj;

        return this.kind == c.kind && this.num == c.num;
    }

    // equals() 를 오버라이딩 하면 hashCode()도 오버라이딩 해야 한다. (이건 규칙이다!)
    public int hashCode(){
        return Objects.hash(kind, num); // Objects.hash() 는 가변 인자라서, 인자 갯수에 구애받지 않고 넣을 수 있다.
    }


}
