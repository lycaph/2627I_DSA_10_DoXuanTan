import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class W5_LT7 {
    void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    int partition(List<Integer> arr, int l, int r) {
        int p = arr.get(r);

        int i = l-1;
        for(int j = l; j<r; j++) {
            if (arr.get(j) < p) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, r);
        return i;
    }
    int findTheMedian(List<Integer> arr, int l, int r, int k) {
        int p = partition(arr, l, r);

        if(p == k) {
            return arr.get(p);
        }
        else if (p < k) {
            return findTheMedian(arr, p+1, arr.size() - 1, k);
        } else {
            return findTheMedian(arr, l, p-1, k);
        }
    }
    void main() {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();

        int n = sc.nextInt();
        for(int i = 0; i<n; i++) {
            arr.add(sc.nextInt());
        }
        int k = arr.size()/2;
        System.out.print(findTheMedian(arr, 0, n-1, k));
    }
}
