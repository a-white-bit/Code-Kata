import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        
        int i = (score.length % m);
        while (i < score.length) {
            answer += score[i] * m;
            i += m;
        }
        
        return answer;
    }
}