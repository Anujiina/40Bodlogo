import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int up = n- r_q;
        int down = r_q-1;
        int left = c_q-1;
        int right = n-c_q;
        int upLeft = Math.min(up, left);
        int upRight = Math.min(up, right);
        int downLeft = Math.min(down, left);
        int downRight = Math.min(down, right);
        
        for (List<Integer> obstacle : obstacles) {
            int r_o = obstacle.get(0);
            int c_o = obstacle.get(1);
            if (r_o == r_q) {
                if (c_o < c_q) {
                    left = Math.min(left, c_q - c_o - 1);
                } else {
                    right = Math.min(right, c_o - c_q - 1);
                }
            } else if (c_o == c_q) {
                if (r_o > r_q) {
      
                    up = Math.min(up, r_o - r_q - 1);
                } else {
                    down = Math.min(down, r_q - r_o - 1);
                }
            } else if (Math.abs(r_o - r_q) == Math.abs(c_o - c_q)) {
                int dr = r_o - r_q;
                int dc = c_o - c_q;
                if (dr > 0 && dc < 0) {
                    upLeft = Math.min(upLeft, dr - 1);
                } else if (dr > 0 && dc > 0) {
                    upRight = Math.min(upRight, dr - 1);
                } else if (dr < 0 && dc < 0) {
                    downLeft = Math.min(downLeft, -dr - 1);
                } else if (dr < 0 && dc > 0) {
                    downRight = Math.min(downRight, -dr - 1);
                }
            }
        }
        
        return up + down + left + right + upLeft + upRight + downLeft + downRight;
    }
}

public class Solution11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> obstaclesRowItems = new ArrayList<>();

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowTempItems[j]);
                obstaclesRowItems.add(obstaclesItem);
            }

            obstacles.add(obstaclesRowItems);
        }

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
