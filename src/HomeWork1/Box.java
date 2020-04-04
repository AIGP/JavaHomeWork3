package HomeWork1;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> arr = new ArrayList<>();
    public void addFruit(T fruit){
        try {
            if (fruit != null)
                this.arr.add(fruit);
        }
        catch (ClassCastException e){
            System.out.println(e.getMessage());
        }
    }
    public String getItemClass(){
        return this.arr.getClass().getName();
    }
    public void moveToOtherBox(Box<T> box){
        if(this.getItemClass().equals(box.getItemClass())){
            for (T i: this.arr) {
                box.addFruit(i);
            }
            this.arr.clear();
        }
    }
    public float getWeight(){
        float weight=0.0f;
        for (T i: this.arr) {
            weight+=i.getWeight();
        }

        return weight;
    }
    public boolean compare(Box<?> box){
        return this.getWeight()==box.getWeight();
    }
}
