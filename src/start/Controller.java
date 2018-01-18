package start;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    private InputClass iClass = new InputClass();
    private ArrayList<Box> boxArrayList = new ArrayList<>();
    private Sorting sorting = new Sorting(boxArrayList);

    public void start() {
        iClass.storeInput(); //Get input from file
        iClass.showBoxInfo();
        System.out.println(iClass.getNrOfBoxes());
        createBox();    //Store input in box objets
        testBox();
        //chooser();  //Choose program then sort and remove boxes
        sorting.sort2(5);
        sorting.testBoxAfterSort();
    }

    private void createBox() {
        HashMap<String, Integer> boxNameWeight = iClass.getBoxNameWeightMap();
        HashMap<String, ArrayList<String>> boxOnTopMap = iClass.getBoxOnTopMap();
        ArrayList<String> boxNameList = iClass.getBoxNameList();

        for (int i = 0; i < iClass.getNrOfBoxes(); i++) { //fill array with boxes,
            boxArrayList.add(new Box(boxNameList.get(i), boxNameWeight.get(boxNameList.get(i)))); //Allows 1 char names
        }
        for (int i = 0; i < iClass.getNrOfBoxes(); i++) {
            if (boxOnTopMap.containsKey(boxNameList.get(i))) {   //If in list, has box above
                for (int j = 0; j < boxOnTopMap.get(boxNameList.get(i)).size(); j++) {  //loop array in hashmap
                    String boxName = boxOnTopMap.get(boxNameList.get(i)).get(j); //get every string box above i
                    for (Box aBoxArrayList : boxArrayList) {
                        if (boxName.equalsIgnoreCase(aBoxArrayList.getName())) {
                            boxArrayList.get(i).addBox(aBoxArrayList);
                        }
                    }
                }
            }
        }
    }

    private void testBox() {
        for (Box aBoxArrayList : boxArrayList) {
            System.out.println(aBoxArrayList.getName() + " " + aBoxArrayList.getWeight());
            for (int j = 0; j < aBoxArrayList.getHigherBox().size(); j++) {
                System.out.println(aBoxArrayList.getHigherBox().get(j).getName());
            }
        }
    }

    private void chooser(){
        Object stringArray[] = {"First", "Second", "Third"};
        int chosen = JOptionPane.showOptionDialog(null, "Make your choice, you must.", "Select a program",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray,
                stringArray[0]);

        //int manpower = 5;
        switch (chosen){
            case 0: sorting.sort1();
            break;
            case 1: sorting.sort2(Integer.parseInt(JOptionPane.showInputDialog(
                    null,"Insert number of workers:","Workers", JOptionPane.QUESTION_MESSAGE)));
            break;
            case 2: sorting.sort3();
            break;
        }
    }
}
