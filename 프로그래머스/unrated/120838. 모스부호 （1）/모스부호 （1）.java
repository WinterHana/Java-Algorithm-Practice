import java.util.*;

class Solution {
    public String solution(String letter) {
        String[] splitString = letter.split(" ");
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        StringBuffer answer = new StringBuffer();
        for(String s : splitString) {
            for(int i = 0; i < morse.length; i++) {
                if(s.equals(morse[i])) {
                    answer.append((char)(i + 97));
                    break;
                }
            }
        }
        
        return answer.toString();
    }
}