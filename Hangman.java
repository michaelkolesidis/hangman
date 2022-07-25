import java.util.ArrayList;

class Hangman {

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.printTitle();

        WordParser wordparser = new WordParser("./wordlist.txt");

        wordparser.createFile();
        wordparser.createScanner();
        ArrayList<String> words = wordparser.parse();

        // WordPicker wordPicker = new WordPicker(words);
        // String word = wordPicker.pick();

        // Print word only for testing
        // System.out.println(word);

        printer.emptyLine();

        int winningStreak = 0;

        do {

            WordPicker wordPicker = new WordPicker(words);
            String word = wordPicker.pick();
            Game game = new Game(word);

            if (game.playing() == true) {
                winningStreak += 1;
                printer.printInput("Winning streak: " + winningStreak);
            } else {
                winningStreak = 0;
            }

        } while (PlayAgain.wannaPlay() == true);

        printer.printInput("Thanks for playing!");
    }

}