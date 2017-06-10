package coursera.algo.sedgewick.unionfind.quickunion;

import coursera.algo.sedgewick.unionfind.UnionFind;

public class QuickUnion implements UnionFind{
	
	protected int[] nodes;
	
	public QuickUnion(int n){
		initializeNodes(n);
	}
	
	private void initializeNodes(int n){
		nodes = new int[n];
		for(int i=0; i<n; i++){
			nodes[i] = i;
		}
	}

	@Override
	public void union(int node1, int node2) {
		if(isValidNode(node1) && isValidNode(node2)){
			nodes[root(node1)] = root(node2);
		}
	}

	@Override
	public boolean connected(int node1, int node2) {
		if(isValidNode(node1) && isValidNode(node2)){
			return (root(node1) == root(node2));
		}
		else{
			return false;
		}
	}
	
	protected boolean isValidNode(int node){
		return (node>=0 && node<nodes.length);
	}
	
	protected int root(int node){
		while(nodes[node] != node){
			node = nodes[node];
		}
		return node;
	}

}
