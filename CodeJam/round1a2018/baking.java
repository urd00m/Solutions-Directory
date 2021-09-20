package round1a2018;

/*
ID: urd00m
LANG: JAVA
TASK: baking
 */
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class baking {
	static int t;
	static int n, p;
	static int[][] waffles; // width then height

	public static void main(String args[]) throws IOException {
		// input

		BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringTokenizer input;
		t = Integer.parseInt(f.readLine());
		for (int cn = 1; cn < t + 1; cn++) {
			input = new StringTokenizer(f.readLine());
			n = Integer.parseInt(input.nextToken());
			p = Integer.parseInt(input.nextToken());
			waffles = new int[n][2];
			int perCur = 0;
			for (int i = 0; i < n; i++) {
				input = new StringTokenizer(f.readLine());
				int a = Integer.parseInt(input.nextToken());
				int b = Integer.parseInt(input.nextToken());
				waffles[i][0] = a;
				waffles[i][1] = b;
				perCur += 2 * a + 2 * b;
			}
			p -= perCur;

			// intervals
			ArrayList<interval> ranges = new ArrayList<interval>();
			ranges.add(new interval(0.0, 0.0));
			for (int i = 0; i < n; i++) {
				double l = 2 * Math.min((double) waffles[i][0], (double) waffles[i][1]);
				double r = (double) maxPer(waffles[i][0], waffles[i][1]);
				ranges = merge(ranges, new interval(l, r));
			}
			double ret = Math.min(p + perCur,
					(((long) (((double) ranges.get(ranges.size() - 1).r + (double) perCur) * 1000000.0)) / 1000000.0));
			NumberFormat formatter = new DecimalFormat("#0.000000");
			System.out.println("Case #" + cn + ": " + formatter.format(ret));
		}
	}

	// we need a merge function
	public static ArrayList<interval> merge(ArrayList<interval> ranges, interval merge) {
		ArrayList<interval> copy = new ArrayList<interval>();
		for (interval item : ranges)
			copy.add(item);
		for (int i = 0; i < copy.size(); i++) {
			interval next = new interval((double) copy.get(i).l + merge.l, (double) copy.get(i).r + merge.r);
			if (next.l > p)
				break;
			for (int j = i; j < ranges.size() + 1; j++) {
				if (j == ranges.size() || ranges.get(j).l > next.l) {
					ranges.add(j, next);
					break;
				}
			}
		}

		// merge any overlapping intervals
		ArrayList<interval> ret = new ArrayList<interval>();
		ret.add(ranges.get(0));
		for (int i = 1; i < ranges.size(); i++) {
			if (ranges.get(i).l >= ret.get(ret.size() - 1).l && ranges.get(i).l <= ret.get(ret.size() - 1).r) {
				ret.get(ret.size() - 1).changeR(ranges.get(i).r);
			} else
				ret.add(ranges.get(i));
		}
		return ret;
	}

	// a helper function to calculate the additional perimeter added
	// with a diagonal cut
	public static double maxPer(int w, int h) {
		double ret = 0.0;
		ret = Math.sqrt((double) (w * w) + (double) (h * h));
		ret = ((long) (2 * ret * 1000000000)) / 1000000000.0; // for precision purposes at the end we chop off the 7th digit
		return ret;
	}

	public static class interval {
		double l, r;

		public interval(double a, double b) {
			l = a;
			r = b;
		}

		public void changeR(double a) {
			r = a;
		}
	}
}
