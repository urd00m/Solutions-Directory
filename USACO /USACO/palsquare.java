package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: palsquare
 */
import java.util.*;
import java.io.*;

public class palsquare {
        public static void main(String arg[]) throws IOException {
                BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));

                int base = Integer.parseInt(f.readLine());
                int[] squares = new int[300];
                for(int i = 1; i < 301; i++) {
                        squares[i-1] = (int)(Math.pow(i, 2));
                }
                //convert to the other base
                ArrayList<String> store = new ArrayList<String>();
                ArrayList<String> store2 = new ArrayList<String>();
                for(int i = 0; i < 300; i++) {
                        String converted = switchT(squares[i],base);
                        if(isPalin(converted)) {
                                store.add(converted);
                                store2.add(switchT(i+1,base));
                        }
                }
                for(int i = 0; i < store.size(); i++) {
                        out.println(store2.get(i) + " " + store.get(i));
                }
                out.close();
        }

        private static boolean isPalin(String a) {
                int middle = (int)(a.length()/2);
                int distance = 0;
                if(a.length()%2 == 0) distance = 1;
                for(int i = middle; i < a.length(); i++) {
//                      System.out.println(a + " " + middle + " " + distance + " " + i + " " + a.substring(i,i+1) + " " + a.substring(middle-distance, (middle-distance)+1));
                        if(  (a.substring(i, i+1).equals(a.substring(middle-distance, (middle-distance)+1))) == false) return false;
                        distance++;
                }
                return true;
        }

        private static String switchT(int num, int base) {
                int pow = 0;
                while( ((int)(num)/(int)(Math.pow(base, pow+1))) >= 1) {
                        pow++;
                }
//System.out.println(pow+ " " + num);
                int rem = num;
                String switched = "";
                while(rem != 0 || pow != -1) {
                        int calc = ((int)((rem)/(int)(Math.pow(base, pow))));
//System.out.println("Num: " + num + " Calc: " + calc + " Rem: " + rem + " pow: " + pow+ " calc calc: " + ((int)((rem)/(int)(Math.pow(base, pow)))));
                        rem = rem - (calc*(int)(Math.pow(base, pow)));
                        String con = baseC( calc, base );
                        switched = switched + con;
//System.out.println(switched + " " + rem +  " " + pow);
                        pow--;
                }
                return switched;
        }

        private static String baseC(int i, int base) {
                if(base >= 11) {
                        switch(i) {
                            case 10:
                                    return "A";
                            case 11:
                                    return "B";
                            case 12:
                                    return "C";
                            case 13:
                                    return "D";
                            case 14:
                                    return "E";
                            case 15:
                                    return "F";
                            case 16:
                                    return "G";
                            case 17:
                                    return "H";
                            case 18:
                                    return "I";
                            case 19:
                                    return "J";
                            case 20:
                                    return "K";
                    }
            }
            if(i == 0) return "" + 0;
            else return "" + i;
    }

}


