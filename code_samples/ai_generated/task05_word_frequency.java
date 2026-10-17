// AI-generated style solution. Task: count word frequency in a sentence.

import java.util.HashMap;
import java.util.Map;

public class task05_word_frequency {

    public static Map<String, Integer> countWords(String sentence) {
        Map<String, Integer> result = new HashMap<String, Integer>();
        if (sentence == null) {
            return result;
        }
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (w.equals("")) {
                continue;
            }
            if (result.containsKey(w) == true) {
                int count = result.get(w);
                count = count + 1;
                result.put(w, count);
            } else {
                result.put(w, 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countWords("the cat the dog the bird"));
    }
}
