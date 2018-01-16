package start;
import java.util.ArrayList;

/**
 * Created by Jaeger on 2016-08-10.
 * Edited by Alvestig.
 */
public class Box {

    private String name;
    private int weight;
    //private boolean free = true;
    private ArrayList<Box> higherBox = new ArrayList<>();

    //Du hade rätt med konstruktorn!
    public Box(String name, int weight ){
        this.name = name;
        this.weight = weight;
    }

    public void removeBox(Box currentBox) {
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
        //free = false;
        }
    public boolean isFree() {
        return higherBox.isEmpty();
    }

    public ArrayList<Box> getHigherBox() {
        return higherBox;
    }

}