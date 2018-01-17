package start;

import java.util.ArrayList;

/**
 * Created by Jaeger on 2016-08-10.
 * Edited by Alvestig.
 */
public class Box {
    private String name;
    private int weight;
    private ArrayList<Box> higherBox = new ArrayList<>();

    public Box(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public void removeBox(int currentBox) {
        higherBox.remove(currentBox);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public void addBox(Box currentBox) {
        higherBox.add(currentBox);
    }

    public boolean isFree() {
        return higherBox.isEmpty();
    }

    public ArrayList<Box> getHigherBox() {
        return higherBox;
    }
}