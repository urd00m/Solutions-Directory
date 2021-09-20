package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: beads
 */
import java.util.*;
import java.io.*;
public class beads {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		
		int nB = Integer.parseInt(f.readLine());

		String beads = f.readLine();
		
		int maxB = 0;
		beads =  beads + beads;
		String current = "";
		for(int i = 0; i < nB; i++) {
			int j = i;
			boolean switched = false;
			int counter = 0;
			while(j < nB*2 && (beads.substring(j, j+1).equals(current) || beads.substring(j, j+1).equals("w"))) {
				if(!beads.substring(j, j+1).equals("w") && current.equals("")) current = beads.substring(j, j+1);
				j++;
				if((!beads.substring(j, j+1).equals(current) && !beads.substring(j, j+1).equals("w")) && switched == false) {
					current = beads.substring(j, j+1);
					switched = true;
				}
				counter++;
				
			}
			if(counter > maxB) maxB = counter;
		}
		out.print(maxB);
		out.close();
		
	}
}

