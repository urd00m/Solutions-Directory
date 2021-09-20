package USACO;


/*
ID: alan.li2
LANG: JAVA
TASK: friday
 */

import java.util.*;
import java.io.*;

public class friday {
        public static void main(String args[]) throws IOException{
                BufferedReader f = new BufferedReader(new FileReader("friday.in"));
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
                StringTokenizer a = new StringTokenizer(f.readLine());
                int[] days = new int[7];
                int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
                //to calculate for leap years year%4 == 0 && year%100 != 0
                //or years%100 == 0 %% year%400 == 0
                int preDayR = -1;
                int addOn = Integer.parseInt(a.nextToken());
                for(int i = 1900; i <1900+addOn; i++) { //years
                        for(int j = 1; j < 13; j++) { //months
                                preDayR += 13; 
                                //do mod
                                days[preDayR%7]++;
                                preDayR += daysInMonth[j-1]-13;
                                if(i == 2 && (i%4 == 0 && i%100 != 0) || (i%100 == 0 && i%400 == 0)) preDayR++;
                        }
                }
                out.print("" + days[5] + " ");
                out.print("" + days[6] + " ");
                out.print(days[0] + " ");
                out.print(days[1]+ " ");
                out.print(days[2] + " ");
                out.print(days[3] + " ");
                out.print(days[4] + "\n");
                out.close();
        }

}

