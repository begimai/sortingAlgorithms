import java.util.*;

public class p02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		for(int i = 0; i < n; ++i) {
			array[i] = scan.nextInt();
		}
		
		mergeSort(array);
		printArray(array);
	}
	
	static void printArray(int[] a) {
		for(int i = 0; i < a.length; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	static void mergeSort(int[] a) {
		if (a == null) {
			throw new NullPointerException();
		}
		int[] t = new int[a.length];
		mergeSortAux(a, t, 0, a.length - 1);
	}
	
	static void mergeSortAux(int[] a, int[] t, int first, int last) {
		if(first < last) {
			int m = first + (last - first) / 2;
			mergeSortAux(a, t, first, m);
			mergeSortAux(a, t, m + 1, last);
			merge(a, t, first, m, last);
		}
	}
	
	static void merge(int[] a, int[] t, int first, int m, int last) {
		int i = first;
		int j = m + 1;
		int k = 0;
		while(i <= m && j <= last) {
			if(a[j] < a[i]) {
				t[k++] = a[j++];
			}
			else {
				t[k++] = a[i++];
			}
		}
		while(i <= m) {
			t[k++] = a[i++];
		}
		while(j <= last) {
			t[k++] = a[j++];
		}
		
		for(i = first, k = 0; i <= last; ++i, ++k) {
			a[i] = t[k];
		}
	}
}
