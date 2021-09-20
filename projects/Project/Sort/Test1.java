package Sort;

public class Test1 {
	public static void main(String args[]) {
		
		
		int[] test = numG(10000000);
		int[] unsorted = new int[test.length];
		//double[] test = {5,6,.5,8,8,.3,.32,10,0};
		//double[] unsorted = new double[test.length];
		//double[] test = numGD(20000000, 2);
		//double[] unsorted = new double[test.length];
		copy(unsorted, test);
		
		char hello = 'a';
		int b = hello;
		System.out.println(b);
		
		//number line      (basically the bucket sort but different used more space (may or may not be faster)
		long now = System.currentTimeMillis(); //records time
		test = NumberLineSort(test, 0, 5000, 0);
		System.out.println("Number Line sort Time total is: " + (System.currentTimeMillis() - now) ); //prints out the time it took to sort
		//System.out.println(printArry(test));
		
		//merge
		/*
		copy(test, unsorted);
		now = System.currentTimeMillis(); //records time
		mergesort(test, 0, test.length);
		System.out.println("merge sort Time total is: " + (System.currentTimeMillis() - now) ); //prints out the time it took to sort
		*/
		//System.out.println(printArry(test));
		
		

	}
	
	public static int[] numG(int Size) { //for test
		int[] arry = new int[Size];
		for(int i = 0; i < Size; i++) {
			arry[i] = (int)(Math.random()*5000);
		}
		return arry;
	}
	
	public static double[] numGD(int Size, int decimal) { //for test
		double[] arry = new double[Size];
		for(int i = 0; i < Size; i++) {
			arry[i] = (Math.round((Math.random()*5000)*Math.pow(10, decimal))/Math.pow(10, decimal));
		}
		return arry;
	}
	
	private static String printArry(int[] a) {
		String b = "";
		for(int i = 0; i < a.length; i++) {
			b = b + " " + a[i];
		}
		return b;
	}
	private static String printArry(double[] a) {
		String b = "";
		for(int i = 0; i < a.length; i++) {
			b = b + " " + a[i];
		}
		return b;
	}
	
	private static double[] NumberLineSort(double[] arry, int min, int max, int decimals) {
		
		int[] store = new int[ (int) ((max-min + 1) * (Math.pow(10, decimals)))];  //roughly max 320 000 000
		for(int i = 0; i < arry.length; i++) {
			store[(int) ((arry[i]-min)*(Math.pow(10, decimals)))]++;
		}
		
		//converting it to one array
		double[] sorted = new double[arry.length];
		int index = 0;
		for(int i = 0; i < sorted.length; index++) {
			for(int j = 0; j < store[index]; j++) {
				sorted[i] = (index+min)/(Math.pow(10, decimals));
				i++;
			}
		}
		return sorted;
	}
	private static int[] NumberLineSort(int[] arry, int min, int max, int decimals) {
		
		int[] store = new int[ (int) ((max-min + 1) * (Math.pow(10, decimals)))];  //roughly max 320 000 000
		for(int i = 0; i < arry.length; i++) {
			store[(int) ((arry[i]-min)*(Math.pow(10, decimals)))]++;
		}
		
		//converting it to one array
		int[] sorted = new int[arry.length];
		int index = 0;
		for(int i = 0; i < sorted.length; index++) {
			for(int j = 0; j < store[index]; j++) {
				sorted[i] = (int) ((index+min)/(Math.pow(10, decimals)));
				i++;
			}
		}
		return sorted;
	}
	
	
	
	
	
	
	public static void copy(int[] n, int[] arry) {
		   	for(int i =0; i<arry.length;i++) {
		   		n[i] = arry[i];
		   	}
	}
	public static void copy(double[] n, double[] arry) {
	   	for(int i =0; i<arry.length;i++) {
	   		n[i] = arry[i];
	   	}
}
		   
	public static void mergesort(int[ ] data, int first, int n)
	{
		int n1; // Size of the first half of the array
		int n2; // Size of the second half of the array
		
		if (n > 1)
		{
		// Compute sizes of the two halves
		n1 = n / 2;
		n2 = n - n1;
		
		//printArray(data,6);
		
		mergesort(data, first, n1); // Sort data[first] through data[first+n1-1]
		
		mergesort(data, first + n1, n2); // Sort data[first+n1] to the end
		
		// Merge the two sorted halves.
		merge(data, first, n1, n2);
		//printArray(data,6);
		
		}
		}
		
		private static void merge(int[ ] data, int first, int n1, int n2)
		// Precondition: data has at least n1 + n2 components starting at data[first]. The first
		// n1 elements (from data[first] to data[first + n1 ñ 1] are sorted from smallest
		
		// to largest, and the last n2 (from data[first + n1] to data[first + n1 + n2 - 1]) are also
		// sorted from smallest to largest.
		// Postcondition: Starting at data[first], n1 + n2 elements of data
		// have been rearranged to be sorted from smallest to largest.
		// Note: An OutOfMemoryError can be thrown if there is insufficient
		// memory for an array of n1+n2 ints.
		{
			int[ ] temp = new int[n1+n2]; // Allocate the temporary array
			int copied = 0; // Number of elements copied from data to temp
			int copied1 = 0; // Number copied from the first half of data
			int copied2 = 0; // Number copied from the second half of data
			int i; // Array index to copy from temp back into data
			
			// Merge elements, copying from two halves of data to the temporary array.
			while ((copied1 < n1) && (copied2 < n2))
			{
				if (data[first + copied1] < data[first + n1 + copied2])
					temp[copied++] = data[first + (copied1++)];
				else
					temp[copied++] = data[first + n1 + (copied2++)];
			}
				
				// Copy any remaining entries in the left and right subarrays.
				while (copied1 < n1)
					temp[copied++] = data[first + (copied1++)];
				while (copied2 < n2)
					temp[copied++] = data[first + n1 + (copied2++)];
				
				// Copy from temp back to the data array.
				
				for (i = 0; i < n1+n2; i++)
					data[first + i] = temp[i];
		}
		
		

}
