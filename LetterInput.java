import java.util.Scanner; // Import the Scanner class to read text files

public class LetterInput implements Input {

    public String input() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine().substring(0, 1);
        // scanner.close();

        return inputString;
    }

}
