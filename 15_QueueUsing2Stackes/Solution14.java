import java.io.*;
import java.util.*;

public class Solution14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();

            if (command == 1) {
                int x = scanner.nextInt();
                stack1.push(x);
            } else if (command == 2) {
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                stack2.pop();
            } else if (command == 3) {
                if (stack2.isEmpty()) {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }
                System.out.println(stack2.peek());
            }
        }
        scanner.close();
    }
}
