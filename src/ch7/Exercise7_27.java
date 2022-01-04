package ch7;

class Outer44 {
    int value = 10;

    class Inner {
        int value = 20;

        void method1() {
            int value = 30;
            System.out.println(value);
            System.out.println(this.value);
            System.out.println(Outer44.this.value);
        }
    }
}

class Exercise7_27 {
    public static void main(String[] args) {
        Outer44 outer = new Outer44();
        Outer44.Inner inner = outer.new Inner();
        inner.method1();
    }
}
