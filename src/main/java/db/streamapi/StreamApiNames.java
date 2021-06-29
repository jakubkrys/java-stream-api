package db.streamapi;

import java.util.*;

public class StreamApiNames {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Darek");
        names.add("Czarek");
        names.add("Kasia");
        names.add("Marcel");
        names.add("Jarek");
        names.add("Karol");

        names.stream().filter(name -> name.startsWith("K")).forEach(name -> System.out.println(name));
        System.out.println("-----------------------------------------------");
        names.stream().filter(name -> name.endsWith("arek")).forEach(name -> System.out.println(name));
        System.out.println("-----------------------------------------------");
        names.stream().filter(name -> name.startsWith("K")).filter(name -> name.endsWith("l")).forEach(name -> System.out.println(name));
        System.out.println("-----------------------------------------------");
        names.stream().filter(name -> name.contains("ar")).forEach(name -> System.out.println(name));
        System.out.println("-----------------------------------------------");
    }
}
