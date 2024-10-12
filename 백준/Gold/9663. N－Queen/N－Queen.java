import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static int N;
    public static int[] arr; // 각 원소의 index를 '열', 원소 값을 '행'으로 생각하기.
    public static int count;

    public static void nQueen(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        for(int i = 0; i < N; i++) {
            arr[depth] = i;

            if(checkPosition(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean checkPosition(int col) {
        for(int i = 0; i < col; i++) {
            if(arr[col] == arr[i]) {
                return false;
            } else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);

        System.out.println(count);
    }
}