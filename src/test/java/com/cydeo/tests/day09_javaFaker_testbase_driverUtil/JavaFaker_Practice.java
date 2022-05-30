package com.cydeo.tests.day09_javaFaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFaker_Practice {

    @Test
    public void test1(){

        // Creating Faker object to reach methods
        Faker faker=new Faker();

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().firstName() = " + faker.name().firstName());

        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());

        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        System.out.println("faker.numerify(\"###-###-##-##\") = " + faker.numerify("###-###-##-##"));

        System.out.println("faker.letterify(\"???-????\") = " + faker.letterify("???-????"));

        System.out.println("faker.bothify(\"##?#-##??+#??#\") = " + faker.bothify("##?#-##??+#??#"));

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard().replace("-",""));

        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());


    }
}
