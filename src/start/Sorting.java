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
        boolean flagTime =false;
        while (boxArrayList.size() > 0) {
            int roundWeight = 0, roundWeightOld = 0, roundWeightTotal = 0;
            for(int j = 0; j<2;j++) {
                for (int i = 0; i < 2; i++) {
                    for (Box aBoxArrayList : boxArrayList) {
                        if (aBoxArrayList.isFree() && manpower >= roundWeight) {
                            //Flag box, it has nothing on it
                            if (roundWeight + aBoxArrayList.getWeight() <= manpower) {

                                roundWeight = roundWeight + aBoxArrayList.getWeight();
                                if (flagTime) {
                                    aBoxArrayList.flag();
                                    //roundWeight = roundWeight + aBoxArrayList.getWeight();
                                }
                            }
                        }
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