import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        
        List<Integer> uRanked = new ArrayList<>();
        int prev = -1;
        for (int score : ranked) {
            if (score != prev) {
                uRanked.add(score);
                prev = score;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int score : player) {
            int left = 0;
            int right = uRanked.size() - 1;
            int rank = uRanked.size() + 1;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (uRanked.get(mid) <= score) {
                    rank = mid + 1;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result.add(rank);
        }
        return result;
    }
}
public class Solution12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] rankedTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ranked = new ArrayList<>();

        for (int i = 0; i < rankedCount; i++) {
            int rankedItem = Integer.parseInt(rankedTemp[i]);
            ranked.add(rankedItem);
        }

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] playerTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> player = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            int playerItem = Integer.parseInt(playerTemp[i]);
            player.add(playerItem);
        }

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
