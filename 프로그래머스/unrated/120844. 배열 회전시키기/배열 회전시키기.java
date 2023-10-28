class Solution {
    public int[] solution(int[] numbers, String direction) {
        int length = numbers.length;
        int[] answer = new int[length];
        if(direction.equals("right")) {
            for(int i = 0; i < length; i++) {
                answer[(i + 1) % length] = numbers[i];
            }
        }
        if(direction.equals("left")) {
            for(int i = 0; i < length; i++) {
                if(i == 0) answer[length - 1] = numbers[i];
                else answer[(i - 1) % length] = numbers[i];
            }
        }
        
        return answer;
    }
}