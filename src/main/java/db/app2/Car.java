package db.app2;

import java.time.*;

public class Car {

    private String name;
    private LocalDate productionDate;

    public Car(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", productionDate=" + productionDate +
                '}';
    }
}
