package a200_300;
/*
ID: alwang 
LANG: JAVA
TASK: texQuotes
 */
import java.io.*;
import java.util.*; 
public class texQuotes {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("texQuotes.in")); 
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("texQuotes.out"))); 
		boolean first = true;
		while(f.ready()) {
			String line = f.readLine(); 
			 
			String ret = ""; 
			for(int i = 0; i < line.length(); i++) {
				if(line.substring(i, i+1).equals("\"")) {
   					if(first) {
   						ret = ret + "``"; 
   						first = false; 
   					}
   					else {
   						ret = ret + "\'\'";
   						first = true; 
   					}
				}
				else {
					ret = ret + line.substring(i, i+1); 
				}
			}
			out.println(ret);
		}
		out.close();
		f.close();
	}
}
