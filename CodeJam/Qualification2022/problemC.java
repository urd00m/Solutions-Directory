import java.io.*;
import java.util.*;

public class problemC {
    public static void main(String args[]) throws IOException {
        //input 
        BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input;
		int t = Integer.parseInt(f.readLine()); 

        for(int count = 1; count <= t; count++) {
            //input
            int n = Integer.parseInt(f.readLine());
            input = new StringTokenizer(f.readLine());
            int[] dies = new int[n];
            for(int i = 0; i < n; i++) {
                dies[i] = Integer.parseInt(input.nextToken());
            }

            //sort 
            Arrays.sort(dies);

            //iterate through and count
            int ret = 0;
            int cur = 1;
            for(int i = 0; i < n; i++) {
                if(dies[i] >= cur) {
                    ret++; cur++;
                }
            }

            //output 
            System.out.println("Case #" + count + ": " + ret);
        }
    }
}
