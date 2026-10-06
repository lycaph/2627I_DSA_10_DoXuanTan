
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LT3 {
    static class Result {
        /*
         * Complete the 'insertionSort1' function below.
         *
         * The function accepts following parameters:
         *  1. INTEGER n
         *  2. INTEGER_ARRAY arr
         */

        static void print(List<Integer> arr) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        public static void insertionSort1(int n, List<Integer> arr) {
            int unsort = arr.get(n - 1);
            int i = n - 2;
            while (i >= 0 && arr.get(i) > unsort) {
                arr.set(i + 1, arr.get(i));
                print(arr);
                i--;
            }
            arr.set(i + 1, unsort);
            print(arr);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
