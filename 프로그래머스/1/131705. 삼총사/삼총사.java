class Solution {
    public int solution(int[] number) {
        int answer = 0;
        // 3중 for문으로 처리하는 방법. 최대 number.length가 13뿐이라 괜찮다.
        for (int i = 0; i < number.length; i++)
        {
            for (int j = i + 1; j < number.length; j++)
            {
                for (int k = j + 1; k < number.length; k++)
                {
                    if (number[i] + number[j] + number[k] == 0) answer++;
                }
            }
        }
        // 다른 방법?
        return answer;
    }
}