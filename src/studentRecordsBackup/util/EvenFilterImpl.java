package studentRecordsBackup.util;

public class EvenFilterImpl implements OddEvenFilterI {

	/*
	 * method to check whether update value is even or not
	 */
	@Override
	public boolean check(int num) {
		// TODO Auto-generated method stub
		if (num % 2 == 0)
			return true;
		else
			return false;
	}

}
