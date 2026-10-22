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

public class W7_CODE5 {
    class Result {

        /*
         * Complete the 'runningMedian' function below.
         *
         * The function is expected to return a DOUBLE_ARRAY.
         * The function accepts INTEGER_ARRAY a as parameter.
         */
        public static List<Double> runningMedian(List<Integer> a) {
            // Write your code here
            PriorityQueue<Integer> lower =
                    new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> higher =
                    new PriorityQueue<>();
            List<Double> median = new ArrayList<>();
            double med;

            for (int k : a) {
                if (lower.isEmpty() || k <= lower.peek()) {
                    lower.add(k);
                } else {higher.add(k);}

                if (lower.size() > higher.size()+1) {
                    higher.add(lower.poll());
                } else if (lower.size() < higher.size()) {
                    lower.add(higher.poll());
                }

                if (lower.size() == higher.size()) {
                    med = (lower.peek() + higher.peek())/2.0;
                } else {
                    med = lower.peek();
                }
                median.add(med);
            }
            return median;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

