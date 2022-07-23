import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class WordParser implements Parser {

    String filePath;
    File file;
    Scanner scanner;
    ArrayList<String> words = new ArrayList<String>();

    WordParser(String filePath_) {
        filePath = filePath_;
    }

    public void createFile() {
        file = new File(filePath);
    }

    public void createScanner() {
        try {
            scanner = new Scanner(file);
        } catch (IOException e) {

            // Print the exception along with line number
            // using printStackTrace() method
            e.printStackTrace();
        }
    }

    public ArrayList<String> parse() {
        while (scanner.hasNextLine()) {
            String word = scanner.nextLine();
            if (word.length() >= 4) {
                words.add(word);
            }
        }

        return(words);
    }

}
