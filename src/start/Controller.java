package start;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    private InputClass iClass = new InputClass();
    private ArrayList<Box> boxArrayList = new ArrayList<>();
    private Sorting sorting = new Sorting(boxArrayList);

    public boolean start() {

        if(!iClass.storeInput()){
            return false;
        }
        //Get input from file
        //iClass.showBoxInfo();
        //System.out.println(iClass.getNrOfBoxes());
        createBox();    //Store input in box objets
        addLowerBoxes();
        //testBox();
        //if (!chooser()) {  //Choose program then sort and remove boxes
        //    return false;
        //}
        sorting.sort2(5);
        //sorting.testBoxAfterSort();*/
        return true;
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
    private void addLowerBoxes(){
        for (int i = boxArrayList.size() -1; i >= 0; i--) {
            for (Box higherBoxes: boxArrayList.get(i).getHigherBox()) {
                higherBoxes.addLowerBox(boxArrayList.get(i));
            }
        }
    }

    private void testBox() {
        for (Box aBoxArrayList : boxArrayList) {
            System.out.println(aBoxArrayList.getName() + " " + aBoxArrayList.getWeight());
            for (int j = 0; j < aBoxArrayList.getHigherBox().size(); j++) {
                System.out.println(aBoxArrayList.getHigherBox().get(j).getName());
            }
            //for (Box allUnder: boxArrayList) {
                System.out.println("Box: " + aBoxArrayList.getName());
                for (Box allUnder: aBoxArrayList.getLowerBox()) {
                    System.out.println(allUnder.getName());
                }
            //}
        }
    }

    private boolean chooser() {
        Object stringArray[] = {"First", "Second", "Third"};

        switch (JOptionPane.showOptionDialog(null, "Make your choice, you must.", "Select a program",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray,
                stringArray[0])) {
            case -1:
                return false;
            case 0:
                sorting.sort1();
                break;
            case 1:
                String workers = JOptionPane.showInputDialog(
                        null, "Insert number of workers:", "Workers", JOptionPane.QUESTION_MESSAGE);
                if (workers == null) {
                    return false;
                }
                sorting.sort2(Integer.parseInt(workers));
                break;
            case 2:
                sorting.sort3();
                break;
        }
        return true;
    }
}
