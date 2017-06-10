package coursera.algo.sedgewick.unionfind.quickunionimprovements.weightedquickunion.beans;

public class RootResult {
	
	public RootResult(int root, int size) {
		super();
		this.root = root;
		this.distanceToRoot = size;
	}
	
	private int root;
	private int distanceToRoot;
	
	public int getRoot() {
		return root;
	}
	public void setRoot(int root) {
		this.root = root;
	}
	public int getDistanceToRoot() {
		return distanceToRoot;
	}
	public void setDistanceToRoot(int distanceToRoot) {
		this.distanceToRoot = distanceToRoot;
	}

}
