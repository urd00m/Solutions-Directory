import java.io.*;
import java.util.*;

class Solution {
    HashMap<Integer, Integer> count; 
    public int singleNumber(int[] nums) {
        count = new HashMap<Integer, Integer>(); 
        for(int item : nums) {
            if(count.containsKey(item) == true) {
                count.replace(item, 2); 
            }
            else {
                count.put(item, 1); 
            }
        }
        
        for(int item : count.keySet()) {
            if(count.get(item) == 1) 
                return item; 
        }
        return -1; //error 
    }
}
