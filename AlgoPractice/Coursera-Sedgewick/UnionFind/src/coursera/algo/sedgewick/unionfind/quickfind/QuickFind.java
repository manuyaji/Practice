package coursera.algo.sedgewick.unionfind.quickfind;

import coursera.algo.sedgewick.unionfind.UnionFind;

public class QuickFind implements UnionFind{
	
	protected static final String INDEX_ERROR = "One or both of the nodes do not exist";
	
	public QuickFind(int n){
		initializeNodes(n);
	}
	
	private void initializeNodes(int n){
		nodes = new int[n];
		for(int i=0; i<n; i++){
			nodes[i] = i;
		}
	}
	
	protected int[] nodes;
	
	protected void changeIndex(int fromIndex, int toIndex){
		for(int i=0; i<nodes.length; i++){
			if(nodes[i] == fromIndex){
				nodes[i] = toIndex;
			}
		}
	}

	@Override
	public void union(int node1, int node2) {
		if(!isValidIndex(node1) || !isValidIndex(node2)){
			System.out.println(INDEX_ERROR);
		}
		else{
			if(!connected(node1, node2)){
				changeIndex(nodes[node1], nodes[node2]);
			}
		}
	}

	@Override
	public boolean connected(int node1, int node2) {
		if(!isValidIndex(node1) || !isValidIndex(node2)){
			System.out.println(INDEX_ERROR);
			return false;
		}
		else{
			return (nodes[node1] == nodes[node2]);
		}
	}	
	
	protected boolean isValidIndex(int index){
		return (index >=0 && index < nodes.length);
	}

}
