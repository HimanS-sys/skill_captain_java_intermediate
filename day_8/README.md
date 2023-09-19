# Assignment 8

## Task
Create a Java program that simulates user registration for an e-commerce application.
- The program should allow users to enter their name, email address, password and shipping address.
- The program should store the user data in an in-memory data structure, such as an ArrayList or HashMap.
- The program should also validate user input to ensure that all required fields are entered and that the email address is in a valid format.

## Approach

1. Create a `User` class having attributes `name`, `email`, `password`, `address`.
2. Create a class `UserRepository` which stores user data in an in- memory data structure.
3. `UserRepository` contains following methods:
    - `addUser(User user)`: Adds a user to the repository.
    - `getUser(String email)`: Retrieves a user from the repository by email address.
    - `getAllUsers()`: Retrieves all users from the repository.
4. Create a static method `isValidEmai(String email)` inside main method which verifies if email is valid.
5. Create a switch case statement inside a while loop so that the switch is being called again and again until we exit from the system.
6. The switch statement will have 4 options
    - `case 0`: exit.
    - `case 1`: register a user.
    - `case 2`: search a user based on email.
    - `case 3`: display all users.

7. Use Similar looping approach inside the case containing validity checks on the inputs.

## Code
To check the .java file:
* go to day_8/eCommerceUserReg/src.
* click on Main.java file.

   
