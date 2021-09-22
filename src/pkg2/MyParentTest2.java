package pkg2;

//import pkg1.MyParent;

class MyChild extends pkg1.MyParent {
    public void printMembers(){
//        System.out.println(prv);    // 에러, 같은 클래스 내에서만
//        System.out.println(dft);    // 에러, 같은 패키지 내에서만
        System.out.println(prt);    // 다른 패키지지만 자손이라
        System.out.println(pub);    // 얘는 다 됨.
    }
}

public class MyParentTest2 {
    public static void main(String[] args) {
        pkg1.MyParent p = new pkg1.MyParent();
//        System.out.println(p.prv);  // 에러
//        System.out.println(p.dft);  // ok
//        System.out.println(p.prt);  // ok
//        System.out.println(p.pub);  // ok


        MyChild c = new MyChild();
    }
}
