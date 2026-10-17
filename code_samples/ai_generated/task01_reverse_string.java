// EXAMPLE PLACEHOLDER — replace with a real AI-generated solution.
// Prompt used: "Write Java code to reverse a string."
// Source: (ChatGPT / Copilot — record which one in task_list.csv notes)

public class task01_reverse_string {
    public static String reverse(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello"));
    }
}
