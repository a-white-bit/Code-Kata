import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        LinkedList<Integer> hallOfFame = new LinkedList<>();
        for (int i = 0; i < score.length; i++) {
            
            int rankSize = (hallOfFame.size() < k) ? hallOfFame.size() : k;
            int j = 0;
            while (j < rankSize && hallOfFame.get(j) > score[i]) {
                j++;
            }
            if (j < k) {
                hallOfFame.add(j, score[i]);
            }
            answer[i] = (rankSize != k) ? hallOfFame.get(rankSize) : hallOfFame.get(k-1);
        }
        return answer;
    }
}