import java.io.*;
import java.math.*;

class Result {
    public static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.ONE;
        while(n>1) {
        
            factorial=factorial.multiply(BigInteger.valueOf(n));
            n--;
        }
        System.out.println(factorial);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("n toogoo oruulna uu: ");
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.extraLongFactorials(n);

        bufferedReader.close();
    }
}