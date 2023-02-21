package com.automation.commons;

import com.github.javafaker.Faker;
import org.junit.Test;

public class JFakerLearning {

    @Test
    public void learnFaker(){

        Faker faker  = new Faker();

        System.out.println(faker.animal().name());
        //System.out.println(faker.beer().name());
        //System.out.println(faker.backToTheFuture().character());
        //System.out.println(faker.avatar().image());
        System.out.println(faker.chuckNorris().fact());

        System.out.println(faker.idNumber().ssnValid());
        System.out.println(faker.internet().emailAddress());


    }
}
