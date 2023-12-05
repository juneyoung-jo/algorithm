package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class N과M_15649 {

    private static int N, M;
    private static int[] num;
    private static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[M];
        v = new boolean[N + 1];

        permutation(0);
    }

    private static void permutation(int index) {
        if (index == M) {
            String result = Arrays.stream(num)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(result);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (v[i]) continue;
            num[index] = i;
            v[i] = true;
            permutation(index + 1);
            v[i] = false;
        }
    }
}
