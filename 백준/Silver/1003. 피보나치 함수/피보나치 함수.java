import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class CountFibo {
    int printZero;
    int printOne;

    CountFibo() {}

    CountFibo(int printZero, int printOne) {
        this.printZero = printZero;
        this.printOne = printOne;
    }

    @Override
    public String toString() {
        return printZero + " " + printOne;
    }

    public CountFibo plus(CountFibo target) {
        return new CountFibo(this.printZero + target.printZero, this.printOne + target.printOne);
    }
}

class Fibo {
    public CountFibo[] countFibos = new CountFibo[41];

    Fibo(int num) {
        countFibos[0] = new CountFibo(1, 0);
        countFibos[1] = new CountFibo(0, 1);

        for(int i = 2; i <= num; i++) {
            countFibos[i] = countFibos[i - 1].plus(countFibos[i - 2]);
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        int max = Arrays.stream(numbers).max().orElse(0);

        Fibo fibo = new Fibo(max);

        for(int num : numbers) {
            System.out.println(fibo.countFibos[num]);
        }
    }
}