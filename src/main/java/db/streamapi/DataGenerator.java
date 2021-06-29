package db.streamapi;

import com.github.javafaker.*;

public class DataGenerator {

    public static Cat newCat(){
        com.github.javafaker.Cat cat = new Faker().cat();
        return new Cat(cat.name(), cat.breed(), cat.registry());
    }
}