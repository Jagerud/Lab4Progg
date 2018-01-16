package start;

import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    private InputClass iClass = new InputClass();
    private ArrayList<Box> boxArrayList = new ArrayList<>();
    private Sorting sorting = new Sorting(boxArrayList);

    public void start(){
        iClass.storeInput(); //Get input from file
        iClass.showBoxInfo();
        System.out.println(iClass.getNrOfBoxes());
        createBox();    //Store input in box objets
        testBox();
        sorting.sort(); //Sort and remove boxes
    }
    private void createBox () {
        HashMap<String, Integer> boxNameWeight = iClass.getBoxNameWeightMap();
        HashMap <String, ArrayList<String>> boxOnTopMap = iClass.getBoxOnTopMap();
        ArrayList <String> boxNameList = iClass.getBoxNameList();

        for(int i = 0; i< iClass.getNrOfBoxes(); i++) {
            boxArrayList.add(new Box(boxNameList.get(i), boxNameWeight.get(boxNameList.get(i)))); //Allows 1 char names
        }
        for(int i = 0; i< iClass.getNrOfBoxes(); i++) {
            if(boxOnTopMap.containsKey(boxNameList.get(i))) {   //If in list, has box above
                for(int j = 0;j < boxOnTopMap.get(boxNameList.get(i)).size();j++){  //loop array in hashmap
                    String boxName = boxOnTopMap.get(boxNameList.get(i)).get(j); //get every string box above i
                    for(int k = 0;k<boxArrayList.size();k++){
                        if(boxName.equalsIgnoreCase(boxArrayList.get(k).getName())){
                            boxArrayList.get(i).addBox(boxArrayList.get(k));
                        }
                    }
                }
            }
        }
    }
    private void testBox(){
        for(int i = 0;i<boxArrayList.size();i++){
            System.out.println(boxArrayList.get(i).getName() + " " + boxArrayList.get(i).getWeight());
            for(int j = 0;j<boxArrayList.get(i).getHigherBox().size();j++){
                System.out.println(boxArrayList.get(i).getHigherBox().get(j).getName());
            }
        }
    }
}
