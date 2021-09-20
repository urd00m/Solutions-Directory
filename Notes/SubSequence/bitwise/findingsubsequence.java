package bitwise;

import java.util.ArrayList;

public class findingsubsequence {
	public static void main(String args[]) {
		int[] a = {1,2,3,4,5}; 
		ArrayList<int[]> sub = new ArrayList<int[]>(); 
		for(int i = 1; i < 32; i++) {
			 int[] result = new int[5]; 
			 int curIndex = 0; 
			 for (int j=0; j<5; j++) {
				 if ( ((1<<j) & i) > 0 ) {
					 result[curIndex] = a[j]; 
					 curIndex++; 
				 }
			 }  
			 sub.add(result); 
		}
		
		for(int[] b : sub) {
			for(int item : b) {
				System.out.print(item + " " );
			}
			System.out.println();
		}
		
		System.out.println();
		
		ArrayList<Integer> test = new ArrayList<Integer>();
		ArrayList<Integer> test2 = new ArrayList<Integer>(); 
		test.add(1); 
		test2.add(1);
		System.out.println(test + " " + test2);
		int[] ary = {1,2,3};
		obj x = new obj(ary);
		obj y = new obj(ary); 
		System.out.println(x.toString() + " " + y.toString()); 
	}
	
	public static class obj {
		int[] v;
		public obj(int[] a) {
			v = a; 
		}
		
		public String toString() {
			String output = ""; 
			for(int item : v ) {
				output += item + " "; 
			}
			return output; 
		}
	}
}

