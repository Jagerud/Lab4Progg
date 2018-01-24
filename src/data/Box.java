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

    /**
     * This method will remove the box on top of the current box.
     * @param currentBox, the box to be removed.
     */
    public void removeBox(int currentBox) {
        higherBox.remove(currentBox);
    }

    /**
     * This method will return the name of the box.
     * @return will return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * This method will return the weight of the box.
     * @return will return the weight.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * This method will add a box on top of the current box.
     * @param currentBox, the box to be added.
     */
    public void addBox(Box currentBox) {
        higherBox.add(currentBox);
    }

    /**
     * This method will add a box below the current box.
     * @param lowerBox, the box to be added.
     */
    public void addLowerBox(Box lowerBox) {
        this.lowerBox.add(lowerBox);
    }

    /**
     * This method will tell weather the box has any other boxes on top of it.
     * @return will return a boolean that it is free.
     */
    public boolean isFree() {
        return higherBox.isEmpty();
    }

    /**
     * This method will flag the box.
     */
    public void flag(){
        flagged = true;
    }

    /**
     * This method checks if the box is flagged.
     * @return will return a boolean that it is flagged.
     */
    public boolean isFlagged(){
        return flagged;
    }

    /**
     * This method changes if the box is a possible target.
     * @param possibleTarget, a boolean that tells if the box is a target.
     */
    public void possibleTarget(boolean possibleTarget){
        this.possibleTarget = possibleTarget;
    }

    /**
     * This method checks if the box is a possible target.
     * @return will return a boolean that it is a target.
     */
    public boolean isPossibleTarget() {
        return possibleTarget;
    }

    /**
     * This method returns the boxes on top of the current box.
     * @return a list of the boxes on top.
     */
    public ArrayList<Box> getHigherBox() {
        return higherBox;
    }

    /**
     * This method returns the boxes below the current box.
     * @return a list of the boxes below.
     */
    public ArrayList<Box> getLowerBox() {
        return lowerBox;
    }
}
