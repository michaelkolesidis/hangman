class PlayAgain {

    boolean wannaPlay() {

        System.out.println("Do you want to play again? (y/n)");

        LetterInput letterInput = new LetterInput();
        String letter = letterInput.input().toLowerCase();

        if (letter.equals("y")) {
            return true;
        } else if (letter.equals("n")) {
            return false;
        } else {
            wannaPlay();
        }

        return false;
    }

}
