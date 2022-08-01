import java.util.ArrayList;

public class Game {

    private Printer printer = new Printer();

    private String word; // The word to find
    private int lettersRemaining;

    private String[] letters;
    private ArrayList<String> enteredLetters;
    private ArrayList<String> foundLetters;
    private ArrayList<String> wrongLetters;

    private int lives;

    Game(String word_) {
        word = word_;
        lettersRemaining = word.length(); // Initialized as the total length of the word
        letters = new String[lettersRemaining]; // Will contain the letters of the word, each letter will be one element
        enteredLetters = new ArrayList<String>();
        foundLetters = new ArrayList<String>();
        wrongLetters = new ArrayList<String>();
        lives = 6;
    }

    // Puts each letter of the word into an array
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

    // Checks how many times a correct letter appears in the word
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

    // One round
    boolean play() {
        createLettersArray();
        printer.printWord(foundLetters, word);

        printer.print("Letters to Find: " + lettersRemaining);
        printer.printEmptyLine();
        printer.printHanging(lives);

        while (lives > 0) {

            printer.print("Enter letter:");

            LetterInput letterInput = new LetterInput();
            String letter = letterInput.input().toLowerCase();

            // Check if input is letter
            if (checkIfLetter(letter) == false) {
                printer.print("This was not a letter!");
                continue;
            }

            // Check if letter has been entered before
            if (checkIfEntered(letter, enteredLetters) == true) {
                printer.print("You have already entered " + letter + "!");
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
                printer.print("You win!");
                return true;
            }

            printer.print("Letters remaining: " + lettersRemaining);
            printer.printEmptyLine();
            printer.printHanging(lives);
            printer.printWord(foundLetters, word);
            printer.printEmptyLine();

        }

        printer.print("You lose!");
        printer.printFullWord(word);

        return false;
    }

}
