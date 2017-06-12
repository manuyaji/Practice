package coursera.algo.sedgewick.selectionsort;

import java.util.Random;

public class SelectionSort<T extends Comparable<T>> {
	
	public Comparable<T>[] sort(Comparable<T>[] input){
		if(input != null && input.length > 1){
			int minIndex = -1;
			for(int i=0; i<input.length; i++){
				minIndex = i;
				for(int j=i+1; j<input.length; j++){
					if(input[minIndex].compareTo((T)input[j]) > 0){
						minIndex = j;
					}
				}
				if(minIndex != i){
					Comparable<T> temp = input[i];
					input[i] = input[minIndex];
					input[minIndex] = temp;
				}
			}
		}
		return input;
	}
	
	public static void main(String args[]){
		SelectionSort<Integer> intSort = new SelectionSort<>();
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
