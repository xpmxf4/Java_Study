package ch7;

public class FinalTest {
    public static void main(String[] args) {

    }
}

final class FinalClass{
    final int MAX_SIZE = 10;

    final int getMaxSize(){
        final int LV = MAX_SIZE;
        return LV;
    }
}