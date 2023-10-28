class Solution {
    public int[][] solution(int[] num_list, int n) {
        int col = num_list.length / n;
        int index = 0;
        int[][] answer = new int[col][];
        for(int i = 0; i < col; i++) {
            answer[i] = new int[n];
            for(int j = 0; j < n; j++) {
                answer[i][j] = num_list[index++];
            }
        }
        return answer;
    }
}