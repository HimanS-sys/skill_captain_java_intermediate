import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public int countWord(String textPara, String word) {
        if(word.isEmpty() || word.trim().isEmpty()) {
            throw new IllegalArgumentException("Kindly enter a non empty string.");
        }
        int wordCounter = 0;
        word = word.toLowerCase();
        String[] textList = new String[]{};
        textList = textPara.split("\\s+");
        for(String txt: textList) {
            txt = txt.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            if(word.equals(txt)) {
                wordCounter += 1;
            }
        }
        return wordCounter;
    }
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        String filePath = "D:\\TempFolder\\input.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
            String text = String.join(" ", stringList);
            String word = "a";
            Main mainObj = new Main();
            int wordCount = mainObj.countWord(text, word);
            System.out.println("Total occurrences of '" + word + "': " + wordCount);

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}