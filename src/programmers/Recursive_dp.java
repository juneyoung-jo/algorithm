package programmers;

public class Recursive_dp {
	/*
	 *1 ~ 10  ++  
	 */ 
	static int[] memo = new int[10+1];
	public static void main(String[] args) {
		//1. 재귀를 이용(인자를 이용)
//		cal(1,0);
		
		// 2.return을 이용한 재귀
//		System.out.println(add_return(1));
		
		// 3. memoization
		int Ans = add_memo(10);
		System.out.println(Ans);
	}

	private static int add_memo(int idx) {
		if(idx == 1) {
			
			return 1;
		}
		
		if(memo[idx] != 0) return memo[idx];
		return memo[idx] = idx + add_memo(idx-1);
	}

	private static int add_return(int idx) {
		// TODO Auto-generated method stub
		if(idx == 10) {
			return 10;
		}
		
		return idx + add_return(idx+1);
		
	}

	private static void cal(int idx,int sum) {
		if(idx == 11) {
			System.out.println(sum);
			return;
		}
		
		cal(idx+1,sum+idx);
	}
	

}
