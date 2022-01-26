package ch12;

enum Direction2{
    EAST(1, "←"),SOUTH(2, "↓"),WEST(3, "←"), NORTH(4, "↑");

    private static final Direction2[] DIR_ARR = Direction2.values();
    private final int value;
    private final String symbol;

    Direction2(int value, String symbol){
        this.value = value;
        this.symbol = symbol;
    }

    public int getValue(){
        return this.value;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public static Direction2 of(int idx){
        if (idx < 1 || 4 < idx) {
            throw new IllegalArgumentException("idx is under 1 or over 4");
        }
        return DIR_ARR[idx];
    }

    public Direction2 rotate(int num){
        num %= 4;

        if(num < 0) num+=4;

        return DIR_ARR[num];
    }
}

public class Ex12_6 {
    public static void main(String[] args) {
        for(Direction2 d : Direction2.values())
            System.out.printf("%s=%d%n", d.name(), d.getValue());

        Direction2 d1 = Direction2.EAST;    // EAST
        Direction2 d2 = Direction2.of(1);   // EAST

        System.out.printf("d1=%s, %d%n", d1.name(), d1.getValue());
        System.out.printf("d2=%s, %d%n", d2.name(), d2.getValue());
        System.out.println(Direction2.EAST.rotate(1));
        System.out.println(Direction2.EAST.rotate(2));
        System.out.println(Direction2.EAST.rotate(-1));
        System.out.println(Direction2.EAST.rotate(-2));
    }
}
