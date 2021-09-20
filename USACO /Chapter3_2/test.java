package Chapter3_2;

public class test {
	public static void main(String args[]) {
		int p = 176; 
		int at = p & 0x3FF; 
		int cost = p>>>10; 
		System.out.println(at + " " + cost);
	}
}
