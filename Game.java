import java.util.ArrayList;

public class Game {

    static String word;
    int wordLength;
    int lettersToFind;
    int lettersRemaining;
    ArrayList<String> foundLetters;
    ArrayList<String> wrongLetters;

    LetterInput letterInput;

    int lives;

    Game(String word_) {
        word = word_;
        wordLength = word.length();
        lettersToFind = wordLength - 2;
        lettersRemaining = lettersToFind;

        foundLetters = new ArrayList<String>();
        wrongLetters = new ArrayList<String>();

        letterInput = new LetterInput();

        lives = 6;
    }

    private boolean play(String letter) {

        System.out.println("Letters to Find:" + lettersToFind);
        boolean found = false;

        for (int i = 0; i < lettersToFind; i++) {
            if (letter == Character.toString(word.charAt(i))) {
                // Check if letter already existis in list
                foundLetters.add(letter);
                lettersRemaining -= 1;
                found = true;

                System.out.println("Found Letters:");
                for (int j = 0; j < foundLetters.size(); j++) {
                    System.out.println(foundLetters.get(j));
                }
            } else {
                wrongLetters.add(letter);

                System.out.println("Wrong Letters:");

                for (int j = 0; j < wrongLetters.size(); j++) {
                    System.out.println(wrongLetters.get(i));
                }
            }

        }
        return found;
    }

    void round() {
        while (lives > 0) {

            String letter = letterInput.input();

            if (play(letter) == false) {
                lives -= 1;
                System.out.println("Lives:" + lives);
            } else {
                System.out.println("Lives:" + lives);
            }
        }
    }

    // str.substring(0, 1)

}