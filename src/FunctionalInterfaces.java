import db.app1.*;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {

        /*
        UnaryOperator<T> - wejście 1xT, wyjście T (apply)
        BinaryOperator<T> - wejście 2xT, wyjście T (apply)
        Consumer<T> - wejście 1xT, wyjście void, (accept)
        Supplier<T> - wejście void, wyjście T (get)
        Function<T,R> - wejscie 1xT, wyjście R (apply)
        Predicate<T> - wejście 1xT, wyjście boolean (test)
        */

        System.out.println("----- UNARY OPERATOR -----");

        UnaryOperator <Car> repair = car -> {
            car.setStatus(Status.READY);
            return car;
        };

        Car car = new Car("Fiat", Status.NEW);
        car.setStatus(Status.TO_REPAIR);
        car = repair.apply(car);
        System.out.println(car);

        System.out.println();
        System.out.println("----- BINARY OPERATOR -----");

        BinaryOperator <Integer> sum = (a,b) -> a*b;
        System.out.println(sum.apply(3, 5));

        System.out.println();
        System.out.println("----- CONSUMER -----");

        Consumer <Message> readMessage = message -> {
            System.out.println(message);
        };

        Message message = new Message("mieciu@gmail.com","Zapraszam na spotkanie", "Spotkanie jutro o 10:00");
        readMessage.accept(message);
        Message message2 = new Message("zaopatrzenie@company.pl","Zapotrzebowanie na sprzęt", "Cześć. Potrzebuję nowego laptopa i myszki.");
        readMessage.accept(message2);

        Consumer <Message> filterSpam = messageToFilter -> {
            if(!messageToFilter.getSender().endsWith("wp.pl") && !messageToFilter.getTitle().contains("Oferta") && !messageToFilter.getDescription().contains("Tylko do jutra")){
                System.out.println(messageToFilter);
            }
        };

        Message message3 = new Message("mieciu@gmail.com","Zapraszam na spotkanie", "Spotkanie jutro o 10:00");
        filterSpam.accept(message3);
        Message message4 = new Message("spam@wp.pl","Oferta na 100-lecie!", "Dajemy Ci rabat 75%");
        filterSpam.accept(message4);
        Message message5 = new Message("magda@onet.com","Rabat na 100-lecie!", "Tylko do jutra 20% taniej!");
        filterSpam.accept(message5);

        System.out.println();
        System.out.println("----- SUPPLIER -----");

        Supplier <Car> produceCar = () -> new Car("BMW X6", Status.NEW);
        List<Car> newCars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            newCars.add(produceCar.get());
        }
        System.out.println(newCars);

        System.out.println();
        System.out.println("----- FUNCTION -----");

        Function <Car, db.app2.Car> mapCarApp1ToCarApp2 = carApp1 -> new db.app2.Car(carApp1.getName());
        List <db.app2.Car> carsApp2 = new ArrayList<>();
        for (Car c : newCars) {
            carsApp2.add(mapCarApp1ToCarApp2.apply(c));
        }
        System.out.println(carsApp2);

        System.out.println();
        System.out.println("----- PREDICATE -----");

        Predicate <String> correctEmail = e -> e.contains("@");

        String email1 = "bogdan@wp.pl";
        System.out.println(correctEmail.test(email1));
        String email2 = "bogdan.wp.pl";
        System.out.println(correctEmail.test(email2));
        String email3 = "bogdanwp.pl";
        System.out.println(correctEmail.test(email3));

        newCars.forEach(a -> a.setStatus(Status.TO_REPAIR));
        newCars.forEach(a -> System.out.println(a));

        newCars.forEach(a -> a.setStatus(Status.NEW));
        newCars.forEach(a -> System.out.println(a));

        newCars.forEach(a -> {
            a.setName(a.getName().replace("X6","Thalia").replace("BMW","Renault"));
            int randomStatusIndex = new Random().nextInt(3);
            a.setStatus(Status.values()[randomStatusIndex]);
        });
        newCars.forEach(a -> System.out.println(a));
        System.out.println(); //\n

        newCars.removeIf(a -> a.getStatus().equals(Status.TO_REPAIR));
        newCars.forEach(a -> System.out.println(a));
        System.out.println(); //\n

        newCars.replaceAll(a -> new Car());
        newCars.forEach(a -> System.out.println(a));
    }
}