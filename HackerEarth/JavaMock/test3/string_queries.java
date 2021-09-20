import java.util.*;
import java.io.*; 


//prefix sum solves this problem easily 

class TestClass {
    static int n, q; 
    static String s; 
    static int[][] pre = new int[26][150000]; //26 letters to a maximum length of 150k just to be safe 
    public static void main(String args[] ) throws Exception {
        BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
        input = new StringTokenizer(f.readLine()); 
        n = Integer.parseInt(input.nextToken()); q = Integer.parseInt(input.nextToken());       
        s = f.readLine(); 
        
        //constructing prefix sum matrix
        for(int i = 0; i < n; i++) { //ranges start at one so the node at 0 is a sentinel node 
            pre[s.charAt(i)-'a'][i+1]++; 
            for(int j = 0; j < 26; j++) { //the letter updates
                pre[j][i+1] += pre[j][i]; 
            }
        }
        
        //queries 
        //find sum of the occurences of the item in a range
        //determine the minimum (excluding 0) 
        //then it is just the total sum of all the sums added together minus the total letters * minimum 
        for(int i = 0; i < q; i++) {
            input = new StringTokenizer(f.readLine()); 
            int l = Integer.parseInt(input.nextToken()); int r = Integer.parseInt(input.nextToken());
            int ret = Integer.MAX_VALUE; int prevMin = Integer.MAX_VALUE;
            for(int j = 0; j < 26; j++) { //finding initial prevMin value 
                int occ = pre[j][r]-pre[j][l-1];
                prevMin = Math.min(prevMin, occ); 
            }
            for(int k = 0; k < 26; k++) {
                int min = Integer.MAX_VALUE; int numDel = 0; 
                for(int j = 0; j < 26; j++) {
                    int occ = pre[j][r]-pre[j][l-1];
                    if(occ != 0) {
                        if(occ > prevMin) {
                            min = Math.min(occ, min); //next min 
                            numDel += occ-prevMin; 
                        }
                        else if (occ < prevMin) {  //do nothing  
                            numDel += occ; 
                        } //if occ == prevMin you do nothing 

                    }
                    
                }
                prevMin = min; 
                ret = Math.min(ret, numDel); 
                if(min == Integer.MAX_VALUE) break; 
            }
            System.out.println( ret ); 
        }
        
    }
}

