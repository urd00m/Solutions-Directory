package Sort;

/**
 * @(#)Node.java
 *
 *
 * @author 
 * @version 1.00 2017/11/30
 */


public class Node 
{

	 Node next; // creates an object called next in Node, the link to the 2nd, 3rd, 4th... location of another object(piece of information).
	 Object data; //creates a general object called data but can be changed to be more specific

   
     public Node(Object data, Node next) //constructors
     {
    	this.next = next;
    	this.data = data;
     }
    

   	 public Node(Node next)
     {
    	this.next = next;
     }
    

   	 public Node(Object data)
   	 {
    	this.data = data;
     }
   
 
   	 public Node() 
     { 
 		next = null;
        data = null;
     }
    
    
}
