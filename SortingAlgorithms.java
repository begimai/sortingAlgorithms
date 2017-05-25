import java.util.*;

public class SortingAlgorithms {
	static void insertionSort(int[] a) {
		for(int i = 1; i < a.length; ++i) {
			int k = a[i];
			int j = i - 1;
			while(j > - 1 && a[j] > k) {
				a[j + 1] = a[j];
				--j;
			}
			a[j + 1] = k;
		}
	}
	
	static void mergeSort(int[] a) {
		if (a == null) {
			throw new NullPointerException();
		}
		int[] t = new int[a.length];
		mergeSortAux(a, t, 0, a.length - 1);
	}
	
	private static void mergeSortAux(int[] a, int[] t, int first, int last) {
		if(first < last) {
			int m = first + (last - first) / 2;
			mergeSortAux(a, t, first, m);
			mergeSortAux(a, t, m + 1, last);
			merge(a, t, first, m, last);
		}
	}
	
	private static void merge(int[] a, int[] t, int first, int m, int last) {
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
	
	static void quickSort(int[] a) {
		if (a == null) {
			throw new NullPointerException();
		}
		Random rnd = new Random();
		quickSortAux(a, 0, a.length - 1, rnd);
	}
	
	private static void quickSortAux(int[] a, int first, int last, Random rnd) {
		
		if(first < last) {
			int p = partition(a, first, last, rnd);
			quickSortAux(a, first, p - 1, rnd);
			quickSortAux(a, p + 1, last, rnd);
		}
	}
	
	private static int partition(int[] a, int first, int last, Random rnd) {
		int j = first + rnd.nextInt(last - first + 1);
		swap(a, j, last);
		int p = a[last];
		int k = first - 1;
		for(int i = first; i < last; ++i) {
			if(a[i] < p) {
				swap(a, ++k, i);
			}
		}
		swap(a, ++k, last);
		return k;
	}
	
	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
