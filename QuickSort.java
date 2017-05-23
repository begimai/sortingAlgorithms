import java.util.*;

public class QuickSort
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] a = new int[n];
		
		for(int i = 0; i < n; ++i)
		{
			a[i] = scan.nextInt();
		}
			
		quickSort(a); 
		
		printArray(a);
	}
	
	static void printArray(int[] a)
	{
		for (int i = 0; i < a.length; ++i)
		{
			System.out.print(a[i] + " ");
		}		
		System.out.println();
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
