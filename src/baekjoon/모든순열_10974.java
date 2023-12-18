package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 모든순열_10974 {
    private static int N;
    private static int[] results;
    private static boolean[] v; // 중복 체크 배열


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        results = new int[N];
        v = new boolean[N + 1];

        permutation(0);
    }

    private static void permutation(int index) {
        if (index == N) {
            String answer = Arrays.stream(results)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(answer);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (v[i]) continue;
            results[index] = i;
            v[i] = true;
            permutation(index + 1);
            v[i] = false;
        }
    }
}
