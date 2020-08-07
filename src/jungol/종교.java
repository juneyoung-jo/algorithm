package jungol;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 종교 {

	static int T, N, K, M, ANS = 1;
	static int cnt;
	static int[][] map;
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};
	static boolean[][]visited;
	static boolean[]alphabet;
	static class Point {
		int r,c,day;
		Point(int r, int c){
			this.r=r;
			this.c=c;
			
		}
	}
	static int[] parents;
	static int[] rank;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/종교.txt"));
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		parents=new int[N+1];
		rank=new int[N+1];
		//makeSet
		
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}
		for (int i = 0; i < M; i++) {
			union(sc.nextInt(),sc.nextInt());
		}
		ANS=0;
		for (int i = 1; i <= N; i++) {
			if(i==parents[i]) {
				ANS++;
			}
		}
		System.out.printf("%d\n",ANS);
	}
	
	private static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		parents[px]=py;
	}

	private static int findSet(int x) {
		if(parents[x]==x) {
			return x;
		}
		return findSet(parents[x]);
	}

	private static void makeSet(int x) {
		parents[x]=x;
	}

	private static boolean check(int nr, int nc) {
		if(nr>=0&&nr<N&&nc>=0&&nc<N) {
			return true;
		}
		return false;
	}
	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
}
