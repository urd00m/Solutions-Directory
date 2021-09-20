package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: namenum
 */

import java.util.*;
import java.io.*;

public class namenum {
        public static void main(String args[]) throws IOException {
                BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
                BufferedReader dict = new BufferedReader(new FileReader("dict.txt"));
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

                String id2 = f.readLine();
                ArrayList<String> Names = new ArrayList<String>();
                String converted = conversion(Integer.parseInt(id2.substring(0, 1)));
                for(int i = 0 ; i < 4617; i++) {
                        String Save = dict.readLine();
                        //System.out.println(Save + " " + i);
                        if(Save.length() == id2.length() && (Save.substring(0, 1).equals(converted.substring(0, 1))==true || Save.substring(0, 1).equals(converted.substring(1, 2))==true  || Save.substring(0, 1).equals(converted.substring(2, 3))==true)) Names.add(Save);
                }
          //      print(Names);
                for(int i = 1; i < id2.length(); i++) {
                        Names = eliminate(conversion(Integer.parseInt(id2.substring(i,i+1))), Names, i);
              //          System.out.println("***");
            //            print(Names);
                }
                for(int i = 0; i < Names.size(); i++) {
                        out.println(Names.get(i));
                }
                if(Names.size() == 0) out.println("NONE");
                out.close();
        }

        public static ArrayList<String> eliminate(String converted, ArrayList<String> a, int num) {
                ArrayList<String> elim = new ArrayList<String>();
                for(int i = 0; i < a.size(); i++) {
                        if( a.get(i).substring(num, num+1).equals(converted.substring(0, 1))==true || a.get(i).substring(num, num+1).equals(converted.substring(1, 2))==true || a.get(i).substring(num, num+1).equals(converted.substring(2, 3))==true ) elim.add(a.get(i));
                }
                return elim;
        }
        //public static void print(ArrayList<String> a) {
        //      for(int i = 0; i < a.size(); i++) {
        //              System.out.println(a.get(i));
        //      }
        //}
        public static String conversion(int b) {
                switch(b) {
                        case 2:
                                return "ABC";
                        case 3:
                                return "DEF";
                        case 4:
                                return "GHI";
                        case 5:
                                return "JKL";
                        case 6:
                                return "MNO";
                        case 7:
                                return "PRS";
                        case 8:
                                return "TUV";
                        case 9:
                                return "WXY";
                }
                return "";
        }
}
