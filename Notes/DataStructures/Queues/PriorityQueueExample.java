package Queues;


import java.util.*;

public class PriorityQueueExample {
	public static void main(String args[]) {
		Queue<Integer> test = new PriorityQueue<Integer>();
		
		//add elements to queue
		test.add(4);
		test.add(1);
		test.add(0);
		test.add(3); 
		
		
		//remove elements
		System.out.println(test.remove()); 
		
		//sorts for you in O(log n)
		
		//private Queue<Type> qe = new PriorityQueue<Type>(20, new MyComparator<Type>())        for complex data type
	}
}
