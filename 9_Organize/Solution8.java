import java.io.*;
import java.math.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
public static String organizingContainers(List<List<Integer>> container) {
    int n = container.size();
    int[] containerCapacity = new int[n]; 
    int[] typeCount = new int[n];     
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int balls = container.get(i).get(j);
            containerCapacity[i] += balls;
            typeCount[j] += balls;
        }
    }

    Arrays.sort(containerCapacity);
    Arrays.sort(typeCount);

    for (int i = 0; i < n; i++) {
        if (containerCapacity[i] != typeCount[i]) {
            return "Impossible";
        }
    }
    return "Possible";
}
}

public class Solution8 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> container = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] containerRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> containerRowItems = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowTempItems[j]);
                    containerRowItems.add(containerItem);
                }

                container.add(containerRowItems);
            }

            String result = Result.organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
