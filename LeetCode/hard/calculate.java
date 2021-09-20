import java.io.*;
import java.util.*; 

class Solution {
    /* Helper functions */
    //removes all whitespaces from a string 
    public String strip(String a) {
        String ret = ""; 
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == ' ') continue; 
            ret += a.charAt(i);
        }
        return ret; 
    }
    
    // Splits a string into a ArrayList<String> by the operation symbols
    public ArrayList<String> splitByOperation(String a) {
        ArrayList<String> ret = new ArrayList<String>(); 
        
        // Runs through the string
        String fullNumber = ""; 
        int i = a.length()-1; 
        boolean rightAfter = false; 
        if(a.charAt(a.length()-1) == '-') {
            fullNumber += '-'; 
            i = a.length()-2; 
        }
        for(; i >= 0; i--) {
            char cur = a.charAt(i); 
            if((cur == '+' || cur == '-') && rightAfter == false) {
                ret.add(fullNumber);
                ret.add(""+cur); 
                fullNumber = ""; 
                rightAfter = true; 
            } else {
                fullNumber += cur; 
                rightAfter = false; 
            }
        }
        ret.add(fullNumber); 
        
        return ret; 
    }
    
    public String reverse(String a) {
        String ret = ""; 
        for(int i = a.length()-1; i >= 0; i--) {
            ret += a.charAt(i); 
        }
        return ret; 
    }
    
    /* Main Functions */
    public int calculate(String s) {
        // Variables / stacks / lists 
        Stack<String> next = new Stack<String>(); 
        
        // Remove white spaces
        s = strip(s); 
        
        // Add in parenthesis
        s = "(" + s + ")"; //remove any leading or trailing whitespaces to make life easier 
        
        // Go through the String 
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i); 
            
            // If close parenthesis 
            if(cur == ')') {
                //remove until we hit a open Parenthesis  
                String toEval = ""; 
                String itemFromStack = next.pop(); 
                while(itemFromStack.charAt(0) != '(') {
                    toEval += itemFromStack; 
                    itemFromStack = next.pop(); 
                }
                
                //evaluate item 
                int value = evalExpression(toEval); 
                next.add(reverse(""+value)); 
            }
            else { //add to stack 
                next.add(""+cur); 
            }
        }
        
        return Integer.parseInt(reverse(next.pop())); //once the loop finishes we should have evauluated everything 
    }
  
    //evaulates a basic string expressions
    public int evalExpression(String s) {
        //Separate into an arraylist 
        ArrayList<String> expression = splitByOperation(s); 
        
        //go left to right 
        System.out.println(s); 
        int value = Integer.parseInt(expression.get(0)); 
        for(int i = 1; i < expression.size(); i+=2) {
            if(expression.get(i).charAt(0) == '+') {
                value += Integer.parseInt(expression.get(i+1)); 
            } else { // Must be - 
                value -= Integer.parseInt(expression.get(i+1)); 
            }
        }
        
        return value; 
    }
}
