package HomeWork1;

import java.util.ArrayList;
import java.util.Collections;

public class Task_1_2_3 {
    public static void main(String[] args) {
        //Task1
        String[] arr = {"A","B","C"};
        replaceTwoArrItems(arr, 1,0);
        for (String s : arr) {
            System.out.println(s);
        }

        //Task2
        ArrayList<String> p;
        p=toArrayList(arr);
        System.out.println(p.toString());

        //Task3
        Box<Apple> appleBox1=new Box<>();
        Box<Apple> appleBox2=new Box<>();
        Box<Orange> orangeBox3=new Box<>();
        for (int i = 0; i < 15; i++) {
            appleBox1.addFruit(new Apple());
        }
        for (int i = 0; i < 10; i++) {
            orangeBox3.addFruit(new Orange());
        }
        for (int i = 0; i < 5; i++) {
            appleBox2.addFruit(new Apple());
        }
        System.out.println("Коробка с яблоками №1: "+appleBox1.getWeight());
        System.out.println("Коробка с яблоками №2: "+appleBox2.getWeight());
        System.out.println("Коробка с апельсинами №3: "+orangeBox3.getWeight());

        System.out.println(appleBox1.compare(orangeBox3));

        appleBox2.moveToOtherBox(appleBox1);

        System.out.println("Коробка с яблоками №1: "+appleBox1.getWeight());
        System.out.println("Коробка с яблоками №2: "+appleBox2.getWeight());
        System.out.println("Коробка с апельсинами №3: "+orangeBox3.getWeight());

        System.out.println(appleBox1.compare(orangeBox3));

    }

    static <T> void replaceTwoArrItems(T[] arr, int el1, int el2){
        if(el1<arr.length && el2<arr.length && el2>=0 && el1>=0 && el2!=el1) {
            T buf = arr[el1];
            arr[el1] = arr[el2];
            arr[el2] = buf;
        }
    }

    static <T> ArrayList<T> toArrayList(T[] arr){
        ArrayList<T> p = new ArrayList<>();
        Collections.addAll(p, arr);
        return p;
    }

}
