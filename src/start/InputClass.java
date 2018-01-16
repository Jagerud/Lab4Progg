package start;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Jaeger on 2016-07-29.
 */
public class InputClass {
    private HashMap<String, Integer> boxMap = new HashMap<>();
    private HashMap<String, ArrayList<String>> maps = new HashMap<>();
    private ArrayList<String> boxOnTopList = new ArrayList<>();
    private int line,nrOfBoxes;
    private String line2;
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
                    nrOfBoxes = line;
                    //line2 = "";// = in.readLine(); //Avoiding first line
                //} catch (IOException e) {

                //    e.printStackTrace();
                //}
                //System.out.println(line);
                    for (int i = 0; i < line; i++) {
                        line2 = in.readLine();
                        if(line2.isEmpty()){
                            line2 = in.readLine();
                        }
                        //System.out.println(line2);
                        if(line2.length() <3){
                            line = Integer.parseInt(line2);
                        }
                        else {
                            String lineString = line2.substring(0, 1);
                            boxOnTopList.add(lineString);
                            int lineNumber = Integer.parseInt(line2.substring(line2.length() - 1)); //bara (2)?

                            boxMap.put(lineString, lineNumber);
                        }
                    }

                    //try {
                //System.out.println("line: " + line);
                if(line2.length() >2){
                    line2 = in.readLine();
                }
                line = Integer.parseInt(in.readLine());
                        //System.out.println("line: " + line);
                    //} catch (IOException e) {
                    //    e.printStackTrace();
                    //}
                    String lineStringSaved;// = "bull";// =
                    String lineString="";
                    String lineString2;
                    ArrayList<String> tempList = new ArrayList<>();
                    //try {
                        //System.out.println("line: " + line);
                        for (int i = 0; i < line; i++) {
                            //lineStringSaved = lineString;
                            line2 = in.readLine();
                            if(line2.isEmpty()){
                                line2 = in.readLine();
                            }
                            //System.out.println(line2);
                            lineString = line2.substring(line2.length() - 1); //top
                            lineString2 = line2.substring(0, 1);
                            //System.out.println(lineString);
                            //System.out.println(lineString2);
                            if(maps.containsKey(lineString)){
                                maps.get(lineString).add(lineString2);
                            }

                            /*if (lineString.compareTo(lineStringSaved) != 0 && lineStringSaved.compareTo("") != 0) { //hoppar över sista, löst, lägger nedanför for
                                maps.put(lineStringSaved, tempList);
                            }
                            /*if (lineString.compareTo(lineStringSaved) == 0) { //samma bokstav ska då lägga flera i list
                                lineString2 = line2.substring(0, 1);
                                tempList.add(lineString2);
                            }*/ else {
                                tempList = new ArrayList<>();
                                tempList.add(lineString2);
                                maps.put(lineString,tempList);
                                //System.out.println(maps.get(lineString));
                            }
                        }
                    /*} catch (IOException e) {
                        e.printStackTrace();
                    } */
                //maps.put(lineString,tempList);
                //System.out.println(maps.size());

            } catch (IOException e) {
                e.printStackTrace();
            }
            //sort();
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
    /*
    public void sort(){ //TODO wat is dis, weird name and stupid loop
        while(maps.keySet().iterator().hasNext()){
            System.out.println(maps.keySet().iterator().next());
        }
    }
    */
    public ArrayList<String> getBoxOnTopList() {
        return boxOnTopList;
    }
    public HashMap<String, Integer> getBoxMap() {
        return boxMap;
    }
    public HashMap<String, ArrayList<String>> getMaps() {
        return maps;
    }
    public int getNrOfBoxes() {
        return nrOfBoxes;
    }
}