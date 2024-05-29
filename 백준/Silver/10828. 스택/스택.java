import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stack {
    int[] arr;
    int size;
    int top;

    Stack() {
        this.arr = new int[10001];
        this.size = 0;
        this.top = -1;
    }

    public int size() {
        return this.size;
    }

    public int empty() {
        return (this.size == 0) ? 1 : 0;
    }

    public int top() {
        if(empty() == 1) return -1;
        return arr[this.top];
    }

    public void push(int num) {
        arr[this.size] = num;
        this.size++;
        this.top++;
    }

    public int pop() {
        if(empty() == 1) return -1;
        int result = arr[this.top];
        this.size--;
        this.top--;
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack stack = new Stack();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] lineSplit = line.split(" ");
            String order = lineSplit[0];
            int num = 0;
            if (lineSplit.length > 1) num = Integer.parseInt(lineSplit[1]);
            if (order.equals("push")) {
                stack.push(num);
            } else if (order.equals("pop")) {
                System.out.println(stack.pop());
            } else if (order.equals("size")) {
                System.out.println(stack.size());
            } else if (order.equals("empty")) {
                System.out.println(stack.empty());
            } else if (order.equals("top")) {
                System.out.println(stack.top());
            }
        }
    }
}