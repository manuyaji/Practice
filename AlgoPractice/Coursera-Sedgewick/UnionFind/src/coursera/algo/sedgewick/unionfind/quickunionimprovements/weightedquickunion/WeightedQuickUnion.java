package coursera.algo.sedgewick.unionfind.quickunionimprovements.weightedquickunion;

import coursera.algo.sedgewick.unionfind.UnionFind;

public class WeightedQuickUnion implements UnionFind{
	
	protected int[] nodes;
	protected int[] maxDepths;
	
	private void initializeNodes(int n){
		nodes = new int[n];
		maxDepths = new int[n];
		for(int i=0; i<n; i++){
			nodes[i] = i;
			maxDepths[i] = 1;
		}
	}

	public WeightedQuickUnion(int n) {
		initializeNodes(n);
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

	@Override
	public void union(int node1, int node2) {
		if(!isValidNode(node1) || !isValidNode(node2)){
			return;
		}
		int root1 = root(node1);
		int root2 = root(node2);
		if(root1 == root2){
			return;
		}
		int maxSizedRoot = maxDepths[root1]>maxDepths[root2]?root1:root2;
		int minSizedRoot = root1==maxSizedRoot?root2:root1;
		nodes[minSizedRoot] = nodes[maxSizedRoot];
		maxDepths[maxSizedRoot] = Math.max(maxDepths[maxSizedRoot], 1+maxDepths[minSizedRoot]);
	}

	@Override
	public boolean connected(int node1, int node2) {
		if(isValidNode(node1) && isValidNode(node2)){
			return root(node1) == root(node2);
		}
		else{
			return false;
		}
	}
	
		
	
	/*private RootResult root(int node){
		int count = 0;
		while(nodes[node] != node){
			count++;
			node = nodes[node];
		}
		return new RootResult(node, count);
	}
	
	private RootResult maxRootResult(RootResult one, RootResult two){
		return (one.getDistanceToRoot() > two.getDistanceToRoot())?one:two;
	}
	
	private RootResult minRootResult(RootResult one, RootResult two){
		return (one.getDistanceToRoot() < two.getDistanceToRoot())?one:two;
	}

	@Override
	public void union(int node1, int node2) {
		if(isValidNode(node1) && isValidNode(node2)){
			RootResult result1 = root(node1);
			RootResult result2 = root(node2);
			RootResult min = minRootResult(result1, result2);
			RootResult max = maxRootResult(result1, result2);
			nodes[min.getRoot()] = nodes[max.getRoot()];
		}
	}

	@Override
	public boolean connected(int node1, int node2) {
		if(isValidNode(node1) && isValidNode(node2)){
			return (root(node1).getRoot() == root(node2).getRoot());
		}
		else{
			return false;
		}
	}*/

}
