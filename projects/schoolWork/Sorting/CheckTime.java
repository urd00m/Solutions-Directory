package Sorting;

/**
 * CheckTime.java
 *
 * @author - Gordon
 *
 * This program gets the current time in milliseconds
 *
 */



public class CheckTime
{
   public static void main(String[] args)
   {
   	int length = 50000;
   	/*							|	30	|	100	|	1000	|
   	 *							________________________________
   	 *		bubble sort:		|	0	|	0	|	
   	 *		Selection sort:		|	0	|	0	|
   	 *		inseration sort:	|	0	|	0	|
   	 *		merge sort:			|	0	|	0	|
   	 *
   	 *
   	 */
   	
   	
   	

   	int[] unsorted = new int[length]; //the arrays to be sorted
   	int[] unsortedC = new int[length];
	getNumbers(unsorted);    //gets random numbers for an array
		
		
	
	//selection sort        
   	copy(unsortedC, unsorted); //copies the randomized array to a new array
   	long now = System.currentTimeMillis(); //records time
   	selectionSort(unsortedC, unsortedC.length); //sorts the array
   	System.out.println("selection sort Time total is: " + (System.currentTimeMillis() - now) ); //prints out the time it took to sort
   	//printArray(unsorted);
   	
	//bubble sort
   	copy(unsortedC, unsorted); //resets the array to be sorted to the same array before sort
   	now = System.currentTimeMillis();
   	bubblesort(unsortedC);  //bubble sort
   	System.out.println("bubble sort total time: " + (System.currentTimeMillis() - now) );  //prints time of sort
   	//printArray(unsorted);
   	
	//insertion sort   
	copy(unsortedC, unsorted); //resets the array to be sorted to the same array before sort
   	now = System.currentTimeMillis();
   	insertionSort(unsortedC, unsortedC.length);   //inseration sort
   	System.out.println("insertion sort Total time " + (System.currentTimeMillis()-now));
   	//printArray(unsorted);
		
	//merge      //Limit: 7735773
	copy(unsortedC, unsorted);  //resets the array to be sorted to the same array before sort
   	now = System.currentTimeMillis();
   	mergesort(unsortedC, 0, unsortedC.length);  //merge sorts
   	System.out.println("merge sort total time: " + (System.currentTimeMillis() - now) ); //prints time
   	//printArray(unsorted);
   	

   }
   
   public static void copy(int[] n, int[] arry) {
   	for(int i =0; i<arry.length;i++) {
   		n[i] = arry[i];
   	}
   }
   
   //methods
   public static void getNumbers(int[] array) {
   	for(int i = 0; i < array.length; i++) {
   		array[i] = (int)(Math.random()*100);
   	}
   }
   public static void printArray(int[] array) {
   	for(int i = 0; i < array.length; i++) {
   		System.out.print(array[i] + " " );
   	}
   	System.out.println();
   }
   public static void selectionSort(int numbers[], int array_size) {
   	int i, j;
		int min, temp;
		for (i = 0; i < array_size-1; i++)
		{
			min = i;
			for (j = i+1; j < array_size; j++)
			{
				if (numbers[j] < numbers[min])

					min = j;
			}
		temp = numbers[i];
		numbers[i] = numbers[min];
		numbers[min] = temp;
		}
	}
	public static void insertionSort(int numbers[], int array_size)
	{
		int temp; // this variable is the element of the unsorted array currently
		
		// being compared to elements of the sorted array.
		int pos; // this variable keeps track of where in the sorted array the
		// comparison takes place
		for (int i = 1; i < array_size; i++) // loop through the unsorted array
		{
		
			// (the first element is considered sorted)
			temp = numbers[i]; // grab the first element of the unsorted array
			pos = i - 1; // get the index of the last sorted element
			
			while ((pos >= 0) && (temp < numbers[pos])) // while the current sorted element
			// is greater than temp
			{
				numbers[pos + 1] = numbers[pos]; // keep shifting sorted elements back by 1
				pos--; // decrement the pos index
			}
			numbers[pos + 1] = temp; // insert temp such that array[pos] <= temp < array[pos + 2]
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
		
		public static void bubblesort(int[] arr) {
			 int n = arr.length;  
		        int temp = 0;  
		         for(int i=0; i < n; i++){  
		                 for(int j=1; j < (n-i); j++){  
		                          if(arr[j-1] > arr[j]){  
		                                 //swap elements  
		                                 temp = arr[j-1];  
		                                 arr[j-1] = arr[j];  
		                                 arr[j] = temp;  
		                         }  
		                          
		                 }  

		         }
		}
	

}