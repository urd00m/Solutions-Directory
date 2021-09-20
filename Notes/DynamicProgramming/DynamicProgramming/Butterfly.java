package DynamicProgramming;

//used to calculate different ways to create sets, such as addition 



public class Butterfly {
	public static void main(String args[]) {
		
	}
	
	//order does matter 
	public static int butterflyOrderMatters(int finishIndex, int[] items) {
		int total = 0; 
		int[] map = new int[finishIndex+1]; 
		map[0] = 1; 
		for(int i = 0; i < finishIndex+1; i++) {
			for(int item : items) {
				map[i+item] += map[i]; 
			}
		}
		
		return total; 
	}
	
	//order doesn't matter
	public static int butterflyOrderDoesNotMatter(int finishIndex, int[] items ) {
		int total = 0; 
		int[] map = new int[finishIndex+1]; 
		map[0] = 1; 
		for(int item : items ) {
			for(int i = 0; i < finishIndex+1; i++) {
				map[i+item] += map[i]; 
			}
		}
		return total; 
	}

}
