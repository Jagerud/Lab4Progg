package logic;

import data.Box;
import start.InputClass;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {
    private InputClass iClass = new InputClass();
    private ArrayList<data.Box> boxArrayList = new ArrayList<>();
    private logic.Algorithms Algorithms = new Algorithms(boxArrayList);

    /**
     *
     * @return
     */
    public boolean start() {

        if (!iClass.chooseFile()) {
            return false;
        }
        //Get input from file
        //iClass.showBoxInfo();
        createBox();    //Store input in box objets
        //testBox();
        if (!chooser()) {  //Choose program then sort and remove boxes
            return false;
        }
        //Algorithms.testBoxAfterSort();*/
        return true;
    }

    /**
     * This method creates the boxes.
     */
    private void createBox() {
        HashMap<String, Integer> boxNameWeight = iClass.getBoxNameWeightMap();
        HashMap<String, ArrayList<String>> boxOnTopMap = iClass.getBoxOnTopMap();
        ArrayList<String> boxNameList = iClass.getBoxNameList();

        for (int i = 0; i < iClass.getNrOfBoxes(); i++) { //fill array with boxes,
            boxArrayList.add(new data.Box(boxNameList.get(i), boxNameWeight.get(boxNameList.get(i)))); //Allows 1 char names
        }
        for (int i = 0; i < iClass.getNrOfBoxes(); i++) {
            if (boxOnTopMap.containsKey(boxNameList.get(i))) {   //If in list, has box above
                for (int j = 0; j < boxOnTopMap.get(boxNameList.get(i)).size(); j++) {  //loop array in hashmap
                    String boxName = boxOnTopMap.get(boxNameList.get(i)).get(j); //get every string box above i
                    for (data.Box aBoxArrayList : boxArrayList) {
                        if (boxName.equalsIgnoreCase(aBoxArrayList.getName())) {
                            boxArrayList.get(i).addBox(aBoxArrayList);
                        }
                    }
                }
            }
        }
        addLowerBoxes();

    }

    /**
     *
     */
    private void addLowerBoxes() {
        for (int i = boxArrayList.size() - 1; i >= 0; i--) {
            for (data.Box higherBoxes : boxArrayList.get(i).getHigherBox()) {
                higherBoxes.addLowerBox(boxArrayList.get(i));
            }
        }
    }

    /**
     * This method is to test functionality.
     */
    private void testBox() {
        for (data.Box aBoxArrayList : boxArrayList) {
            System.out.println(aBoxArrayList.getName() + " " + aBoxArrayList.getWeight());
            for (int j = 0; j < aBoxArrayList.getHigherBox().size(); j++) {
                System.out.println(aBoxArrayList.getHigherBox().get(j).getName());
            }
            //for (Box allUnder: boxArrayList) {
            System.out.println("Box: " + aBoxArrayList.getName());
            for (Box allUnder : aBoxArrayList.getLowerBox()) {
                System.out.println(allUnder.getName());
            }
            //}
        }
    }

    /**
     * This method checks which problem the user wants to solve.
     * @return a boolean that is if the user wants to continue.
     */
    private boolean chooser() {
        Object stringArray[] = {"First", "Second", "Third"};

        switch (JOptionPane.showOptionDialog(null, "Make your choice, you must.", "Select a program",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray,
                stringArray[0])) {
            case -1:
                return false;
            case 0:
                Algorithms.sort1();
                Algorithms.print();
                break;
            case 1:
                String workers;
                do {
                    workers = JOptionPane.showInputDialog(
                            null, "Insert number of workers:", "Workers", JOptionPane.QUESTION_MESSAGE);
                    if (workers == null) {
                        return false;
                    }
                } while (Integer.parseInt(workers) < Algorithms.heaviestBox(boxArrayList));
                Algorithms.sort2(Integer.parseInt(workers));
                Algorithms.print();
                break;
            case 2:
                sort3();
                Algorithms.print();
                break;
        }
        return true;
    }

    /**
     * This method will calculate the solution to the third problem.
     */
    public void sort3() {

        int heaviestBox = Algorithms.heaviestBox(boxArrayList);
        int heaviestRound = Algorithms.sort2(999);
        int cheapestPrice = 0, leastWorkers = 0;

        for (int i = heaviestBox; i <= heaviestRound; i++) {

            createBox();
            addLowerBoxes();

            Algorithms.sort2(i);
            int currentPrice = (int) (100 * i * Math.ceil((Algorithms.getTime() * 15) / 60.0));

            if (cheapestPrice == 0) {
                cheapestPrice = currentPrice;
            }

            if (currentPrice <= cheapestPrice) {
                cheapestPrice = currentPrice;
                leastWorkers = i;
            }
        }
        System.out.println("The most effective way to move the boxes is with " + leastWorkers + " workers. The cost will be: " + cheapestPrice);
        createBox();
        addLowerBoxes();

        Algorithms.sort2(leastWorkers);
    }
}
