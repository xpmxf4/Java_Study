package ch7.pkg2;

//import ch7.pkg1.MyParent;

public class MyParentTest2 {
    public static void main(String[] args) {
        MyChild c = new MyChild();
//        System.out.println(c.prv);
//        System.out.println(c.dft);
//        System.out.println(c.prt);
        System.out.println(c.pub);
    }
}

class MyChild extends ch7.pkg1.MyParent{
    public void printMembers(){
//        System.out.println(prv);
//        System.out.println(dft);
        System.out.println(prt);
        System.out.println(pub);
    }
}