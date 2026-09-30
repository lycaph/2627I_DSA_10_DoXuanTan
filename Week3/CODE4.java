import java.io.*;
import java.util.*;

public class CODE4 {
    static class query {
        StringBuffer w;
        int query;
        public query(int query, StringBuffer s) {
            this.query = query;
            this.w = s;
        }
    }

    static class simpletexteditor {
        Stack<query> stack = new Stack<>();
        StringBuffer s = new StringBuffer();

        public void append(String w) {
            stack.push(new query(1, new StringBuffer(s)));
            s.append(w);

        }
        public void delete(int k) {
            stack.push(new query(2, new StringBuffer(s)));
            int n = s.length();
            s.delete(n - k, n);

        }
        public void print(int k) {
            System.out.println(s.charAt(k-1));
        }
        public void undo() {
            s = new StringBuffer(stack.pop().w);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        simpletexteditor stt = new simpletexteditor();

        int n = sc.nextInt();
        for(int i = 0; i<n; i++) {
            int query = sc.nextInt();
            switch (query) {
                case 1 -> stt.append(sc.next());
                case 2 -> stt.delete(sc.nextInt());
                case 3 -> stt.print(sc.nextInt());
                case 4 -> stt.undo();
            }
        }
    }
}
