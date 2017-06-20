package coursera.algo.sedgewick.shellsort;

import java.util.Random;

public class ShellSort<T extends Comparable<T>> {
	
	private boolean less(Comparable<T>[] arr, int i, int j){
		if(arr[i].compareTo((T)arr[j]) < 0){
			return true;
		}
		return false;
	}
	
	private void swap(Comparable<T>[] arr, int i, int j){
		Comparable<T> temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public Comparable<T>[] sort(Comparable<T>[] arr){
		if(arr == null || arr.length == 1){
			return arr;
		}
		int h = 1;
		while(h < arr.length){
			h = h * 3 + 1;
		}
		while(h >= 1){
			for(int i=0; i<arr.length-h; i++){
				for(int j=i; (j-h)>=0 && less(arr, j, j-h); j=j-h){
					swap(arr, j, j-h);
				}
			}
			h = h/3;
		}
		return arr;
	}
	
	public static void main(String args[]){
		ShellSort<Integer> intSort = new ShellSort<>();
		Integer[] arr = (Integer[])intSort.sort(new Integer[]{10,54,64,12,63,13,68});
		displayIntArray(arr);
		System.out.println();
		System.out.println("==========================");
		Integer[] test = constructRandomIntArray(20, 0, 1000);
		displayIntArray(test);
		System.out.println();
		intSort.sort(test);
		displayIntArray(test);
		System.out.println();
	}
	
	private static Integer[] constructRandomIntArray(int n, int lowerBound, int upperBound){
		Random rnd = new Random(System.currentTimeMillis());
		Integer[] ret = new Integer[n];
		for(int i=0; i<n; i++){
			ret[i] = lowerBound + rnd.nextInt(upperBound - lowerBound + 1);
		}
		return ret;
	}
	
	private static void displayIntArray(Integer[] arr){
		if(arr == null){
			System.out.println("NULL");
		}
		else if(arr.length == 0){
			System.out.println("Array is empty");
		}
		else{
			for(int i=0; i<arr.length; i++){
				System.out.print(arr[i]+", ");
			}
		}
	}

}
