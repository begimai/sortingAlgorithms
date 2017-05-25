import java.util.*;

interface Generator {
	int[] generate(int n);
	String getName();	
}

interface Sorter {
	String getName();
	void sort(int[] a);
}

public class InterfacesForSortingAlgorithms {
	public static void main(String[] args) {
		printSortedResults(new InsertSorter(), new RandomArrayGenerator(), 800, 8);
		printSortedResults(new MergeSorter(), new RandomArrayGenerator(), 800, 8);
		printSortedResults(new QuickSorter(), new RandomArrayGenerator(), 800, 8);
		
		printSortedResults(new InsertSorter(), new SortedArrayGenerator(), 800, 8);
		printSortedResults(new MergeSorter(), new SortedArrayGenerator(), 800, 8);
		printSortedResults(new QuickSorter(), new SortedArrayGenerator(), 800, 8);
		
		printSortedResults(new InsertSorter(), new SortedInReverseArrayGenerator(), 800, 8);
		printSortedResults(new MergeSorter(), new SortedInReverseArrayGenerator(), 800, 8);
		printSortedResults(new QuickSorter(), new SortedInReverseArrayGenerator(), 800, 8);		
	}
	
	static void printSortedResults(Sorter sorter, Generator gen, int size, int n) {
		System.out.println(sorter.getName());
		System.out.println(gen.getName());
		long prevTime = 0;
		for(int i = 0; i < n; ++i) {
			int[]a = gen.generate(size);
			long beg = System.currentTimeMillis();
			sorter.sort(a);
			long end = System.currentTimeMillis();
			long currTime = end - beg;
			String ratio = "-";
			if (prevTime != 0) {
				ratio = String.format("%.2f", (double)currTime / prevTime);
			}
			System.out.printf("%20d %20d %20s %n", size, currTime, ratio);
			prevTime = currTime;
			size *= 2;
		}
		System.out.println("\n");
	}
}

class InsertSorter implements Sorter {
	public String getName() {
		return "Insertion Sort";
	}
	
	public void sort(int[] a) {
		SortAlgorithms.insertionSort(a);
	}
}

class MergeSorter implements Sorter {
	public String getName() {
		return "Merge Sort";
	}
	
	public void sort(int[] a) {
		SortAlgorithms.mergeSort(a);
	}
}

class QuickSorter implements Sorter {
	public String getName() {
		return "Quick Sort";
	}
	
	public void sort(int[] a) {
		SortAlgorithms.quickSort(a);
	}
}

class RandomArrayGenerator implements Generator {
	public String getName() {
		return "Random Array Generator";
	}
	public int[] generate(int n) {
		Random rnd = new Random(1);
		int[] r = new int[n];
		for(int i = 0; i < n; ++i) {
			r[i] = rnd.nextInt();
		}
		return r;
	}
}

class SortedArrayGenerator implements Generator {
	public String getName() {
		return "Sorted Array Generator";
	}
	public int[] generate(int n) {
		int[] r = new int[n];
		for(int i = 0; i < n; ++i) {
			r[i] = i;
		}
		return r;
	}
}

class SortedInReverseArrayGenerator implements Generator {
	public String getName() {
		return "Sorted In Reverse Array Generator";
	}
	public int[] generate(int n) {
		int[] r = new int[n];
		for(int i = 0; i < n; ++i) {
			r[i] = n - i;
		}
		return r;
	}
}
