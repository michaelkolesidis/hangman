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

        // Print word only for testing
        // System.out.println(word);

        printer.emptyLine();

        Game game = new Game(word);
        game.playing();

        // PlayAgain playAgain = new PlayAgain();

        // do {
        // Game game = new Game(word);
        // game.playing();

        // } while (playAgain.wannaPlay() == true);

        // printer.printInput("Thanks for playing!");
    }

}