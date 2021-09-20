package Sort;

public class QuickSort {
	public static void main(String[] args) {
		int[] x = numG(10000000);
		int low = 0;
		int high = x.length - 1;
		
		long now = System.currentTimeMillis(); //records time
		quickSort(x, low, high);
		System.out.println("quick sort Time total is: " + (System.currentTimeMillis() - now) ); //prints out the time it took to sort
	}
 
	public static int[] numG(int Size) { //for test
		int[] arry = new int[Size];
		for(int i = 0; i < Size; i++) {
			arry[i] = (int)(Math.random()*5000);
		}
		return arry;
	}

	public static void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
	}
}