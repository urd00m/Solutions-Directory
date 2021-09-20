import java.io.*;
import java.util.*; 

class TestClass {
    static String input; 
    static long mod = 1000000007; 
    static long[] dp = new long[3];
    public static void main(String args[] ) throws Exception {
        BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); 
        input = f.readLine(); 
        for(int i = 0; i < input.length(); i++) {
            //updating total number of combinations of just a 
            //this is always double the previous number of sets + 1
            if(input.charAt(i)-'a' == 0) {
                dp[0] = (dp[0]*2+1)%mod; 
            }
            //updating the total number of combinations of a and b 
            //this never updates until the end is a b
            //the value is the current value of a + 2*the total combinations of ab since a new b 
            //has been introduced doubling the b sets doubling the value 
            else if(input.charAt(i)-'a' == 1) {
                dp[1] = (dp[1]*2+dp[0])%mod; 
            }
            //c   updating the totaln umber of combinationsof a, b, and c 
            //same logic as b, once a new c is introducded, it doubles the current number of a b and
            //c and also adds on the current total number of a b since a c can be attached after them 
            else {
                dp[2] = (dp[2]*2+dp[1])%mod; 
            }
        }
        System.out.println(dp[2]); 
    }
}

