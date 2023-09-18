import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public void textWriter(String text, String path) {
        try(FileWriter writer = new FileWriter(path)) {
            writer.write(text);
            System.out.println("text written to file: " + path);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the the text to be written on 'output.txt':");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Main mainObj = new Main();
        mainObj.textWriter(text, "output.txt");
    }
}