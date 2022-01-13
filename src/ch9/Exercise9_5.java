package ch9;

public class Exercise9_5 {
    public static int count(String src, String target) {
        int count = 0; // 찾은 횟수
        int pos = 0; // 찾기 시작할 위치

        for(int i = 0 ; i < src.length(); i++){
            if (src.indexOf(target, pos) != -1) {
//                System.out.println("found target on pos = " + pos);
                pos += src.indexOf(target, pos)-1;
                count++;
            }else{
                break;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(count("12345AB12AB345AB","AB"));
        System.out.println(count("12345","AB"));
//        System.out.println("12345AB12AB345AB".indexOf("AB",7));
//        System.out.println("12345AB12AB345AB".indexOf("AB",11));
    }
}

