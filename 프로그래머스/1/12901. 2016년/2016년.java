class Solution {
    public String solution(int a, int b) {
    String[] date = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
    int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int sum = 0;
    for (int i = 0; i < a - 1; i++) {
        sum += day[i];
    }
    sum += b;
    sum %= 7;
    return date[sum];
    }
}