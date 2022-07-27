import java.util.ArrayList;
import java.util.Random;

public class WordPicker implements Picker {
    private ArrayList<String> list = new ArrayList<String>();
    private Random random;

    WordPicker(ArrayList<String> list_) {
        list = list_;
    }

    public String pick() {
        int listSize = list.size();
        random = new Random(System.currentTimeMillis());

        int randomNum = random.nextInt(listSize + 1);
        String word = list.get(randomNum);
        return word;
    }

}
