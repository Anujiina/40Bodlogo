import java.io.*;
import java.util.*;

class Result {
    public static int formingMagicSquare(List<List<Integer>> s) {
        int[][] magicSquares = {
            {4, 9, 2, 3, 5, 7, 8, 1, 6},
            {2, 7, 6, 9, 5, 1, 4, 3, 8},
            {6, 1, 8, 7, 5, 3, 2, 9, 4},
            {8, 3, 4, 1, 5, 9, 6, 7, 2},
            {2, 9, 4, 7, 5, 3, 6, 1, 8},
            {6, 7, 2, 1, 5, 9, 8, 3, 4},
            {8, 1, 6, 3, 5, 7, 4, 9, 2},
            {4, 3, 8, 9, 5, 1, 2, 7, 6}
        };

        int[] hevtee = new int[9];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                hevtee[index++] = s.get(i).get(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < magicSquares.length; i++) {
            int cost = 0;
            for (int j = 0; j < 9; j++) {
                cost += Math.abs(hevtee[j] - magicSquares[i][j]);
            }
            min= Math.min(min, cost);
        }

        return min;
    }
}

public class Solution6 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> s = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            String[] sRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> sRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowTempItems[j]);
                sRowItems.add(sItem);
            }

            s.add(sRowItems);
        }

        int result = Result.formingMagicSquare(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
