import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int checkArr[];
    static int myArr[];
    static int checkSecret;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int result = 0;
        char A[] = new char[5];
        checkArr = new int[4];
        myArr = new int[4];
        checkSecret = 0;

        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) {
                checkSecret++;
            }
        }

        for (int i = 0; i < P; i++) {
            add(A[i]);
        }

        if (checkSecret == 4) {
            result++;
        }

        for(int i = P; i < S; i++) {
            int j = i - P;
            add(A[i]);
            remove(A[j]);
            if (checkSecret == 4) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void add(char c) {
        if(c == 'A') {
            myArr[0]++;
            if(myArr[0] == checkArr[0]) {
                checkSecret++;
            }
        } else if (c == 'C') {
            myArr[1]++;
            if(myArr[1] == checkArr[1]) {
                checkSecret++;
            }
        } else if (c == 'G') {
            myArr[2]++;
            if(myArr[2] == checkArr[2]) {
                checkSecret++;
            }
        } else if (c == 'T') {
            myArr[3]++;
            if(myArr[3] == checkArr[3]) {
                checkSecret++;
            }
        }
    }

    private static void remove(char c) {
        if(c == 'A') {
            if(myArr[0] == checkArr[0]) {
                checkSecret--;
            }
            myArr[0]--;
        } else if (c == 'C') {
            if(myArr[1] == checkArr[1]) {
                checkSecret--;
            }
            myArr[1]--;
        } else if (c == 'G') {
            if(myArr[2] == checkArr[2]) {
                checkSecret--;
            }
            myArr[2]--;
        } else if (c == 'T') {
            if(myArr[3] == checkArr[3]) {
                checkSecret--;
            }
            myArr[3]--;
        }
    }
}