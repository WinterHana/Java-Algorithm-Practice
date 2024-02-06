import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Integer> splitNumbers(int num) {
        List<Integer> list = new ArrayList<>();
        int temp = num;
        while(true) {
            list.add(temp % 10);
            temp = temp / 10;
            if(temp == 0) break;
        }

        return list;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 1; i <= num; i++) {
            boolean isCount = true;
            if(i >= 1 && i <= 99) {
                count++;
            } else {
                List<Integer> list = splitNumbers(i);
                for(int j = 0; j < list.size() - 2; j++) {
                    if((list.get(j) - list.get(j + 1)) != (list.get(j + 1) - list.get(j + 2))) {
                        isCount = false;
                        break;
                    }
                }
                if(isCount) count++;
            }
        }
        System.out.println(count);
    }
}