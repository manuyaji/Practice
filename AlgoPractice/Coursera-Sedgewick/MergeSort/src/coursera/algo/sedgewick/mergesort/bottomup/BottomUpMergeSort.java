package coursera.algo.sedgewick.mergesort.bottomup;

import java.util.Random;

import coursera.algo.sedgewick.mergesort.MergeSort;
import coursera.algo.sedgewick.mergesort.normal.NormalMergeSort;

public class BottomUpMergeSort<T> implements MergeSort<T> {

	@Override
	public Comparable<T>[] sort(Comparable<T>[] input) {
		if(input == null || input.length <= 1){
			return input;
		}
		else{
			for(int i=1; i<input.length+1; i=i*2){
				for(int p=0; p<input.length; p=i+2*i){
					int low = i;
					int mid = i+i-1;
					int high = Math.min(i+2*i-1, input.length);
					merge(input, low, mid, high);
				}
			}
			return input;
		}
	}
	
	private Comparable<T>[] constructTempArray(Comparable<T>[] arr, int low, int high){
		Comparable<T>[] ret = new Comparable[arr.length];
		for(int i=low; i<=high; i++){
			ret[i] = arr[i];
		}
		return ret;
	}
		
	protected Comparable<T>[] merge(Comparable<T>[] arr, int low, int mid, int high){
		if(arr != null && arr.length > 1){
			Comparable<T>[] temp = constructTempArray(arr, low, high);
			int left = low;
			int right = mid + 1;
			for(int k = low; k<=high; k++){
				if(left > mid){
					arr[k] = temp[right++];
				}
				else if(right > high){
					arr[k] = temp[left++];
				}
				else if(temp[left].compareTo((T)temp[right]) <= 0){
					arr[k] = temp[left++];
				}
				else{
					arr[k] = temp[right++];
				}
			}
		}
		return arr;
	}
	
	
	public static void main(String args[]){
		NormalMergeSort<Integer> intSort = new NormalMergeSort<>();
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
