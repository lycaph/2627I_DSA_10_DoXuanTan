import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class W5_LT6 {
    public static void swap(int i, int j, List<Integer> arr) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    public static void quicksort(List<Integer> arr, int l, int r) {
        if (l>=r) {return;}
        int pivot = partition(arr, l, r);

        quicksort(arr, l, pivot-1);
        quicksort(arr, pivot+1, r);

    }
    private static int partition(List<Integer> arr, int l, int r) {
        int pivot = arr.get(r);
        int i = l-1;
        for(int j = l; j < arr.size(); j++) {
            if(arr.get(j) < pivot) {
                i++;
                swap(i, j, arr);
            }
        }
        i++;
        swap(i, r, arr);
        return i;
    }
    public static void main() {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i< n; i++) {
            arr.add(sc.nextInt());
        }
        quicksort(arr, 0, n-1);
        for(int j:arr) {
            System.out.print(j + " ");
        }

    }
}
