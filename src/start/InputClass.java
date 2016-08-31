package start;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class InputClass {

    private HashMap<String, Integer> boxMap = new HashMap<>();
    private HashMap<String, ArrayList<String>> maps = new HashMap<>();
    private ArrayList<String> boxOnTopList = new ArrayList<>();
    private int line;
    private String line2 = "";
    private BufferedReader in;
    public InputClass() {

    }

    public void storeInput() {
        File fileObj;
        JFileChooser fileBrowser = new JFileChooser();
        int result = fileBrowser.showOpenDialog(fileBrowser);

        if (result == JFileChooser.APPROVE_OPTION) {
            fileObj = fileBrowser.getSelectedFile();
            if (!fileObj.exists()) {
                System.out.println("File does not exist");
            }
            try {
                BufferedReader in = new BufferedReader(new FileReader(fileObj));
                //try {
                    line = Integer.parseInt(in.readLine());
                    //line2 = "";// = in.readLine(); //Avoiding first line
                //} catch (IOException e) {

                //    e.printStackTrace();
                //}

                    for (int i = 0; i < line; i++) {
                        line2 = in.readLine();
                        //System.out.println(line2);
                        String lineString = line2.substring(0, 1);
                        int lineNumber = Integer.parseInt(line2.substring(line2.length() - 1)); //bara (2)?
                        boxMap.put(lineString, lineNumber);
                    }
                    try {
                        line = Integer.parseInt(in.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String lineStringSaved;// = "bull";// =
                    String lineString="";
                    String lineString2;
                    ArrayList<String> tempList = new ArrayList<>();
                    //try {
                        //System.out.println("line: " + line);
                        for (int i = 0; i < line; i++) {
                            lineStringSaved = lineString;
                            line2 = in.readLine();
                            lineString = line2.substring(0, 1); //top
                            if (lineString.compareTo(lineStringSaved) != 0 && lineStringSaved.compareTo("") != 0) { //hoppar över sista, löst, lägger nedanför for
                                maps.put(lineStringSaved, tempList);
                            }
                            if (lineString.compareTo(lineStringSaved) == 0) { //samma bokstav ska då lägga flera i list
                                lineString2 = line2.substring(line2.length() - 1);
                                tempList.add(lineString2);
                            } else {
                                lineString2 = line2.substring(line2.length() - 1);
                                tempList = new ArrayList<>();
                                tempList.add(lineString2);
                            }
                        }
                    /*} catch (IOException e) {
                        e.printStackTrace();
                    } */
                maps.put(lineString,tempList);

            } catch (IOException e) {
                e.printStackTrace();
            }
            Object stringArray[] = {"First", "Second", "Third"};
            JOptionPane.showOptionDialog(null, "Make your choice, you must.", "Select a program",
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray,
                    stringArray[0]);
        }
    }

    public void showBoxInfo() { //oklart om det behövs 2 iteratorer, fundera nån gång

        Iterator it = boxMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
        Iterator it2 = maps.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry pair = (Map.Entry)it2.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
        }
    }

    public ArrayList<String> getBoxOnTopList() {
        return boxOnTopList;
    }

    public HashMap<String, Integer> getBoxMap() {
        return boxMap;
    }
}
