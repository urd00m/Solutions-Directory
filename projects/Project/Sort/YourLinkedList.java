package Sort;

/**
 * @(#)YourLinkedList.java
 *
 *
 * @author 
 * @version 1.00 2017/11/30
 */

import  java.util.ListIterator;
import  java.util.NoSuchElementException;


public class YourLinkedList 
{
      Node first; //creates an object of class Node called first

       /** Constructs an empty linked list.   **/
      public YourLinkedList()
      {
           first = null;
      }

       
    /** Returns the first element in the linked list **/
       public Object getFirst()
       {
            if (first == null)
                throw new NoSuchElementException();
           	return first.data;
       }
       public void getAll() {
       		Node output = new Node();
       		if(first == null)
       			throw new NoSuchElementException();
       		output = first;
       		while(output != null) {
       			System.out.println(output.data);
       			output = output.next;
       		}
       }
       //returns the length of a linked list
       public int getLength(YourLinkedList a) {
       		int counter = 0;
       		Node output = new Node();
       	    if(first == null)
       			throw new NoSuchElementException();
       		output = first;
       		while(output != null) {
				counter++;
				output = output.next;
       		}
       		return counter;
       }

       /** Removes the first element in the linked list and
              returns the removed element **/
       public Object removeFirst()
       {
            if (first == null)
               throw new NoSuchElementException();
             Object  element = first.data;
             first = first.next;
             return element;
       }

      
 /** Adds an element to the front of the linked list **/
       public void addFirst(Object element)
       {
           Node newNode = new Node();
           newNode.data = element;
           newNode.next = first;
           first = newNode;
       }
       
       






/** Inserts  an element in the middle (no place specific) of the linked list **/
/* 	
   
 */
       public void insertMiddle(Object element, int index) //"string", 1
       {
       		Node node = new Node(first); //creates new Node node and inputs first Node into it node.next = first Node initialize node so while loop would run
       		while(index>0 && node.next!=null) //index can't be lower than 0 and node.next != null nothing at first node.next = First Node
       		{
       			node=node.next; //sets node to the first Node
       			index--; //index is decreased by one
       		}
       		node.next = new Node(element, node.next);       	
       }
       
    


/** Removes an element from the middle (no place specific) of the linked list **/

   public Object removeMiddle(int index)
       {
       	Node node = new Node(first);
       	while(index>=0 && node.next!=null)
       	{
       		node=node.next;
       		index--;
       	}
       	Node output = new Node(node.next.data);
       	node.next = node.next.next;
       	return output;     	
       }
       
      


/** Inserts an element at the end of the linked list **/

     public void insertEnd(Object element)
     {
          Node node = new Node(first);
           while(node.next!=null)
           {
              node=node.next;
           }
           node.data = element;
       }
       




   /** Removes an element from the end of the linked list **/
    

   public Object removeEnd()
   {
          Node node = new Node(first);
           while(node.next!=null)
           {
               node=node.next;
           }
           Node output = new Node(node.data);
           node=null;
           return output;
   }
   //	Given any two lists of type node it joins the list and returns the combined list.
   //        Test by printing the joined list.
   public Node joinTwoLists(Node L1, Node L2) {
   	   Node node = new Node(first);
       while(node.next!=null)
       {
          node=node.next;
       }
       node.next = L2;
       return L1;
   }
   
   public YourLinkedList searchList(Object Search) {
		YourLinkedList locations = new YourLinkedList();
		Node node = new Node();
        node = first;
		int position = 0;
		int i = 1;
		Boolean firstP = true;
		while(node.next != null) {
			if(node.data == Search) {
				if(firstP == false) {
				    locations.insertMiddle(position, i);
				    i++;
			    }
				else {
				    locations.addFirst(position);
				    firstP = false;
			    }

			}
			position++;
			
			node = node.next;
		}
		if(node.data == Search) {
		    if(firstP == false) {
		        locations.insertMiddle(position, i);
		        i++;
		    }
		    else {
		        locations.addFirst(position);
		    }
		}
		if(firstP == true) locations.addFirst(-1);
		return locations;   	
   }
   
   public void sortList() {
   		int set; //For Integers onlys
   		int set2;	
   		Node list2 = new Node();
   		Node list = new Node();
   		list = first;
		while(list.next != null) {   
   			int min = (Integer) list.data; 
   			list2 = list.next;
			while(list2.next != null) { 
   				if(min > (Integer) list2.data ) { 
   					set = (Integer) list2.data; 
   					set2 = min; 
   					list2.data = set2; 
   					min = set;
					list.data = min;
   				}
   				list2 = list2.next;
   			}
   			if(min > (Integer) list2.data ) { //Finding the last term that isn't found in while loops
   					set = (Integer) list2.data; 
   					set2 = min; 
   					list2.data = set2; 
   					min = set;
					list.data = min;
   			}
			list = list.next;
   		}
   }
   
   public void sortListString() {
   		String set;
   		String set2;
   		Node list2 = new Node();
   		Node list = new Node();
   		list = first;
   		while(list.next != null) {   
   			String min = (String) list.data; 
   			list2 = list.next;
			while(list2.next != null) { 
   				if(min.toLowerCase().compareTo(((String) list2.data).toLowerCase()) > 0) { 
   					set = (String) list2.data; 
   					set2 = min; 
   					list2.data = set2; 
   					min = set;
					list.data = min;
   				}
   				list2 = list2.next;
   			}
   			if(min.toLowerCase().compareTo(((String) list2.data).toLowerCase()) > 0) { 
   					set = (String) list2.data; 
   					set2 = min; 
   					list2.data = set2; 
   					min = set;
					list.data = min;
   				}
			list = list.next;
   		}
   }


       
       
}
