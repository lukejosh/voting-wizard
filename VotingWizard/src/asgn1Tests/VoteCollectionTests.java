/**
 * 
 */
package asgn1Tests;

import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Test;

import asgn1Election.Candidate;
import asgn1Election.CandidateIndex;
import asgn1Election.ElectionException;
import asgn1Election.VoteCollection;
import asgn1Election.VoteList;

/**
 * @author luke
 *
 */
public class VoteCollectionTests {

	/**
	 * Test method for {@link asgn1Election.VoteCollection#VoteCollection(int)}.
	 */
	@Test
	public void testVoteCollection() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#countPrefVotes(java.util.TreeMap, asgn1Election.CandidateIndex)}.
	 * @throws ElectionException 
	 */
	@Test
	public void testCountPrefVotesReassignsLowest() throws ElectionException {
		VoteList testVoteOne = new VoteList(3);
		testVoteOne.addPref(1);
		testVoteOne.addPref(2);
		testVoteOne.addPref(3);
		
		VoteList testVoteTwo = new VoteList(3);
		testVoteTwo.addPref(1);
		testVoteTwo.addPref(2);
		testVoteTwo.addPref(3);
		
		VoteList testVoteThree = new VoteList(3);
		testVoteThree.addPref(1);
		testVoteThree.addPref(2);
		testVoteThree.addPref(3);
		
		VoteList testVoteFour = new VoteList(3);
		testVoteFour.addPref(3);
		testVoteFour.addPref(1);
		testVoteFour.addPref(2);
		
		VoteList testVoteFive = new VoteList(3);
		testVoteFive.addPref(3);
		testVoteFive.addPref(1);
		testVoteFive.addPref(2);
		
		VoteList testVoteSix = new VoteList(3);
		testVoteSix.addPref(2);
		testVoteSix.addPref(3);
		testVoteSix.addPref(1);
		
		VoteCollection testVc = new VoteCollection(3);
		testVc.includeFormalVote(testVoteOne);
		testVc.includeFormalVote(testVoteTwo);
		testVc.includeFormalVote(testVoteThree);
		testVc.includeFormalVote(testVoteFour);
		testVc.includeFormalVote(testVoteFive);
		testVc.includeFormalVote(testVoteSix);
		
		TreeMap<CandidateIndex, Candidate> testCds = new TreeMap<CandidateIndex, Candidate>();
		CandidateIndex testCandidateIndexOne = new CandidateIndex(1);
		CandidateIndex testCandidateIndexTwo = new CandidateIndex(2);
		CandidateIndex testCandidateIndexThree = new CandidateIndex(3);
		
		testCds.put(testCandidateIndexOne, new Candidate("Candidate A", "A Party", "AP", 3));
		testCds.put(testCandidateIndexTwo, new Candidate("Candidate B", "B Party", "AP", 2));
		testCds.put(testCandidateIndexThree, new Candidate("Candidate C", "C Party", "AP", 1));
		
		assertEquals(testCds.get(testCandidateIndexOne).getVoteCount(), 3);
		
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#countPrimaryVotes(java.util.TreeMap)}.
	 * @throws ElectionException 
	 */
	@Test
	public void testCountPrimaryVotes() throws ElectionException {
		VoteList testVoteOne = new VoteList(3);
		testVoteOne.addPref(1);
		testVoteOne.addPref(2);
		testVoteOne.addPref(3);
		
		VoteList testVoteTwo = new VoteList(3);
		testVoteTwo.addPref(1);
		testVoteTwo.addPref(2);
		testVoteTwo.addPref(3);
		
		VoteList testVoteThree = new VoteList(3);
		testVoteThree.addPref(1);
		testVoteThree.addPref(2);
		testVoteThree.addPref(3);
		
		VoteList testVoteFour = new VoteList(3);
		testVoteFour.addPref(3);
		testVoteFour.addPref(1);
		testVoteFour.addPref(2);
		
		VoteList testVoteFive = new VoteList(3);
		testVoteFive.addPref(3);
		testVoteFive.addPref(1);
		testVoteFive.addPref(2);
		
		VoteList testVoteSix = new VoteList(3);
		testVoteSix.addPref(2);
		testVoteSix.addPref(3);
		testVoteSix.addPref(1);
		
		VoteCollection testVc = new VoteCollection(3);
		testVc.includeFormalVote(testVoteOne);
		testVc.includeFormalVote(testVoteTwo);
		testVc.includeFormalVote(testVoteThree);
		testVc.includeFormalVote(testVoteFour);
		testVc.includeFormalVote(testVoteFive);
		testVc.includeFormalVote(testVoteSix);
		
		TreeMap<CandidateIndex, Candidate> testCds = new TreeMap<CandidateIndex, Candidate>();
		CandidateIndex testCandidateIndexOne = new CandidateIndex(1);
		CandidateIndex testCandidateIndexTwo = new CandidateIndex(2);
		CandidateIndex testCandidateIndexThree = new CandidateIndex(3);
		
		testCds.put(testCandidateIndexOne, new Candidate("Candidate A", "A Party", "AP", 0));
		testCds.put(testCandidateIndexTwo, new Candidate("Candidate B", "B Party", "AP", 0));
		testCds.put(testCandidateIndexThree, new Candidate("Candidate C", "C Party", "AP", 0));
						
		testVc.countPrimaryVotes(testCds);
		
		assertTrue(testCds.get(testCandidateIndexOne).getVoteCount() == 3 && testCds.get(testCandidateIndexTwo).getVoteCount() == 2 && testCds.get(testCandidateIndexThree).getVoteCount() == 1);
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#emptyTheCollection()}.
	 * @throws ElectionException 
	 */
	@Test
	public void testEmptyTheCollection() throws ElectionException {
		VoteList testVote = new VoteList(3);
		testVote.addPref(1);
		testVote.addPref(2);
		testVote.addPref(3);
		
		VoteCollection testVc = new VoteCollection(3);
		testVc.includeFormalVote(testVote);
		
		int oldVoteCount = testVc.getFormalCount();
		testVc.emptyTheCollection();
		
		System.out.println(Integer.toString(oldVoteCount) + " " + testVc.getFormalCount());
		
		assertNotEquals(oldVoteCount, testVc.getFormalCount());
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#getFormalCount()}.
	 */
	@Test
	public void testGetFormalCount() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#getInformalCount()}.
	 */
	@Test
	public void testGetInformalCount() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#includeFormalVote(asgn1Election.Vote)}.
	 */
	@Test
	public void testIncludeFormalVote() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#updateInformalCount()}.
	 */
	@Test
	public void testUpdateInformalCount() {
		fail("Not yet implemented");
	}

}
