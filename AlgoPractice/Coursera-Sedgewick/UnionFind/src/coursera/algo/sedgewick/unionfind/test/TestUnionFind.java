package coursera.algo.sedgewick.unionfind.test;

import coursera.algo.sedgewick.unionfind.quickfind.QuickFind;
import coursera.algo.sedgewick.unionfind.quickunion.QuickUnion;
import coursera.algo.sedgewick.unionfind.quickunionimprovements.weightedquickunion.WeightedQuickUnion;

public class TestUnionFind{
	
	private static int n = 100;
	
	public static void main(String args[]){
		quickFindTest();
		quickUnionTest();
		quickUnionImprovementsTest();
		
		quickFindTestInLecture();
		quickUnionTestInLecture();
		quickWeightedUnionTestInLecture();
	}

	private static void quickUnionImprovementsTest() {
		JUnitTestSet testSet = new JUnitTestSet(new QuickFind(n), n);
		testSet.test();
	}

	private static void quickUnionTest() {
		JUnitTestSet testSet = new JUnitTestSet(new QuickFind(n), n);
		testSet.test();
	}

	private static void quickFindTest() {
		JUnitTestSet testSet = new JUnitTestSet(new QuickFind(n), n);
		testSet.test();
	}
	
	private static void quickFindTestInLecture(){
		System.out.println("======= EXECUTING QUICKFIND TEST IN LECTURE ========");
		JUnitTestSet testSet = new JUnitTestSet(new QuickFind(10), 10);
		testSet.testAsInLecture1();
		testSet.testAsInLecture2();
	}
	
	private static void quickUnionTestInLecture(){
		System.out.println("======= EXECUTING QUICKUNION TEST IN LECTURE ========");
		JUnitTestSet testSet = new JUnitTestSet(new QuickUnion(10), 10);
		testSet.testAsInLecture1();
		testSet.testAsInLecture2();
	}
	
	private static void quickWeightedUnionTestInLecture(){
		System.out.println("======= EXECUTING WEIGHTEDQUICKUNION TEST IN LECTURE ========");
		JUnitTestSet testSet = new JUnitTestSet(new WeightedQuickUnion(10), 10);
		testSet.testAsInLecture1();
		testSet.testAsInLecture2();
	}

}
