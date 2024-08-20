import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

//        int start = 0; // 글자를 가져올 시작점
//        List<Integer> numbers = new ArrayList<>();
//        for(int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if(!(c >= '0' && c <= '9')) { // 부호 만나면
//                numbers.add(Integer.parseInt(s.substring(start, i)));
//                start = i;
//            } else if(i == s.length() - 1) { // 끝나면 나머지 숫자 저장
//                numbers.add(Integer.parseInt(s.substring(start, i + 1)));
//            }
//        }
//
//        for(int i = 0; i < numbers.size(); i++) {
//            System.out.println(numbers.get(i));
//        }

        // 1. '-'로 문자열을 나눈다.
        String[] splitString = s.split("-");
        List<Integer> numbers = new ArrayList<>();
        
        // 2. '-'로 나눈 문자열을 다시 '+'로 나눈 다음, 이들간의 List를 만든다.
        for(String expression : splitString) {
            String[] splitNumbers = expression.split("\\+");
            int number = 0;
            for(String numberString : splitNumbers) {
                number += Integer.parseInt(numberString);
            }
            numbers.add(number);
        }

        // 3. 첫 문자는 그대로 더하고, 나머지는 전부 뺀다.
        int result = numbers.get(0);
        for(int i = 1; i < numbers.size(); i++) {
            result -= numbers.get(i);
        }

        System.out.println(result);
    }
}