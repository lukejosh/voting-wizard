/**
 * 
 */
package asgn1Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn1Election.CandidateIndex;
import asgn1Election.Vote;
import asgn1Election.VoteList;

/**
 * @author luke
 *
 */
public class VoteListTests {

	/**
	 * Test method for {@link asgn1Election.VoteList#addPref(int)}.
	 */
	@Test
	public void testAddPrefFailsWhenAlreadyFull() {
		
		VoteList testVoteList = new VoteList(1);
		
		testVoteList.addPref(1);
		assertFalse(testVoteList.addPref(2));
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#addPref(int)}.
	 */
	@Test
	public void testAddPrefRegularIndex() {

		VoteList testVoteList = new VoteList(2);
		String expectedOutput = "1 ";
		
		testVoteList.addPref(1);

		assertEquals(expectedOutput, testVoteList.toString());
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#copyVote()}.
	 */
	@Test
	public void testCopyVoteReturnsIdentitcalFields() {
		
		VoteList testVoteList;
		Vote copyVoteList;
		
		testVoteList = new VoteList(1);
		testVoteList.addPref(1);
		copyVoteList = testVoteList.copyVote();
		
		assertEquals(testVoteList.toString(), copyVoteList.toString());
	}
	
	/**
	 * Test method for {@link asgn1Election.VoteList#copyVote()}.
	 */
	@Test
	public void testCopyVoteReturnsNewObject() {
		
		VoteList testVoteList;
		Vote copyVoteList;
		
		testVoteList = new VoteList(2);
		testVoteList.addPref(1);
		
		copyVoteList = testVoteList.copyVote();
		copyVoteList.addPref(2);
		
		assertNotEquals(testVoteList.toString(), copyVoteList.toString());
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#getPreference(int)}.
	 */
	@Test
	public void testGetPreference() {
		VoteList testVoteList = new VoteList(3);
		
		CandidateIndex expectedIndex = new CandidateIndex(2);
		
		testVoteList.addPref(2);
		testVoteList.addPref(1);
		testVoteList.addPref(3);
		
		assertEquals(0, testVoteList.getPreference(1).compareTo(expectedIndex));
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#invertVote()}.
	 */
	@Test
	public void testInvertVote() {
		VoteList testVoteList = new VoteList(3);
		Vote expectedOutput = new VoteList(3);
		
		expectedOutput.addPref(2);
		expectedOutput.addPref(3);
		expectedOutput.addPref(1);
		
		testVoteList.addPref(3);
		testVoteList.addPref(1);
		testVoteList.addPref(2);
		
		Vote orderedVote = testVoteList.invertVote();
		
		assertEquals(expectedOutput.toString(), orderedVote.toString());
	}
	
	/**
	 * Test method for {@link asgn1Election.VoteList#invertVote()}.
	 */
	@Test
	public void testInvertVoteAlreadyInverted() {
		VoteList testVoteList = new VoteList(3);
		Vote expectedOutput = new VoteList(3);
		
		expectedOutput.addPref(3);
		expectedOutput.addPref(2);
		expectedOutput.addPref(1);
		
		testVoteList.addPref(3);
		testVoteList.addPref(2);
		testVoteList.addPref(1);
		
		Vote orderedVote = testVoteList.invertVote();
		
		assertEquals(expectedOutput.toString(), orderedVote.toString());
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#iterator()}.
	 */
	@Test
	public void testIterator() {
		VoteList testVoteList = new VoteList(1);
		if(testVoteList.iterator() == null){
			fail();
		}
		
	}
}