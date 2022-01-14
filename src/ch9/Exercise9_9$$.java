package ch9;

public class Exercise9_9$$ {
    static String delChar(String src, String delCh){
        StringBuffer newSrc = new StringBuffer(src);

        for(int i = 0 ; i < src.length(); i++){
            System.out.println("newSrc.toString() = " + newSrc.toString());
            System.out.println("src.length() = " + src.length());
            char ch = delCh.toCharArray()[i];
            int pos = newSrc.indexOf(String.valueOf(ch));

            if(pos != -1){
            newSrc.deleteCharAt(pos);
            }

        }


        return newSrc.toString();
    }

    public static void main(String[] args) {
        System.out.println("(1!2@3^4~5)"+" -> " + delChar("(1!2@3^4~5)","~!@#$%^&*()"));
//        System.out.println("(1 2      3      4\t5)"+" -> " + delChar("(1 2 3 4\t5)"," \t"));


    }
}
