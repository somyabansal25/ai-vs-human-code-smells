// AI-generated style solution. Task: find the largest number in a list.

import java.util.List;

public class task03_largest_number {

    public static int findLargest(List<Integer> numbers) {
        int largest = 0;
        boolean first = true;
        for (int i = 0; i < numbers.size(); i++) {
            int current = numbers.get(i);
            if (first == true) {
                largest = current;
                first = false;
            } else {
                if (current > largest) {
                    largest = current;
                } else {
                    // do nothing
                }
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        System.out.println(findLargest(List.of(3, 7, 2, 9, 4)));
    }
}
