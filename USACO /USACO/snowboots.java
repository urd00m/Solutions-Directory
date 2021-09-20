package USACO;
/*
ID: alwang
LANG: JAVA
TASK: snowboots
 */
import java.util.*;
import java.io.*;
public class snowboots {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("snowboots.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		
		//input 
		StringTokenizer in = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(in.nextToken());
		int b = Integer.parseInt(in.nextToken());
		tile[] tiles = new tile[n];
		boot[] boots = new boot[b];
		in = new StringTokenizer(f.readLine());
		for(int i = 0; i < n; i++) { //get tiles
			tiles[i] = new tile(i, Integer.parseInt(in.nextToken()));
		}
		for(int i = 0; i < b; i++) { //get boots
			in = new StringTokenizer(f.readLine());
			boots[i] = new boot(Integer.parseInt(in.nextToken()), Integer.parseInt(in.nextToken()));
		}
		
		//sorting
		Arrays.sort(tiles, new Comparator<tile>() {
			@Override 
			public int compare(tile o1, tile o2) {
				return o2.getRes()-o1.getRes();
			}
		});
        Arrays.sort(boots, new Comparator<boot>() {
            @Override
            public int compare(boot o1, boot o2) {
                return o1.getRes()-o2.getRes();
            }
        });
        
        //getting
        int[] can = new int[b];
        for(int i = b-1; i >= 0; i--) { //current boot
        	int counter = n;
        	int position = -1;

        	while ( counter > 0 && boots[i].getRes() < tiles[counter].getRes() ) { //finds the current position of the tile res that doesn't work
        		if( boots[i-1].getRes() >= tiles[counter].getRes() ) position = counter;
        		counter--;
        	}
        	int z = 0; 
        	tile[] record = new tile[position+1];
        	for(int j = position; j >= 0; j--) {  //records the new boot positions 
        		record[z] = tiles[j];
        		z++;
        	}
        	Arrays.sort(record, new Comparator<tile>() { //sorts by location not by res
        		@Override
        		public int compare(tile o1, tile o2) {
        			return o2.getLoc()-o1.getLoc();
        		}
        	});
        	counter = 0;
        	while(counter < record.length-1 && can[i] != 0) { //finds the max distance between the sizes and sees if it fits
        		if(boots[i].getStep() < (record[counter+1].getLoc()-record[counter].getLoc())) 
        			can[i] = 0;
        		counter++;
        	}
        	if(counter == record.length-1) can[i] =1;
        	
        }
        //printing out solution
        for(int i = 0; i < b; i++) {
        	out.println(can[i]);
        }
        out.close();
		
	}
	
	public static class boot {
		private int res;
		private int step;
		public boot(int a, int b) {
			res = a;
			step = b;
		}
		public int getRes() {
			return res;
		}
		public int getStep() {
			return step;
		}
	}
	
	public static class tile {
		private int res;
		private int loc;
		public tile(int a, int b) {
			res = a;
			loc = b;
		}
		public int getRes() {
			return res;
		}
		public int getLoc() {
			return loc;
		}
	}

}
