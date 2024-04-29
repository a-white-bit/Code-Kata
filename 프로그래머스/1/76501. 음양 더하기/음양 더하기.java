class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        // 간단히 모든 배열을 순회하며 합을 구함
        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) answer += absolutes[i];
            else answer -= absolutes[i];
        }
        return answer;
    }
}