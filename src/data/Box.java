package data;

import java.util.ArrayList;

/**
 * Created by Jaeger on 2016-08-10.
 * Edited by Alvestig.
 */

public class Box {
    private String name;
    private int weight;
    private boolean flagged, possibleTarget;
    private ArrayList<Box> higherBox = new ArrayList<>();
    private ArrayList<Box> lowerBox = new ArrayList<>();

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

    public void flag(){
        flagged = true;
    }

    public boolean isFlagged(){
        return flagged;
    }

    public void possibleTarget(boolean possibleTarget){
        this.possibleTarget = possibleTarget;
    }

    public boolean isPossibleTarget() {
        return possibleTarget;
    }

    public ArrayList<Box> getHigherBox() {
        return higherBox;
    }

    public ArrayList<Box> getLowerBox() {
        return lowerBox;
    }

    public void addLowerBox(Box lowerBox) {
        this.lowerBox.add(lowerBox);
    }
}
