import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    public static List<String> bomberMan(int n, List<String> grid) {
        if (n == 1) {
            return grid;
        }
        if (n % 2 == 0) {
            return fillGridWithBombs(grid);
        }
        List<String> firstDetonation = detonate(grid);
        List<String> secondDetonation = detonate(firstDetonation);
        if (n % 4 == 3) {
            return firstDetonation;
        } else {
            return secondDetonation;
        }
    }
    
    private static List<String> fillGridWithBombs(List<String> grid) {
        List<String> result = new ArrayList<>();
        int cols = grid.get(0).length();
        String bombRow = new String(new char[cols]).replace('\0', 'O');
        for (int i = 0; i < grid.size(); i++) {
            result.add(bombRow);
        }
        return result;
    }
    
    private static List<String> detonate(List<String> grid) {
        int rows = grid.size();
        int cols = grid.get(0).length();
        char[][] newGrid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(newGrid[i], 'O');
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid.get(i).charAt(j) == 'O') {
                    newGrid[i][j] = '.';
                    if (i > 0) newGrid[i-1][j] = '.';
                    if (i < rows-1) newGrid[i+1][j] = '.';
                    if (j > 0) newGrid[i][j-1] = '.';
                    if (j < cols-1) newGrid[i][j+1] = '.';
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (char[] row : newGrid) {
            result.add(new String(row));
        }
        return result;
    }
}
public class Solution23 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);
        int c = Integer.parseInt(firstMultipleInput[1]);
        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String gridItem = bufferedReader.readLine();
            grid.add(gridItem);
        }

        List<String> result = Result.bomberMan(n, grid);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
