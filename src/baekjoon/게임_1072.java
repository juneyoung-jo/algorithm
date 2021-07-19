package baekjoon;
import java.util.*;

public class 게임_1072 {
	static int ans;
	static long X,Y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextLong();
		Y = sc.nextLong();
		int Z = cal(X,Y);
		int start = 0;
		int end = 2000000001;
		
		if(Y == X || Z == 99) {
		}else {
			while(start <= end) {
				int mid = (start + end) / 2;
				if(cal(X+mid,Y+mid) >= Z+1) {
					end = mid - 1;
					ans = mid;
				}else{
					start = mid + 1;
				};
			}
		}
		
		System.out.println(ans == 0 ? -1 : ans);

	}
	
	private static int cal(long x, long y) {
		long num = (y*100)/x ;
		return (int)num;
	}

}
