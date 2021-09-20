package USACO;

import java.util.Arrays;
import java.util.Comparator;

import USACO.snowboots.tile;

public class SortTest {
	public static void main(String args[]) {
		boot[] a = new boot[10];
		boot[] b = new boot[10]; 
		set(a, b);
		Arrays.sort(a, new Comparator<boot>() {
			@Override 
			public int compare(boot o1, boot o2) {
				return o2.getRes()-o1.getRes();
			}
		});
		
		Arrays.sort(b, new Comparator<boot>() {
			@Override 
			public int compare(boot o1, boot o2) {
				return o1.getRes()-o2.getRes();
			}
		});
		print(a);
		System.out.println();
		print(b);
	}
	
	public static void print(boot[] e) {
		for(int i =0; i < 10; i++) {
			System.out.print(" " + e[i].getRes());
		}
	}
	public static void set(boot[] c, boot[] d) {
		int set =0;
		for(int i =0; i < 10; i++) 
		{
			set = (int)(Math.random()*100);
			c[i] = new boot(set, 0);
			d[i] = new boot(set, 0);
		}
	}
	
	public static class boot {
		private int res;
		private int step;
		public boot(int a, int b) {
			res = a;
			step = b;
		}
		public int getRes() {
			return res;
		}
		public int getStep() {
			return step;
		}
	}
}
