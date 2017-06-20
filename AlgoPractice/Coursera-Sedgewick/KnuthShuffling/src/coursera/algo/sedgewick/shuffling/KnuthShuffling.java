package coursera.algo.sedgewick.shuffling;

import java.util.Random;

public class KnuthShuffling<T> {
	
	public T[] shuffle(T[] arr){
		if(arr == null || arr.length == 0){
			return arr;
		}
		else{
			Random random = new Random();
			int r = -1;
			for(int i=0; i< arr.length; i++){
				r = random.nextInt(i+1);
				swap(arr, i, r);
			}
			return arr;
		}
	}
	
	private void swap(T[] arr, int i, int j){
		T temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}
