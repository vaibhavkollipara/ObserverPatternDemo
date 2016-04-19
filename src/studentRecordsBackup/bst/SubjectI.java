package studentRecordsBackup.bst;

import studentRecordsBackup.util.OddEvenEnum.EvenOddEnum;

public interface SubjectI {

	public void updateObservers(int newBNum);

	public void registerObserver(ObserverI o, EvenOddEnum filter);

}
