package ch6;

// 10
public class Notepad {
    public static void change(String str){
        str = "456";
    }
    public static void main(String[] args) {
        String str = "ABC123";
        System.out.println(str);
        change(str);
        System.out.println(str);
    }
}
