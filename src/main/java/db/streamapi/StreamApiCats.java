package db.streamapi;

import java.util.*;

public class StreamApiCats {
    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            cats.add(DataGenerator.newCat());
        }

        // filter
        cats.stream()
                .filter(cat -> cat.getBreed().startsWith("U"))
                .sorted((c1, c2) -> c1.getBreed().compareTo(c2.getBreed()))
                .forEach(c -> System.out.println(c));
        System.out.println("-------------------------------------------------");
        cats.stream()
                .filter(cat -> cat.getBreed().startsWith("B"))
                .sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))
                .forEach(c -> {
                    c.setName("Lil' "+c.getName());
                    System.out.println(c);
                });
        System.out.println("-------------------------------------------------");
        cats.stream()
                .filter(cat -> cat.getRegistry().startsWith("E"))
                .filter(cat -> cat.getBreed().endsWith("a"))
                .sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))
                .forEach(c -> {
                    c.setRegistry("Officially Accredited "+c.getRegistry());
                    c.setBreed("FCE "+c.getBreed());
                    System.out.println(c);
                });
    }
}
