import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class ArrayNum implements Comparable<ArrayNum> {
    int number;
    int index;

    public ArrayNum(int number, int index) {
        this.number = number;
        this.index = index;
    }

    @Override
    public int compareTo(ArrayNum o) {
        return this.number - o.number;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayNum[] arrayNums = new ArrayNum[N];
        for(int i = 0; i < N; i++) {
            arrayNums[i] = new ArrayNum(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(arrayNums);
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            if(arrayNums[i].index - i > max) {
                max = arrayNums[i].index - i;
            }
        }

        // index가 1부터 시작하기 때문에 +1를 한다.
        System.out.println(max + 1);
    }
}