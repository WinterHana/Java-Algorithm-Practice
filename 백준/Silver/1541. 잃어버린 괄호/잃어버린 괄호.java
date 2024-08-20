import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String[] splitString = s.split("-");
        List<Integer> numbers = new ArrayList<>();
        for(String expression : splitString) {
            String[] splitNumbers = expression.split("\\+");
            int number = 0;
            for(String numberString : splitNumbers) {
                number += Integer.parseInt(numberString);
            }
            numbers.add(number);
        }

        int result = numbers.get(0);
        for(int i = 1; i < numbers.size(); i++) {
            result -= numbers.get(i);
        }

        System.out.println(result);
    }
}