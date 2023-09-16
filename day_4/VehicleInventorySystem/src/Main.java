import java.util.*;

abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double price;

    public Vehicle(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public abstract void displayDetails();
}

class Car extends Vehicle {
    private int numDoors;
    private String fuelType;

    public Car(String make, String model, int year, double price, int numDoors, String fuelType) {
        super(make, model, year, price);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }

    @Override
    public void displayDetails() {
        System.out.println("------ Car Information ------");
        System.out.println("make: " + this.make);
        System.out.println("model: " + this.model);
        System.out.println("year: " + this.year);
        System.out.println("total doors: " + this.numDoors);
        System.out.println("fuel type " + this.fuelType);
        System.out.println("Price: " + this.price);
        System.out.println("------------------------------");
    }

    public double calculateMileage() {
        return 0.00d;
    }

    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }


}

class Motorcycle extends Vehicle {
    private boolean hasSideCar;
    private int engineCapacity; // cc(cm^3)
    private double weight; // pounds

    public Motorcycle(String make, String model, int year, double price, boolean hasSideCar, int engineCapacity, double weight) {
        super(make, model, year, price);
        this.hasSideCar = hasSideCar;
        this.engineCapacity = engineCapacity;
        this.weight = weight;
    }

    @Override
    public void displayDetails(){
        System.out.println("------ Motorcycle Information ------");
        System.out.println("make: " + this.make);
        System.out.println("model: " + this.model);
        System.out.println("year: " + this.year);
        System.out.println("side car available: " + this.hasSideCar);
        System.out.println("engine capacity(cc): " + this.engineCapacity);
        System.out.println("Weight(pounds): " + this.weight);
        System.out.println("Price: " + this.price);
    }

    public double calculateSpeed() {
        double engineCapacityHP = this.engineCapacity/15;//convert cc to HP
        return (2*engineCapacityHP)/(this.weight);
    }

    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setHasSideCar(boolean hasSideCar) {
        this.hasSideCar = hasSideCar;
    }
    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

}

public class Main {
    public static void main(String[] args) {
        List<String> carMakeList = new ArrayList<>();
        List<String> carModelList = new ArrayList<>();
        List<Integer> carYearList = new ArrayList<>();
        List<Double> carPriceList = new ArrayList<>();
        List<Integer> carNumDoorsList = new ArrayList<>();
        List<String> carFuelTypeList = new ArrayList<>();

        List<Car> carInventory = new ArrayList<>();
        Map<String, List<String>> carStringMap = new HashMap<>();
        Map<String, List<Integer>> carIntMap = new HashMap<>();
        Map<String, List<Double>> carDoubleMap = new HashMap<>();

        List<String> bikeMakeList = new ArrayList<>();
        List<String> bikeModelList = new ArrayList<>();
        List<Integer> bikeYearList = new ArrayList<>();
        List<Double> bikePriceList = new ArrayList<>();
        List<Boolean> bikeHasSideCarList = new ArrayList<>();
        List<Integer> bikeEngineCapacityList = new ArrayList<>();
        List<Double> bikeWeightList = new ArrayList<>();

        List<Motorcycle> bikeInventory = new ArrayList<>();
        Map<String, List<String>> bikeStringMap = new HashMap<>();
        Map<String, List<Integer>> bikeIntMap = new HashMap<>();
        Map<String, List<Double>> bikeDoubleMap = new HashMap<>();
        Map<String, List<Boolean>> bikeBooleanMap = new HashMap<>();
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("------ Vehicle Inventory System ------");
            System.out.println("======================================");
            System.out.println("Select an option to perform");
            System.out.println("1 - Add Vehicle to Inventory");
            System.out.println("2- Display all the vehicles in the inventory");
            System.out.println("3- Search a vehicle");
            System.out.println("4- Update details of a given vehicle");
            System.out.println("5- Remove a vehicle from inventory");
            System.out.println("0- Exit");

            int option1 = sc.nextInt();

            switch(option1) {
                case 0:
                    System.out.println("Shutting down Vehicle Inventory System.");
                    sc.close();
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Enter type of vehicle\n1- car\n2- Motorcycle");
                    int vehicleType = sc.nextInt();
                    if(vehicleType == 1) {
                        System.out.println("Enter Car details");
                        System.out.println("make: ");
                        String makeCar = sc.nextLine();
                        System.out.println("model: ");
                        String modelCar = sc.nextLine();
                        System.out.println("year: ");
                        Integer yearCar = sc.nextInt();
                        System.out.println("total doors: ");
                        Integer numDoorsCar = sc.nextInt();
                        System.out.println("fuel type: ");
                        String fuelTypeCar = sc.nextLine();
                        System.out.println("Price: ");
                        Double priceCar = sc.nextDouble();

                        if(numDoorsCar <= 0 || priceCar <= 0 || (yearCar < 2000 || yearCar > 2023)) {
                            System.out.println("Variable entered is invalid");
                            break;
                        }

                        Car carObj = new Car(makeCar, modelCar, yearCar, priceCar, numDoorsCar, fuelTypeCar);
                        carInventory.add(carObj);

                        if(carStringMap.isEmpty()) {
                            carStringMap.put("make", carMakeList);
                            carStringMap.put("model", carModelList);
                            carStringMap.put("fuelType", carFuelTypeList);
                        }

                        carMakeList.add(makeCar);
                        carModelList.add(modelCar);
                        carFuelTypeList.add(fuelTypeCar);

                        if(carIntMap.isEmpty()) {
                            carIntMap.put("year", carYearList);
                            carIntMap.put("totalDoors", carNumDoorsList);
                        }
                        carYearList.add(yearCar);
                        carNumDoorsList.add(numDoorsCar);

                        if(carDoubleMap.isEmpty()) {
                            carDoubleMap.put("price", carPriceList);
                        }
                        carPriceList.add(priceCar);
                        System.out.println("added car to inventory.");


                    } else if(vehicleType == 2) {
                        System.out.println("Enter bike details");
                        System.out.println("make: ");
                        String makeBike = sc.nextLine();
                        System.out.println("model: ");
                        String modelBike = sc.nextLine();
                        System.out.println("year: ");
                        Integer yearBike = sc.nextInt();
                        System.out.println("price(INR): ");
                        Double priceBike = sc.nextDouble();
                        System.out.println("side car available(true/false): ");
                        Boolean hasSideCarBIke = sc.nextBoolean();
                        System.out.println("engine capacity(cc): ");
                        Integer engineCapacityBike = sc.nextInt();
                        System.out.println("weight(pounds): ");
                        Double weightBike = sc.nextDouble();

                        if(weightBike <= 0 || priceBike <= 0 || (yearBike < 2000 || yearBike > 2023) || engineCapacityBike <= 0) {
                            System.out.println("Variable entered is invalid");
                            break;
                        }

                        Motorcycle bikeObj = new Motorcycle(makeBike, modelBike, yearBike, priceBike, hasSideCarBIke, engineCapacityBike,weightBike);
                        bikeInventory.add(bikeObj);

                        if(bikeStringMap.isEmpty()) {
                            bikeStringMap.put("make", bikeMakeList);
                            bikeStringMap.put("model", bikeModelList);
                        }

                        bikeMakeList.add(makeBike);
                        bikeModelList.add(modelBike);

                        if(bikeIntMap.isEmpty()) {
                            bikeIntMap.put("year", bikeYearList);
                            bikeIntMap.put("engineCapacity", bikeEngineCapacityList);
                        }
                        bikeYearList.add(yearBike);
                        bikeEngineCapacityList.add(engineCapacityBike);

                        if(bikeBooleanMap.isEmpty()) {
                            bikeBooleanMap.put("HasSideCar", bikeHasSideCarList);
                        }
                        bikeHasSideCarList.add(hasSideCarBIke);

                        if(bikeDoubleMap.isEmpty()) {
                            bikeDoubleMap.put("price", bikePriceList);
                            bikeDoubleMap.put("price", bikeWeightList);
                        }
                        bikePriceList.add(priceBike);
                        bikeWeightList.add(weightBike);

                    } else {
                        System.out.println("Vehicle type entered is invalid");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Displaying all Cars in the Inventory.\n\n");
                    if(!carInventory.isEmpty()) {
                        for (Car car : carInventory) {
                            car.displayDetails();
                        }
                    }

                    if(!bikeInventory.isEmpty()) {
                        System.out.println("Displaying all Cars in the Inventory.\n\n");
                        for (Motorcycle bike : bikeInventory) {
                            bike.displayDetails();
                        }
                    }
                    break;
                case 3:
                    Set<Integer> makeSet = new HashSet<>();
                    Set<Integer> yearSet = new HashSet<>();
                    Set<Integer> priceSet = new HashSet<>();

                    System.out.println("Enter type of vehicle\n1- car\n2- Motorcycle");
                    int vehicleType2 = sc.nextInt();
                    if(vehicleType2 == 1) {
                        System.out.println("Enter Car details");
                        System.out.println("make(-1 to skip): ");
                        String makeCar = sc.nextLine();
                        if(makeCar.isEmpty() || makeCar.trim().isEmpty()){
                            throw new IllegalArgumentException("make: Kindly enter a non empty string.");
                        }
                        System.out.println("year start(-1 to skip): ");
                        Integer startYearCar = sc.nextInt();
                        if((startYearCar < 2000 || startYearCar > 2023) && startYearCar != -1) {
                            throw new IllegalArgumentException("year start: Enter a valid year between 2000 and 2023.");
                        }
                        System.out.println("year end(-1 to skip): ");
                        Integer endYearCar = sc.nextInt();
                        if((endYearCar < startYearCar || endYearCar > 2023) && endYearCar != -1) {
                            throw new IllegalArgumentException("year end: Enter a valid year between 'start year' and 2023.");
                        }
                        System.out.println("start price in INR(-1 to skip): ");
                        Double startPriceCar = sc.nextDouble();
                        if(startPriceCar <= 0 && startPriceCar != -1) {
                            throw new IllegalArgumentException("price start: Enter a valid price greater than 0.");
                        }
                        System.out.println("end price in INR(-1 to skip): ");
                        Double endPriceCar = sc.nextDouble();
                        if(endPriceCar < startPriceCar && endPriceCar != -1) {
                            throw new IllegalArgumentException("price end: Enter a price greater than start price.");
                        }

                        boolean emptyCheck = !makeCar.equals("-1") || startYearCar != -1 || endYearCar != -1 || startPriceCar != -1 || endPriceCar != -1;
                        if(emptyCheck) {

                            List<String> makeSearchCar = carStringMap.get("make");
                            List<Integer> makeYearCar = carIntMap.get("year");
                            List<Double> makePriceCar = carDoubleMap.get("price");



                            for(int i = 0; i<makeSearchCar.size(); i++) {
                                boolean makeCarFilter = makeCar.equals(makeSearchCar.get(i));
                                boolean startYearFilter = (startYearCar != -1 && startYearCar <= makeYearCar.get(i));
                                boolean endYearFilter = (endYearCar != -1 && endYearCar >= makeYearCar.get(i));
                                boolean startPriceFilter = (startPriceCar != -1 && startPriceCar <= makePriceCar.get(i));
                                boolean endPriceFilter = (endPriceCar != -1 && endPriceCar >= makePriceCar.get(i));

                                if(makeCarFilter) {
                                    makeSet.add(i);
                                }
                                if(startYearFilter || endYearFilter) {
                                    yearSet.add(i);
                                }
                                if(startPriceFilter || endPriceFilter) {
                                    priceSet.add(i);
                                }
                            }

                            makeSet.retainAll(yearSet);
                            makeSet.retainAll(priceSet);

                            if(!makeSet.isEmpty()) {
                                for(int i : makeSet) {
                                    Car carObj = carInventory.get(i);
                                    carObj.displayDetails();
                                }
                            } else {
                                System.out.println("No results found.");
                            }
                        } else {
                            System.out.println("No results found.");
                        }
                    } else if(vehicleType2 == 2) {
                        System.out.println("Enter Bike details");
                        System.out.println("make(-1 to skip): ");
                        String makeBike = sc.nextLine();
                        if(makeBike.isEmpty() || makeBike.trim().isEmpty()){
                            throw new IllegalArgumentException("make: Kindly enter a non empty string.");
                        }
                        System.out.println("year start(-1 to skip): ");
                        Integer startYearBike = sc.nextInt();
                        if((startYearBike < 2000 || startYearBike > 2023) && startYearBike != -1) {
                            throw new IllegalArgumentException("year start: Enter a valid year between 2000 and 2023.");
                        }
                        System.out.println("year end(-1 to skip): ");
                        Integer endYearBike = sc.nextInt();
                        if((endYearBike < startYearBike || endYearBike > 2023) && endYearBike != -1) {
                            throw new IllegalArgumentException("year end: Enter a valid year between 'start year' and 2023.");
                        }
                        System.out.println("start price in INR(-1 to skip): ");
                        Double startPriceBike = sc.nextDouble();
                        if(startPriceBike <= 0 && startPriceBike != -1) {
                            throw new IllegalArgumentException("price start: Enter a valid price greater than 0.");
                        }
                        System.out.println("end price in INR(-1 to skip): ");
                        Double endPriceBike = sc.nextDouble();
                        if(endPriceBike < startPriceBike && endPriceBike != -1) {
                            throw new IllegalArgumentException("price end: Enter a price greater than start price.");
                        }

                        boolean emptyCheck = !makeBike.equals("-1") || startYearBike != -1 || endYearBike != -1 || startPriceBike != -1 || endPriceBike != -1;
                        if(emptyCheck) {

                            List<String> makeSearchBike = bikeStringMap.get("make");
                            List<Integer> makeYearBike = bikeIntMap.get("year");
                            List<Double> makePriceBike = bikeDoubleMap.get("price");



                            for(int i = 0; i<makeSearchBike.size(); i++) {
                                boolean makeBikeFilter = makeBike.equals(makeSearchBike.get(i));
                                boolean startYearFilter = (startYearBike != -1 && startYearBike <= makeYearBike.get(i));
                                boolean endYearFilter = (endYearBike != -1 && endYearBike >= makeYearBike.get(i));
                                boolean startPriceFilter = (startPriceBike != -1 && startPriceBike <= makePriceBike.get(i));
                                boolean endPriceFilter = (endPriceBike != -1 && endPriceBike >= makePriceBike.get(i));

                                if(makeBikeFilter) {
                                    makeSet.add(i);
                                }
                                if(startYearFilter || endYearFilter) {
                                    yearSet.add(i);
                                }
                                if(startPriceFilter || endPriceFilter) {
                                    priceSet.add(i);
                                }
                            }

                            makeSet.retainAll(yearSet);
                            makeSet.retainAll(priceSet);

                            if(!makeSet.isEmpty()) {
                                for(int i : makeSet) {
                                    Motorcycle bikeObj = bikeInventory.get(i);
                                    bikeObj.displayDetails();
                                }
                            } else {
                                System.out.println("No results found.");
                            }
                        } else {
                            System.out.println("No results found.");
                        }
                    } else {
                        System.out.println("Vehicle type entered is invalid.");
                        break;
                    }
                    break;
                case 4:
                    System.out.println("Enter type of vehicle\n1- Car\n2- Motorcycle");
                    int vehicleType3 = sc.nextInt();
                    if(vehicleType3 == 1) {
                        System.out.println("Check the complete car inventory to select the car for changes:");
                        for(int i = 0; i < carInventory.size(); i++) {
                            System.out.println("car number " + i + " :");
                            carInventory.get(i).displayDetails();
                            System.out.println("press 1 to make changes, 2 for next, [any] number to exit.");
                            int option = sc.nextInt();
                            if(option == 1) {
                                Car carObj = carInventory.get(i);
                                System.out.println("press 1 to change value, [any] to move");
                                System.out.println("Change make:");
                                int changeMake = sc.nextInt();
                                if(changeMake == 1) {
                                    System.out.println("enter new value: ");
                                    String makeNew = sc.nextLine();
                                    carObj.setMake(makeNew);
                                    carMakeList.set(i, makeNew);
                                }
                                System.out.println("Change model:");
                                int changeModel = sc.nextInt();
                                if(changeModel == 1) {
                                    System.out.println("enter new value: ");
                                    String modelNew = sc.nextLine();
                                    carObj.setMake(modelNew);
                                    carMakeList.set(i, modelNew);
                                }
                                System.out.println("Change year:");
                                int changeYear = sc.nextInt();
                                if(changeYear == 1) {
                                    System.out.println("enter new value: ");
                                    int yearNew = sc.nextInt();
                                    carObj.setYear(yearNew);
                                    carYearList.set(i, yearNew);
                                }
                                System.out.println("Change price:");
                                int changePrice = sc.nextInt();
                                if(changePrice == 1) {
                                    System.out.println("enter new value: ");
                                    double priceNew = sc.nextDouble();
                                    carObj.setPrice(priceNew);
                                    carPriceList.set(i, priceNew);
                                }
                                System.out.println("Change total doors:");
                                int changeTotalDoors = sc.nextInt();
                                if(changeTotalDoors == 1) {
                                    System.out.println("enter new value: ");
                                    int totalDoorsNew = sc.nextInt();
                                    carObj.setNumDoors(totalDoorsNew);
                                    carNumDoorsList.set(i, totalDoorsNew);
                                }
                                System.out.println("Change fuel type:");
                                int changeFuelType = sc.nextInt();
                                if(changeFuelType == 1) {
                                    System.out.println("enter new value: ");
                                    String fuelTypeNew = sc.nextLine();
                                    carObj.setFuelType(fuelTypeNew);
                                    carFuelTypeList.set(i, fuelTypeNew);
                                }
                                System.out.println("car values changed.\n\n");
                            } else if(option == 2) {
                            } else {
                                break;
                            }

                        }
                    }
                    else if(vehicleType3 == 2) {
                        System.out.println("Check the complete bike inventory to select the bike for changes:");
                        for(int i = 0; i < bikeInventory.size(); i++) {
                            System.out.println("bike number " + i + " :");
                            bikeInventory.get(i).displayDetails();
                            System.out.println("press 1 to make changes, 2 for next, [any] number to exit.");
                            int option = sc.nextInt();
                            if(option == 1) {
                                Motorcycle bikeObj = bikeInventory.get(i);
                                System.out.println("press 1 to change value, [any] to move");
                                System.out.println("Change make:");
                                int changeMake = sc.nextInt();
                                if(changeMake == 1) {
                                    System.out.println("enter new value: ");
                                    String makeNew = sc.nextLine();
                                    bikeObj.setMake(makeNew);
                                    bikeMakeList.set(i, makeNew);
                                }
                                System.out.println("press 1 to change value, [any] to move");
                                System.out.println("Change model:");
                                int changeModel = sc.nextInt();
                                if(changeModel == 1) {
                                    System.out.println("enter new value: ");
                                    String modelNew = sc.nextLine();
                                    bikeObj.setMake(modelNew);
                                    bikeModelList.set(i, modelNew);
                                }
                                System.out.println("press 1 to change value, [any] to move");
                                System.out.println("Change year:");
                                int changeYear = sc.nextInt();
                                if(changeYear == 1) {
                                    System.out.println("enter new value: ");
                                    int yearNew = sc.nextInt();
                                    bikeObj.setYear(yearNew);
                                    bikeYearList.set(i, yearNew);
                                }
                                System.out.println("press 1 to change value, [any] to move");
                                System.out.println("Change price:");
                                int changePrice = sc.nextInt();
                                if(changePrice == 1) {
                                    System.out.println("enter new value: ");
                                    double priceNew = sc.nextDouble();
                                    bikeObj.setPrice(priceNew);
                                    bikePriceList.set(i, priceNew);
                                }
                                System.out.println("press 1 to change value, [any] to move");
                                System.out.println("Change side car exists:");
                                int changeHasSideCar = sc.nextInt();
                                if(changeHasSideCar == 1) {
                                    System.out.println("enter new value: ");
                                    boolean hasSideCarNew = sc.nextBoolean();
                                    bikeObj.setHasSideCar(hasSideCarNew);
                                    bikeHasSideCarList.set(i, hasSideCarNew);
                                }
                                System.out.println("press 1 to change value, [any] to move");
                                System.out.println("Change engine capacity:");
                                int changeEngineCapacity = sc.nextInt();
                                if(changeEngineCapacity == 1) {
                                    System.out.println("enter new value: ");
                                    int engineCapacityNew = sc.nextInt();
                                    bikeObj.setEngineCapacity(engineCapacityNew);
                                    bikeEngineCapacityList.set(i, engineCapacityNew);
                                }
                                System.out.println("press 1 to change value, [any] to move");
                                System.out.println("Change weight:");
                                int changeWeight = sc.nextInt();
                                if(changeWeight == 1) {
                                    System.out.println("enter new value: ");
                                    double weightNew = sc.nextDouble();
                                    bikeObj.setWeight(weightNew);
                                    bikeWeightList.set(i, weightNew);
                                }
                                System.out.println("bike values changed.\n\n");
                            } else if(option == 2) {
                            } else {
                                System.out.println("Exiting...");
                                break;
                            }

                        }

                    } else {
                        System.out.println("Vehicle type entered is invalid");
                        break;
                    }
                    break;
                case 5:
                    System.out.println("Enter type of vehicle\n1- Car\n2- Motorcycle");
                    int vehicleType4 = sc.nextInt();
                    if(vehicleType4 == 1) {
                        System.out.println("Check the complete car inventory to select the car for deletion:");
                        int loopSize = carInventory.size();
                        for(int i = 0; i < loopSize; i++) {
                            System.out.println("car number " + i + " :");
                            carInventory.get(i).displayDetails();
                            System.out.println("press 1 to confirm deletion, 2 for next, [any] number to exit.");
                            int option = sc.nextInt();
                            if(option == 1) {
                                carInventory.remove(i);
                                carMakeList.remove(i);
                                carModelList.remove(i);
                                carYearList.remove(i);
                                carPriceList.remove(i);
                                carNumDoorsList.remove(i);
                                carFuelTypeList.remove(i);
                                break;
                            } else if(option == 2) {
                            } else {
                                System.out.println("Exiting...");
                                break;
                            }
                        }
                    } else if(vehicleType4 == 2) {
                        System.out.println("Check the complete bike inventory to select the bike for deletion:");
                        int loopSize = bikeInventory.size();
                        for(int i = 0; i < loopSize; i++) {
                            System.out.println("bike number " + i + " :");
                            bikeInventory.get(i).displayDetails();
                            System.out.println("press 1 to confirm deletion, 2 for next, [any] number to exit.");
                            int option = sc.nextInt();
                            if(option == 1) {
                                bikeInventory.remove(i);
                                bikeMakeList.remove(i);
                                bikeModelList.remove(i);
                                bikeYearList.remove(i);
                                bikePriceList.remove(i);
                                bikeHasSideCarList.remove(i);
                                bikeEngineCapacityList.remove(i);
                                bikeWeightList.remove(i);
                                break;
                            } else if(option == 2) {
                            } else {
                                System.out.println("Exiting...");
                                break;
                            }
                        }
                    } else {
                        System.out.println("Vehicle type entered is invalid.");
                        break;
                    }
                    break;
                default:
                    System.out.println("Invalid option.\nenter an option between 1 - 5.");
                    break;

            }
        }
    }

}