/**
 * 
 * This file is part of the VotingWizard Project, written as 
 * part of the assessment for CAB302, Semester 1, 2016. 
 * 
 */
package asgn1Election;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

import asgn1Util.Strings;

/**
 * 
 * Subclass of <code>Election</code>, specialised to preferential, but not optional
 * preferential voting.
 * 
 * @author hogan
 * 
 */
public class PrefElection extends Election {

	/**
	 * Simple Constructor for <code>PrefElection</code>, takes name and also sets the 
	 * election type internally. 
	 * 
	 * @param name <code>String</code> containing the Election name
	 */
	public PrefElection(String name) {
		super(name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Election#findWinner()
	 */
	@Override
	public String findWinner() {
		String result = "";
		Candidate candWinner = null;
		int winVotes = ((this.numVotes - this.vc.getInformalCount()) / 2) + 1;
		CandidateIndex candToDrop = null;
		
		this.vc.countPrimaryVotes(this.cds);
		result += this.reportCountStatus();
		winner = this.clearWinner(winVotes);
		
		while(candWinner == null){
			candToDrop = this.selectLowestCandidate();
			result += this.prefDistMessage(this.cds.get(candToDrop));
			System.out.println("Remaining indices: " + this.cds.keySet().toString());
			System.out.println("DISTRIB " + candToDrop.toString());
			this.vc.countPrefVotes(this.cds, candToDrop);
			this.cds.remove(candToDrop);
			result += this.reportCountStatus();
			candWinner = this.clearWinner(winVotes);
		}
		result += this.reportWinner(candWinner);
		return result;
	}

	/* 
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Election#isFormal(asgn1Election.Vote)
	 */
	@Override
	public boolean isFormal(Vote v) {
		List<Integer> checked = new ArrayList<Integer>();
		Iterator<Integer> iter = v.iterator();
		while(iter.hasNext()){
			int value = iter.next();
			if(checked.contains(value) || value < 1 || value > this.numCandidates){
				return false;
			}
			else{
				checked.add(value);
			}
		}
		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
        String str = this.name + " - Preferential Voting";
		return str;
	}
	
	// Protected and Private/helper methods below///


	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Election#clearWinner(int)
	 */
	@Override
	protected Candidate clearWinner(int winVotes) {
		for(Candidate cand: this.cds.values()){
			if(cand.getVoteCount() >= winVotes){
				return cand;
			}
		}
		return null;
	}

	/**
	 * Helper method to create a preference distribution message for display 
	 * 
	 * @param c <code>Candidate</code> to be eliminated
	 * @return <code>String</code> containing preference distribution message 
	 */
	private String prefDistMessage(Candidate c) {
		String str = "\nPreferences required: distributing " + c.getName()
				+ ": " + c.getVoteCount() + " votes";
		return str;
	}

	/**
	 * Helper method to create a string reporting the count progress
	 * 
	 * @return <code>String</code> containing count status  
	 */
	private String reportCountStatus() {
		String str = "\nPreferential election: " + this.name + "\n\n"
				+ candidateVoteSummary() + "\n";
		String inf = "Informal";
		String voteStr = "" + this.vc.getInformalCount();
		int length = ElectionManager.DisplayFieldWidth - inf.length()
				- voteStr.length();
		str += inf + Strings.createPadding(' ', length) + voteStr + "\n\n";

		String cast = "Votes Cast";
		voteStr = "" + this.numVotes;
		length = ElectionManager.DisplayFieldWidth - cast.length()
				- voteStr.length();
		str += cast + Strings.createPadding(' ', length) + voteStr + "\n\n";
		return str;
	}

	/**
	 * Helper method to select candidate with fewest votes
	 * 
	 * @return <code>CandidateIndex</code> of candidate with fewest votes
	 */
	private CandidateIndex selectLowestCandidate() {
		int curLowest = this.numVotes + 1;
		CandidateIndex candLowest = null;
		for(CandidateIndex cIndex: this.cds.keySet()){
			if (this.cds.get(cIndex).getVoteCount() < curLowest){
				curLowest = this.cds.get(cIndex).getVoteCount();
				candLowest = cIndex;
			}
		}
		return candLowest;
	}
}