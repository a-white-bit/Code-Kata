import java.lang.StringBuilder;

class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            if (food[i] % 2 == 1) {
                food[i]--;
            }
            for (int j = 0; j < food[i]; j++) {
                answer.insert(answer.length()/2, i);
            }
        }
        answer.insert(answer.length()/2, 0);
        
        return answer.toString();
    }
}