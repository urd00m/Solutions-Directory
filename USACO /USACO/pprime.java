package USACO;
/*
ID: alan.li2
LANG: JAVA
TASK: pprime
 */
import java.util.*;
import java.io.*;
public class pprime {
	static int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499};
	public static void main(String args[]) throws IOException{
		BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
		StringTokenizer in = new StringTokenizer(f.readLine());
		int lowerbound = Integer.parseInt(in.nextToken());
		int upperbound = Integer.parseInt(in.nextToken());
		int[] endDigits = { 1,3,7,9};
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		//for one digit pp's
		if(5 >= lowerbound && 5 <= upperbound) 
			list.add(5);
		if(7 >= lowerbound && 7 <= upperbound) 
			list.add(7);
		
		//for two digit pp's 
		if(11 >= lowerbound && 11 <= upperbound) 
			list.add(11);
		
		//for three digit pp's 
		int palsave;
		if((""+upperbound).length() >= 3)
			for(int i = 0; i < 4; i++) {
				for(int p2 = 0; p2 < 10; p2++) {
					palsave = 100*endDigits[i] + 10*p2 + endDigits[i];
					//check if prime
					int sum;
					sum = endDigits[i]+endDigits[i]+p2; 
					if(palsave >= lowerbound && palsave <= upperbound && isPrime(palsave)) 
						list.add(palsave);
				}
			}
		//for five digits 
		if((""+upperbound).length() >= 5)
			for(int i = 0; i < 4; i++) {
				for(int p2 = 0; p2 < 10; p2++) {
					for(int p3 = 0; p3 < 10; p3++) {
						palsave = 10000*endDigits[i] + 1000*p2 + p3*100 + p2*10 + endDigits[i];
						//check if prime
						int sum;
						sum = endDigits[i]+endDigits[i]+p2+p2+p3; 
						if(palsave >= lowerbound && palsave <= upperbound && isPrime(palsave)) 
							list.add(palsave);
					}
				}
			}
		//for seven digits 
		if((""+upperbound).length() >= 7)
			for(int i = 0; i < 4; i++) {
				for(int p2 = 0; p2 < 10; p2++) {
					for(int p3 = 0; p3 < 10; p3++) {
						for(int p4 = 0; p4<10; p4++) {
							palsave = 1000000*endDigits[i] + 100000*p2 + p3*10000 + p4*1000 + p3*100 + p2*10 + endDigits[i];
							//check if prime
							int sum;
							sum = endDigits[i]+endDigits[i]+p2+p2+p3+p3+p4; 
							if(palsave >= lowerbound && palsave <= upperbound && isPrime(palsave)) 
								list.add(palsave);
						}
					}
				}
			}
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			out.println(list.get(i));
		}
		out.close();
	}
	
	public static boolean isPrime(int num) {
		for(int i = 0; i < primeNumbers.length; i++) {
			if(primeNumbers[i] == num) return true;
			if(num%primeNumbers[i] == 0) return false;
		}
		for(int i = 1500; i < 3500; i++) {
			if(i == num) return true;
			if(num%i == 0) return false;
		}
		return true; 
	}
}
