package ch12;

import java.util.*;

class Product2 {
}

class Tv2 extends Product2 {
}

class Audio2 extends Product2 {
}

public class Ex12_1 {
    public static void main(String[] args) {
        ArrayList<Product2> productList = new ArrayList<Product2>();
        ArrayList<Tv2>       tvList = new ArrayList<Tv2>();
//        ArrayList<Product2> tvList = new ArrayList<Tv2>();
//        List<Tv2> tvList = new ArrayList<Tv2>();

        productList.add(new Product2());
        productList.add(new Tv2());
        productList.add(new Audio2());

        tvList.add(new Tv2());
//        tvList.add(new Product2());

        printAll(productList);
//        printAll(tvList); 불일치 하므로 안됨!
    }

    public static void printAll(ArrayList<Product2> list){
        for(Product2 p : list){
            System.out.println(p);
        }
    }
}

