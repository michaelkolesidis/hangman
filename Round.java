public class Round {
    int lives = 6;
    String word;

    Round(String word_) {
        word = word_;
    }

    String createHiddenWord() {
        int wordLength = word.length();
        int hiddenLetters = wordLength - 2;

        String firstLetter = Character.toString(word.charAt(0)); 
        String lastLetter = Character.toString(word.charAt(wordLength - 1)); 

        String middle = "";

        for (int i = 0; i < hiddenLetters; i++) {
            middle += "_";
        } 
        
        String hiddenWord = (firstLetter + middle + lastLetter).replaceAll(".(?!$)", "$0 ");

        return hiddenWord;

    }

}
