package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
*/
public class 파이프옮기기1bfs_강의코드1 {

	static int N;
	static int[][] map;
	static int ans = 0;
	static int[] dr = { 0, 0, 1, 1};
	static int[] dc = { 0, 1, 1, 0};
	static int dir = -1;
	static int cnt=0;
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/파이프옮기기1.txt"));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 2][N + 2];
		
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		//print(map);
		bfs(1, 2, 1);
		
		System.out.println(cnt);
	}
	static class Point{
		int r,c,dir;
		Point(int r,int c, int dir){
			this.r=r;
			this.c=c;
			this.dir=dir;
		}
	}
	private static void bfs(int r, int c, int dir) {
		Queue<Point>Q=new LinkedList<Point>();
		Q.add(new Point(r, c, dir));
		
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			if(p.r==N&&p.c==N) {
				cnt++;
			}
			if(p.dir==1) {
				for (int k = 1; k <= 2; k++) {
					int nr = p.r+dr[k];
					int nc = p.c+dc[k];
					if(nr>=1&&nr<=N&&nc>=0&&nc<=N&&check(p.r,p.c,k)) {
						
						Q.add(new Point(nr, nc, k));
						
					}
				}
			}else if(p.dir==2) {
				for (int k = 1; k <= 3; k++) {
					int nr = p.r+dr[k];
					int nc = p.c+dc[k];
					if(nr>=1&&nr<=N&&nc>=0&&nc<=N&&check(p.r,p.c,k)) {
						Q.add(new Point(nr, nc, k));
						
					}
				}
			}else if(p.dir==3) {
				for (int k = 2; k <= 3; k++) {
					int nr = p.r+dr[k];
					int nc = p.c+dc[k];
					if(nr>=1&&nr<=N&&nc>=0&&nc<=N&&check(p.r, p.c, k)) {
						Q.add(new Point(nr, nc, k));
					}
				}
			}
		}
		
	}
	
	private static void dfs(int r, int c,int dir) {
		if(r==N&&c==N) {
			cnt++;
			return ;
		}
		if(dir==1) {
			for (int k = 1; k <= 2; k++) {
				int nr = r+dr[k];
				int nc = c+dc[k];
				if(nr>=1&&nr<=N&&nc>=0&&nc<=N&&check(r,c,k)) {
					dfs(nr,nc,k);
					
				}
			}
		}else if(dir==2) {
			for (int k = 1; k <= 3; k++) {
				int nr = r+dr[k];
				int nc = c+dc[k];
				if(nr>=1&&nr<=N&&nc>=0&&nc<=N&&check(r,c,k)) {
					dfs(nr,nc,k);
					
				}
			}
		}else if(dir==3) {
			for (int k = 2; k <= 3; k++) {
				int nr = r+dr[k];
				int nc = c+dc[k];
				if(nr>=1&&nr<=N&&nc>=0&&nc<=N&&check(r,c,k)) {
					dfs(nr,nc,k);
					
				}
			}
		}
		
	}

	private static boolean check(int r, int c, int k) {
		if(k==1) {
			if(map[r][c+1]==0) {
				return true;
			}
		}else if(k==2) {
			if(map[r][c+1]==0&&map[r+1][c+1]==0&&map[r+1][c]==0) {
				return true;
			}
		}else if(k==3) {
			if(map[r+1][c]==0) {
				return true;
			}
		}
		return false;
	}

	private static void print(int[][] map) {
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c < map[r].length; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
}