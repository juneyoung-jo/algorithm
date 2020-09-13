package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author THKim
 *
 */
public class 보호필름_강의코드 {

	static int D, W, K, map[][], list[], min;
	static final int NOT = -1, A = 0, B = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		for (int t = 1; t <= TC; ++t) {
			st = new StringTokenizer(in.readLine().trim());
			D = Integer.parseInt(st.nextToken()); // 행
			W = Integer.parseInt(st.nextToken()); // 열
			K = Integer.parseInt(st.nextToken()); // 합격기준
			map = new int[D][W]; // 보호필름 막 정보
			list = new int[D]; // 투여된 약품의 상태 정보를 관리할 배열
			min = K;

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 막정보 입력

			Arrays.fill(list, NOT); // 약품을 비투여 상태로 만듦
			if(check()) { // 약품을 하나도 사용하지 않은 상태로 체크
				min = 0;
			}else { // 약품을 하나도 사용하지 않는것이 불가능하다면 약품사용하는 시도
				process(0, 0);
			}
			System.out.println("#" + t + " " + min);
		} // end TC
	}// end main

	private static void process(int row, int cnt) {

		if (cnt>=min) return; // 가지치기 
		if (row == D) { // 끝까지 다 시도했다면
			// 해당 보호필름의 상태가 통과기준에 부합하는 지 체크
			// 통과한다면 이때 쓰인 약품의 개수를 이용하여 최소값 갱신로직
			if (check()) {
				if (min > cnt)
					min = cnt;
			}
			// 통과못한다면 답이 될수 없다
			return;
		}

		// 약품 투여(A)
		list[row] = A;
		process(row + 1, cnt + 1);
		// 약품 투여(B)
		list[row] = B;
		process(row + 1, cnt + 1);

		// 약품 비투여
		list[row] = NOT;
		process(row + 1, cnt);

	}

	
	// D= 4
	// A A A A
	// A A A B
	// A A A N
	// A A B A
	// A A B B
	// A A B N
	// A A N A
	// A A N B
	// A A N N	
	
	
	// 분석하자 -> 시간줄이는 방법임. 
	
	private static boolean check() { 
		// 열 우선탐색(수직으로 연속된 K개를 체크)
		for (int j = 0; j < W; j++) {
			int before = list[0]==NOT?map[0][j]:list[0]; // 첫행의 약품의 투여 상태가 비투여상태이면 보호필름셀 그대로 아니면 약품값
			int count = 1;
			for (int i = 1; i < D; i++) { // 1행부터 마지막행까지 직전과 자기자신이 셀의 연속성 체크
				int current = list[i]==NOT?map[i][j]:list[i];// 현재행의 약품의 투여 상태가 비투여상태이면 보호필름셀 그대로 아니면 약품값
				if(before != current) {// 인접한 2개 셀이 다르다면
					before = current;
					count = 1;
				}else { // 인접한 2개 셀이 같다면 
					if(++count>=K) break; // 연속셀의 갯수가 K이상이면 더이상 연속성 체크하지 않는다.
				}	
			}
			if(count<K) return false;
		}
		return true;
	}

}


