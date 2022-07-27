import java.util.ArrayList;

class Printer {

    // Print game title and OS info
    void printTitle() {
        System.out.println("----------------------");
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_WHITE = "\u001B[37m";
        System.out.println(ANSI_RED + "       Hangman!     " + ANSI_WHITE);
        System.out.println("----------------------");
        System.out.println(
                ">> Running on " + System.getProperty("os.name") + " <<" + System.getProperty("line.separator"));
    }

    // Prints an empty line in an OS-independent manner
    void printEmptyLine() {
        System.out.print(System.getProperty("line.separator"));
    }

    // Generic fucntion to print input entered as parameter
    void print(String input) {
        System.out.println(input);
    }

    // Update word changing blanks with found letters
    void printWord(ArrayList<String> foundLetters, String word) {
        String output = "";

        for (int i = 0; i < word.length(); i++) {
            if (foundLetters.contains(Character.toString(word.charAt(i)))) {
                output += Character.toString(word.charAt(i)) + " ";
            } else {
                output += "_ ";
            }

        }

        System.out.println(output);
    }

    // Print whether letter is present in word
    void printIsLetterPresent(String letter, boolean result) {
        String yesOrNo = "";

        if (result == true) {
            yesOrNo = "Yes";
        } else {
            yesOrNo = "No";
        }
        System.out.println("Is " + letter + " present in word? --> " + yesOrNo);
    }

    // Print the list of the found letters and the list of the wrong letters
    // submitted
    void printLetterLists(ArrayList<String> foundLetters, ArrayList<String> wrongLetters) {
        System.out.print("Found Letters: ");

        for (String let : foundLetters) {
            System.out.print(let + " ");
        }

        System.out.println("");

        System.out.print("Wrong Letters: ");
        for (String let : wrongLetters) {
            System.out.print(let + " ");
        }

        System.out.println("");
    }

    // Print the whole word
    void printFullWord(String word) {
        System.out.println("The word was: " + word);
    }

    void printHappyMan() {
        System.out.println("  +---+");
        System.out.println("  |   |");
        System.out.println("      |");
        System.out.println(" \\O/  |");
        System.out.println("  |   |");
        System.out.println(" / \\  |");
        System.out.println("=========");
    }

    // Print the ASCII art of the hangman according to lives remaining
    void printHanging(int lives) {
        switch (lives) {
            case 6:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");

                break;
            case 5:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 4:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println("  |   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 3:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|   |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 2:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println("      |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 1:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" /    |");
                System.out.println("      |");
                System.out.println("=========");
                break;
            case 0:
                System.out.println("  +---+");
                System.out.println("  |   |");
                System.out.println("  O   |");
                System.out.println(" /|\\  |");
                System.out.println(" / \\  |");
                System.out.println("      |");
                System.out.println("=========");
                break;

        }
    }
}
