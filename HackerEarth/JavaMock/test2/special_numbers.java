import java.io.*;
import java.util.*; 

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    static int n; 
    public static void main(String args[] ) throws Exception {
        //input
        BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input; 
        n = Integer.parseInt(f.readLine()); 
        for(int i = 0; i < n; i++) {
            input = new StringTokenizer(f.readLine()); 
            int l = Integer.parseInt(input.nextToken()); int r = Integer.parseInt(input.nextToken()); 
            long sum = 0; 
            for(long cur = l; cur <= r; cur++) {
                long x = f(cur); 
                sum += (Math.min(x,r)-cur+1)*x;
                cur = Math.min(x,r); 
            }
            System.out.println(sum); 
        }
    
    }
    public static long f(long x) {
        String temp = "" + x; 
        String ret = ""; //reversed in the end 
        boolean changed = false; 
        for(int i = 0; i < temp.length(); i++) {
            if(changed == true) 
                ret = ret + "2"; 
            else {
                if(temp.charAt(i) - '0' == 2 || temp.charAt(i) - '0' == 5) 
                    ret = ret + temp.substring(i, i+1); 
                else if(temp.charAt(i)-'0' >= 0 && temp.charAt(i)-'0' < 2) {
                    changed = true; 
                    ret = ret + "2"; 
                }
                else if(temp.charAt(i)-'0' < 5 && temp.charAt(i)-'0' > 2) {
                    changed = true; 
                    ret = ret + "5"; 
                }
                else {
                    changed = true; 
                    int j = i-1; 
                    String newRet = ""; 
                    while(j >= -1) {
                        if(j == -1) newRet = newRet + "2"; 
                        else {
                            if(ret.charAt(j)-'0' == 2) {
                                newRet = newRet + "5"; 
                                break; 
                            }
                            else {
                                newRet = newRet+"2"; 
                            }
                        }
                        j--; 
                    }
                    if(j<=0) {
                        StringBuilder reverse = new StringBuilder(newRet); 
                        ret = reverse.reverse().toString()+"2"; 

                    }
                    else {
                        StringBuilder reverse = new StringBuilder(newRet); 
                        ret = ret.substring(0, j) + reverse.reverse().toString()+"2"; 
                    }
                }
            }
        } 
        return Long.parseLong(ret); 
    }
}

