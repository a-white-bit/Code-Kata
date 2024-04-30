import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        // 스트림을 이용한 min값 제거
        int minNumber = Arrays.stream(arr).min().orElse(0);
        int[] answer = Arrays.stream(arr).filter(num -> num != minNumber).toArray();
        if (answer.length == 0) answer = new int[]{-1};
        return answer;
    }
}