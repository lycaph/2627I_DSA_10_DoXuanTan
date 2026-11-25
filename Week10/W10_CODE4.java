import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class W10_CODE4 {
    class Result {

        /*
         * Complete the 'pairs' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER k
         *  2. INTEGER_ARRAY arr
         */

        public static int pairs(int k, List<Integer> arr) {
            // Write your code here
            HashMap<Integer, Integer> check_tb = new HashMap<>();
            int cnt = 0;

            for (int i: arr) {
                if (check_tb.containsKey(i)) {
                    cnt += check_tb.get(i);
                    check_tb.put(i, 0);
                }
                check_tb.put(i-k, check_tb.getOrDefault(i-k, 0)+1);
                check_tb.put(i+k, check_tb.getOrDefault(i+k, 0)+1);
            }
            return cnt;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
