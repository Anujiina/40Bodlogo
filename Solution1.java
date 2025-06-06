import java.io.*;


class Result {
    
    public static String timeInWords(int h, int m) {
      if (m==0) {
        return hourInWords(h) + " o' clock"; 
      }
      else if (m<=30) {
        return minuteInWords(m) + " past "+ hourInWords(h);
      }
      else {
        return minuteInWords(60-m)+ " to "+ hourInWords(h+1);
      }
        }
        
public static String hourInWords(int h){
           String[] hours = { " ", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve" };
return hours[h% 12];

        }
        public static String minuteInWords(int m){
            String[] minutes= { " ", "one minutes", "two minutes", "three minutes", "four minutes", "five minutes", "six minutes", "seven minutes", "eight minutes", "nine minutes", "ten minutes", "eleven minutes", "twelve minutes","thirteen minutes", "fourteen minutes", "quarter", "sixteen minutes", "seventeen minutes", "eighteen minutes", "nineteen minutes","twenty minutes","twenty-one minutes", "twenty-two minutes", "twenty-three minutes", "twenty-four minutes", "twenty-five minutes", "twenty-six minutes", "twenty-seven minutes", "twenty-eight minutes", "twenty-nine minutes", "half"};
   return minutes[m] ;
    }
}

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}