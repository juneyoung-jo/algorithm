package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @author THKim
 *
 */
public class 줄기세포배양_강의코드 {

	static int N,M,K, map[][];
	static boolean[][] visited;
	static PriorityQueue<Cell> pQueue;
	static final int I=0,A=1,D=2;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static class Cell implements Comparable<Cell>{
		int r,c,x,time,status; // 행,열,생명력, 흐른시간(음수부터 출발),상태

		public Cell(int r, int c, int x) {
			super();
			this.r = r;
			this.c = c;
			this.x = x;
			this.time = -x;
			// 상태는 기본값이 0으로 비활성 
		}
		@Override
		public String toString() {
			return "Cell [r=" + r + ", c=" + c + ", x=" + x + ", time=" + time + ", status=" + status + "]";
		}
		@Override
		public int compareTo(Cell o) {
			return Integer.compare(o.x, this.x); // 비교값이 음수/양수가 섞여있을때 일어날수 있는 오버플로우,언더플로우를 방지한다.
		}
		public void flowTime() {
			time++;
			if(time == 0 || time == x) status++; // 흐른시간이 0 : 활성상태가 되어야함.
												// 흐른시간이 x : 죽음상태가 되어야함.
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    int TC = Integer.parseInt(in.readLine().trim());
	    StringTokenizer st = null;
	    for(int t=1; t<=TC; ++t) {
	        st = new StringTokenizer(in.readLine().trim());
	        N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        K = Integer.parseInt(st.nextToken());
	        map = new int[N+K][M+K];
	        visited = new boolean[N+K][M+K];
	        pQueue = new PriorityQueue<Cell>();
	        
	        for(int i=K/2,iCnt=0; iCnt<N; ++i,++iCnt) {
	            st = new StringTokenizer(in.readLine().trim()," ");
	            for(int j=K/2,jCnt=0; jCnt<M; ++j,++jCnt) {
	                map[i][j] = Integer.parseInt(st.nextToken());
	                if(map[i][j]>0) { // 생명력이 있다면 줄기세포임 
	                    visited[i][j] = true; // 이미 번식된 처리
	                    pQueue.offer(new Cell(i, j, map[i][j])); // PQ에 넣기
	                }
	            }
	        } // 배양가능한 크기의 배열을 이용하여 중앙에  N*M 초기 배양상태를 저장
	        
	        System.out.println("#"+t+" "+process());
	    }// end TC
	}//end main
	
   private static int process() {
    	int t = K,nr,nc;
    	
    	Cell cell;
    	ArrayList<Cell> list = new ArrayList<Cell>(); //죽음 상태가 아니어서 다음 반복시 처리해야하는 줄기세포 저장할 임시 리스트
    	
    	while(t-->0) { // k시간만큼 진행
    		// 매시간마다 모든 줄기세포에 대해 시간의 흐름에 따른 처리
    		while(!pQueue.isEmpty()) {
    			cell = pQueue.poll();
    			
    			// 줄기세포의 상태가 활성상태이며 활성화된 첫시간에만 번식
    			if(cell.status==A && cell.time == 0) {
    				for (int d = 0; d < 4; d++) { // 4방으로 자신과 같은 생명력을 갖는 줄기세포 번식
						nr = cell.r + dr[d];
						nc = cell.c + dc[d];
						if(visited[nr][nc]) continue; // 다른줄기세포가 이미 번식시킨 자리라면 건너뜀(번식 불가)
						visited[nr][nc] = true; // 무조건 번식 시킴(뒤에 오는 줄기세포는 생명력이 같거나 작다)
						list.add(new Cell(nr, nc, cell.x)); // 새로운 줄기세포는 자신을 번식시키는 모줄기세포와 같은 생명력으로 생성
					}
    			}
    			
    			// 모든 세포에 흐른 시간 처리
    			cell.flowTime();
    			
    			if(cell.status == D) continue; // 죽은 줄기세포는 리스트에 추가하지 않고 다음 줄기세포 처리하러 continue
    			list.add(cell); // 죽지 않고 살아 있는 줄기세포 리스트에 추가
    		}// 매 시간 처리
    		
    		pQueue.addAll(list); // 죽지 않고 살아있는 줄기세포들을 pQueue에 다음처리 위해 넣기.
    		list.clear(); // 다음 처리를 위해 리스트를 비운다.
    	}
    	
    	return pQueue.size();
    }

}
	