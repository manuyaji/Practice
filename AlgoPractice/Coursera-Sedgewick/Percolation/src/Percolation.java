import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
	
	private int[][] sites;
	//int[][] full;
	private WeightedQuickUnionUF uf;
	private int n;
	private int numOfOpenSites;
	
	// create n-by-n grid, with all sites blocked
	public Percolation(int n){
		if(n<=0){
			throw new IllegalArgumentException("n should be greater than 0");
		}
		this.n = n;
		sites = new int[n][n];
		//full = new int[n][n];
		uf = new WeightedQuickUnionUF(n*n + 2);
		numOfOpenSites = 0;
	}
	
	private int getNodeIndex(int row, int col){
		return row*n + col + 1;
	}
	
	private boolean checkValidCell(int origRow, int origCol){
		if((origRow<1) || (origCol<1) || (origRow>n) || (origCol>n)){
			throw new IndexOutOfBoundsException("row and col should be in the range [1,"+n+"].");
		}
		return true;
	}
	
	private void union(int curRow, int curCol, int toUnionRow, int toUnionCol){
		int curNode = getNodeIndex(curRow, curCol);
		int otherNode = getNodeIndex(toUnionRow, toUnionCol);
		uf.union(curNode, otherNode);
	}
	
	/*private void doFull(int curRow, int curCol, int toUnionRow, int toUnionCol){
		doFull(curRow, curCol);
		if(!isFull(curRow+1, curCol+1) && isFull(toUnionRow + 1, toUnionCol + 1)){
			full[curRow][curCol] = 1;
		}
	}*/
	
	/*private void doFull(int curRow, int curCol){
		if(curRow == 0){
			full[curRow][curCol] = 1;
		}
	}*/
	
	private void doAdjacentOperation(int curRow, int curCol, int adjRow, int adjCol){
		if(isOpen(adjRow+1, adjCol+1)){
			union(curRow, curCol, adjRow, adjCol);
		}
		//doFull(curRow, curCol, adjRow, adjCol);
	}
	
	private void unionWithLastNode(int row, int col){
		if(row == n-1){
			uf.union(getNodeIndex(row, col), n*n+1);
		}
	}
	
	private void unionWithFirstNode(int row, int col){
		if(row == 0){
			uf.union(getNodeIndex(row, col), 0);
		}
	}
	
	private void doAdjacentOperations(int row, int col){
		// Union with First Node
		if(row == 0){
			unionWithFirstNode(row, col);
		}
		// Union with Last Node
		if(row == n-1){
			unionWithLastNode(row, col);
		}
		// Union with above cell
		if(row > 0){ 
			doAdjacentOperation(row, col, row-1, col);
		}
		// Union with below cell
		if(row < sites.length-1){
			doAdjacentOperation(row, col, row+1, col);
		}
		// Union with left cell
		if(col > 0){
			doAdjacentOperation(row, col, row, col-1);
		}
		// Union with right cell
		if(col < sites.length - 1){
			doAdjacentOperation(row, col, row, col+1);
		}
	}
	
	// open site (row, col) if it is not open already
	public void open(int row, int col){
		checkValidCell(row, col);
		sites[row-1][col-1] = 1;
		numOfOpenSites++;
		doAdjacentOperations(row-1, col-1);
	}
	
	// is site (row, col) open?
	public boolean isOpen(int row, int col){
		checkValidCell(row, col);
		return (sites[row-1][col-1] == 1);
	}
	
	// is site (row, col) full?
	public boolean isFull(int row, int col){
		checkValidCell(row, col);
		//return (full[row-1][col-1] == 1);
		return uf.connected(0, getNodeIndex(row-1, col-1));
	}
	
	// number of open sites
	public int numberOfOpenSites(){
		return numOfOpenSites;
	}
	
	// does the system percolate?
	public boolean percolates(){
		return uf.connected(0, n*n+1);
	}
	
	public static void main(String args[]){
		System.out.println("Helo Works!");
		fiveByFive();
		
	}
	
	private static void fiveByFive(){
		Percolation perc = new Percolation(5);
		while(!perc.percolates()){
			System.out.println("========================");
			int row = StdRandom.uniform(5)+1;
			int col = StdRandom.uniform(5)+1;
			System.out.println("Opening "+row+","+col);
			perc.open(row, col);
			displayPercolationDetails(perc);
			System.out.println("========================");
		}
	}
	
	private static void displayPercolationDetails(Percolation percolation){
		if(percolation == null){
			System.out.println("Percolation is NULL");
		}
		else{
			System.out.println("numOfOpenSites: "+percolation.numberOfOpenSites());
			System.out.println("--------- SITES ----------");
			displayPercolationSitesDetails(percolation);
			/*System.out.println("--------- FULL SITES ----------");
			displayPercolationFullSitesDetails(percolation);*/
		}
	}
	
	private static void displayPercolationSitesDetails(Percolation percolation){
		if(percolation == null){
			System.out.println("Percolation is NULL");
		}
		for(int i=0; i<percolation.n; i++){
			for(int j=0; j<percolation.n; j++){
				System.out.print(percolation.sites[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/*private static void displayPercolationFullSitesDetails(Percolation percolation){
		if(percolation == null){
			System.out.println("Percolation is NULL");
		}
		for(int i=0; i<percolation.n; i++){
			for(int j=0; j<percolation.n; j++){
				System.out.print(percolation.full[i][j]+" ");
			}
			System.out.println();
		}
	}*/
	
	private int getAboveCellIndex(int row, int col){
		int node = getNodeIndex(row, col);
		return node - n;
	}
	
	private int getBelowCellIndex(int row, int col){
		int node = getNodeIndex(row, col);
		return node + n;
	}
	
	private int getLeftCellIndex(int row, int col){
		int node = getNodeIndex(row, col);
		return node - 1;
	}

	private int getRightCellIndex(int row, int col){
		int node = getNodeIndex(row, col);
		return node + 1;
	}

}
