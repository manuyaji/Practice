import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	
	private int n;
	private int trials;
	private double[] trialResults;
	private double mean;
	private double stddev;
	
	// perform trials independent experiments on an n-by-n grid
	public PercolationStats(int n, int trials){
		initialize(n, trials);
		perform();
	}
	
	private void initialize(int n, int trials){
		if(n<=0 || trials <= 0){
			throw new IllegalArgumentException("Both arguments ('n' and 'trials') have to be more than 0.");
		}
		this.n = n;
		this.trials = trials;
		trialResults = new double[trials];
	}
	
	private void perform(){
		Percolation percolation;
		int numberOfGrids = n*n;
		for(int i=0; i<trials; i++){
			percolation = new Percolation(n);
			int count = 0;
			while(!percolation.percolates()){
				int row = StdRandom.uniform(n)+1;
				int col = StdRandom.uniform(n)+1;
				if(!percolation.isOpen(row, col)){
					percolation.open(row, col);;
					count++;
				}
			}
			trialResults[i] = ((1.0*count)/numberOfGrids);
		}
	}
	
    // sample mean of percolation threshold
	public double mean(){
		this.mean = StdStats.mean(trialResults);
		return this.mean;
	}
	
	// sample standard deviation of percolation threshold
	public double stddev(){
		this.stddev = StdStats.stddev(trialResults);
		return this.stddev;
	}
	
	// low  endpoint of 95% confidence interval
	public double confidenceLo(){
		double ret = mean - ((1.96 * stddev)/Math.sqrt(trials));
		return ret;
	}
	
	// high endpoint of 95% confidence interval
	public double confidenceHi(){
		double ret = mean + ((1.96 * stddev)/Math.sqrt(trials));
		return ret;
	}

	
	// test client (described below)
	public static void main(String[] args){
		if(args != null && args.length == 2){
			gridRowSize = Integer.parseInt(args[0]);
			numOfTrials = Integer.parseInt(args[1]);
		}
		PercolationStats stats = new PercolationStats(gridRowSize, numOfTrials);
		System.out.println("mean\t= "+stats.mean());
		System.out.println("stddev\t= "+stats.stddev());
		System.out.println("95% confidence interval\t= ["+stats.confidenceLo()+", "+stats.confidenceHi()+"]");
	}
	
	private static int gridRowSize = 200;
	private static int numOfTrials = 100;
	
	/*private static int gridRowSize = 2;
	private static int numOfTrials = 10000;*/
	
	/*private static int gridRowSize = 2;
	private static int numOfTrials = 100000;*/

}
