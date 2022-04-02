import java.io.*;
import java.util.*;

public class problemB {
    public static void main(String args[]) throws IOException {
        //input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input;
		int t = Integer.parseInt(f.readLine()); 

        for(int count = 1; count <= t; count++) {
            int[] min = new int[4];            
            Arrays.fill(min, Integer.MAX_VALUE);
            for(int i = 0; i < 3; i++) {
                input = new StringTokenizer(f.readLine());
                for(int j = 0; j < 4; j++) {
                    int cur = Integer.parseInt(input.nextToken()); 
                    if(cur < min[j]) {
                        min[j] = cur; 
                    }
                }
            }

            // sum 
            int sum = 0; 
            for(int i = 0; i < 4; i++)
                sum += min[i];
        
            if(sum < 1000000)
                System.out.println("Case #" + count + ": IMPOSSIBLE");
            else {
                sum = 0; 
                String ret = "";
                for(int i = 0; i < 4; i++) {
                    if(sum >= 1000000) {
                        ret += " 0";
                    }
                    else {
                        ret += " " + (min[i]+sum >= 1000000 ? 1000000-sum : min[i]);
                        sum += min[i];
                    }
                }
                System.out.println("Case #" + count + ":" + ret);
            }
        }
    }
}
