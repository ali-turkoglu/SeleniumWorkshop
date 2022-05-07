package com.cydeo.utilities;

public class HandleWait {

    public static void staticWait(int second){
        try {
            Thread.sleep(second*1000);
        }catch (Exception e){

        }
    }
}
