package asgn1Election;

import java.io.FileNotFoundException;
import java.io.IOException;

import asgn1Util.NumbersException;


public class MyOwnSanity {
	
	public static void main(String[] args) throws ElectionException, FileNotFoundException,
	IOException, NumbersException{
		PrefElection prefelec = new PrefElection("MinMorgulVale");
		prefelec.loadDefs();
		VoteList vltest = new VoteList(3);
		vltest.addPref(1);
		vltest.addPref(2);
		vltest.addPref(3);
		prefelec.isFormal(vltest);
//		prefelec.loadVotes();
	}

}
