import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
public static String biggerIsGreater(String w) {
        char[] chars = w.toCharArray();

        int i = chars.length - 2;
        while (i >= 0 && chars[i] >= chars[i + 1]) {
            i--;
        }

        if (i < 0) 
        return "no answer";

        int j = chars.length - 1;
        while (chars[j] <= chars[i]) {
          j--;
        }
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        Arrays.sort(chars, i + 1, chars.length);

        return new String(chars);
    }
}

public class Solution7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        for (int TItr = 0; TItr < T; TItr++) {
            String w = bufferedReader.readLine();

            String result = Result.biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
