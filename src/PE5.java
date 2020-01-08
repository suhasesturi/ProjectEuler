import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PE5 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			int result = 1;
			for (int i = 2; i <= n; i++) {
				result = lcm(result, i);
			}
			System.out.println(result);
		}
	}

	private static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}

	private static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
}
