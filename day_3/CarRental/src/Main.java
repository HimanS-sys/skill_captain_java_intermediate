
class Vehicle {
    String brand;
    String model;
    int year;
    float rentalPrice;

    public Vehicle(String brand, String model, int year, float rentalPrice) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }

    public void getInfo() {
        System.out.println("----- Vehicle Information -----");
        System.out.println("Brand: " + this.brand);
        System.out.println("Model: " + this.model);
        System.out.println("Year: " + this.year);
        System.out.println("Rent Price: " + this.rentalPrice);
    }
}

class Car extends Vehicle {
    private int numberOfSeats;
    public Car(String brand, String model, int year, float rentalPrice, int numberOfSeats) {
        super(brand, model, year, rentalPrice);
        this.numberOfSeats = numberOfSeats;
    }

    public int getNoOfSeats() {
        return this.numberOfSeats;
    }

}

class MotorCycle extends Vehicle {
    private int engineCapacity;
    public MotorCycle(String brand, String model, int year, float rentalPrice, int engineCapacity) {
        super(brand, model, year, rentalPrice);
        this.engineCapacity = engineCapacity;
    }

    public int getEngineCapacity() {
        return this.engineCapacity;
    }
}

public class Main {
    public static void main(String[] args) {
        Car carA = new Car("Tata", "Nano", 2010, 500.00f, 4);
        carA.getInfo();
        int totalSeats = carA.getNoOfSeats();
        System.out.println("Total seats: " + totalSeats);
        MotorCycle bikeA = new MotorCycle("Suzuki", "GIXXER", 2020, 300.00f, 155);
        bikeA.getInfo();
        int engineCapacity = bikeA.getEngineCapacity();
        System.out.println("Engine capacity: " + engineCapacity);
    }
}