package ch9;

public class Exercise9_12 {
    static int getRand(int from, int to){

        int result = (int) (Math.random() * Math.abs(from - to)) + Math.min(from, to);
        return result ;

    }

    public static void main(String[] args)
    {
        for(int i=0; i< 20; i++)
            System.out.print(getRand(1,-3)+",");
    }
}
