package start;

import java.util.ArrayList;

/**
 * Created by Jaeger on 2016-08-02.
 */
public class Sorting {
    private ArrayList<Box> boxArrayList;
    private final String removed = "xxxxx";

    public Sorting(ArrayList<Box> boxArrayList) {
        this.boxArrayList = boxArrayList;
    }

    public void sort1() {
        ArrayList<String> order = new ArrayList<>(boxArrayList.size());
        while (boxArrayList.size() > 0) {
            for (int i = 0; i < boxArrayList.size(); i++) {
                if (boxArrayList.get(i).isFree()) {
                    //Remove box, it has nothing on it
                    String nameRemoved = boxArrayList.get(i).getName();
                    order.add(nameRemoved);
                    boxArrayList.remove(i);
                    for (Box aBoxArrayList : boxArrayList) {
                        for (int k = 0; k < aBoxArrayList.getHigherBox().size(); k++) {
                            if (aBoxArrayList.getHigherBox().get(k).getName().equalsIgnoreCase(nameRemoved)) {
                                aBoxArrayList.removeBox(k);   //remove deleted box from arraylists in boxes
                            }
                        }
                    }
                }
            }
        }
        System.out.println("The boxes can be removed in this order: " + order);
    }

    public void sort2(int manpower) {
        int time = 0;
        while (boxArrayList.size() > 0) {
            int roundWeight = 0;    //TODO not sure where to place
            for (int i = 0; i < boxArrayList.size(); i++) {
                if (boxArrayList.get(i).isFree() && manpower >= roundWeight) {
                    //Remove box, it has nothing on it
                    String nameRemoved = boxArrayList.get(i).getName();
                    roundWeight = roundWeight + boxArrayList.get(i).getWeight();
                    if(manpower >= roundWeight) {
                        boxArrayList.remove(i);
                        for (Box aBoxArrayList : boxArrayList) {
                            for (int k = 0; k < aBoxArrayList.getHigherBox().size(); k++) {
                                if (aBoxArrayList.getHigherBox().get(k).getName().equalsIgnoreCase(nameRemoved)) {
                                    aBoxArrayList.removeBox(k);   //remove deleted box from arraylists in boxes
                                }
                                time++;
                            }
                            time++;
                        }
                    }
                    time++;
                    System.out.println("weight: " + roundWeight);
                }
            }
        }
        time++;
        System.out.println("Time:" + time);
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
if(!maps.containsKey(boxNam.get(i)) || (maps.get(boxNam.get(i)).isEmpty()) || !boxNam.get(i).matches(removed)){ //check if box does not exist in order
boxNam.get(i).replaceAll(boxNam.get(i), "*****");   //Changes removed box´s name to ***** to skip

                for(int j = 0; j< boxArrayList.size(); j++) {
                    if(maps.containsValue("")){
                        //If box to be removed is value, remove value
                        if(!maps.containsKey(boxNam.get(j)) || (maps.get(boxNam.get(j)).isEmpty())){ //If now empty
                            //Remove boxes, they have nothing on them
                            boxNam.get(j).replaceAll(boxNam.get(j), removed);   //Changes removed box´s name to ***** to skip
                        }
                    }


                }

 */