package start;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    private InputClass iClass = new InputClass();
    private ArrayList<Box> boxArrayList = new ArrayList<>();
    private Sorting sorting = new Sorting(boxArrayList);
    public void start(){

        iClass.storeInput();
        iClass.showBoxInfo();
        System.out.println(iClass.getNrOfBoxes());

        sorting.sort();
    }
    public void createBox () {
        HashMap boxMap = iClass.getBoxMap();
        HashMap <String, ArrayList<String>> maps = iClass.getMaps();
        ArrayList <String> boxNam = iClass.getBoxOnTopList();


        //for å grejjer som lägger in data från hashmaps ovan i boxes
        //boxArrayList.add osv
    }
}
