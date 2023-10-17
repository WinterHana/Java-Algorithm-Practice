import java.util.Arrays;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int max = 0;        // 최빈값을 결정한 개수
        int mode = 1;       // 최빈값
        int tmp = 1;        // max를 결정하는 임시변수
        
        
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] == array[i + 1]) {
                tmp++;
            } else {
                if(tmp > max) {
                    mode = array[i];
                    max = tmp;
                }
                tmp = 1;
            }
        }
        if(tmp > max) {
            mode = array[array.length - 1];
            max = tmp;
        }
        
        
        tmp = 1; 
        int maxCount = 0;            // max가 나오는 횟수, 2가 되면 -1 반환
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] == array[i + 1]) {
                tmp++;
            } else {
                if(tmp == max){
                    maxCount++;
                    if(maxCount == 2) return -1;
                } 
                tmp = 1;
            }
        }
        if(tmp == max){
            maxCount++;
            if(maxCount == 2) return -1;
        } 
        
        return mode;
    }
}