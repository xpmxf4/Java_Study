package ch9;

public class Exercise9_13 {
    public static void main(String[] args) {
        String src = "aabbccAABBCCaa";
        System.out.println(src);
        System.out.println("aa 를" + stringCount(src, "aa") +"개 찾았습니다.");
    }

    static int stringCount(String src, String key) {
        return stringCount(src, key, 0);
    }

    static int stringCount(String src, String key, int pos) {
        int count = 0;
        int index = 0;
        if (key == null || key.length() == 0)
            return 0;

        for(index = 0 ; index < src.length() ; index++){
            if(src.startsWith(key, index)) count++;

        }

        return count;
    }

}
