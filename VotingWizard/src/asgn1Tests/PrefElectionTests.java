/**
 * 
 */
package asgn1Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import asgn1Election.ElectionException;
import asgn1Election.PrefElection;
import asgn1Election.VoteCollection;
import asgn1Election.VoteList;
import asgn1Util.NumbersException;

/**
 * @author luke
 *
 */
public class PrefElectionTests {

	/**
	 * Test method for {@link asgn1Election.PrefElection#findWinner()}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testFindWinnerRegular() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		String expectedOutput = "Results for election: MinMorgulVale\nEnrolment: 25\n\nShelob              Monster Spider Party          (MSP)\nGorbag              Filthy Orc Party              (FOP)\nShagrat             Stinking Orc Party            (SOP)\n\n\nCounting primary votes; 3 alternatives available\n\nPreferential election: MinMorgulVale\n\nShelob (MSP)                 8\nGorbag (FOP)                 7\nShagrat (SOP)                3\n\nInformal                     3\n\nVotes Cast                  21\n\n\nPreferences required: distributing Shagrat: 3 votes\n\nPreferential election: MinMorgulVale\n\nShelob (MSP)                10\nGorbag (FOP)                 8\n\nInformal                     3\n\nVotes Cast                  21\n\n\nCandidate Shelob (Monster Spider Party) is the winner with 10 votes...\n";
		PrefElection testElection = new PrefElection("MinMorgulVale");
		testElection.loadDefs();
		testElection.loadVotes();
		
		assertEquals(testElection.findWinner(), expectedOutput);
	}
	
	/**
	 * Test method for {@link asgn1Election.PrefElection#findWinner()}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testFindWinnerTie() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		String expectedOutput = "Results for election: MinMorgulValeTie\nEnrolment: 25\n\nShelob              Monster Spider Party          (MSP)\nGorbag              Filthy Orc Party              (FOP)\nShagrat             Stinking Orc Party            (SOP)\n\n\nCounting primary votes; 3 alternatives available\n\nPreferential election: MinMorgulValeTie\n\nShelob (MSP)                 8\nGorbag (FOP)                 7\nShagrat (SOP)                3\n\nInformal                     3\n\nVotes Cast                  21\n\n\nPreferences required: distributing Shagrat: 3 votes\n\nPreferential election: MinMorgulValeTie\n\nShelob (MSP)                 9\nGorbag (FOP)                 9\n\nInformal                     3\n\nVotes Cast                  21\n\n\nPreferences required: distributing Shelob: 9 votes\n\nPreferential election: MinMorgulValeTie\n\nGorbag (FOP)                18\n\nInformal                     3\n\nVotes Cast                  21\n\n\nCandidate Gorbag (Filthy Orc Party) is the winner with 18 votes...\n";
		PrefElection testElection = new PrefElection("MinMorgulValeTie");
		testElection.loadDefs();
		testElection.loadVotes();
		
		assertEquals(testElection.findWinner(), expectedOutput);
	}

	/**
	 * Test method for {@link asgn1Election.PrefElection#isFormal(asgn1Election.Vote)}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testIsFormalDuplicatePreference() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		PrefElection testElection = new PrefElection("MinMorgulVale"); //allows number of candidates to be loaded, for formality check
		testElection.loadDefs();
		VoteList testVote = new VoteList(testElection.getNumCandidates());
		testVote.addPref(1);
		testVote.addPref(2);
		testVote.addPref(2);
		
		assertFalse(testElection.isFormal(testVote));
	}
	
	/**
	 * Test method for {@link asgn1Election.PrefElection#isFormal(asgn1Election.Vote)}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testIsFormalPreferenceOutOfRangeUpper() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		PrefElection testElection = new PrefElection("MinMorgulVale"); //allows number of candidates to be loaded, for formality check
		testElection.loadDefs();
		VoteList testVote = new VoteList(testElection.getNumCandidates());
		testVote.addPref(1);
		testVote.addPref(2);
		testVote.addPref(4);
		
		assertFalse(testElection.isFormal(testVote));
	}
	
	/**
	 * Test method for {@link asgn1Election.PrefElection#isFormal(asgn1Election.Vote)}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testIsFormalPreferenceOutOfRangeLower() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		PrefElection testElection = new PrefElection("MinMorgulVale"); //allows number of candidates to be loaded, for formality check
		testElection.loadDefs();
		VoteList testVote = new VoteList(testElection.getNumCandidates());
		testVote.addPref(1);
		testVote.addPref(2);
		testVote.addPref(-1);
		
		assertFalse(testElection.isFormal(testVote));
	}
	
	/**
	 * Test method for {@link asgn1Election.PrefElection#isFormal(asgn1Election.Vote)}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testIsFormalPassesFormalVote() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		PrefElection testElection = new PrefElection("MinMorgulVale"); //allows number of candidates to be loaded, for formality check
		testElection.loadDefs();
		VoteList testVote = new VoteList(testElection.getNumCandidates());
		testVote.addPref(1);
		testVote.addPref(2);
		testVote.addPref(3);
		
		assertTrue(testElection.isFormal(testVote));
	}
	/**
	 * Test method for {@link asgn1Election.PrefElection#isFormal(asgn1Election.Vote)}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testIsFormalFailsDuplicatePrefNotFirst() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		PrefElection testElection = new PrefElection("MinMorgulVale"); //allows number of candidates to be loaded, for formality check
		testElection.loadDefs();
		VoteList testVote = new VoteList(testElection.getNumCandidates());
		testVote.addPref(1);
		testVote.addPref(2);
		testVote.addPref(2);
		
		assertFalse(testElection.isFormal(testVote));
	}
	
	/**
	 * Test method for {@link asgn1Election.PrefElection#isFormal(asgn1Election.Vote)}.
	 * @throws NumbersException 
	 * @throws IOException 
	 * @throws ElectionException 
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testIsFormalFailsNoFirstPref() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		PrefElection testElection = new PrefElection("MinMorgulVale"); //allows number of candidates to be loaded, for formality check
		testElection.loadDefs();
		VoteList testVote = new VoteList(testElection.getNumCandidates());
		testVote.addPref(2);
		testVote.addPref(3);
		testVote.addPref(4);
		
		assertFalse(testElection.isFormal(testVote));
	}
	
	
	
	/**
	 * Test method for {@link asgn1Election.Election#loadDefs()}.
	 */
	@Test(expected=ElectionException.class)
	public void testLoadDefsFailsInvalidElectionFile() throws FileNotFoundException, ElectionException, IOException, NumbersException{
		PrefElection testElection = new PrefElection("/testdata/InvalidPrefElection");
		testElection.loadDefs();
	}
	
	/**
	 * Test method for {@link asgn1Election.Election#loadDefs()}.
	 */
	@Test(expected=ElectionException.class)
	public void testLoadDefsFailsNoSeatName() throws FileNotFoundException, ElectionException, IOException, NumbersException{
		PrefElection testElection = new PrefElection("/testdata/prefElectionMissingSeatName");
		testElection.loadDefs();
	}
	
	/**
	 * Test method for {@link asgn1Election.Election#loadDefs()}.
	 */
	@Test(expected=ElectionException.class)
	public void testLoadDefsFailsNoEnrolment() throws FileNotFoundException, ElectionException, IOException, NumbersException{
		PrefElection testElection = new PrefElection("/testdata/prefElectionMissingEnrolment");
		testElection.loadDefs();
	}
	
	/**
	 * Test method for {@link asgn1Election.Election#loadDefs()}.
	 */
	@Test(expected=NumbersException.class)
	public void testLoadDefsFailsInvalidEnrolment() throws FileNotFoundException, ElectionException, IOException, NumbersException{
		PrefElection testElection = new PrefElection("/testdata/prefElectionInvalidEnrolment");
		testElection.loadDefs();
	}
	
	/**
	 * Test method for {@link asgn1Election.Election#loadDefs()}.
	 */
	@Test(expected=ElectionException.class)
	public void testLoadDefsFailsNoNumCandidates() throws FileNotFoundException, ElectionException, IOException, NumbersException{
		PrefElection testElection = new PrefElection("/testdata/prefElectionNoNumCandidates");
		testElection.loadDefs();
	}
	
	/**
	 * Test method for {@link asgn1Election.Election#loadDefs()}.
	 */
	@Test(expected=NumbersException.class)
	public void testLoadDefsFailsInvalidNumCandidates() throws FileNotFoundException, ElectionException, IOException, NumbersException{
		PrefElection testElection = new PrefElection("/testdata/prefElectionInvalidNumCandidates");
		testElection.loadDefs();
	}
	
	/**
	 * Test method for {@link asgn1Election.Election#loadDefs()}.
	 */
	@Test(expected=NumbersException.class)
	public void testLoadDefsFailsInvalidVoteValues() throws FileNotFoundException, ElectionException, IOException, NumbersException{
		PrefElection testElection = new PrefElection("/testdata/prefElectionInvalidNumCandidates");
		testElection.loadDefs();
	}
	
	/**
	 * Test method for {@link asgn1Election.Election#loadDefs()}.
	 */
	@Test(expected=ElectionException.class)
	public void testLoadVotesFailsTooFewVotes() throws FileNotFoundException, ElectionException, IOException, NumbersException{
		PrefElection testElection = new PrefElection("/testdata/prefElectionTooFewPreferences");
		testElection.loadDefs();
		testElection.loadVotes();
	}
	
	/**
	 * Test method for {@link asgn1Election.Election#loadDefs()}.
	 * @throws ElectionException
	 */
	@Test(expected=ElectionException.class)
	public void testLoadVotesFailsMissingVoteValues() throws FileNotFoundException, ElectionException, IOException, NumbersException{
		PrefElection testElection = new PrefElection("/testdata/prefElectionMissingVoteValues");
		testElection.loadDefs();
		testElection.loadVotes();
	}
	
	/**
	 * Test method for {@link asgn1Election.Election#loadDefs()}.
	 */
	@Test(expected=NumbersException.class)
	public void testLoadVotesFailsInvalidVoteValues() throws FileNotFoundException, ElectionException, IOException, NumbersException{
		PrefElection testElection = new PrefElection("/testdata/prefElectionInvalidVoteValues");
		testElection.loadDefs();
		testElection.loadVotes();
	}
	
	@Test
	public void testLoadVotesMorgulValeThirtyVotes() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		ExtendedElection elec = new ExtendedElection("MorgulVale");
    	elec.loadDefs();
		elec.loadVotes();
		VoteCollection vc = (VoteCollection) elec.getVoteCollection(); 
		assertTrue((vc.getFormalCount() == 30) && (vc.getInformalCount() == 0));
	}

}
