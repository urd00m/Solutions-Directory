package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: milk
 */
import java.util.*;
import java.io.*;

public class milk {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		StringTokenizer in = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(in.nextToken());
		int M = Integer.parseInt(in.nextToken());
		sell[] data = new sell[M];
		for(int i = 0; i < M; i++) {
			in = new StringTokenizer(f.readLine());
			data[i] = new sell(Integer.parseInt(in.nextToken()), Integer.parseInt(in.nextToken()));
		}
        Arrays.sort(data, new Comparator<sell>() {
            @Override
            public int compare(sell o1, sell o2) {
                return o1.getCost()-o2.getCost();
            }
        });
        int cost = 0;
        int i = 0;
        while(N > 0) {
        	if(data[i].getAmount() < N) {
        		N = N-data[i].getAmount();
        		cost = cost + data[i].getAmount()*data[i].getCost();
        		i++;
        	}
        	else {
        		cost = cost + N*data[i].getCost();
        		N = 0;
        	}
        }
        out.println(cost);
        out.close();
				
	}
	
	public static class sell {
		int cost = 0;
		int amount = 0;
		public sell(int n, int m) {
			cost = n;
			amount = m;
		}
		public int getCost() {
			return cost;
		}
		public int getAmount() {
			return amount;
		}
	}

}
