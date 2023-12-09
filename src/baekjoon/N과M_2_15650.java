package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N과M_2_15650 {

    private static int N, M;
    private static int[] answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        answer = new int[M];

        combination(0, 1);

    }

    private static void combination(int index, int start) {
        if (index == M) {
            String result = Arrays.stream(answer)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(result);
            return;
        }

        for (int i = start; i <= N; i++) {
            answer[index] = i;
            combination(index + 1, i + 1);
        }
    }
}
