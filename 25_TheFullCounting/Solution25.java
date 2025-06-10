import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
 public static void countSort(List<List<String>> arr) {
    int n = arr.size();

    List<List<String>> buckets = new ArrayList<>();
    for (int i = 0; i < 100; i++) {
        buckets.add(new ArrayList<String>());
    }

    for (int i = 0; i < n; i++) {
        int index = Integer.parseInt(arr.get(i).get(0));
        // For first half elements, replace string with "-"
        String value = i < n / 2 ? "-" : arr.get(i).get(1);
        buckets.get(index).add(value);
    }

    StringBuilder result = new StringBuilder();
    for (List<String> bucket : buckets) {
        for (String s : bucket) {
            result.append(s).append(" ");
        }
    }

    System.out.println(result.toString().trim());
}

}

public class Solution25 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        Result.countSort(arr);

        bufferedReader.close();
    }
}
