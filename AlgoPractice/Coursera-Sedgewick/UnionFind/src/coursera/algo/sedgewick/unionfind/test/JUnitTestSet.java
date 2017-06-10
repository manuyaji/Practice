package coursera.algo.sedgewick.unionfind.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import coursera.algo.sedgewick.unionfind.UnionFind;
import coursera.algo.sedgewick.unionfind.quickfind.QuickFind;
import coursera.algo.sedgewick.unionfind.quickunion.QuickUnion;
import coursera.algo.sedgewick.unionfind.quickunionimprovements.weightedquickunion.WeightedQuickUnion;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class JUnitTestSet {
	
	UnionFind uf;
	int n;
	
	public JUnitTestSet(UnionFind uf, int n){
		this.uf = uf;
		this.n = n;
	}
	
	@Test
	public void test(){
		
	}
	
	//Test Given In Lecture of QuickFind
	@Test
	public void testAsInLecture1(){
		if(n != 10){
			throw new UnsupportedOperationException("The Union Find object does not have 10 elements as required for this test.");
		}
		uf.union(4, 3);
		uf.union(3, 8);
		uf.union(6, 5);
		uf.union(9, 4);
		uf.union(2, 1);
		
		assertEquals(uf.connected(8, 9), true);
		assertEquals(uf.connected(5, 0), false);
		
		uf.union(5, 0);
		uf.union(7, 2);
		uf.union(6, 1);
		
	}
	
	//Test Given In Lecture of QuickUnion
	@Test
	public void testAsInLecture2(){
		if(n != 10){
			throw new UnsupportedOperationException("The Union Find object does not have 10 elements as required for this test.");
		}
		uf.union(4, 3);
		uf.union(3, 8);
		uf.union(6, 5);
		uf.union(9, 4);
		uf.union(2, 1);
		
		assertEquals(uf.connected(8, 9), true);
		assertEquals(uf.connected(5, 4), false);
		
		uf.union(5, 0);
		uf.union(7, 2);
		uf.union(6, 1);
		uf.union(7, 3);
		
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> instancesToTest(){
		return Arrays.asList(
				new Object[]{new QuickFind(10), 10},
				new Object[]{new QuickUnion(10), 10},
				new Object[]{new WeightedQuickUnion(10), 10}
				//new Object[]{new QuickFind(10), 10},
				//new Object[]{new QuickFind(10), 10}
				);
	}

}
