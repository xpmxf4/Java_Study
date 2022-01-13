package ch9;

class Exercise9_6$$ {
    public static String fillZero(String src, int length) {


//        if(src == null || src.length() == length) return src;   // 1
//        if(length <= 0) return "";                              // 2
//        if(src.length() >= length){                             // 3
//
//        }
//        char[] arr = new char[length];
//        for(int i = 0 ; i < length; i++){
//            arr[i] = 0;
//        }

        return "";
    }

    public static void main(String[] args) {
        String src = "12345";
        System.out.println(fillZero(src,10));
        System.out.println(fillZero(src,-1));
        System.out.println(fillZero(src,3));
    }
}

