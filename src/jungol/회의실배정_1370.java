package jungol;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;



public class 회의실배정_1370 {
	static class Room implements Comparable<Room>{
		int num;
		int sTime;
		int eTime;
		Room(int num, int sTime, int eTime){
			this.num = num;
			this.sTime= sTime;
			this.eTime = eTime;
		}
		
		@Override
		public int compareTo(Room o) {
			// TODO Auto-generated method stub
			return eTime - o.eTime;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return num + " ";
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt( in.readLine());
		ArrayList<Room> list = new ArrayList();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			list.add(new Room(
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		ArrayList<Room> assign = new ArrayList<Room>();
		assign.add(list.get(0));
		int eTime = list.get(0).eTime;
		int cnt = 1;
		for (int i = 1; i < list.size(); i++) {
			if(eTime <= list.get(i).sTime) {
				cnt++;
				eTime = list.get(i).eTime;
				assign.add(list.get(i));
			}
		}
		System.out.println(cnt);
		for (int i = 0; i < assign.size(); i++) {
			System.out.print(assign.get(i).toString());
		}
	}

}
