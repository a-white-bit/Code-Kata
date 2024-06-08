import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = ' ';
        int xCount = 0;
        for (char c : s.toCharArray()) {
            if (x == ' ') {
                x = c;
                xCount = 1;
                continue;
            }
            
            if (x == c) {
                xCount++;
            } else {
                xCount--;
            }
            
            if (xCount == 0) {
                x = ' ';
                answer++;
            }
        }
        
        if (x != ' ') {
            answer++;
        }
        
        return answer;
    }
}