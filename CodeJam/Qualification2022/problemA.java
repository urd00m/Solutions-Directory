import java.io.*;
import java.util.*; 

public class problemA {
    public static void main(String args[]) throws IOException {
        //input 
		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in)); StringTokenizer input;
		int t = Integer.parseInt(f.readLine()); 
		
		for(int count = 1; count <= t; count++) {
            String ret = ""; 
            input = new StringTokenizer(f.readLine());
		    int r = Integer.parseInt(input.nextToken()); 
            int c = Integer.parseInt(input.nextToken()); 

            String line1 = "..+"; 
            for(int i = 1; i < c; i++)
                line1 += "-+"; 
            line1 += "\n"; 
            ret += line1;
            line1 = "..|"; 
            for(int i = 1; i < c; i++)
                line1 += ".|"; 
            line1 += "\n"; 
            ret += line1;
            line1 = "+-+"; 
            for(int i = 1; i < c; i++)
                line1 += "-+"; 
            line1 += "\n"; 
            ret += line1;
            for(int i = 1; i < r; i++) {
                String line = "|.|";
                for(int j = 1; j < c; j++) 
                    line += ".|";
                line += "\n";
                ret += line; 
                line = "+-+";
                for(int j = 1; j < c; j++) 
                    line += "-+";
                line += "\n";
                ret += line; 
            }
		    System.out.println("Case #" + count + ":");
            System.out.println(ret);
		}
    }
}