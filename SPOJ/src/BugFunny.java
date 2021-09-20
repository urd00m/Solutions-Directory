//package src;
/*
ID: urd00m
LANG: JAVA
TASK: BugFunny
 */
import java.util.*;
import java.io.BufferedReader;
import java.lang.*;
import java.io.*;

public class BugFunny {
	public static void main(String args[]) throws java.lang.Exception, IOException {
		//input 
		BufferedReader f = new BufferedReader(new FileReader("BugFunny.in")); StringTokenizer input;  //new java.io.InputStreamReader(System.in)
		while(f.ready() == true) {
			input = new StringTokenizer(f.readLine()); 
			if(input.nextToken().indexOf(input.nextToken()) != -1) System.out.println("1"); 
			else System.out.println("0");
		}
		f.close();
	}
}
