
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class Main {
    public static void main(String[] args) {
        Person personA = new Person("Alice", 25);
        Person personB = new Person("Bob", 30);
        System.out.println("---- Person 1 ----");
        System.out.println("Name: "  + personA.name);
        System.out.println("Age: " + personA.age);
        System.out.println("---- Person 2 ----");
        System.out.println("Name: "  + personB.name);
        System.out.println("Age: " + personB.age);
    }
}