import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[15][15];
        for(int i = 0; i < 15; i++) {
            if(i == 0) {
                for(int j = 1; j < 15; j++) {
                    arr[i][j] = j;
                }
            } else {
                for(int j = 1; j < 15; j++) {
                    arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
                }
            }
        }

//        for(int i = 0; i < 15; i++) {
//            for(int j = 0; j < 15; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[k][n]);
        }
    }
}