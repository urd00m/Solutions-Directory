package Chapter4_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import Chapter4_3.buylow.slot;

public class test {
	static int n; 
	static slot[] slots; 
	public static void main(String args[]) throws IOException {
		//input
		n = 10; 
		slots = new slot[n]; 
		for(int i = 0; i < n; i++) {
			slots[i] = new slot(i, i); 
		}
		Arrays.sort(slots, new Comparator<slot>() {
			@Override
			public int compare(slot a, slot b) {
				return b.price-a.price; 
			}
		});
		//algorithm 
		for(slot item : slots) System.out.println(item.price);
		//output 
	}
	public static class slot {
		public int day; 
		public int price;
		public slot(int a, int b) {
			day = a;
			price = b; 
		}
	}
}
