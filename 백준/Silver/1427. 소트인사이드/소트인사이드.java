import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] arr = new int[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(str.substring(i, i+1));
        }

        int max;
        for(int i = 0; i < arr.length; i++) {
            max = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }
            int t = arr[i];
            arr[i] = arr[max];
            arr[max] = t;
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}