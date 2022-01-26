package ch12;

enum Direction {EAST, SOUTH, WEST, NORTH}

public class Ex12_5 {
    public static void main(String[] args) {
        Direction d1 = Direction.EAST;  // 열거형타입.상수이름
        Direction d2 = Direction.valueOf("WEST");   // valueOf 로 가져오기
        Direction d3 = Enum.valueOf(Direction.class, "EAST");

        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d3 = " + d3);


        System.out.println("d1 == d2 = " + (d1 == d2));     // false
        System.out.println("(d1==d3) = " + (d1 == d3));     // true
        System.out.println("d1.equals(d3) = " + d1.equals(d3)); // true
        System.out.println("d1.compareTo(d2) = " + d1.compareTo(d2));   // -2
        System.out.println("d1.compareTo(d3) = " + d1.compareTo(d3));   // 0

        switch(d1){
            case EAST:
                System.out.println("this is EAST");break;
            case WEST:
                System.out.println("this is WEST");
                break;
            case NORTH:
                System.out.println("this is NORTH");
                break;
            case SOUTH:
                System.out.println("this is SOUTH");
                break;
        }

    }
}
