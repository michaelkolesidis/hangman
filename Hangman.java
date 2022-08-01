import java.util.ArrayList;

class Hangman {

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.printTitle();

        WordParser wordparser = new WordParser("./wordlist.txt");

        wordparser.createFile();
        wordparser.createScanner();
        ArrayList<String> words = wordparser.parse();

        // Print word for testing
        // System.out.println(word);

        printer.printEmptyLine();

        int winningStreak = 0;

        do {

            WordPicker wordPicker = new WordPicker(words);
            String word = wordPicker.pick();
            Game game = new Game(word);

            if (game.play() == true) {
                winningStreak += 1;
                printer.print("Winning streak: " + winningStreak);
            } else {
                winningStreak = 0;
            }

        } while (PlayAgain.wannaPlay() == true);

        printer.print("Thanks for playing!");
        
    }

}
