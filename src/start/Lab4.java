package start;


/**
 * Created by Sand on 2016-04-04.
 */
public class Lab4 {
    public static void main(String args[]) {
        /*Test test = new Test();
        test.test();
        */
        poop();
        InputClass iClass = new InputClass();
        iClass.storeInput();
        iClass.showBoxInfo();
    }
    public static void poop(){
        System.out.println("this is master now?");
    }
}
/*
    -------Anteckningar-------
    Kolla om bokstaven som skall flyttas finns i högra ledet i andra delen av textfilen, om den gör det kontrollera
    om bokstaven till vänster om den har plockats bort eller inte. Föra ett register på de som plockats bort för
    att sedan kontrollera mot detta. Gå igenom alla bokstäver en i taget (baklänges?) och kontrollera om de har något
    över för att sedan flytta de som inte har det.
 */