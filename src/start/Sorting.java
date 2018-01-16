package start;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Jaeger on 2016-08-02.
 */
public class Sorting {
    private InputClass inputClass;

    public Sorting(InputClass inputClass){
        this.inputClass = inputClass;
    }

    public void sort(){

        HashMap boxMap = inputClass.getBoxMap();
        HashMap maps = inputClass.getMaps();
        ArrayList boxNam = inputClass.getBoxOnTopList();
        System.out.println(inputClass.getNrOfBoxes());
        //move if nothing above
        for(int i=0;i<inputClass.getNrOfBoxes();i++) {
            if(!maps.containsKey(boxNam.get(i)) /*|| (maps.get(boxNam.get(i).))*/){ //check if box does not exist in order
                //move the stuff
                System.out.println("inside if");
            }else{
                System.out.println("outside if");
            }
        }
    }
}
