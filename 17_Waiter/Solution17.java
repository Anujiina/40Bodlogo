import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> result = new ArrayList<>();
        List<Integer> primes = generatePrimes(q);
        Stack<Integer> currentStack = new Stack<>();
        for (int num : number) {
            currentStack.push(num);
        }

        for (int i = 0; i < q; i++) {
            int prime = primes.get(i);
            Stack<Integer> divisibleStack = new Stack<>();
            Stack<Integer> nonDivisibleStack = new Stack<>();

            while (!currentStack.isEmpty()) {
                int plate = currentStack.pop();
                if (plate % prime == 0) {
                    divisibleStack.push(plate);
                } else {
                    nonDivisibleStack.push(plate);
                }
            }

            while (!divisibleStack.isEmpty()) {
                result.add(divisibleStack.pop());
            }

            currentStack = nonDivisibleStack;
        }

        while (!currentStack.isEmpty()) {
            result.add(currentStack.pop());
        }

        return result;
    }

    private static List<Integer> generatePrimes(int q) {
        List<Integer> primes = new ArrayList<>();
        if (q == 0) {
            return primes;
        }
        primes.add(2);
        int num = 3;
        while (primes.size() < q) {
            boolean isPrime = true;
            for (int p : primes) {
                if (p * p > num) {
                    break;
                }
                if (num % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
            num += 2;
        }
        return primes;
    }
}

public class Solution17 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        String[] numberTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int numberItem = Integer.parseInt(numberTemp[i]);
            number.add(numberItem);
        }

        List<Integer> result = Result.waiter(number, q);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
