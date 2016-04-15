/**
 * 
 */
package asgn1Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import asgn1Election.CandidateIndex;
import asgn1Election.ElectionException;
import asgn1Election.SimpleElection;
import asgn1Election.VoteList;
import asgn1Util.NumbersException;

/**
 * @author luke
 *
 */
public class SimpleElectionTests {

	/**
	 * Test method for {@link asgn1Election.SimpleElection#findWinner()}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testFindWinnerDifferentCount() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		String expectedOutput = "Results for election: MinMorgulValeSimple\nEnrolment: 25\n\nShelob              Monster Spider Party          (MSP)\nGorbag              Filthy Orc Party              (FOP)\nShagrat             Stinking Orc Party            (SOP)\n\n\nCounting primary votes; 3 alternatives available\n\nSimple election: MinMorgulValeSimple\n\nShelob (MSP)                 8\nGorbag (FOP)                 8\nShagrat (SOP)                3\n\nInformal                     4\n\nVotes Cast                  23\n\n\nCandidate Shelob (Monster Spider Party) is the winner with 8 votes...\n";
		
		SimpleElection testElection = new SimpleElection("MinMorgulValeSimple");
		testElection.loadDefs();
		testElection.loadVotes();
		
		assertEquals(expectedOutput, testElection.findWinner());
	}
	
	/**
	 * Test method for {@link asgn1Election.SimpleElection#findWinner()}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testFindWinnerSameCount() throws FileNotFoundException, ElectionException, IOException, NumbersException{
		String expectedOutput = "Results for election: MinMorgulValeTieSimple\nEnrolment: 25\n\nShelob              Monster Spider Party          (MSP)\nGorbag              Filthy Orc Party              (FOP)\nShagrat             Stinking Orc Party            (SOP)\n\n\nCounting primary votes; 3 alternatives available\n\nSimple election: MinMorgulValeTieSimple\n\nShelob (MSP)                 8\nGorbag (FOP)                 7\nShagrat (SOP)                3\n\nInformal                     3\n\nVotes Cast                  21\n\n\nCandidate Shelob (Monster Spider Party) is the winner with 8 votes...\n";

				
		SimpleElection testElection = new SimpleElection("MinMorgulValeTieSimple"); 
		testElection.loadDefs();
		testElection.loadVotes();
		
		assertEquals(expectedOutput, testElection.findWinner());
	}
	
	/**
	 * Test method for {@link asgn1Election.SimpleElection#isFormal(asgn1Election.Vote)}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testIsFormalMultipleFirstPrefs() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		SimpleElection testElection = new SimpleElection("invalidSimpleVoteElection");
		VoteList testVote = new VoteList(3);
		testElection.loadDefs();
		testVote.addPref(1);
		testVote.addPref(2);
		testVote.addPref(1);
		
		assertFalse(testElection.isFormal(testVote));
		
	}
	
	/**
	 * Test method for {@link asgn1Election.SimpleElection#isFormal(asgn1Election.Vote)}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testIsFormalPrefOutOfRange() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		SimpleElection testElection = new SimpleElection("MinMorgulValeSimple"); //Load number of candidates, required for formality test
		VoteList testVote = new VoteList(3);
		testElection.loadDefs();
		testVote.addPref(1);
		testVote.addPref(2);
		testVote.addPref(4);
		
		assertFalse(testElection.isFormal(testVote));
		
	}
	
	/**
	 * Test method for {@link asgn1Election.SimpleElection#isFormal(asgn1Election.Vote)}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testIsFormalPassesFormalVote() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		SimpleElection testElection = new SimpleElection("invalidSimpleVoteElection");
		VoteList testVote = new VoteList(3);
		testElection.loadDefs();
		testVote.addPref(1);
		testVote.addPref(2);
		testVote.addPref(3);
		
		assertTrue(testElection.isFormal(testVote));
		
	}

	/**
	 * Test method for {@link asgn1Election.SimpleElection#clearWinner(int)}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testClearWinnerReturnsWinnerWhenDifferent() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		SimpleElection testElection = new SimpleElection("MinMorgulValeSimple");
		CandidateIndex expectedIndex = new CandidateIndex(1);
		testElection.loadDefs();
		testElection.loadVotes();
		
		assertEquals(expectedIndex.compareTo(expectedIndex), 0);
	}
	
	/**
	 * Test method for {@link asgn1Election.SimpleElection#clearWinner(int)}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testClearWinnerReturnsWinnerWhenSame() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		SimpleElection testElection = new SimpleElection("MinMorgulValeTieSimple");
		CandidateIndex expectedIndex = new CandidateIndex(1);
		testElection.loadDefs();
		testElection.loadVotes();
		
		assertEquals(expectedIndex.compareTo(expectedIndex), 0);
	}
}
