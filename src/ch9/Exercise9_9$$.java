package ch9;

public class Exercise9_9$$ {
    static String delChar(String src, String delCh){
        StringBuffer newSrc = new StringBuffer(src);

        for(int i = 0 ; i < delCh.length(); i++){
            System.out.println(newSrc.length());
            if (newSrc.indexOf(delCh.charAt(i)+ "") != -1) {
                newSrc.deleteCharAt(delCh.charAt(i));
                System.out.println("newSrc = " + newSrc);
            }
        }


        return newSrc.toString();
    }

    public static void main(String[] args) {
        System.out.println("(1!2@3^4~5)"+" -> " + delChar("(1!2@3^4~5)","~!@#$%^&*()"));
        //System.out.println("(1 2      3      4\t5)"+" -> " + delChar("(1 2 3 4\t5)"," \t"));


    }
}
