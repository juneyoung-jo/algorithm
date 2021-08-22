package programmers;

public class 타겟넘버 {
    static int N, tar, ans;

    public int solution(int[] numbers, int target) {
        int answer = 0;

        N = numbers.length;
        tar = target;


        cal(0, 0, numbers);

        return ans;
    }

    public void cal(int idx, int cnt, int[] numbers) {
        if (idx == N) {
            if (cnt == tar) ans += 1;
            return;
        }

        cal(idx + 1, cnt + numbers[idx], numbers);
        cal(idx + 1, cnt - numbers[idx], numbers);

    }
}
