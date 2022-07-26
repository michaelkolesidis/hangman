import java.util.Scanner;

public class LetterInput implements Input {

    public String input() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String outputString = " ";

        if (inputString.length() > 0) {
            outputString = inputString.substring(0, 1);
        }

        return outputString;
    }

}
