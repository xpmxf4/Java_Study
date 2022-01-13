package ch9;

public class Ex9_16 {
    public static void main(String[] args) {
        int i = 10;

        // 기본형 -> 참조형
        Integer intg = (Integer) i; // Integer.valueOf(i);
        Object obj = (Object) i;    // (Object)Integer.valueOf(i);

        Long lng = 100L;            // Long.valueOf(100L); new Long(100L);

        int i2 = intg + 10;         // intg.intValue() + 10;
        long l = intg + lng;        // intg.longValue() + lng.longValue();

        Integer intg2 = new Integer(20);
        int i3 = (int) intg2;       // 참조형을 기본형으로 형변환도 가능

    }
}
