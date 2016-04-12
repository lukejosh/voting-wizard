package asgn1Election;

public class SelfTest {

	public static void main(String[] args) throws ElectionException {
		Vote v = new VoteList(3);
		VoteCollection vc = new VoteCollection(3);
		
		v.addPref(1);
		v.addPref(1);
		v.addPref(1);
		v.addPref(1);
		
		System.out.println(vc.getPrimaryKey(v));
		
	}

}
