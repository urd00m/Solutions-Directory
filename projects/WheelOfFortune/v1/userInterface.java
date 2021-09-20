package v1;

import v1.wheel;

import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;

public class userInterface {
	static String[] decode;

	public static void main(String args[]) throws IOException {
		int gems, initialGems;
		gems = Integer.parseInt(JOptionPane.showInputDialog("How many gems?"));
		initialGems = gems;
		ArrayList<Integer> results = new ArrayList<Integer>();
		boolean freeSpin = true;
		boolean reducedSpin = true;
		int spinCounter = 0;
		wheel spinner = new wheel();
		decode = spinner.getDecode();
		int run = Integer.parseInt(JOptionPane.showInputDialog("Run Times?"));
		double[] averages = new double[12];
		for (int runNum = 1; runNum <= run; runNum++) {
			while (gems >= 800) {
				int option;
				if (freeSpin == true && gems >= 3600) {
					option = Integer.parseInt(JOptionPane.showInputDialog("5 = 5*spins 3600 gems\n0 = free spin"));
					if (option == 0) {
						gems -= 0;
						freeSpin = false;
						results.add(spinner.spin());
						spinCounter++;
					} else {
						spinCounter += 5;
						gems -= 3600;
						int[] store = spinner.spin(5);
						for (int i = 0; i < 5; i++) {
							results.add(store[i]);
						}
					}
				} else if (freeSpin == true && gems < 3600) {
					option = Integer.parseInt(JOptionPane.showInputDialog("0 = free spin"));
					gems -= 0;
					freeSpin = false;
					results.add(spinner.spin());
					spinCounter++;
				} else if (reducedSpin == true && gems >= 3600) {
					option = Integer
							.parseInt(JOptionPane.showInputDialog("5 = 5*spins 3600 gems\n1 = 1*spin 400 gems"));
					if (option == 1) {
						gems -= 400;
						reducedSpin = false;
						results.add(spinner.spin());
						spinCounter++;
					} else {
						gems -= 3600;
						int[] store = spinner.spin(5);
						spinCounter += 5;
						for (int i = 0; i < 5; i++) {
							results.add(store[i]);
						}
					}
				} else if (reducedSpin == true && gems < 3600) {
					option = Integer.parseInt(JOptionPane.showInputDialog("1 = 1*spin 400 gems"));
					gems -= 400;
					reducedSpin = false;
					results.add(spinner.spin());
					spinCounter++;
				} else if (gems < 3600) {
					option = Integer.parseInt(JOptionPane.showInputDialog("1 = 1*spin 800 gems"));
					gems -= 800;
					results.add(spinner.spin());
					spinCounter++;
				} else {
					option = Integer
							.parseInt(JOptionPane.showInputDialog("5 = 5*spins 3600 gems\n1 = 1*spin 800 gems"));
					if (option == 1) {
						gems -= 800;
						spinCounter++;
						results.add(spinner.spin());
					} else {
						spinCounter += 5;
						gems -= 3600;
						int[] store = spinner.spin(5);
						for (int i = 0; i < 5; i++) {
							results.add(store[i]);
						}
					}
				}
				JOptionPane.showConfirmDialog(null, "You have spun a total of " + spinCounter + "\nYou have " + gems
						+ " remaining\nYou have used " + (initialGems - gems) + " gems");
				printItems(results);
			}

			// out of gems
			JOptionPane.showConfirmDialog(null, "Out of Gems!\nYou have spun a total of " + spinCounter
					+ "\nYou have used " + (initialGems - gems) + " gems");
			int[] occ = printItems(results);
			for (int i = 0; i < 12; i++) {
				averages[i] += occ[i];
			}
			results.clear(); 
			freeSpin = true; 
			reducedSpin = true; 
			gems = initialGems; 
			spinCounter = 0; 
		}
		for(int i = 0; i < 12; i++) {
			averages[i] /= (run*1.0); 
		}
		//display 
		double sculCount = 0.0; 
		String message = ""; 
		for (int i = 0; i < 12; i++) {
			if (i == 0 || i == 1) {
				sculCount += averages[i];
			}
			if (i == 2) {
				sculCount += 8 * averages[i];
			}
			message += "You got " + decode[i] + " " + averages[i] + " times\n";
		}
		message += "You got " + sculCount + " legendary commander sculptures to use!";
		JOptionPane.showMessageDialog(null, message);
	}

	public static int[] printItems(ArrayList<Integer> results) {
		// calculating results

		int[] occ = new int[12];
		Arrays.fill(occ, 0);
		for (int i = 0; i < results.size(); i++) {
			occ[results.get(i)]++;
		}
		String message = "";
		int sculCount = 0;
		for (int i = 0; i < 12; i++) {
			if (i == 0 || i == 1) {
				sculCount += occ[i];
			}
			if (i == 2) {
				sculCount += 8 * occ[i];
			}
			message += "You got " + decode[i] + " " + occ[i] + " times\n";
		}
		message += "You got " + sculCount + " legendary commander sculptures to use!";
		JOptionPane.showMessageDialog(null, message);
		return occ;
	}
}
