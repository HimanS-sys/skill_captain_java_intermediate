# Assignment 4
## Vehicle Inventory System

You have been tasked with creating a vehicle inventory system that can store and manage information about different types of vehicles. Follow the instructions below to complete the assignment:

1. Create an abstract class called `Vehicle` with the following attributes and methods:
- Attributes:
- `make` (String): Represents the make of the vehicle.
- `model` (String): Represents the model of the vehicle.
- `year` (int): Represents the year of manufacture of the vehicle. - `price` (double): Represents the price of the vehicle.
- Methods:
- `displayDetails()`: Abstract method that should be implemented by the subclasses to display the details of the vehicle.

2. Create two subclasses of `Vehicle`: `Car` and `Motorcycle`. Each subclass should inherit from the `Vehicle` class and add its own specific attributes and methods:
- `Car`:
- Additional attributes:
- `numDoors` (int): Represents the number of doors the car has.
- `fuelType` (String): Represents the type of fuel the car uses.
- Additional methods:
- `calculateMileage()`: Calculates and returns the mileage of the car based on certain criteria.
- `Motorcycle`:
- Additional attributes:
- `hasSidecar` (boolean): Indicates whether the motorcycle has a sidecar or not. - `engineCapacity` (int): Represents the engine capacity of the motorcycle. - Additional methods:
- `calculateSpeed()`: Calculates and returns the top speed of the motorcycle based on certain criteria.

3. In the `displayDetails()` method of each subclass, override the method from the `Vehicle` class to display the specific details of the car or motorcycle, including the additional attributes.

4. In the `Main` class, create an inventory system where you can add and manage different vehicles. Implement the following functionalities:
- Allow the user to add vehicles to the inventory by providing details such as make, model, year, price, and any specific attributes related to the vehicle type.
- Provide an option to display the details of all the vehicles in the inventory.
- Implement a search functionality that allows the user to search for a vehicle based on a specific criteria (e.g., make, model, price range).
- Allow the user to update the details of a specific vehicle in the inventory.
- Implement a feature to remove a vehicle from the inventory.

5. Test the program by adding multiple vehicles to the inventory, displaying the details of all vehicles, searching for specific vehicles, updating vehicle details, and removing vehicles from the inventory.

To check the .java file:
* go to day_4/VehicleInventorySystem/src.
* click on Main.java file.
