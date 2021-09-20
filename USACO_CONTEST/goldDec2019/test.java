package goldDec2019;

import java.util.Arrays;
import javax.swing.JOptionPane;
public class test {
	public static void main(String args[]) {
		int[][] tes = new int[10][10]; 
		for(int i = 0; i < 10; i++) Arrays.fill(tes[i], 9);
		for(int[] ary : tes) {
			for(int item : ary) System.out.print(item + " " );
			System.out.println();
		}
	}
}
