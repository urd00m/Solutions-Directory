//package chapter2_4;
/*
ID: alan.li2
LANG: JAVA
TASK: fracdec
 */

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class fracdec {
	static int n, d; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("fracdec.in")); 
		StringTokenizer input = new StringTokenizer(f.readLine());
		n = Integer.parseInt(input.nextToken()); 
		d = Integer.parseInt(input.nextToken());
		BigDecimal numerator = new BigDecimal(n);
		BigDecimal denamonator = new BigDecimal(d); 
		numerator.divide(denamonator); 
		
	}
}
