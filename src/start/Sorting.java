package start;

public class Sorting {

    InputClass inputClass = new InputClass();
    public Sorting(){

    }

    public void sort(){
        //move if nothing above
        for (int i = 0; i < inputClass.getBoxOnTopList().size(); i++) { //Need to substring! both bottom and top in same spot atm
            if (inputClass.getBoxOnTopList().get(i).compareTo("a") == 0) { //check if 0 is true
                //move the stuff
            }
            else{

            }
        }
    }
}
