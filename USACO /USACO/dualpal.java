package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: dualpal
*/

import java.util.*;
import java.io.*;

public class dualpal {
    public static void main(String args[]) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        //first convert base
        //then find if it is palindromic 
        //then go through base 2-10 to find out if it palindromic first N numbers
        StringTokenizer in = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(in.nextToken()); //first N numbers that are double palindromic in 2 or more bases
        int S = (Integer.parseInt(in.nextToken()))+1; //The numbers greater then S that are double palindromic 
        
        int palCount = 0;
        int[] dpal = new int[N];
        
        while(palCount < dpal.length
        		) {
            int count = 0;
            
            for(int i = 2; i < 11; i++) {
                if( isPalin(convertBase(i, S)) == true) count++; 
            }
            if(count >= 2) {
                dpal[palCount] = S;
                palCount++; 
            }
            S++;
        }
        
        for(int i = 0 ; i < dpal.length; i++) {
            out.println(dpal[i]);   
        }
        out.close();
        
    }
    
    private static boolean isPalin(String a) {
        int middle = (int)(a.length()/2);
        int distance = 0;
        if(a.length()%2 == 0) distance = 1;
        for(int i = middle; i < a.length(); i++) {
                if(  (a.substring(i, i+1).equals(a.substring(middle-distance, (middle-distance)+1))) == false) return false;
                distance++;
        }
        return true;
    }
    
    public static String convertBase(int base, int num) {
        int pow = 0;
        while( ((int)(num)/(int)(Math.pow(base, pow+1))) >= 1) {
                pow++;
        }
        int rem = num;
        String switched = "";
        while(rem != 0 || pow != -1) {
                int calc = ((int)((rem)/(int)(Math.pow(base, pow))));
                rem = rem - (calc*(int)(Math.pow(base, pow)));
                switched = switched + calc;
                pow--;
        }
        return switched;
    }
}