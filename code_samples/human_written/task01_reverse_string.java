// EXAMPLE PLACEHOLDER — replace with a real human-written solution.
// Source: (team member / textbook / public GitHub repo — record in task_list.csv notes)

public class task01_reverse_string {
    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }
}
