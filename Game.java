import java.util.ArrayList;

public class Game {

    Printer printer = new Printer();

    String word;
    int wordLength;
    int lettersToFind;
    int lettersRemaining;

    String[] letters;
    ArrayList<String> enteredLetters;
    ArrayList<String> foundLetters;
    ArrayList<String> wrongLetters;

    int lives;

    Game(String word_) {
        word = word_;
        lettersToFind = word.length();
        lettersRemaining = lettersToFind;

        letters = new String[lettersToFind];

        enteredLetters = new ArrayList<String>();
        foundLetters = new ArrayList<String>();
        wrongLetters = new ArrayList<String>();

        lives = 6;
    }

    private void createLettersArray() {
        for (int i = 0; i < letters.length; i++) {
            letters[i] = Character.toString(word.charAt(i));
        }
    }

    // Check if input is letter
    private boolean checkIfLetter(String letter) {
        boolean isLetter = false;

        if (letter.matches("[a-zA-Z]+")) {
            isLetter = true;
        }
        return isLetter;
    }

    // Checks if letter has been entered before
    private boolean checkIfEntered(String letter, ArrayList<String> enteredLetters) {
        boolean entered = false;
        for (String let : enteredLetters) {
            if (let.equals(letter)) {
                entered = true;
                break;
            }
        }
        return entered;
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

    // Adds letter to arraylist
    private void addLetter(String letter, ArrayList<String> letters) {
        letters.add(letter);
    }

    boolean playing() {
        createLettersArray();
        printer.printWord(foundLetters, word);

        printer.printInput("Letters to Find: " + lettersRemaining);
        printer.emptyLine();
        printer.printHanging(lives);

        while (lives > 0) {
            
            printer.printInput("Enter letter:");

            LetterInput letterInput = new LetterInput();
            String letter = letterInput.input().toLowerCase();

            // Check if input is letter
            if (checkIfLetter(letter) == false) {
                printer.printInput("This was not a letter!");
                continue;
            }

            // Check if letter has been entered before
            if (checkIfEntered(letter, enteredLetters) == true) {
                printer.printInput("You have already entered " + letter + "!");
                continue;
            }

            enteredLetters.add(letter);

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
                printer.printHappyMan();
                printer.printWord(foundLetters, word);
                printer.printInput("You win!");
                return true;
            }

            printer.printInput("Letters remaining: " + lettersRemaining);
            printer.emptyLine();
            printer.printHanging(lives);
            printer.printWord(foundLetters, word);
            printer.emptyLine();

        }

        printer.printLose();
        printer.printFullWord(word);

        return false;
    }

}