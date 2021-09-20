package permuatations;

import java.util.Arrays;

public class nextPermutation {
	// Function to swap the data
	// present in the left and right indices
	public static int[] swap(int data[], int left, int right) {
		int temp = data[left];
		data[left] = data[right];
		data[right] = temp;
		return data;
	}

	// Function to reverse the sub-array
	// starting from left to the right
	// both inclusive
	public static int[] reverse(int data[], int left, int right) {
		while (left < right) {
			int temp = data[left];
			data[left++] = data[right];
			data[right--] = temp;
		}
		return data;
	}

	// Function to find the next permutation
	// of the given integer array
	public static boolean findNextPermutation(int data[]) {
		if (data.length <= 1)
			return false;
		int last = data.length - 2;
		while (last >= 0) {
			if (data[last] < data[last + 1]) {
				break;
			}
			last--;
		}
		if (last < 0)
			return false;
		int nextGreater = data.length - 1;
		for (int i = data.length - 1; i > last; i--) {
			if (data[i] > data[last]) {
				nextGreater = i;
				break;
			}
		}
		data = swap(data, nextGreater, last);
		data = reverse(data, last + 1, data.length - 1);
		return true;
	}

	public static void main(String args[]) {
		int data[] = { 3, 2, 1, 3 };
		long time = System.currentTimeMillis();
		do {
			System.out.println(Arrays.toString(data));
		} while(findNextPermutation(data)); 
		System.out.println( (System.currentTimeMillis()-time)); 	
	}
}
