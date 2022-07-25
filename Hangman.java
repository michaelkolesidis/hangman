import java.util.ArrayList;

class Hangman {

    public static void main(String[] args) {
        // System.out.println("HANGMAN");
        // System.out.println("-------");
        //  final String ANSI_BLUE = "\u001B[34m";
        // final String ANSI_WHITE = "\u001B[37m";
        // System.out.println(ANSI_BLUE + "Hangman!" + ANSI_WHITE);
        // System.out.println("-------");
        // System.out.println(System.getProperty("os.name"));

        WordParser wordparser = new WordParser("./wordlist.txt");

        wordparser.createFile();
        wordparser.createScanner();
        ArrayList<String> words = wordparser.parse();

        WordPicker wordPicker = new WordPicker(words);
        String word = wordPicker.pick();

        System.out.println(word);


        Game game = new Game(word);
        game.playing();




    }   

}