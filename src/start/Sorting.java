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

        //int time = 0;

        while (boxArrayList.size() > 0) {
            //boolean flagTime = false, breaker = false;
            ArrayList<Box> possibleBoxesList = new ArrayList<>();
            //ArrayList<String> removedBoxes = new ArrayList<>();
            //ArrayList<Integer> roundWeightList = new ArrayList<>();
            //ArrayList<String> possibleBoxesList = new ArrayList<>();
            int roundWeight = 0;//, roundWeightOld = 0, roundWeightTotal = 0;
            //for(int j = 0; j<2;j++) {
            //  for (int i = 0; i < 2; i++) {
            for (Box aBoxArrayList : boxArrayList) {
                if (aBoxArrayList.getHigherBox().isEmpty()) { //if nothing above
                    aBoxArrayList.possibleTarget(true);
                    possibleBoxesList.add(aBoxArrayList);
                } else { /* //If testing under before removing, not done
                    for (Box aBoxInBoxList : aBoxArrayList.getHigherBox()) { //loop boxes above  //TODO empty on a,b what happens?
                        if (aBoxInBoxList.getHigherBox().isEmpty()) { //boxes with just one level of boxes on them
                            for (String removed : removedBoxes) {
                                if (aBoxInBoxList.getName().compareToIgnoreCase(removed) == 0) {  //if higher box is to be removed
                                    aBoxArrayList.possibleTarget(true);
                                    possibleBoxesList.add(aBoxArrayList);
                                } else {  //If parent has not been removed neither can this one
                                    aBoxArrayList.possibleTarget(false);
                                    breaker = true;
                                    break;  //TODO check that this breaks one for loop
                                }
                            }
                            if (!breaker) {
                                break;  //stop checking other boxes if not possible target
                            }
                        } else {
                            //TODO more than one level of boxes above, ignore
                        }
                    }
                    //checked one box in lower layer, marked as possible or not
                    */
                }

                            /*
                            if (roundWeight + aBoxArrayList.getWeight() <= manpower) {  //TODO can probably merge if with the one above

                                roundWeight = roundWeight + aBoxArrayList.getWeight();
                                removedBoxes.add(aBoxArrayList.getName());
                                if(roundWeight == manpower){    //can not get better, stop looping
                                    //TODO Fill with correct boxes and flag
                                }
                                if (flagTime) { //TODO unsure when to flag now
                                    aBoxArrayList.flag();
                                    //roundWeight = roundWeight + aBoxArrayList.getWeight();
                                }
                            }
                        }*/
            }
            //TODO loop through possibleBoxes and flag as close to manpower as possible (not over)
            //if (aBoxArrayList.isPossibleTarget() && manpower >= roundWeight) {    //TODO add more in if to check possible
            //Flag box, it has nothing on it

            for (int i = 0; i < possibleBoxesList.size(); i++) {
                for (int j = 1; j < (possibleBoxesList.size()-i); j++) {
                    //Box possibleBoxList = boxArrayList.get(i);   //Loop all boxes to get all possible targets
                    //if (boxArrayList.get(i).isPossibleTarget()) {
                    System.out.println("innan");
                    if (possibleBoxesList.get(j - 1).getLowerBox().size() < possibleBoxesList.get(j).getLowerBox().size()) {
                        System.out.println(possibleBoxesList.get(0).getName());
                        System.out.println(possibleBoxesList.get(1).getName());
                        Collections.rotate(possibleBoxesList.subList(j - 1, j+1), -1);
                        System.out.println(possibleBoxesList.get(1).getName());
                    }
                }
            }
            for (Box printIt: possibleBoxesList
                 ) {
                System.out.println(printIt.getName());
            }


                roundWeight = 0;
                for (int i = 0; i < possibleBoxesList.size(); i++) {
                    //Box sortedPossibleBoxes = possibleBoxesList.get(i);
                    if (roundWeight + possibleBoxesList.get(i).getWeight() <= manpower) {
                        roundWeight = roundWeight + possibleBoxesList.get(i).getWeight();
                        //roundWeightOld = roundWeight;
                        //roundWeightList.add(roundWeight);
                        possibleBoxesList.get(i).flag();
                        possibleBoxesList.remove(possibleBoxesList.get(i));
                        i--;
                    /*
                    if (roundWeight == manpower) {
                        sortedPossibleBoxes.flag();
                        break;
                    } else {

                    }
                    */
                    }
                }
                removeFlagged();
            
                //}

            //}
                    /*if (i == 0) {
                        roundWeightOld = roundWeight;
                    }
                }
                if(j == 0) {
                    roundWeightTotal = roundWeight + roundWeightOld;
                }
            }
            if (roundWeightTotal < roundWeight + roundWeightOld) {
                removeFlagged();
            } else {
                //rollback and remove first try
            }*/
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
        order.add("]");
    }

    private void print() {
        System.out.println("The boxes can be removed in this order: " + order);
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