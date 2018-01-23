package start;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by Jaeger on 2016-08-02.
 */
public class Sorting {
    private final String removed = "xxxxx";
    private ArrayList<Box> boxArrayList;
    private ArrayList<String> order;
    private int time = 0;

    public Sorting(ArrayList<Box> boxArrayList) {
        this.boxArrayList = boxArrayList;
    }

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
        print();
    }

    public void sort2(int manpower) {
        order = new ArrayList<>(boxArrayList.size());
        while (boxArrayList.size() > 0) {
            ArrayList<Box> possibleBoxesList = new ArrayList<>();
            int roundWeight = 0;
            for (Box aBoxArrayList : boxArrayList) {
                if (aBoxArrayList.getHigherBox().isEmpty()) { //if nothing above
                    aBoxArrayList.possibleTarget(true);
                    possibleBoxesList.add(aBoxArrayList);
                } else {  //If testing under before removing, not done

                }
            }

            for (int i = 0; i < possibleBoxesList.size(); i++) {
                for (int j = 1; j < (possibleBoxesList.size() - i); j++) {
                    if (possibleBoxesList.get(j - 1).getLowerBox().size() < possibleBoxesList.get(j).getLowerBox().size()) {
                        Collections.rotate(possibleBoxesList.subList(j - 1, j + 1), -1);
                    }
                }
            }

            roundWeight = 0;
            for (int i = 0; i < possibleBoxesList.size(); i++) {
                if (roundWeight + possibleBoxesList.get(i).getWeight() <= manpower) {
                    roundWeight = roundWeight + possibleBoxesList.get(i).getWeight();
                    possibleBoxesList.get(i).flag();
                    possibleBoxesList.remove(possibleBoxesList.get(i));
                    i--;
                }
            }
            removeFlagged();
        }
        print();
    }

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

    private void print() {
        System.out.println("The boxes can be removed in this order: " + order);
        if (time != 0) {
            System.out.println("Total time: " + time);
        }
    }

    public void sort3() {
        System.out.println("To be continued...");
    }

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
}
/*
//Saving for eventual mistakes
if (aBoxArrayList.isFree() && manpower >= roundWeight) {    //TODO add more in if to check possible
                            //Flag box, it has nothing on it
                            if (roundWeight + aBoxArrayList.getWeight() <= manpower) {

                                roundWeight = roundWeight + aBoxArrayList.getWeight();
                                removedBoxes.add(aBoxArrayList.getName());
                                if (flagTime) { //TODO unsure when to flag now
                                    aBoxArrayList.flag();

                                    //roundWeight = roundWeight + aBoxArrayList.getWeight();
                                }
                            }
                        }
 */