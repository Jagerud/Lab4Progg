package start;

import java.util.ArrayList;

/**
 * Created by Jaeger on 2016-08-02.
 */
public class Sorting {
    private ArrayList<Box> boxArrayList;
    private ArrayList<String> order;
    private final String removed = "xxxxx";

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
        int time = 0;

        while (boxArrayList.size() > 0) {
            boolean flagTime =false, breaker = false;
            ArrayList<String> removedBoxes = new ArrayList<>();
            int roundWeight = 0, roundWeightOld = 0, roundWeightTotal = 0;
            for(int j = 0; j<2;j++) {
                for (int i = 0; i < 2; i++) {
                    for (Box aBoxArrayList : boxArrayList) {
                        for (Box aBoxInBoxList: aBoxArrayList.getHigherBox()) { //loop boxes above
                            if(aBoxInBoxList.getHigherBox().isEmpty()){ //boxes with just one level of boxes on them
                                for (String removed: removedBoxes
                                     ) {
                                    if(aBoxInBoxList.getName().compareToIgnoreCase(removed) == 0){  //if higher box is to be removed
                                        aBoxArrayList.possibleTarget(true);
                                    }else{  //If parent has not been removed neither can this one
                                        aBoxArrayList.possibleTarget(false);
                                        breaker = true;
                                        break;  //TODO check that this breaks one for loop
                                    }
                                }
                            if(!breaker){
                                    break;  //stop checking other boxes if not possible target
                            }
                            }else{
                                //TODO more than one level of boxes above, ignore
                            }
                        }
                        //checked one box in lower layer, marked as possible or not

                        if (aBoxArrayList.isPossibleTarget() && manpower >= roundWeight) {    //TODO add more in if to check possible
                            //Flag box, it has nothing on it
                            if (roundWeight + aBoxArrayList.getWeight() <= manpower) {  //TODO can probably merge if with the one above

                                roundWeight = roundWeight + aBoxArrayList.getWeight();
                                removedBoxes.add(aBoxArrayList.getName());
                                if (flagTime) { //TODO unsure when to flag now
                                    aBoxArrayList.flag();

                                    //roundWeight = roundWeight + aBoxArrayList.getWeight();
                                }
                            }
                        }
                    }
                    if(roundWeight == manpower){    //TODO can not get better, stop looping
                        //Fill with correct boxes and flag
                    }
                    if (i == 0) {
                        roundWeightOld = roundWeight;
                    }
                }
                if(j == 0) {
                    roundWeightTotal = roundWeight + roundWeightOld;
                }
            }
            if(roundWeightTotal < roundWeight + roundWeightOld) {
                removeFlagged();
            }else{
                //rollback and remove first try
            }
        }
        print();
    }
    private void removeFlagged(){
        order.add("["); //to easier see which boxes are taken at the same time
        for (int i = 0; i < boxArrayList.size(); i++) {
            if (boxArrayList.get(i).isFlagged()) {
                String nameRemoved = boxArrayList.get(i).getName();
                order.add(nameRemoved);
                boxArrayList.remove(i);
                i=-1;
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
    private void print(){
        System.out.println("The boxes can be removed in this order: " + order);
    }

    public void sort3(){
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