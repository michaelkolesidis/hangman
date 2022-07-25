import java.util.ArrayList;

class Hangman {

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.printTitle();

        WordParser wordparser = new WordParser("./wordlist.txt");

        wordparser.createFile();
        wordparser.createScanner();
        ArrayList<String> words = wordparser.parse();

        WordPicker wordPicker = new WordPicker(words);
        String word = wordPicker.pick();

        System.out.println(word);
        printer.printEmptyWord(word);

        Game game = new Game(word);
        game.playing();

    }

}