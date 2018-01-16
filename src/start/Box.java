package start;
import java.util.ArrayList;

/**
 * Created by Jaeger on 2016-08-10.
 * Edited by Alvestig.
 */
public class Box {

    private char name;
    private int weight;
    private ArrayList<Box> higherBox;


    public Box(char name, int weight, ArrayList<Box> higherBox){
        this.name = name;
        this.weight = weight;
        this.higherBox = higherBox;
    }

    public void removeBox(Box currentBox) {
        higherBox.remove(currentBox);
    }

    public char getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isFree() {
        return higherBox.isEmpty();
    }

    public ArrayList<Box> getHigherBox() {
        return higherBox;
    }

}
