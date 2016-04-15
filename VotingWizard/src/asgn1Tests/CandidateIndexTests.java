/**
 * 
 */
package asgn1Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn1Election.CandidateIndex;

/**
 * @author luke
 *
 */
public class CandidateIndexTests {

	/**
	 * Test method for {@link asgn1Election.CandidateIndex#inRange(int)}.
	 */
	@Test
	public void testInRangeUpperBound() {
		CandidateIndex testIndex = new CandidateIndex(5);
		assertFalse(testIndex.inRange(testIndex.MaxCandidates + 1));
	}
	
	/**
	 * Test method for {@link asgn1Election.CandidateIndex#inRange(int)}.
	 */
	@Test
	public void testInRangeLowerBound() {
		CandidateIndex testIndex = new CandidateIndex(5);
		assertFalse(testIndex.inRange(testIndex.MinCandidates - 1));
	}
	
	/**
	 * Test method for {@link asgn1Election.CandidateIndex#inRange(int)}.
	 */
	@Test
	public void testInRangeWhileValid() {
		CandidateIndex testIndex = new CandidateIndex(5);
		assertTrue(testIndex.inRange((testIndex.MinCandidates + testIndex.MaxCandidates) / 2));
	}

	/**
	 * Test method for {@link asgn1Election.CandidateIndex#compareTo(asgn1Election.CandidateIndex)}.
	 */
	@Test
	public void testCompareToEqual() {
		CandidateIndex testIndexOne = new CandidateIndex(1);
		CandidateIndex testIndexTwo = new CandidateIndex(1);
		assertEquals(testIndexOne.compareTo(testIndexTwo), 0);
	}
	
	/**
	 * Test method for {@link asgn1Election.CandidateIndex#compareTo(asgn1Election.CandidateIndex)}.
	 */
	@Test
	public void testCompareToLesser() {
		CandidateIndex testIndexOne = new CandidateIndex(1);
		CandidateIndex testIndexTwo = new CandidateIndex(2);
		assertEquals(testIndexOne.compareTo(testIndexTwo), -1);
	}

	/**
	 * Test method for {@link asgn1Election.CandidateIndex#compareTo(asgn1Election.CandidateIndex)}.
	 */
	@Test
	public void testCompareToGreater() {
		CandidateIndex testIndexOne = new CandidateIndex(2);
		CandidateIndex testIndexTwo = new CandidateIndex(1);
		assertEquals(testIndexOne.compareTo(testIndexTwo), 1);
	}
	
	/**
	 * Test method for {@link asgn1Election.CandidateIndex#copy()}.
	 */
	@Test
	public void testCopy() {
		CandidateIndex testIndex = new CandidateIndex(1);
		CandidateIndex testCopy = testIndex.copy();
		
		assertEquals(testIndex.compareTo(testCopy), 0);
	}

	/**
	 * Test method for {@link asgn1Election.CandidateIndex#incrementIndex()}.
	 */
	@Test
	public void testIncrementIndex() {
		CandidateIndex testIndex = new CandidateIndex(1);
		testIndex.incrementIndex();
		
		assertEquals(Integer.parseInt(testIndex.toString()), 2);
	}

	/**
	 * Test method for {@link asgn1Election.CandidateIndex#toString()}.
	 */
	@Test
	public void testToString() {
		CandidateIndex testIndex = new CandidateIndex(1);
		assertEquals(testIndex.toString(), "1");
	}

}
