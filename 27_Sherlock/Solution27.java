import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
public static int sherlockAndAnagrams(String s) {
    Map<String, Integer> map = new HashMap<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j <= n; j++) {
            String sub = s.substring(i, j);
            char[] chars = sub.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (map.containsKey(sorted)) {
                map.put(sorted, map.get(sorted) + 1);
            } else {
                map.put(sorted, 1);
            }
        }
    }
    int count = 0;
    for (int freq : map.values()) {
        if (freq > 1) {
            count += (freq * (freq - 1)) / 2;
        }
    }
    return count;
}

}

public class Solution27 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();

            int result = Result.sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
