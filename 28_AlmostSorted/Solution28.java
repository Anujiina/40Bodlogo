import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.*;

class Result {
 public static void almostSorted(List<Integer> arr) {
    int n = arr.size();
    List<Integer> sortedArr = new ArrayList<>(arr);
    Collections.sort(sortedArr);
    List<Integer> diffIndices = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        if (!arr.get(i).equals(sortedArr.get(i))) {
            diffIndices.add(i);
        }
    }
    if (diffIndices.isEmpty()) {
        System.out.println("yes");
        return;
    }
    if (diffIndices.size() == 2) {
        System.out.println("yes");
        System.out.printf("swap %d %d%n", diffIndices.get(0) + 1, diffIndices.get(1) + 1);
        return;
    }
    int start = diffIndices.get(0);
    int end = diffIndices.get(diffIndices.size() - 1);
    List<Integer> subList = arr.subList(start, end + 1);
    List<Integer> reversed = new ArrayList<>(subList);
    Collections.reverse(reversed);
    if (reversed.equals(sortedArr.subList(start, end + 1))) {
        System.out.println("yes");
        System.out.printf("reverse %d %d%n", start + 1, end + 1);
    } else {
        System.out.println("no");
    }
}
}

public class Solution28 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.almostSorted(arr);

        bufferedReader.close();
    }
}
