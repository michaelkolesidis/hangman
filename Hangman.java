import java.util.ArrayList;

class Hangman {

    public static void main(String[] args) {
        System.out.println("Hangman");

        WordParser wordparser = new WordParser("./wordlist.txt");

        wordparser.createFile();
        wordparser.createScanner();
        ArrayList<String> words = wordparser.parse();

        System.out.println(words.size());

        WordPicker wordPicker = new WordPicker(words);
        String word = wordPicker.pick();

        System.out.println(word);
    }

}