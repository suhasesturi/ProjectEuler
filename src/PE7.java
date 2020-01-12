import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PE7 {
	private static final ArrayList<Integer> primes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		computePrimes();
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			System.out.println(primes.get(n - 1));
		}
	}

	private static void computePrimes() {
		primes.add(2);
		for (int i = 3; primes.size() < 10001; i += 2) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
	}

	private static boolean isPrime(int n) {
		for (int i = 0; i < primes.size() && primes.get(i) <= Math.sqrt(n); i++) {
			if (n % primes.get(i) == 0) {
				return false;
			}
		}
		return true;
	}
}
