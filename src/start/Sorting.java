package start;

import java.util.ArrayList;

/**
 * Created by Jaeger on 2016-08-02.
 */
public class Sorting {
    private ArrayList<Box> boxArrayList;
    private final String removed = "xxxxx";

    public Sorting(ArrayList<Box> boxArrayList){
        this.boxArrayList = this.boxArrayList;
    }

    public void sort(){
/*
        HashMap boxMap = boxArrayList.getBoxMap();
        HashMap <String, ArrayList<String>> maps = boxArrayList.getMaps();
        ArrayList <String> boxNam = boxArrayList.getBoxOnTopList();
        System.out.println(boxArrayList.getNrOfBoxes());*/

        //GET BOXArray



        //move if nothing above
        //maps.put("l","");
        /*
        maps.get("i").clear();
        for(int i = 0; i< boxArrayList.getNrOfBoxes(); i++) {
            if(!maps.containsKey(boxNam.get(i)) || (maps.get(boxNam.get(i)).isEmpty()) || !boxNam.get(i).matches(removed)){ //check if box does not exist in order
                //Remove boxes, they have nothing on them
                System.out.println("inside 1 if");
                boxNam.get(i).replaceAll(boxNam.get(i), "*****");   //Changes removed box´s name to ***** to skip
                for(int j = 0; j< boxArrayList.getNrOfBoxes(); j++) { //TODO fix with box
                    if(maps.containsValue("")){
                        //If box to be removed is value, remove value
                        if(!maps.containsKey(boxNam.get(j)) || (maps.get(boxNam.get(j)).isEmpty())){ //If now empty
                            //Remove boxes, they have nothing on them
                            boxNam.get(j).replaceAll(boxNam.get(j), removed);   //Changes removed box´s name to ***** to skip
                        }
                    }


                }

            }else{
                //Still under a box
                System.out.println("outside if");
            }
        }*/
    }
}
