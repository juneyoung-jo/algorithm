package softeer;

import java.util.Arrays;

public class sort {
	public static void main(String[] args) {

		int[] list = { 3, 9, 4, 7, 0, 5, 1, 6, 8, 2 };
//		System.out.println("정렬 전 : " + Arrays.toString(list));
//		selection(list);
//		insertion(list);
//		quick(list);
//		merge(list);
//		heap(list);
		count();
//		System.out.println("정렬 후 : " + Arrays.toString(list));

	}

	private static void count() {
		
		int[] arr = {5,4,3,2,1}; 		// [5, 4, 3, 2, 1 ]
		int[] sorted_arr = new int[5];
		// 과정 1 - counting 배열의 사이즈를 최대값 5가 담기도록 크게 잡기
		int[] counting = new int[6];	// 단점 : counting 배열의 사이즈의 범위를 가능한 값의 범위만큼 크게 잡아야 하므로, 비효율적이 됨.

		// 과정 2 - counting 배열의 값을 증가해주기.
		for (int i = 0; i < arr.length; i++) {
		    counting[arr[i]]++;
		}
		// 과정 3 - counting 배열을 누적합으로 만들어주기.
		for (int i = 1; i < arr.length; i++) {
		    counting[i] += counting[i - 1];
		}
		// 과정 4 - 뒤에서부터 배열을 돌면서, 해당하는 값의 인덱스에 값을 넣어주기.
		for (int i = arr.length - 1; i >= 0; i--) {
		    sorted_arr[counting[arr[i]]] = arr[i];
		    counting[arr[i]]--;
		}
		
		System.out.println(Arrays.toString(sorted_arr));
		
	}

	private static void heap(int[] arr) {

		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		
		// extract
		for (int i = n-1; i >= 0; i--) {
			swap(arr,0,i);
			heapify(arr, i, 0);
		}

	}

	private static void heapify(int[] arr, int n, int i) {

		int p = i;
		int l = i * 2 + 1;
		int r = i * 2 + 2;
		
		if( l < n && arr[p] < arr[l]) {
			p = l;
		}
		
		if( r < n && arr[p] < arr[r]) {
			p = r;
		}
		
		if(i != p) {
			swap(arr,p,i);
			heapify(arr,n,p);
		}

	}

	private static void merge(int[] arr) {
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length - 1);

	}

	private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, tmp, start, mid);
			mergeSort(arr, tmp, mid + 1, end);
			merge(arr, tmp, start, mid, end);
		}

	}

	private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
		// 임시저장소에 필요한만큼 복사
		for (int i = start; i <= end; i++) {
			tmp[i] = arr[i];
		}

		int part1 = start;
		int part2 = mid + 1;
		int idx = start;

		while (part1 <= mid && part2 <= end) {
			if (tmp[part1] <= tmp[part2]) {
				arr[idx] = tmp[part1];
				part1++;
			} else {
				arr[idx] = tmp[part2];
				part2++;
			}
			idx++;
		}

//		for (int i = 0; i <= mid-part1; i++) {
//			arr[idx + i] = tmp[part1 + i]; 
//		}
		// part2 부분이 먼저 끝나고 part1이 남았을 때
		while (part1 <= mid) {
			arr[idx] = tmp[part1];
			idx++;
			part1++;
		}

	}

	private static void quick(int[] arr) {
		quick(arr, 0, arr.length - 1);
	}

	private static void quick(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);
		// 왼쪽
		if (start < part2 - 1) {
			quick(arr, start, part2 - 1);
		}
		// 오른쪽
		if (part2 < end) {
			quick(arr, part2, end);
		}

	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start + end) / 2]; // 배열의 중간값

		while (start <= end) {
			// 시작점
			while (arr[start] < pivot)
				start++;
			while (arr[end] > pivot)
				end--;
			if (start <= end) {
				swap(arr, start, end);
				start++;
				end--;
			}

		}

		return start;
	}

	private static void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}

	public static void insertion(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int prev = i - 1;

			while ((prev >= 0) && (arr[prev] > temp)) {
				arr[prev + 1] = arr[prev];
				prev--;
			}

			arr[prev + 1] = temp;
		}
	}

	public static void Bubble(int[] list) {
		for (int i = 0; i < list.length; i++) {
			for (int j = 1; j < list.length; j++) {
				if (list[j - 1] > list[j]) {
					int tmp = list[j - 1];
					list[j - 1] = list[j];
					list[j] = tmp;
				}
			}
		}
	}

	public static void selection(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[index]) {
					index = j;
				}
			}

			int tmp = arr[i];
			arr[i] = arr[index];
			arr[index] = tmp;
		}
	}

}