package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 블랙잭_2798 {

    private static int N, M, max = 3, answer = 0;
    private static int[] cards, results;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cards = new int[N];
        results = new int[max]; // 3개만 뽑는다.

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        combination(0, 0);
        System.out.println(answer);
    }

    private static void combination(int index, int start) {
        if (index == max) {
            int sum = Arrays.stream(results).sum();
            if (sum <= M) {
                answer = Integer.max(answer, sum);
            }
            return;
        }

        for (int i = start; i < N; i++) {
            results[index] = cards[i];
            combination(index + 1, i + 1);
        }
    }

}
