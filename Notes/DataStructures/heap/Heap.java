package heap;

import java.util.ArrayList;

public class Heap {
	ArrayList<Integer> data;  
	public Heap() {
		data = new ArrayList<Integer>(); 
	}
	
	public void add(int x) {
		data.add(x); 
		int idx = data.size()-1; 
		int pidx = parent(idx); 
		
		while (idx != 0) {
			if(x > data.get(pidx)) {
				int temp = data.get(idx);
				data.set(idx, data.get(pidx));
				data.set(pidx, temp); 
				idx = pidx; 
				pidx = parent(idx); 
			}
			else {
				break; 
			}
		}
	}
	
	public int max() {
		return data.get(0); 
	}
	
	public int pop_max() {
		int ans = data.get(0); 
		data.set(0, data.get(data.size()-1)); 
		data.remove(data.size()-1); 
		heapify(0); 
		return ans; 
	}
	
	public void heapify(int idx) {
		while(true) {
			int leftIdx = left(idx); 
			int rightIdx = right(idx);
			int max_idx = idx;
			if(leftIdx < data.size() && data.get(max_idx) < data.get(leftIdx)) {
				max_idx = leftIdx; 
			}
			if(rightIdx < data.size() && data.get(max_idx) < data.get(rightIdx)) {
				max_idx = rightIdx; 
			}
			if(max_idx != idx) {
				int temp = data.get(max_idx); 
				data.set(max_idx, data.get(idx)); 
				data.set(idx, temp);
				idx = max_idx; 
			}
			else {
				break; 
			}
		}
	}
	
	
	
	//Position locater functions
	public static int left(int idx) {
		return 2*idx+1; 
	}
	public static int right(int idx) {
		return 2*idx+2;
	}
	public static int parent(int idx) {
		return (idx-1)/2;
	}
	
}
