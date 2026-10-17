// Human-written style solution. Task: find the largest number in a list.

import java.util.Collections;
import java.util.List;

public class task03_largest_number {

    public static int findLargest(List<Integer> numbers) {
        return Collections.max(numbers);
    }

    public static void main(String[] args) {
        System.out.println(findLargest(List.of(3, 7, 2, 9, 4)));
    }
}
