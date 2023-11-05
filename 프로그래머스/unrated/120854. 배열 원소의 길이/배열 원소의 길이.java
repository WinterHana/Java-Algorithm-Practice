class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        int index = 0;
        for(String str : strlist) {
            answer[index++] = str.length();
        }
        
        return answer;
    }
}