package studentRecordsBackup.util;

public class OddFilterImpl implements OddEvenFilterI {

	/* 
	 * method to check whether the update value is odd or not
	 */
	@Override
	public boolean check(int num) {
		// TODO Auto-generated method stub
		if (num % 2 != 0)
			return true;
		else
			return false;
	}

}
