package com.cydeo.tests.day09_javaFaker_testbase_driverUtil;

import org.testng.annotations.Test;

public class SingletonPractice {

    @Test(priority = 2)
    public void singleton_understand_test1() {

        String str1 = Singleton.getWord();
        System.out.println("1: "+str1);

        String str2 = Singleton.getWord();
        System.out.println("2: "+str2);

        Singleton.setWord();

        String str3 = Singleton.getWord();
        System.out.println("3: "+str3);




        }

        @Test(priority = 1)
        public void singleton_understand_test2 () {

            String str4 = Singleton.getWord();
            System.out.println("4: "+str4);

        }

        }
