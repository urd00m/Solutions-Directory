package Chapter2_2;

import java.util.ArrayList;
import java.util.Collections;

public class test {
	public static void main(String args[]) {
		ArrayList<String> in = new ArrayList<String>(); 
		in.add("110110110");
		in.add("010101010");
		Collections.sort(in);
		System.out.println(in.get(0) + " " + in.get(1));
	}
}
