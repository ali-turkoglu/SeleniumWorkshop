package com.cydeo.utilities;

public class HandleWait {


    //This method will accept int (in seconds) and execute Thread.sleep for given duration
    public static void staticWait(int second){

        try {
            Thread.sleep(second*1000);
        }catch (Exception e){

        }
    }
}
