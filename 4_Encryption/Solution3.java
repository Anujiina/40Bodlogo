import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.Scanner;

class Result {
    public static String encryption(String s) {
        s= s.replaceAll("\\s", "");
        int size = s.length();
        int rowSize = (int) Math.floor(Math.sqrt(size));
        int colSize = (int) Math.ceil(Math.sqrt(size));
        if (rowSize * colSize < size) {
            rowSize++;
        }

        StringBuilder encrypted = new StringBuilder();
        for (int c = 0; c < colSize; c++) {
            for (int r = 0; r < rowSize; r++) {
                int idx = r * colSize + c;
                if (idx < size) {
                    encrypted.append(s.charAt(idx));
                }
            }
            encrypted.append(" ");
        }

        return encrypted.toString().trim();
    }
}

public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}