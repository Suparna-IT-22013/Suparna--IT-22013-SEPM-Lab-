class Vehicle {
    protected String type = "Vehicle";

    void display() {
        System.out.println("This is a vehicle.");
    }
}

class Car extends Vehicle {
    void drive() {
        System.out.println(type + " is driving.");
    }
}

public class Inherit {
    public static void main(String[] args) {
        Car c = new Car();
        c.display();
        c.drive();
    }
}

