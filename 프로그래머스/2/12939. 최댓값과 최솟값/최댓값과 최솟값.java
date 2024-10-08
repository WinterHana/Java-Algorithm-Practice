import java.util.*; 

class Solution {
    public String solution(String s) {
        String[] numbers = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String resultMax = "";
        String resultMin = "";
        
        
        for(String n : numbers) {
            int parseNumber = Integer.parseInt(n);
            if(max < parseNumber) {
                resultMax = n;
                max = parseNumber;
            }
            if(min > parseNumber) {
                resultMin = n;
                min = parseNumber;
            } 
        }
        
        return resultMin + " " + resultMax;
    
    }
}