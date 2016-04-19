package studentRecordsBackup.bst;

import java.util.HashMap;
import java.util.Map;

import studentRecordsBackup.util.EvenFilterImpl;
import studentRecordsBackup.util.OddFilterImpl;
import studentRecordsBackup.util.OddEvenEnum.EvenOddEnum;

public class Node implements SubjectI, ObserverI {

	private int bNum;
	private Node left, right;
	private boolean max;
	private HashMap<ObserverI, EvenOddEnum> observers;
	private static EvenFilterImpl evenFilter = new EvenFilterImpl();
	private static OddFilterImpl oddFilter = new OddFilterImpl();

	public Node(int bNumIn) {
		setbNum(bNumIn);
		setMax(false);
		observers = new HashMap<ObserverI, EvenOddEnum>();
	}

	/**
	 * method to get left node
	 */
	public Node getLeft() {
		return left;
	}

	/**
	 * method to set left node
	 */
	public void setLeft(Node leftIn) {
		this.left = leftIn;
	}

	/**
	 * method to get right node
	 */
	public Node getRight() {
		return right;
	}

	/**
	 * @param rightIn
	 *            method to set rightnode
	 */
	public void setRight(Node rightIn) {
		this.right = rightIn;
	}

	/**
	 * method to get BNumber
	 */
	public int getbNum() {
		return bNum;
	}

	/**
	 * @param bNum
	 *            method to set BNum
	 */
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

	/**
	 * method to check whether node has max value or not
	 */
	public boolean isMax() {
		return max;
	}

	/**
	 * @param maxIn
	 *            method to set max flag
	 */
	public void setMax(boolean maxIn) {
		this.max = maxIn;
	}

	/**
	 * @param updateValue
	 *            method to update the BNumber
	 */
	public void updateNode(int updateValue) {
		// TODO Auto-generated method stub
		if (isMax())
			setbNum(getbNum() + (2 * updateValue));
		else
			setbNum(getbNum() + updateValue);
		updateObservers(updateValue);

	}

	/**
	 * @param updateValue
	 *            method to update Observer BNumber
	 */
	public void updateObserver(int updateValue) {
		setbNum(getbNum() + updateValue);
	}

	/**
	 * @param updateValue
	 *            method to update Observers
	 */
	@Override
	public void updateObservers(int updateValue) {
		// TODO Auto-generated method stub
		for (Map.Entry<ObserverI, EvenOddEnum> o : observers.entrySet()) {
			if (o.getValue() == EvenOddEnum.EVEN) {
				if (evenFilter.check(updateValue))
					o.getKey().updateObserver(updateValue);
			} else if (o.getValue() == EvenOddEnum.ODD) {
				if (oddFilter.check(updateValue))
					o.getKey().updateObserver(updateValue);
			} else {
				System.out.println("Invalid Filter...");
			}
		}

	}

	/**
	 * @param o
	 * @param filter
	 *            method to register observers
	 */
	@Override
	public void registerObserver(ObserverI o, EvenOddEnum filter) {
		// TODO Auto-generated method stub
		observers.put(o, filter);

	}

}
