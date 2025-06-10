import java.io.*;
import java.util.*;

class Result {

    public static void kaprekarNumbers(int p, int q) {
        List<Integer> kaprekarNums = new ArrayList<>();
        
        for (int num = p; num <= q; num++) {
            if (isKaprekar(num)) {
                kaprekarNums.add(num);
            }
        }
        
        if (kaprekarNums.isEmpty()) {
            System.out.println("INVALID RANGE");
        } else {
            for (int k : kaprekarNums) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
    
    private static boolean isKaprekar(int num) {
        if (num == 1) return true;
        
        long square = (long) num * num;
        String squareStr = Long.toString(square);
        int len = squareStr.length();
        int splitPos = len / 2;
        
        String leftStr = squareStr.substring(0, splitPos);
        String rightStr = squareStr.substring(splitPos);
        
        int left = leftStr.isEmpty() ? 0 : Integer.parseInt(leftStr);
        int right = rightStr.isEmpty() ? 0 : Integer.parseInt(rightStr);
        
        return left + right == num;
    }
}

public class Solution35 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(bufferedReader.readLine().trim());
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        Result.kaprekarNumbers(p, q);

        bufferedReader.close();
    }
}
