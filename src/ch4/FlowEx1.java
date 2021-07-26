package ch4;

public class FlowEx1 {
    public static void main(String[] args){
        int x = 0;
        System.out.printf("x=%d일때, 참인 것은%n", x);

        if(x==0) System.out.println("x==0");        //  발동
        if(x!=0) System.out.println("x!=0");
        if(!(x==0)) System.out.println("!(x==0)");
        if(!(x!=0)) System.out.println("!(x!=0)");  //  발동

        x = 1;
        System.out.printf("x=%d일때, 참인 것은%n", x);

        if(x==0) System.out.println("x==0");
        if(x!=0) System.out.println("x!=0");        //  발동
        if(!(x==0)) System.out.println("!(x==0)");  //  발동
        if(!(x!=0)) System.out.println("!(x!=0)");

    }
}
