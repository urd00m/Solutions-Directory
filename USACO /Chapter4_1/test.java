package Chapter4_1;

public class test {
	public static void main(String args[]) {
		int[] a = new int[2000000000];
		a[4324342] = 1;
		System.out.println(a[4324342]); 
	}
}
