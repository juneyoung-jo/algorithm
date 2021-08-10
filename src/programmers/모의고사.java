package programmers;

public class 모의고사 {
	public int[] solution(int[] answers) {

		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] c = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int cntA = 0;
		int cntB = 0;
		int cntC = 0;

		for (int index = 0; index < answers.length; index++) {
			if (answers[index] == a[index % 5])
				cntA++;
			if (answers[index] == b[index % 8])
				cntB++;
			if (answers[index] == c[index % 10])
				cntC++;
		}

		int win = 0;
		if (win < cntA)
			win = cntA;
		if (win < cntB)
			win = cntB;
		if (win < cntC)
			win = cntC;

		int size = 0;
		if (win == cntA)
			size++;
		if (win == cntB)
			size++;
		if (win == cntC)
			size++;

		int[] answer = new int[size];
		int[] arr = new int[3];

		arr[0] = cntA;
		arr[1] = cntB;
		arr[2] = cntC;

		int i = 0;
		for (int s = 0; s < 3; s++) {
			if (arr[s] == win) {
				answer[i++] = s + 1;
			}
		}

		return answer;
	}
}
