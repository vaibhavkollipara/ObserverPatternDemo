package studentRecordsBackup.driver;

import studentRecordsBackup.bst.BST;
import studentRecordsBackup.util.BSTBuilder;
import studentRecordsBackup.util.FileProcessor;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BST main, backup1, backup2;
		int updateValue;
		String filename;
		if (args.length == 2) {
			main = new BST();
			backup1 = new BST();
			backup2 = new BST();
			try {
				filename = args[0];
				updateValue = Integer.parseInt(args[1]);
				new BSTBuilder(new FileProcessor(filename), main, backup1, backup2).buildBST();
				System.out.println("Before Update");
				main.printInorder();
				backup1.printInorder();
				backup2.printInorder();
				System.out.println();
				main.printBSum();
				backup1.printBSum();
				backup2.printBSum();
				main.increment(updateValue);
				System.out.println("\n\nAfter Update");
			/*	main.printInorder();
				backup1.printInorder();
				backup2.printInorder();
				// printing sum of bNums*/
				System.out.println();
				main.printBSum();
				backup1.printBSum();
				backup2.printBSum();
			} catch (NumberFormatException e) {
				System.out.println("Invalid Command line argument for update value");
				System.out.println(e.getMessage());
				e.printStackTrace();
			} finally {
			}

		} else {
			System.out.println("Invalid No. Of Command Line Arguments");
		}
	}

}
