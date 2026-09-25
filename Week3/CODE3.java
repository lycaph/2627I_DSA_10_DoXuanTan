import java.util.Scanner;
import java.util.Stack;

public class CODE3 {
    Stack<Integer> stack_in = new Stack<>();
    Stack<Integer> stack_out = new Stack<>();

    public void enqueue(int data) {
        stack_in.push(data);
    }
    public int dequeue() {
        if (stack_out.isEmpty()) {
            while(!stack_in.isEmpty()) {
                stack_out.push(stack_in.pop());
            }
        }
        return stack_out.pop();
    }
    public void peek() {
        if (stack_out.isEmpty()) {
            while(!stack_in.isEmpty()) {
                stack_out.push(stack_in.pop());
            }
        }
        System.out.println(stack_out.peek());
    }
    public static void main(String[] args) {
        CODE3 solution = new CODE3();
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        for (int i = 0; i< queries; i++) {
            int query = sc.nextInt();
            if (query == 1) {
                int data = sc.nextInt();
                solution.enqueue(data);
            } else if (query == 2) {
                solution.dequeue();
            } else {
                solution.peek();
            }
        }
        sc.close();
    }
}
