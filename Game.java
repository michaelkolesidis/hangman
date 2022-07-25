import java.util.ArrayList;

public class Game {

    String word;
    int wordLength;
    int lettersToFind;
    int lettersRemaining;

    String[] letters;
    ArrayList<String> foundLetters;
    ArrayList<String> wrongLetters;

    int lives;

    Game(String word_) {
        word = word_;
        wordLength = word.length();
        lettersToFind = wordLength - 2;
        lettersRemaining = lettersToFind;

        letters = new String[lettersToFind];

        foundLetters = new ArrayList<String>();
        wrongLetters = new ArrayList<String>();

        lives = 6;
    }

    private void createLettersArray() {
        for (int i = 0; i < letters.length; i++) {
            letters[i] = Character.toString(word.charAt(i + 1));
        }
    }

    // Checks if letter input is present in word
    private boolean checkLetter(String letter, String[] letters) {
        boolean found = false;

        for (String let : letters) {
            if (let.equals(letter)) {
                found = true;
                break;
            }
        }

        return found;

    }

    private int checkTimesFound(String letter, String[] letters) {
        int times = 0;
        for (String let : letters) {
            if (let.equals(letter)) {
                times += 1;
            }
        }

        return times;
    }

    // Adds letter to array
    private void addLetter(String letter, ArrayList<String> letters) {
        letters.add(letter);
    }

    private void printLetters(ArrayList<String> foundLetters, ArrayList<String> wrongLetters) {

        System.out.print(System.getProperty("line.separator"));

        System.out.print("Found Letters: ");

        for (String let : foundLetters) {
            System.out.print(let + " ");
        }

        System.out.println("");

        System.out.print("Wrong Letters: ");
        for (String let : wrongLetters) {
            System.out.print(let + " ");
        }

        System.out.println(System.getProperty("line.separator"));
    }

    void playing() {
        createLettersArray();

        System.out.println("Letters to Find:" + lettersRemaining);

        while (lives > 0) {
            LetterInput letterInput = new LetterInput();
            String letter = letterInput.input();

            System.out.println("Letter is : " + letter);

            // System.out.println("Letters are : ");
            // for (int i = 0; i < letters.length; i++) {
            // System.out.println(letters[i]);
            // }

            boolean result = checkLetter(letter, letters);

            if (result == true) {
                int timesFound = checkTimesFound(letter, letters);
                lettersRemaining -= timesFound;
                addLetter(letter, foundLetters);

                printLetters(foundLetters, wrongLetters);
            }

            if (result == false) {
                lives -= 1;
                addLetter(letter, wrongLetters);

                printLetters(foundLetters, wrongLetters);
            }

            // Winning condition
            if (lettersRemaining == 0 && lives > 0) {
                System.out.println("You win!");
                return;
            }

            System.out.println("Is " + letter + " present in word? --> " + result);
            System.out.println("Letters remaining:" + lettersRemaining);
            System.out.println("Lives remaining: " + lives);
        }

        System.out.println("You lose!");

    }

}