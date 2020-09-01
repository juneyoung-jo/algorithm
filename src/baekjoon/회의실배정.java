package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 회의실배정 {
	static int N;
	static Time[] time;

	static class TimeCompare implements Comparator<Time> {
		int ret;

		@Override
		public int compare(Time o1, Time o2) {
			if (o1.end < o2.end) {
				ret = -1;
			} else {
				ret = 1;
			}
			if (o1.end == o2.end) {
				if (o1.start < o2.start) {
					ret = -1;
				} else {
					ret = 1;
				}

			}

			return ret;
		}

	}

	static class Time {
		int start, end;

		public Time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		time = new Time[N];
		for (int i = 0; i < N; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			time[i] = new Time(start, end);
		}

		Arrays.sort(time, new TimeCompare()); // 정렬완료

		int cnt = 1;
		int num = 0;
		for (int i = 1; i < time.length; i++) {
			if (time[num].end <= time[i].start) {
				cnt++;
				num = i;
			}
		}

		System.out.println(cnt);
	}

	private static void print(Time[] time) {
		for (Time time1 : time) {
			System.out.println(time1.start + " : " + time1.end);
		}
	}

}
