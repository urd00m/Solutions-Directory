package Chapter2_2;
/*
ID: alan.li2
LANG: JAVA
TASK: runround	
 */
import java.util.*;
import java.io.*; 
public class runround {
	static long Start;
	static Long next; 
	public static void main(String args[]) throws IOException {
		//input
		BufferedReader f = new BufferedReader(new FileReader("runround.in"));
		Start = Long.parseLong(f.readLine()); //want as string, easier to access the substrings
		next = Long.MAX_VALUE;  
		f.close();
		
		while(next == Long.MAX_VALUE) {
			Start++;
			if(runRound("" + Start) == true) 
				next = Start; 
		}
		
		//output
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
		out.println(next);
		out.close();
		
		
	}

	public static boolean runRound(String number) {
		//gets rid of zeros
		Long input = Long.parseLong(number);
		number = "" + input;
		boolean[] marked = new boolean[number.length()]; 
		boolean[] unique = new boolean[10];
		int index = 0; 
		marked[0] = true; 
		unique[0] = true;
		for(int i = 0; i < number.length(); i++) {
			if(i == number.length()-1) marked[0] = false; 
			index = (Integer.parseInt(number.substring(index, index+1))+index)%number.length(); //setting the new index, next index
			if(marked[index] == true || unique[Integer.parseInt(number.substring(index,index+1))] == true) 
				return false; 
			else {
				marked[index] = true; 
				unique[Integer.parseInt(number.substring(index,index+1))] = true; 
			}
		}
		return true;
	}
}
