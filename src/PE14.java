import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PE14 {
	private static int MAX = (int) 5e6;
	private static int[] steps = new int[MAX + 1];
	private static int[] cumulative = new int[MAX + 1];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		computeSteps();
		for (int i = 2; i <= MAX; i++) {
			if (steps[cumulative[i - 1]] <= steps[i]) {
				cumulative[i] = i;
			} else {
				cumulative[i] = cumulative[i - 1];
			}
		}
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			System.out.println(cumulative[n]);
		}
	}

	private static void computeSteps() {
		for (int i = 2; i <= MAX; i++) {
			compute(i);
		}
	}

	private static int compute(long i) {
		if (i == 1 || (i <= MAX && steps[(int) i] != 0)) return steps[(int) i];
		int result = 1 + compute(i % 2 == 0 ? i / 2 : 3 * i + 1);
		if (i <= MAX) {
			steps[(int) i] = result;
		}
		return result;
	}
}
