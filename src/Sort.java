import java.util.*;
import java.io.*;

/**
 * This class implements simple ways to sort and print numbers provided in a
 * file
 * 
 * @author Mary Mercado
 * @version 1.0
 */
interface SortChallenge {
	/**
	 * Public method to sort an array of integers in ascending or descending order
	 * 
	 * @param list      the array that contains the numbers given in the file
	 * @param ascending a boolean value of requested order, true if ascending, false
	 *                  if descending
	 * @return the sorted array of integers
	 */
	public int[] simpleSort(int[] list, boolean ascending);

	/**
	 * Public method to print the integers in an array in ascending order and
	 * display the frequency of each number
	 * 
	 * @param list the array that contains the numbers given in the file
	 */
	public void printSortedFrequency(int[] list);

	/**
	 * Public method to return the number of unique values in our array
	 * 
	 * @param list list the array that contains the numbers given in the file
	 * @return the number of unique values
	 */
	public int numberOfUniqueValues(int[] list);
}

public class Sort implements SortChallenge {

	/**
	 * Method sorts an array of integers in ascending or descending order
	 */
	public int[] simpleSort(int[] list, boolean ascending) {

		if (ascending == true) {
			int n = list.length;
			for (int i = 1; i < n; ++i) {
				int key = list[i];
				int j = i - 1;

				while (j >= 0 && list[j] > key) {
					list[j + 1] = list[j];
					j = j - 1;
				}
				list[j + 1] = key;
			}
		} else {
			int n = list.length;
			for (int i = 1; i < n; ++i) {
				int key = list[i];
				int j = i - 1;

				while (j >= 0 && list[j] < key) {
					list[j + 1] = list[j];
					j = j - 1;
				}
				list[j + 1] = key;
			}
		}

		return list;
	}

	/**
	 * Method prints the integers in an array in ascending order and display the
	 * frequency of each number
	 */
	public void printSortedFrequency(int[] list) {

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		int count = 0;
		
		// Traverse the array of numbers
		for (int i = 0; i < list.length; i++) {
			Integer c = hmap.get(list[i]);

			// First occurence of a number
			if (hmap.get(list[i]) == null)
				hmap.put(list[i], 1);

			// Number already exists, increment
			else
				hmap.put(list[i], ++c);
		}

		for (Map.Entry m : hmap.entrySet())
			System.out.println(m.getKey() + " appears " + m.getValue() + " times ");

	}

	/**
	 * Method returns the number of unique values in our array
	 */
	public int numberOfUniqueValues(int[] list) {

		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		int count = 0;

		// Traverse the array of numbers
		for (int i = 0; i < list.length; i++) {
			Integer c = hmap.get(list[i]);

			// First occurence of a number
			if (hmap.get(list[i]) == null)
				hmap.put(list[i], 1);

			// Number already exists, increment
			else
				hmap.put(list[i], ++c);
		}

		return hmap.size();

	}

	/**
	 * Main method: Accepts filename and sort order
	 * 
	 * @param args "filename", sort-ascending (true/false)
	 * @throws FileNotFoundException provided filename does not exist or is not
	 *                               accessible
	 */
	public static void main(String args[]) throws FileNotFoundException {

		File numbers;
		String ascending;
		String line = null;

		if (args.length == 0) {

			Scanner in = new Scanner(System.in);
			System.out.println("Please enter the filename including file:");
			String filename = in.nextLine().trim();
			numbers = new File(filename);

			System.out.println("Ascending order? Please use true/false:");
			ascending = in.nextLine();

		} else {
			numbers = new File(args[0]);
			ascending = args[1];
		}

		boolean sortOrder = ascending.equalsIgnoreCase("true") ? true : false;

		Scanner scan = new Scanner(numbers); // provide file name from outside
		int counter = 0; // keep track of how many integers in the file

		while (scan.hasNextLine()) {
			line = scan.nextLine();
			
			//If line is blank or non-numeric, skip it. It won't be processed
			if ((!line.equals("")) || (line.matches("[0-9]+"))) {
				counter++;
			}
		}

		Scanner scan2 = new Scanner(numbers);
		int a[] = new int[counter];
		for (int i = 0; i < counter; i++) {
			
			line = scan2.nextLine();
			
			//Make sure it is only numeric
			if (line.matches("[0-9]+")) {
				a[i] = Integer.parseInt(line);
			}
			else {
				//Make sure there is actually another line to get
				if(scan2.hasNextLine()) {
					line = scan2.nextLine();
				}
			}
		}

		Sort sortObject = new Sort();

		sortObject.simpleSort(a, sortOrder);

		for (int i = 0; i < counter; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		sortObject.printSortedFrequency(sortObject.simpleSort(a, true));

		System.out.println("The number of unique values is " + sortObject.numberOfUniqueValues(a));

	}

}