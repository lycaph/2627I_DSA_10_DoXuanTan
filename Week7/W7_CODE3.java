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
public class W7_CODE3 {


    class Result {

        /*
         * Complete the 'cookies' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER k
         *  2. INTEGER_ARRAY A
         */
        static class MinHeap {
            private List<Integer> heap;
            public MinHeap() {
                heap = new ArrayList<>();
                heap.add(0);
            }
            public void push(int k) {
                heap.add(k);
                swim(heap.size()-1);
            }
            public int poll() {
                int root = heap.get(1);
                int last = heap.remove(heap.size()-1);
                if (heap.size() > 1) {
                    heap.set(1, last);
                    sink(1);
                }
                return root;
            }
            public int peek() {
                return heap.get(1);
            }
            public boolean isEmpty() {
                return heap.size() <= 1;
            }

            private void swim(int k) {
                while( k > 1 && heap.get(k) < heap.get(k/2)) {
                    swap(heap, k, k/2);
                    k = k/2;
                }
            }
            private void sink(int k) {
                int size = heap.size()-1;
                while(2*k <= size) {
                    int smallest = 2*k;
                    if (smallest + 1 <= size && heap.get(2*k) > heap.get(2*k+1)) {
                        smallest++;
                    }
                    if (heap.get(k) <= heap.get(smallest)) {
                        break;
                    }
                    swap(heap, k, smallest);
                    k = smallest;
                }
            }
            private void swap(List<Integer> heap, int i, int j) {
                int temp = heap.get(i);
                heap.set(i, heap.get(j));
                heap.set(j, temp);
            }
        }

        public static int cookies(int k, List<Integer> A) {
            // Write your code here
            MinHeap heap = new MinHeap();
            for (int i = 0; i < A.size(); i++) {
                heap.push(A.get(i));
            }
            int operations = 0;
            while (!heap.isEmpty()) {
                if (heap.peek() >= k) {return operations;}
                int first = heap.poll();

                if (heap.isEmpty()) {return -1;}
                int second = heap.poll();

                heap.push(first + 2*second);
                operations++;
            }
            return -1;

        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
