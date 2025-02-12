import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 소수 구하기 + 백트래킹
 */

public class Main {
    static int n;
    static boolean[] isPrime;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = new int[n];
        visited = new boolean[n + 1];
        findPrime(5000 * 5000);

        if(backtrack(0, 0)) {
            System.out.println("YES");
            for(int i = 0; i < n; i++) {
                System.out.print(result[i] + " ");
            }
        } else {
            System.out.println("NO");
        }
    }

    public static boolean backtrack(int index, int sum) {
        if(index == n) {
            return true;
        }

        for(int i = n; i >= 1; i--) {
            if(!visited[i]) {
                int newSum = sum + i;
                if(!isPrime[newSum]) {
                    visited[i] = true;
                    result[index] = i;

                    if(backtrack(index + 1, newSum)) {
                        return true;
                    }

                    visited[i] = false;
                }
            }
        }

        return false;
    }

    public static void findPrime(int n) {
        isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i * i <= n; i++) {
            if(isPrime[i]) {
                int j = 2;
                while(i * j <= n) {
                    isPrime[i * j] = false;
                    j++;
                }
            }
        }
    }
}

