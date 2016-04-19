package studentRecordsBackup.util;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.bst.Node;
import studentRecordsBackup.util.OddEvenEnum.EvenOddEnum;

public class BSTBuilder {

	private FileProcessor fileProcessor;
	BST main, backup1, backup2;

	public BSTBuilder(FileProcessor fileProcessorIn, BST mainIn, BST backup1In, BST backup2In) {
		main = mainIn;
		backup1 = backup1In;
		backup2 = backup2In;
		fileProcessor = fileProcessorIn;
	}

	/**
	 * method to build trees
	 */
	public void buildBST() {
		int bnum;
		Node s, o1, o2;
		for (String line = fileProcessor.readLineFromFile(); line != null; line = fileProcessor.readLineFromFile()) {
			try {
				bnum = Integer.parseInt(line);
				s = new Node(bnum);
				main.insert(s);
				o1 = new Node(bnum);
				o2 = new Node(bnum);
				backup1.insert(o1);
				backup2.insert(o2);
				s.registerObserver(o1, EvenOddEnum.EVEN);
				s.registerObserver(o2, EvenOddEnum.ODD);

			} catch (NumberFormatException e) {
				System.out.println("Invalid input from file");
				System.out.println(e.getMessage());
				e.printStackTrace();
			} finally {

			}

		}

	}

}
