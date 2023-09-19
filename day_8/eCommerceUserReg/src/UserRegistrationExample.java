import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class User {
    // name, email, password, address
    private String name;
    private String email;
    private String password;
    private String address;

    // constructor
    public User(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    //getter and setter methods
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

class UserRepository {
    private List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
    }

    public void addUser(User user) {
        this.userList.add(user);
    }

    public User getUser(String email) {
        for(User usr: userList) {
            if(usr.getEmail().equals(email)) {
                return usr;
            }
        }
        return null;
    }

    public List<User> getAllUsers() {
        return this.userList;
    }
}



public class UserRegistrationExample {
    public static boolean isValidEmail(String email) {
        //validate email
        if(email == null || email.isEmpty() || email.trim().isEmpty()) {
            return false;
        }
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pat = Pattern.compile(regexPattern);
        return pat.matcher(email).matches();
    }

    public static void main(String[] args) {
        //execute program

        Scanner sc = new Scanner(System.in);
        UserRepository userRepo = new UserRepository();

        while(true) {
            System.out.println("---- Ecommerce User Registration ----");
            System.out.println("1- add user");
            System.out.println("2- search user");
            System.out.println("3- show all users registered");
            System.out.println("0- Exit");

            int option = sc.nextInt();
            sc.nextLine(); // consumes unwanted newline character

            boolean check = true; // used inside switch case

            switch (option) {
                case 0:
                    sc.close();
                    System.out.println("exiting...");
                    System.exit(0);
                    break;
                case 1:
                    check = true;
                    while(check) {
                        System.out.println("enter user details:");
                        System.out.println("name: ");
                        String name = sc.nextLine();
                        if(name.isEmpty() || name.trim().isEmpty()) {
                            System.out.println("enter a non empty name.");
                            continue;
                        }
                        System.out.println("email: ");
                        String email = sc.nextLine();
                        if(!isValidEmail(email)) {
                            System.out.println("enter a valid email.");
                            continue;
                        }
                        System.out.println("password: ");
                        String password = sc.nextLine();
                        if(password.isEmpty() || password.trim().isEmpty()) {
                            System.out.println("enter a valid password.");
                            continue;
                        }
                        System.out.println("address: ");
                        String address = sc.nextLine();
                        // can also use isBlank() to reduce code
                        if(address.isBlank()) {
                            System.out.println("enter a valid address.");
                            continue;
                        }
                        User user = new User(name, email, password, address);
                        userRepo.addUser(user);

                        System.out.println("user '" + name + "' registered.");
                        check = false;
                    }
                    break;
                case 2:
                    check = true;
                    while(check) {
                        System.out.println("search user:");
                        System.out.println("enter email to search user:");
                        String email = sc.nextLine();
                        if (!isValidEmail(email)) {
                            System.out.println("enter a valid email.");
                        } else if(userRepo.getUser(email) != null) {
                            User user = userRepo.getUser(email);
                            System.out.println("user found!");
                            System.out.println("name: " + user.getName());
                            System.out.println("email: " + user.getEmail());
                            System.out.println("address: " + user.getAddress());
                            check = false;
                        } else {
                            System.out.println("no user found.");
                            check = false;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Showing all the users available");
                    int i = 1;
                    for(User usr: userRepo.getAllUsers()) {
                        System.out.println("user: " + i);
                        System.out.println("name: " + usr.getName());
                        System.out.println("email: " + usr.getEmail());
                        System.out.println("---------------------------------");
                        i += 1;
                    }
                    break;
                default:
                    System.out.println("invalid option! enter an option between 0-3");
                    break;
            }
        }
    }
}


