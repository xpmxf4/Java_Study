package ch7;

class InheritanceTv {
    boolean power;
    int channel;

    void power() {
        System.out.println("this is from InheritanceTv");
    }

    void channelUp(){
        channel++;
    }

    void channelDown(){
        channel--;
    }
}

class InheritanceDVD{
    void power(){
        System.out.println("this is from InheritacneDVD");
    };

}

class InheritanceTvDVD extends InheritanceTv{
    InheritanceDVD Id = new InheritanceDVD();

    void power(){
        Id.power();
    }
}

public class InheritanceTest {
    public static void main(String[] args) {
        InheritanceTvDVD t1 = new InheritanceTvDVD();
        System.out.println(t1.toString());
        t1.power();
    }
}
