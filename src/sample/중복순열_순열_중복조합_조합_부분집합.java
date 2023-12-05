package sample;

import java.util.Arrays;
import java.util.Scanner;

public class 중복순열_순열_중복조합_조합_부분집합 {

    static int N, numbers[], totalCnt;
    static boolean[] isSelected;
    static int[] number = {1, 3, 5};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        numbers = new int[N];
        isSelected = new boolean[7];

        // 중복순열
//         permutation1(0);
        // 순열
//         permutation2(0);
        // 중복조합
         combination1(0, 1);
        // 조합
//         combination2(0, 1);
        // 부분집합
//        powerSet(0);
        System.out.println(totalCnt);

    }

    // 부분집합
    private static void powerSet(int idx) {
        if (idx == N) {
            for (int i = 0; i < isSelected.length; i++) {
                if (isSelected[i]) {
                    System.out.print(number[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        isSelected[idx] = true;
        powerSet(idx + 1);
        isSelected[idx] = false;
        powerSet(idx + 1);

    }

    // 조합
    private static void combination2(int idx, int start) {
        if (idx == N) {
            ++totalCnt;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = start; i <= 6; i++) {
            numbers[idx] = i;
            combination2(idx + 1, i + 1);
        }
    }

    // 중복 조합
    private static void combination1(int idx, int start) {
        if (idx == N) {
            ++totalCnt;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = start; i <= 6; i++) {
            numbers[idx] = i;
            combination1(idx + 1, i);
        }

    }

    // 순열
    private static void permutation2(int idx) {
        if (idx == N) {
            ++totalCnt;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 1; i <= 6; i++) {
            if (isSelected[i]) continue;
            numbers[idx] = i;
            isSelected[i] = true;
            permutation2(idx + 1);
            isSelected[i] = false;
        }

    }

    // 중복 순열
    private static void permutation1(int idx) {
        if (idx == N) {
            ++totalCnt;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 1; i <= 6; i++) {
            numbers[idx] = i;
            permutation1(idx + 1);
        }

    }
}
