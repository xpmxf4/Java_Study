import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NotePad {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 5);
        IntStream intStream1 = IntStream.range(5, 10);

        intStream.forEach(System.out::print);
        System.out.println();
        intStream1.forEach(System.out::print);
    }
}

