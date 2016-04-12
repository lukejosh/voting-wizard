package asgn1Election;

import static org.junit.Assert.*;

import org.junit.Test;

public class CandidateTest {

	@Test
	public void testGetName() throws ElectionException{
		Candidate testCand = new Candidate ("John", "Smith Party", "SPT", 0);
		String expectedOutput = "John";
		String actualOutput = testCand.getName();
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void testGetParty() throws ElectionException{
		Candidate testCand = new Candidate("Julia", "Doe Party", "DPT", 0);
		assertEquals("Doe Party", testCand.getParty());
	}
	
	@Test
	public void testGetVoteCount() throws ElectionException{
		Candidate testCand = new Candidate("Jane", "Lemon Party", "LPT", 5);
		assertEquals(5, testCand.getVoteCount());
	}
	
	@Test
	public void testGetVoteCountString() throws ElectionException{
		Candidate testCand = new Candidate("Alex", "Liars Party", "LPT", 2);
		assertEquals("2", testCand.getVoteCountString());
	}
	
	@Test
	public void testIncrementVoteCount() throws ElectionException{
		Candidate testCand = new Candidate("Aaron", "Alphabet Party", "ABC", 7);
		testCand.incrementVoteCount();
		
		assertEquals(8, testCand.getVoteCount());
	}
	
	@Test
	public void testCopy() throws ElectionException{
		Candidate testCand = new Candidate("Kyle", "Python Party", "PPT", 5);
		Candidate testCopy = testCand.copy();
		assertEquals("Kyle", testCopy.getName());
		assertEquals("Python Party", testCopy.getParty());
		assertEquals(5, testCopy.getVoteCount());
		
		testCopy.incrementVoteCount();
		
		assertNotEquals(testCand.getVoteCount(), testCopy.getVoteCount()); //ensure it is a true copy
	}

}