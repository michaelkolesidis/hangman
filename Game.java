import java.util.ArrayList;

public class Game {

    Printer printer = new Printer();

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
        lettersToFind = word.length();
        lettersRemaining = lettersToFind;

        letters = new String[lettersToFind];

        foundLetters = new ArrayList<String>();
        wrongLetters = new ArrayList<String>();

        lives = 6;
    }

    private void createLettersArray() {
        for (int i = 0; i < letters.length; i++) {
            letters[i] = Character.toString(word.charAt(i));
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

    void playing() {
        createLettersArray();

        System.out.println("Letters to Find: " + lettersRemaining);
        System.out.print(System.getProperty("line.separator"));
        printer.printHanging(lives);
        // System.out.println("Lives remaining: " + lives);

        while (lives > 0) {
            System.out.println("Enter letter:");

            LetterInput letterInput = new LetterInput();
            String letter = letterInput.input();

            System.out.println("Letter is : " + letter);

            // System.out.println("Letters are : ");
            // for (int i = 0; i < letters.length; i++) {
            // System.out.println(letters[i]);
            // }

            boolean result = checkLetter(letter, letters);

            printer.printIsLetterPresent(letter, result);

            if (result == true) {
                int timesFound = checkTimesFound(letter, letters);
                lettersRemaining -= timesFound;
                addLetter(letter, foundLetters);

                printer.printLetterLists(foundLetters, wrongLetters);
            }

            if (result == false) {
                lives -= 1;
                addLetter(letter, wrongLetters);

                printer.printLetterLists(foundLetters, wrongLetters);
            }

            // Winning condition
            if (lettersRemaining == 0 && lives > 0) {
                System.out.println("You win!");
                return;
            }

            System.out.println("Letters remaining: " + lettersRemaining);
            System.out.print(System.getProperty("line.separator"));
            printer.printHanging(lives);
            // System.out.println("Lives remaining: " + lives);
        }

        printer.printLose();
        printer.printFullWord(word);

    }

}