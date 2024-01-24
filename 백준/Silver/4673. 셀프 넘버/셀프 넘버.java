public class Main {
    private static int d(int num) {
        int temp = num;
        int result = num;
        while(temp > 0) {
            result += temp % 10;
            temp /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        int limitNum = 10000;
        boolean[] arr = new boolean[limitNum + 1];

        for(int i = 1; i <= limitNum; i++) {
            if(d(i) <= limitNum) {
                arr[d(i)] = true;
            }
        }

        for(int i = 1; i <= limitNum; i++) {
            if(arr[i] == false) {
                System.out.println(i);
            }
        }
    }
}