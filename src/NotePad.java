import java.util.ArrayList;

public class NotePad {
    public static void main(String[] args) {
        Box<?> b = new Box<Apple>();


    }

    public static ArrayList<? extends Fruit> merge(ArrayList<? extends Fruit> list1, ArrayList<? extends Fruit> list2){
        ArrayList<? extends Fruit> newList = new ArrayList<>(list1);

        return newList;
    }
}


class Fruit {
};

class Apple extends Fruit {
}

class Grape extends Fruit {
}


class Box<T> {
    T item;

    T getItem() {
        return item;
    }

    void setItem(T item) {
        this.item = item;
    }
};