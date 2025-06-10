import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i = h1.size() - 1; i >= 0; i--) {
            sum1 += h1.get(i);
            stack1.push(sum1);
        }
        for (int i = h2.size() - 1; i >= 0; i--) {
            sum2 += h2.get(i);
            stack2.push(sum2);
        }
        for (int i = h3.size() - 1; i >= 0; i--) {
            sum3 += h3.get(i);
            stack3.push(sum3);
        }
        while (true) {
            if (stack1.isEmpty() || stack2.isEmpty() || stack3.isEmpty()) {
                return 0;
            }
            
            int current1 = stack1.peek();
            int current2 = stack2.peek();
            int current3 = stack3.peek();
            if (current1 == current2 && current2 == current3) {
                return current1;
            }
            if (current1 >= current2 && current1 >= current3) {
                stack1.pop();
            } else if (current2 >= current1 && current2 >= current3) {
                stack2.pop();
            } else {
                stack3.pop();
            }
        }
    }
}

public class Solution32 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);
        int n2 = Integer.parseInt(firstMultipleInput[1]);
        int n3 = Integer.parseInt(firstMultipleInput[2]);

        String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> h1 = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            int h1Item = Integer.parseInt(h1Temp[i]);
            h1.add(h1Item);
        }

        String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> h2 = new ArrayList<>();
        for (int i = 0; i < n2; i++) {
            int h2Item = Integer.parseInt(h2Temp[i]);
            h2.add(h2Item);
        }

        String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        List<Integer> h3 = new ArrayList<>();
        for (int i = 0; i < n3; i++) {
            int h3Item = Integer.parseInt(h3Temp[i]);
            h3.add(h3Item);
        }

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
