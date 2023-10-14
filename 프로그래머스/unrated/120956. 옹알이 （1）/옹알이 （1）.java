class Solution {
    public int solution(String[] babbling) {
        String[] speaking = new String[] {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for(String str : babbling) {
            for(String isContain : speaking) {
                if(str.contains(isContain)) {
                    str = str.replace(isContain, " ");
                    System.out.println(str);
                }
            }
            if(str.isBlank()) answer++;
        }
        return answer;
    }
}