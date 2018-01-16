package start;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jaeger on 2016-08-02.
 */
public class Sorting {
    private InputClass inputClass;
    private final String removed = "xxxxx";

    public Sorting(InputClass inputClass){
        this.inputClass = inputClass;
    }

    public void sort(){

        HashMap boxMap = inputClass.getBoxMap();
        HashMap <String, ArrayList<String>> maps = inputClass.getMaps();
        ArrayList <String> boxNam = inputClass.getBoxOnTopList();
        System.out.println(inputClass.getNrOfBoxes());
        //move if nothing above
        //maps.put("l","");
        maps.get("i").clear();
        for(int i=0;i<inputClass.getNrOfBoxes();i++) {
            if(!maps.containsKey(boxNam.get(i)) || (maps.get(boxNam.get(i)).isEmpty()) || !boxNam.get(i).matches(removed)){ //check if box does not exist in order
                //Remove boxes, they have nothing on them
                System.out.println("inside 1 if");
                boxNam.get(i).replaceAll(boxNam.get(i), "*****");   //Changes removed box´s name to ***** to skip
                for(int j=0;j<inputClass.getNrOfBoxes();j++) { //TODO fix with box
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
        }
    }
}
