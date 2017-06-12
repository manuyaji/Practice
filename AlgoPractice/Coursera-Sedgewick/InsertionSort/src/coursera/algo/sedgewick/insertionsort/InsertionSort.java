package coursera.algo.sedgewick.insertionsort;

import java.util.Random;

public class InsertionSort<T extends Comparable<T>> {
	
	public Comparable<T>[] sort(Comparable<T>[] input){
		if(input != null && input.length > 1){
			for(int i=1; i< input.length; i++){
				for(int j=i; j>0 && input[j-1].compareTo((T)input[j]) > 0; j--){
					Comparable<T> temp = input[j];
					input[j] = input[j-1];
					input[j-1] = temp;
				}
			}
		}
		return input;
	}
	
	public static void main(String args[]){
		InsertionSort<Integer> intSort = new InsertionSort<>();
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
