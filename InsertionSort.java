import java.util.*;

public class InsertionSort {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		for(int i = 0; i < n; ++i) {
			array[i] = scan.nextInt();
		}
		
		System.out.print("Before sort: ");
		printArray(array);
		insertionSort(array);
		System.out.print("After sort: ");
		printArray(array);
	}
	
	static void printArray(int[] a) {
		for(int i = 0; i < a.length; ++i) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	static void insertionSort(int[] a) {
		if (a == null) {
			throw new NullPointerException();
		}
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
}
