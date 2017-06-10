package coursera.algo.sedgewick.queues.strings.arrays;

import coursera.algo.sedgewick.queues.Queue;

public class QueueOfStrings implements Queue<String> {

	private String[] arr;
	private int first;
	private int last;
	
	
	
	public QueueOfStrings() {
		super();
		arr = new String[10];
		first = -1;
		last = -1;
	}
	
	private void resize(){
		if(last == arr.length){
			int len = last - first;
			int newLen = 0;
			if(len < 5){
				newLen = 10;
			}
			else{
				newLen = len * 2;
			}
			String[] newArr = new String[newLen];
			for(int i=0; i<len; i++){
				newArr[i] = arr[first+i];
			}
			arr = newArr;
			first = 0;
			last = len;
		}
	}

	@Override
	public void enqueue(String t) {
		if(first == -1){
			first = 0;
			 last = 0;
		}
		resize();
		arr[last] = t;
		last++;
	}

	@Override
	public String dequeue() {
		if(!isEmpty()){
			String ret = arr[first++];
			if(first >= last){
				first = -1;
				last = -1;
			}
			return ret;
		}
		throw new IllegalStateException("Queue is empty.");
	}

	@Override
	public boolean isEmpty() {
		return (first == -1 && last == -1) || (first >= last);
	}

	@Override
	public int size() {
		return last - first;
	}

}
