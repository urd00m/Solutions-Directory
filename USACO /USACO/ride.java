package USACO;

/*
ID: alan.li2
LANG: Java
TASK: ride
 */
import java.util.*;
import java.io.*;

public class ride {
	public static void main(String args[]) throws IOException {
		String read = "COMETQ";
		int anum = 1;
		int hnum = 1;
		int i = 0;
		for(int j = 0; j < read.length(); j++) {
			if(i == 0) {
				anum = anum * (read.charAt(j) - 64);
				System.out.println((read.charAt(j) - 64));
			}
			else hnum = hnum * (read.charAt(j) - 96);
		}
		System.out.println(anum);
		
		
	}

}
