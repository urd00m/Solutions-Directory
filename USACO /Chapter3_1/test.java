package Chapter3_1;

public class test {
	public static void main(String args[]) {
		long[] a = new long[100000000];
		a[99999999] = 2113; 
		a[0] = 2343; 
		System.out.println(a[99999999]);
	}

}
