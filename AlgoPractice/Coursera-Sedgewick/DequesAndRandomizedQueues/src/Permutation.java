import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
	
	public static void main(String args[]){
		//System.out.println("Here we go!");
		int k = Integer.parseInt(args[0]);
		//System.out.println("k="+k);
		RandomizedQueue<String> q = new RandomizedQueue<String>();
		while(!StdIn.isEmpty()){
				String str = StdIn.readString();
				//System.out.println(str);
				q.enqueue(str);
		}
		for(int i=0; i<k; i++){
			StdOut.println(q.dequeue());
		}
	}

}
