import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PE15 {
	private static final int MODULO = (int) 1e9 + 7;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			String[] s = in.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			long result = 1;
			for (int i = Math.min(n, m); i > 0; i--) {
				result = (result * (n + m - i + 1)) % MODULO;
				result = (result * inverseModulo(i, MODULO)) % MODULO;
			}
			System.out.println(result);
		}
	}

	private static int pow(int a, int b, int m) {
		long result = 1;
		a %= m;
		while (b > 0) {
			if (b % 2 == 1) {
				result = (result * a) % m;
			}
			b = b >> 1;
			a = (int) (((long) a * a) % m);
		}
		return (int) (result % m);
	}

	private static int inverseModulo(int a, int m) {
		return pow(a, m - 2, m);
	}
}
