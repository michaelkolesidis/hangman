import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

public class WordParser implements Parser {

    private String filePath;
    private File file;
    private Scanner scanner;
    private ArrayList<String> words = new ArrayList<String>();

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
                boolean hasApostrophe = false;
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == '\'' && word.charAt(i) == ' ') {
                        hasApostrophe = true;
                    }
                }

                if (hasApostrophe == false) {
                    words.add(word);
                }
            }
        }
        return (words);
    }

}
