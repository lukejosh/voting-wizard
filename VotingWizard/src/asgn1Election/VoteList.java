/**
 * 
 * This file is part of the VotingWizard Project, written as 
 * part of the assessment for CAB302, Semester 1, 2016. 
 * 
 */
package asgn1Election;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * <p>Implementing class for the {@link asgn1Election.Vote} interface. <code>Vote</code> 
 * should be implemented as some sort of <code>List</code>, with 
 * <code>ArrayList<Integer></code> the default choice.</p>
 * 
 * @author hogan
 * 
 */
public class VoteList implements Vote {
	/** Holds the information that comprises a single vote */
	private List<Integer> vote = new ArrayList<Integer>();

	/** Number of candidates in the election */
	private int numCandidates;

	/**
	 * <p>Simple Constructor for the <code>VoteList</code> class. <code>numCandidates</code> 
	 * is known to be in range through check on <code>VoteCollection</code>. 
	 * 
	 * @param numCandidates <code>int</code> number of candidates competing for 
	 * this seat. 
	 */
	public VoteList(int numCandidates) {
		this.numCandidates = numCandidates;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Vote#addPref(asgn1Election.CandidateIndex)
	 */
	@Override
	public boolean addPref(int index) {
		if(this.vote.size() == this.numCandidates){
			return false;
		}
		
		else{
			this.vote.add(index);
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Vote#copyVote()
	 */
	@Override
	public Vote copyVote() {
		return null;
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Vote#getPreference(int)
	 */
	@Override
	public CandidateIndex getPreference(int cand) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Vote#invertVote()
	 */
	@Override
	public Vote invertVote() {
		return null;

	}

	/* 
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Integer> iterator() {
		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "";
		for (Integer index : this.vote) {
			str += index.intValue() + " ";
		}
		return str;
	}
}
