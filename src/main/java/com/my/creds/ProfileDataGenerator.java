package com.my.creds;

import com.github.javafaker.Faker;

public class ProfileDataGenerator {

    public static Profile getRandom(){
        Faker faker = new Faker();
        return new Profile(faker.name().firstName(),faker.internet().emailAddress(),faker.internet().password());
    }
}
