package ch14;

@FunctionalInterface
interface MyFunction {
    public abstract void run();
}

public class Ex14_1 {
    static void execute(MyFunction f){
        f.run();
    }

    static MyFunction getMyFunction(){
        return () -> System.out.println("f3.run()");
    }

    public static void main(String[] args){
        MyFunction f1 = () -> System.out.println("f1.run()");

        MyFunction f2 = new MyFunction(){
            public void run(){
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        execute(f1);
        execute(f2);
        execute(f3);
    }
}
