package datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class test {
	
	public static void main(String[] args) {
		
		List<Integer> arr = new LinkedList<>();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>((o1,o2) -> o2-o1);
		
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(1);
		q.add(2);
		q.add(3);
		
		
		System.out.println(q.peek());
		while(!q.isEmpty()) {
			System.out.println(q.poll());
			
		}
		
		
//		System.out.println(arr.);
		
		
		
	}

}
