package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이_2309 {

    private static final int N = 9, M = 7;
    private static final int[] height = new int[N];
    private static final int[] result = new int[M];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            height[i] = sc.nextInt();
        }

        combination(0, 0);

    }

    private static void combination(int index, int start) {
        if (index == M) {
            int sum = Arrays.stream(result).sum();
            if (sum == 100) {
                Arrays.stream(result)
                        .sorted()
                        .forEach(System.out::println);
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < N; i++) {
            result[index] = height[i];
            combination(index + 1, i + 1);
        }
    }
}
