// Human-written style solution. Task: count word frequency in a sentence.

import java.util.HashMap;
import java.util.Map;

public class task05_word_frequency {

    public static Map<String, Integer> countWords(String sentence) {
        Map<String, Integer> result = new HashMap<>();
        if (sentence == null || sentence.isBlank()) return result;
        for (String word : sentence.trim().split("\\s+")) {
            result.merge(word, 1, Integer::sum);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countWords("the cat the dog the bird"));
    }
}
