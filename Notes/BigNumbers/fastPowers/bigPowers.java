package fastPowers;

public class bigPowers {
	public static void main(String args[]) {
		int mod = 1000000007; 
		System.out.println((Math.pow(9999, 9)%mod)); //incorrect
		System.out.println(exp(9999, 9, mod)); //correct
	}
	public static long exp(long base, int power, int MOD) {
		if (power == 0)
			return 1;
		if (power == 1)
			return (base + MOD) % MOD;
		long ans = exp(base, power / 2, MOD);
		ans = (ans * ans + MOD) % MOD;
		if (power % 2 == 1)
			ans = (ans * base + MOD) % MOD;
		return (ans + MOD) % MOD;
	}
}
