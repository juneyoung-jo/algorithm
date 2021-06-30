package baekjoon;
import java.io.*;
import java.util.*;

public class boj4연산_14395 {
	
	static long s,t;
	static Set<Long> v = new HashSet<>();
	static class Point implements Comparable<Point>{
		long i;
		String str;
		int len;
		
		public Point(long i,String str,int len) {
			this.i = i;
			this.str = str;
			this.len = len;
		}

		@Override
		public int compareTo(Point o) {
			
			if(this.len == o.len) return this.str.compareTo(o.str);
			return this.len-o.len;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		t = sc.nextInt();
		
		if(s == t) System.out.println(0);
		else {
			String cal = cal();
			System.out.println(cal.equals("") ? -1 : cal);
		}
		
	}

	private static String cal() {
		PriorityQueue<Point> q = new PriorityQueue<>();
		v.add(s);
		v.add(1L);
		q.add(new Point(s,"",0));
		q.add(new Point(1,"/",1));
		Point p = null;
		while(!q.isEmpty()) {
			p = q.poll();
			
			if(p.i == t) return p.str;
			if(p.i > t) continue;
			
			long mul = p.i*p.i;
			long plus = p.i*2;
			
			if(!v.contains(mul)) {
				v.add(mul);
				q.add(new Point(mul,p.str+"*",p.len+1));
			}
			
			if(!v.contains(plus)) {
				v.add(plus);
				q.add(new Point(plus,p.str+"+",p.len+1));
			}
			
		}
		
		return "";
		
	}

}
