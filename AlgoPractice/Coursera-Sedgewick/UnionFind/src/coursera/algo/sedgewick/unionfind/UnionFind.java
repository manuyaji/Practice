package coursera.algo.sedgewick.unionfind;

public interface UnionFind {
	
	public void union(int node1, int node2);
	
	public boolean connected(int node1, int node2);

}
