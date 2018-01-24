package logic;

import data.Box;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jaeger on 2016-08-02.
 * Edited by Alvestig
 */

public class Algorithms {
    private ArrayList<Box> boxArrayList;
    private ArrayList<String> order;
    private int time = 0;

    public Algorithms(ArrayList<Box> boxArrayList) {
        this.boxArrayList = boxArrayList;
    }

    /**
     * This method will calculate the solution to the first problem.
     */
    public void sort1() {
        order = new ArrayList<>(boxArrayList.size());
        while (boxArrayList.size() > 0) {
            for (Box aBoxArrayList : boxArrayList) {
                //order.add(Integer.toString(i));
                if (aBoxArrayList.isFree()) {
                    //Flag box, it has nothing on it
                    aBoxArrayList.flag();
                }
            }
            removeFlagged();
        }
    }

    /**
     * This method will calculate the solution to the second problem.
     * @param manpower, how many workers there are.
     * @return will return the heaviest round while removing boxes.
     */
    public int sort2(int manpower) {
        time = 0;
        order = new ArrayList<>(boxArrayList.size());
        int maxRoundWeight = 0;
        while (boxArrayList.size() > 0) {
            ArrayList<Box> possibleBoxesList = new ArrayList<>();
            for (Box aBoxArrayList : boxArrayList) {
                if (aBoxArrayList.getHigherBox().isEmpty()) { //if nothing above
                    aBoxArrayList.possibleTarget(true);
                    possibleBoxesList.add(aBoxArrayList);
                } else {  //If testing under before removing, not done

                }
            }
            int roundWeight = flagBoxes(sortByLowerBoxes(possibleBoxesList), manpower);
            if(roundWeight > maxRoundWeight){
                maxRoundWeight = roundWeight;
            }
            removeFlagged();
        }
        return maxRoundWeight;
    }

    /**
     * This method flags boxes that are to be removed. It also checks
     * how many boxes that can be removed depending on the parameter manpower.
     * @param possibleBoxesList
     * @param manpower
     * @return
     */
    private int flagBoxes(ArrayList<Box> possibleBoxesList, int manpower){
        int roundWeight = 0;
        for (int i = 0; i < possibleBoxesList.size(); i++) {
            if (roundWeight + possibleBoxesList.get(i).getWeight() <= manpower) {
                roundWeight = roundWeight + possibleBoxesList.get(i).getWeight();
                possibleBoxesList.get(i).flag();
                possibleBoxesList.remove(possibleBoxesList.get(i));
                i--;
            }
        }
        return roundWeight;
    }

    /**
     * This method sorts the array by number of boxes under the chosen box.
     * @param possibleBoxesList
     * @return, returns the array sorted.
     */
    private ArrayList<Box> sortByLowerBoxes(ArrayList<Box> possibleBoxesList){
        for (int i = 0; i < possibleBoxesList.size(); i++) {
            for (int j = 1; j < (possibleBoxesList.size() - i); j++) {
                if (possibleBoxesList.get(j - 1).getLowerBox().size() < possibleBoxesList.get(j).getLowerBox().size()) {
                    Collections.rotate(possibleBoxesList.subList(j - 1, j + 1), -1);
                }
            }
        }
        return possibleBoxesList;
    }

    /**
     *  This method removes boxes that are flagged. It also removes
     *  them as "higher" boxes in boxes under them.
     */
    private void removeFlagged() {
        order.add("["); //to easier see which boxes are taken at the same time
        for (int i = 0; i < boxArrayList.size(); i++) {
            if (boxArrayList.get(i).isFlagged()) {
                String nameRemoved = boxArrayList.get(i).getName();
                order.add(nameRemoved);
                boxArrayList.remove(i);
                i = -1;
                for (Box aBoxArrayList : boxArrayList) {
                    for (int k = 0; k < aBoxArrayList.getHigherBox().size(); k++) {
                        if (aBoxArrayList.getHigherBox().get(k).getName().equalsIgnoreCase(nameRemoved)) {
                            aBoxArrayList.removeBox(k);   //remove deleted box from arraylists in boxes
                        }
                    }
                }
            }
        }
        time++;
        order.add("]");
    }

    /**
     * This method prints out the order in which to remove the boxes and the total time.
     */
    public void print() {
        System.out.println("The boxes can be removed in this order: " + order);
        if (time != 0) {
            System.out.println("Total time: " + time * 15);
        }
    }


    /**
     * A test method to print out the remaining boxes.
     */
    public void testBoxAfterSort() {
        for (Box aBoxArrayList : boxArrayList) {
            System.out.println(aBoxArrayList.getName() + " " + aBoxArrayList.getWeight());
            for (int j = 0; j < aBoxArrayList.getHigherBox().size(); j++) {
                System.out.println(aBoxArrayList.getHigherBox().get(j).getName());
            }
        }
        if (boxArrayList.isEmpty()) {
            System.out.println("Empty");
        }
    }

    /**
     * This method returns the heaviest box in the file.
     * @param boxes, the boxes to be sorted.
     * @return the heaviest box.
     */
    public int heaviestBox(ArrayList<Box> boxes) {
        int heaviest = 0;
        for (Box box : boxes) {
            int temp = box.getWeight();
            if (temp > heaviest) {
                heaviest = temp;
            }
        }
        return heaviest;
    }

    public int getTime() {
        return time;
    }
}
