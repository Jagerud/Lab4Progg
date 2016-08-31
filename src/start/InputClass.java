package start;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class InputClass {

    private HashMap<String, Integer> boxMap = new HashMap<>();
    private HashMap<String, ArrayList<String>> maps = new HashMap<>();
    private ArrayList<String> boxOnTopList = new ArrayList<>();
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

                int line = Integer.parseInt(in.readLine());
                String line2;

                for (int i = 0; i < line; i++) {
                    line2 = in.readLine();
                    String lineString = line2.substring(0, 1);
                    int lineNumber = Integer.parseInt(line2.substring(line2.length() - 1)); //bara (2)?
                    boxMap.put(lineString, lineNumber);
                }
                try {
                    line = Integer.parseInt(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String lineString, lineString2;
                ArrayList<String> tempList;

                for (int i = 0; i < line; i++) {
                    line2 = in.readLine();
                    lineString = line2.substring(line2.length() - 1);
                    lineString2 = line2.substring(0, 1);

                     if (maps.containsKey(lineString)) {
                        maps.get(lineString).add(lineString2);
                    }

                    else {
                        tempList = new ArrayList<>();
                        tempList.add(lineString2);
                        maps.put(lineString,tempList);
                    }
                }

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

        /*ArrayList<String> temp = new ArrayList<>();
        Iterator it = boxMap.keySet().iterator();
        Iterator it2 = maps.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            while (it2.hasNext()) {
                Map.Entry pair2 = (Map.Entry)it2.next();
                if (pair == pair2) {
                    String test = pair2.getKey();
                    temp.add(pair2.getKey());
                }
            }
        }*/
        ArrayList<String> onTop = new ArrayList<>();
        ArrayList<String> one = new ArrayList<>();
        Set<String> first = boxMap.keySet();
        Set<String> second = maps.keySet();
        one = first.toArray(new String[]);
        //Iterator it = one.iterator();
        for (int i = 0; i < one.; i++) {
            if (second.contains(one.)) {
                temp.add(first);
            }
        }
        return onTop;
    }

    public HashMap<String, Integer> getBoxMap() {
        return boxMap;
    }
}
