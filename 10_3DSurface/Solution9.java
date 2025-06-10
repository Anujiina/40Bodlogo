import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    public static int surfaceArea(List<List<Integer>> A) {
        int H = A.size();
        if (H == 0) {
        return 0; }
        int W = A.get(0).size();
        int surface = 0;
        surface += 2 * H * W;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                int current = A.get(i).get(j);
                if (i == 0) {
                    surface += current;
                } else {
                    int north = A.get(i-1).get(j);
                    if (current > north) {
                        surface += current - north;
                    }
                }
                if (i == H - 1) {
                    surface += current;
                } else {
                    int south = A.get(i+1).get(j);
                    if (current > south) {
                        surface += current - south;
                    }
                }
                if (j == 0) {
                    surface += current;
                } else {
                    int west = A.get(i).get(j-1);
                    if (current > west) {
                        surface += current - west;
                    }
                }
                if (j == W - 1) {
                    surface += current;
                } else {
                    int east = A.get(i).get(j+1);
                    if (current > east) {
                        surface += current - east;
                    }
                }
            }
        }
        return surface;
    }
}

public class Solution9 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        for (int i = 0; i < H; i++) {
            String[] ARowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> ARowItems = new ArrayList<>();

            for (int j = 0; j < W; j++) {
                int AItem = Integer.parseInt(ARowTempItems[j]);
                ARowItems.add(AItem);
            }

            A.add(ARowItems);
        }

        int result = Result.surfaceArea(A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
