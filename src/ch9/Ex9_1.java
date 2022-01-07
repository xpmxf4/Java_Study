package ch9;

public class Ex9_1 {
    public static void main(String[] args) {
        Value v1 = new Value(10);
        Value v2 = new Value(10);

        if (v1.equals(v2)) {
            System.out.println("v1 과 v2 는 같습니다");
        }else{
            System.out.println("v1 과 v2 는 다릅니다.");
        }

    }
}

class Value{
    int value;

    Value(int value) {
        this.value = value;
    }

    // Object 의 equals() 를 오버라이딩 해버림.
    public boolean equals(Object obj){
        if(!(obj instanceof Value)) return false;
        Value v = (Value) obj;  // 참조변수 형변환 하기 전에는 instanceOf로 확인해야함!
//        return this == obj;   원래 이거임. 주소 비교를 했었음!
        return this.value == v.value;
    }
}
