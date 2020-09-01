package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스타일리쉬들여쓰기_강의코드 {
	static int p, q;
	static char[][] master, own;
	static int[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			master = new char[p][];
			own = new char[q][];
			result = new int[q]; // 자신의 코드의 각 행마다 들여쓰기로 결정된 칸 수(-1 : 결정이 불가능한 값으로 사용)
			Arrays.fill(result, -2); // 처음 들여쓰기 시도하는 것으로 판단목적으로 -2로 초기화

			for (int i = 0; i < p; i++) {
				master[i] = in.readLine().toCharArray();
			} // 마스트 코드 라인별 입력
			for (int i = 0; i < q; i++) {
				own[i] = in.readLine().toCharArray();
			} // 자신의 코드 라인별 입력

			// 가능한 모든 r,c,s에 대해 다 시도해 봄
			for (int r = 1; r <= 20; r++) {
				for (int c = 1; c <= 20; c++) {
					for (int s = 1; s <= 20; s++) {
						if (isAvailable(r, c, s)) { // 마스터의 코드에 r,c,s를 적용하여 가능한지 판단.
							processIndent(r, c, s); // 본인의 코드에 해당 r,c,s를 적용해봄
						}
					}
				}
			}

			StringBuilder sb = new StringBuilder("#" + t);
			for (int r : result) {
				sb.append(" ").append(r);
			}
			System.out.println(sb.toString());
		}
	}

	private static void processIndent(int r, int c, int s) {

		int rCount = 0, cCount = 0, sCount = 0;

		for (int i = 0; i < q; i++) {
			if (result[i] == -2) { // 처음 들여쓰기 계산을 하는 경우라면
				result[i] = r * rCount + c * cCount + s * sCount;
			} else { // 들여쓰기 계산이 처음이 아닌 경우(다른, r,c,s의 해로도 들여쓰기가 가능했던 상황)
				if (result[i] != r * rCount + c * cCount + s * sCount) { // 둘의 들여쓰기 결과가 다르다면 들여쓰기 결정 불가능
					result[i] = -1;
				}
			}

			for (char ch : own[i]) {
				switch (ch) {
				case '(':
					rCount++;
					break;
				case ')':
					rCount--;
					break;
				case '{':
					cCount++;
					break;
				case '}':
					cCount--;
					break;
				case '[':
					sCount++;
					break;
				case ']':
					sCount--;
					break;
				}
			}

		}

	}

	private static boolean isAvailable(int r, int c, int s) {

		int rCount = 0, cCount = 0, sCount = 0;
		for (int i = 0; i < p; i++) {
			int cnt = 0;
			// 온점 개수 세기(맨 앞부터 연속된 온점개수만 세기)
			for (char ch : master[i]) {
				if (ch == '.')
					++cnt;
				else
					break;
			}
			int indent = r * rCount + c * cCount + s * sCount;

			if (indent != cnt)
				return false; // 계산된 들여쓰기 개수와 실제 마스터의 들여쓰기 개수가 다르면 r,c,s는 답이 될수 없음.

			for (char ch : master[i]) { // 현재행의 괄호들의 차이를 계산
				switch (ch) {
				case '(':
					rCount++;
					break;
				case ')':
					rCount--;
					break;
				case '{':
					cCount++;
					break;
				case '}':
					cCount--;
					break;
				case '[':
					sCount++;
					break;
				case ']':
					sCount--;
					break;
				}
			}
		}

		return true;
	}

}
