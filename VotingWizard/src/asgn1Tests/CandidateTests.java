package asgn1Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import asgn1Election.Candidate;
import asgn1Election.ElectionException;

@SuppressWarnings("unused")

public class CandidateTests {

	/**
	 * Test method for {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test(expected = ElectionException.class)
	public void testCandidateElectionExceptionVoteCountLessThanZero() throws ElectionException{
		Candidate testCand = new Candidate("John Smith", "Lemon Party", "LPT", -1);
	}

	/**
	 * Test method for {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test(expected = ElectionException.class)
	public void testCandidateElectionExceptionEmptyName() throws ElectionException{
		Candidate testCand = new Candidate("", "Lemon Party", "LPT", 5);
	}
	
	/**
	 * Test method for {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test(expected = ElectionException.class)
	public void testCandidateElectionExceptionEmptyParty() throws ElectionException{
		Candidate testCand = new Candidate("John Smith", "", "LPT", 5);
	}
	
	/**
	 * Test method for {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test(expected = ElectionException.class)
	public void testCandidateElectionEmptyPartyAbbreviation() throws ElectionException{
		Candidate testCand = new Candidate("John Smith", "Lemon Party", "", 5);
	}
	
	/**
	 * Test method for {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}.
	 */
	@Test
	public void testRegularCandidateConstructor() throws ElectionException{
		
		boolean thrown = false;
		
		try{
			Candidate testCand = new Candidate("John Smith", "Lemon Party", "LPT", 0);
		}
		catch(ElectionException e){
			thrown = true;
		}
		
		assertFalse(thrown);
	}

	/**
	 * Test method for {@link asgn1Election.Candidate#copy()}.
	 * @throws ElectionException 
	 */
	@Test
	public void testCopyReturnsCopy() throws ElectionException {
		Candidate testCand = new Candidate("John Smith", "Lemon Party", "LPT", 3);
		assertEquals(testCand.toString(), testCand.copy().toString());
	}
	
	/**
	 * Test method for {@link asgn1Election.Candidate#copy()}.
	 * @throws ElectionException 
	 */
	@Test
	public void testCopyReturnsNewObject() throws ElectionException {
		Candidate testCand = new Candidate("John Smith", "Lemon Party", "LPT", 3);
		Candidate testCopy = testCand.copy();
		
		testCopy.incrementVoteCount();
		assertNotEquals(testCand.toString(), testCopy.toString());
	}

	/**
	 * Test method for {@link asgn1Election.Candidate#incrementVoteCount()}.
	 */
	@Test
	public void testIncrementVoteCount() throws ElectionException {
		Candidate testCand = new Candidate("John Smith", "Lemon Party", "LPT", 4);
		testCand.incrementVoteCount();
		assertEquals(testCand.getVoteCount(), 5);
	}

}
