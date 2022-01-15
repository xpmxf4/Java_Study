package ch10;

import java.text.DecimalFormat;

public class NotePad {
    public static void main(String[] args) {
        double number = 1234567.89;
        DecimalFormat df = new DecimalFormat("##.########E0");
        String result = df.format(number);
        System.out.println("result = " + result);
    }
}
