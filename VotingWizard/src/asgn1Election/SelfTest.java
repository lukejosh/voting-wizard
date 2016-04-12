package asgn1Election;

import java.io.FileNotFoundException;
import java.io.IOException;

import asgn1Util.NumbersException;

public class SelfTest {

	public static void main(String[] args) throws ElectionException, FileNotFoundException, IOException, NumbersException {
		Election elec = new SimpleElection("ShitVale");
		elec.loadDefs();
		elec.loadVotes();
		System.out.println(elec.findWinner());
	}

}
