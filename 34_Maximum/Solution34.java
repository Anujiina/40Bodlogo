import java.io.*;
import java.util.*;

class Result {

    public static List<Integer> getMax(List<String> operations) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        
        for (String op : operations) {
            String[] parts = op.split(" ");
            int type = Integer.parseInt(parts[0]);
            if (type == 1) {
                int num = Integer.parseInt(parts[1]);
                stack.push(num);
                if (maxStack.isEmpty() || num >= maxStack.peek()) {
                    maxStack.push(num);
                }
            } else if (type == 2) {
                if (!stack.isEmpty()) {
                    int popped = stack.pop();
                    if (popped == maxStack.peek()) {
                        maxStack.pop();
                    }
                }
            } else if (type == 3) {
                if (!maxStack.isEmpty()) {
                    result.add(maxStack.peek());
                }
            }
        }
        
        return result;
    }
}

public class Solution34 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String opsItem = bufferedReader.readLine();
            ops.add(opsItem);
        }

        List<Integer> res = Result.getMax(ops);

        for (int i = 0; i < res.size(); i++) {
            bufferedWriter.write(String.valueOf(res.get(i)));

            if (i != res.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
