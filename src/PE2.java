import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PE2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		compute();
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			long n = Long.parseLong(in.readLine());
			System.out.println(find(n));
		}
	}

	private static Long find(long n) {
		int a = 0, b = series.size() - 1;
		while (a < b) {
			int mid = (a + b + 1) / 2;
			if (series.get(mid).get(1) == n) {
				return series.get(mid).get(0);
			} else if (series.get(mid).get(1) < n) {
				a = mid;
			} else {
				b = mid - 1;
			}
		}

		if (a == 0) {
			if (series.get(0).get(1) > n) {
				return 0L;
			} else {
				return series.get(a).get(0);
			}
		} else {
			return series.get(a).get(0);
		}
	}

	private static List<List<Long>> series = new ArrayList<>();
	private static final long MAX = 4 * (long) 1e16 + 1;

	private static void compute() {
		long a = 1, b = 2, c;
		long sum = 0;
		while (a < MAX) {
			if (a % 2 == 0) {
				sum += a;
				series.add(Arrays.asList(sum, a));
			}
			c = a + b;
			a = b;
			b = c;
		}
	}
}
