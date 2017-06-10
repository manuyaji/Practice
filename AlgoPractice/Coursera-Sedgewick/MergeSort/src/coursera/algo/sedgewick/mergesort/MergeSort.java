package coursera.algo.sedgewick.mergesort;

import java.util.Random;

public class MergeSort<T> {
	
	public MergeSort(){
	}
	
	public Comparable<T>[] sort(Comparable<T>[] input){
		//Trivial Case
		if(input == null || input.length <= 1){
			return input;
		}
		else{
			divideAndMerge(input, 0, input.length-1);
			return input;
		}
	}
	
	protected void divideAndMerge(Comparable<T>[] array, int low, int high){
		if(low != high){
			int mid = (low + high)/2;
			divideAndMerge(array, low, mid);
			divideAndMerge(array, mid+1, high);
			merge(array, low, mid, high);
		}
	}
	
	private Comparable<T>[] constructTemporaryArray(Comparable<T>[] array, int low, int high){
		Comparable<T>[] newArr = new Comparable[array.length];
		for(int m=low; m<=high; m++){
			newArr[m] = array[m];
		}
		return newArr;
	}
	
	protected void merge(Comparable<T>[] array, int low, int mid, int high){
		if(array != null && array.length != 0 && low >=0 && high<array.length && high >= low && mid>=low && mid<=high){
			int i = low;
			int j = mid+1;
						
			Comparable<T>[] newArr = constructTemporaryArray(array, low, high);
			
			for(int k=low; k<=high; k++){
				if(i > mid){
					array[k] = newArr[j];
					j++;
				}
				else if(j > high){
					array[k] = newArr[i];
					i++;
				}
				else if(newArr[i].compareTo((T)newArr[j]) <= 0){
					array[k] = newArr[i];
					i++;
				}
				else{
					array[k] = newArr[j];
					j++;
				}
			}
		}
	}
	
	public static void main(String args[]){
		MergeSort<Integer> intSort = new MergeSort<>();
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
