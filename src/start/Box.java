package start;
import java.util.ArrayList;

/**
 * Created by Jaeger on 2016-08-10.
 * Edited by Alvestig.
 */
public class Box {

    private char name;
    private int weight;
    private ArrayList<Box> higherBox = new ArrayList<Box>();
    private boolean free = true;


    public Box(char name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public void addBox(Box currentBox) {
        higherBox.add(currentBox);
        free = false;
    }

    public void removeBox(Box currentBox) {
        higherBox.remove(currentBox);
        if (higherBox.isEmpty()) {
            free = true;
        }
    }

    public char getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isFree() {
        return free;
    }

    public ArrayList<Box> getHigherBox() {
        return higherBox;
    }

}
