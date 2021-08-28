package programmers;

public class 무지의먹방라이브 {
    public int solution(int[] food_times, long k) {
        long start = 0;
        long end = k;
        long cycle = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (int t : food_times) {
                sum += t > mid ? mid : t;
            }
            if (sum <= k) {
                start = mid + 1;
                cycle = mid;
            } else end = mid - 1;
        }

        for (int i = 0; i < food_times.length; i++) {
            k -= cycle < food_times[i] ? cycle : food_times[i];
        }

        int answer = -1;
        for (int i = 0; i < food_times.length; i++) {
            if (cycle < food_times[i]) --k;
            if (k < 0) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }
}