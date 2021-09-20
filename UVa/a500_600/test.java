package a500_600;
import java.util.*;

public class test {
	public static void main(String args[]) {
		ArrayList<String> a = new ArrayList<String>(); 
		a.add("2 15"); 
		a.add("2 25"); 
		Collections.sort(a, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				String[] a1 = a.split(" "); 
				String[] b1 = b.split(" ");
				for(int i = 0; i < a1.length; i++) {
					if(Integer.parseInt(a1[i]) < Integer.parseInt(b1[i])) return -1;
					else if (Integer.parseInt(a1[i]) < Integer.parseInt(b1[i])) return 1; 
				}
				return 0;
			}
		}); 
		System.out.println(a.toString());
	}
}
