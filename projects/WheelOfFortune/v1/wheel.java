package v1;
//the wheel of fortune 
import java.io.*;
import java.lang.Math;

public class wheel {
	String[] items = new String[12]; 
	int[] max = new int[12]; 
	int[] min = new int[12];
	
	
	public wheel() throws IOException {
		//do nothing 
		BufferedReader f = new BufferedReader(new FileReader("names.in")); 
		for(int i = 0; i < 12; i++) {
			items[i] = f.readLine(); 
		}
		//assignning min and Max 
		f = new BufferedReader(new FileReader("percentages.in")); 
		int l = 0; 
		for(int i = 0; i < 12; i++) {
			int cur = Integer.parseInt(f.readLine()); 
			min[i] = l; max[i] = l+cur-1; 
			l += cur; 
		}
	}
	
	public String[] getDecode() {
		return items; 
	}
	
	//when called it does a spin 
	//and returns the number of the block chosen 
	public int spin() { 
		int ret = -1; 
		int spinNum = (int)(Math.random()*100); //0 to 99
		for(int i = 0; i < 12; i++) {
			if(spinNum >= min[i] && spinNum <= max[i]) {
				//this is the one 
				ret = i; 
				break; 
			}
		}
		return ret; 
		
	}
	
	//takes in the number of spins the user wishes to do 
	//and returns the spin numbers 
	public int[] spin(int num) {
		int[] ret = new int[num]; //0, 1, 2 are good for a spin and counted towards the total number 
		for(int i = 0; i < num; i++) {
			ret[i] = spin(); 
		}
		return ret; 
	}
}
