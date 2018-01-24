package start;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jaeger on 2016-07-29.
 */

public class InputClass {
    private HashMap<String, Integer> boxMap = new HashMap<>();
    private HashMap<String, ArrayList<String>> maps = new HashMap<>();
    private ArrayList<String> boxNameList = new ArrayList<>();
    private int nrOfBoxes;
    private String line2;
    private File fileObj;

    public InputClass() {

    }

    /**
     * This method lets the user upload a file.
     * @return a boolean that is if the user wants to continue.
     */
    public boolean chooseFile() {
        JFileChooser fileBrowser = new JFileChooser();
        int result = fileBrowser.showOpenDialog(fileBrowser);

        if (result == JFileChooser.APPROVE_OPTION) {
            fileObj = fileBrowser.getSelectedFile();
            if (!fileObj.exists()) {
                System.out.println("File does not exist");
            }
            storeFile();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method stores the file in the program.
     */
    public void storeFile() {

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileObj));
            int line = Integer.parseInt(in.readLine());
            nrOfBoxes = line;

            for (int i = 0; i < line; i++) {
                line2 = in.readLine();
                if (line2.isEmpty()) {
                    line2 = in.readLine();
                }
                if (line2.length() < 3) {
                    line = Integer.parseInt(line2);
                } else {
                    String lineString = line2.substring(0, 1);
                    boxNameList.add(lineString);
                    int lineNumber = Integer.parseInt(line2.substring(line2.length() - 1));
                    boxMap.put(lineString, lineNumber);
                }
            }
            if (line2.length() > 2) {
                line2 = in.readLine();
            }
            line = Integer.parseInt(in.readLine());
            String lineString;
            String lineString2;
            ArrayList<String> tempList;

            for (int i = 0; i < line; i++) {
                line2 = in.readLine();
                if (line2.isEmpty()) {
                    line2 = in.readLine();
                }
                lineString = line2.substring(line2.length() - 1); //top
                lineString2 = line2.substring(0, 1);
                if (maps.containsKey(lineString)) {
                    maps.get(lineString).add(lineString2);
                } else {
                    tempList = new ArrayList<>();
                    tempList.add(lineString2);
                    maps.put(lineString, tempList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method prints the info from hashmaps filled in
     * InputClass.storeFile()
     */
    public void showBoxInfo() { //oklart om det behövs 2 iteratorer, fundera nån gång
        for (Object o : boxMap.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
        for (Object o : maps.entrySet()) {
            Map.Entry pair = (Map.Entry) o;
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }

    /**
     * This method returns a list of names of the boxes.
     * @return a list of names.
     */
    public ArrayList<String> getBoxNameList() {
        return boxNameList;
    }

    /**
     * This method returns the weights for all the boxes.
     * @return a list of weights.
     */
    public HashMap<String, Integer> getBoxNameWeightMap() {
        return boxMap;
    }

    /**
     * This method returns which box is on top of which.
     * @return a map of the boxes locations.
     */
    public HashMap<String, ArrayList<String>> getBoxOnTopMap() {
        return maps;
    }

    /**
     * This method returns the amount of boxes in the current file.
     * @return the amount of boxes.
     */
    public int getNrOfBoxes() {
        return nrOfBoxes;
    }
}
