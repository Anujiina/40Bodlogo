import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {
    
    public static int countingValleys(int steps, String path) {
        int altitude = 0;
        int valleyCount = 0;
        for (int i = 0; i < steps; i++) {
            char step = path.charAt(i);
            if (step == 'U') {
                altitude++;
            } else {
                altitude--;
            }
            if (altitude == 0 && step == 'U') {
                valleyCount++;
            }
        }
        
        return valleyCount;
    }

}

public class Solution33 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
