import java.util.ArrayList;

class Hangman {

    public static void main(String[] args) {
        // System.out.println("HANGMAN");
        // System.out.println("=======");


        WordParser wordparser = new WordParser("./wordlist.txt");

        wordparser.createFile();
        wordparser.createScanner();
        ArrayList<String> words = wordparser.parse();

        WordPicker wordPicker = new WordPicker(words);
        String word = wordPicker.pick();

        System.out.println(word);


        // Round round = new Round(word);
        // System.out.println(round.createHiddenWord());

        Game game = new Game(word);

        game.round();
    }   

}