package heap;

public class HeapTester {
	public static void main(String args[]) {
		Heap a = new Heap(); 
		for(int i = 0; i < 10; i++)
			a.add(i);
		
		for(int i = 0; i < 10; i++)
			System.out.println(a.pop_max());
	}

}
