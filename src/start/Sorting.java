package start;

import java.util.ArrayList;

/**
 * Created by Jaeger on 2016-08-02.
 */
public class Sorting {
    private ArrayList<Box> boxArrayList;
    private final String removed = "xxxxx";

    public Sorting(ArrayList<Box> boxArrayList){
        this.boxArrayList = boxArrayList;
    }

    public void sort(){
        while(boxArrayList.size()>0) {
            for (int i = 0; i < boxArrayList.size(); i++) {
                if (boxArrayList.get(i).isFree()) {
                    //Remove box, it has nothing on it
                    String nameRemoved = boxArrayList.get(i).getName();
                    boxArrayList.remove(i);
                    for (int j = 0; j < boxArrayList.size(); j++) {
                        for (int k = 0; k < boxArrayList.get(j).getHigherBox().size(); k++) {
                            if (boxArrayList.get(j).getHigherBox().get(k).getName().equalsIgnoreCase(nameRemoved)) {
                                boxArrayList.get(j).removeBox(k);   //remove deleted box from arralists in boxes
                            }
                        }
                    }
                }

            }
        }
    }
    public void testBoxAfterSort(){
        for(int i = 0;i<boxArrayList.size();i++){
            System.out.println(boxArrayList.get(i).getName() + " " + boxArrayList.get(i).getWeight());
            for(int j = 0;j<boxArrayList.get(i).getHigherBox().size();j++){
                System.out.println(boxArrayList.get(i).getHigherBox().get(j).getName());
            }
        }
        if(boxArrayList.isEmpty()) {
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