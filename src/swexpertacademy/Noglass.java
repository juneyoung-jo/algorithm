package swexpertacademy;

import java.util.Scanner;

public class Noglass {
	static int T, N;
	static String str_1, str_2;
	static int[] array = { 1, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 };
	//A~Z까지 원 개수
	static char[] arr_1;
	static char[] arr_2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			str_1 = sc.next();
			str_2 = sc.next();

			int str1_size = str_1.length();
			int str2_size = str_2.length();

			arr_1 = new char[str1_size]; //배열생성
			arr_2 = new char[str2_size];

			for (int j = 0; j < str1_size; j++) {//배열에 값 입력
				arr_1[j] = str_1.charAt(j);
			}

			for (int j = 0; j < str2_size; j++) {
				arr_2[j] = str_2.charAt(j);
			}
			int count1 = 0;
			for (int i = 0; i < arr_1.length; i++) { // B의 갯수 구하기
				if (arr_1[i] == 'B') {
					count1++;
				}
			}
			int count2 = 0;
			for (int i = 0; i < arr_2.length; i++) { // B의 갯수 구하기
				if (arr_2[i] == 'B') {
					count2++;
				}
			}

			if (str1_size == str2_size) {
				if (count1 == count2) {
					for (int i = 0; i < arr_2.length; i++) {
						if(array[arr_1[i]%65] != array[arr_2[i]%65]) {
							System.out.println("#" + tc + " " + "DIFF");
							break;
						}
						if(i == arr_2.length-1) {
							System.out.println("#" + tc + " " + "SAME");
						}
						
					}
				} else {
					System.out.println("#" + tc + " " + "DIFF");
				}
			} else {
				System.out.println("#" + tc + " " + "DIFF");

			}
		}
		sc.close();

	}

}
/* 1. 입력값의 크기가 다른경우 ex) BBBB BBB : 4개,3개
 * 2. B의 개수 구해서 비교
 * 3. 각 자리 별로 65를 나눈 나머지(%)를구해 생성해둔 arr와 비교
 * */

