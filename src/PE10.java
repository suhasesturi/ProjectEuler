import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PE10 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		computePrimes();
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			long result = 0;
			for (int i = 0; i < primes.size() && primes.get(i) <= n; i++) {
				result += primes.get(i);
			}
			System.out.println(result);
		}
	}

	private static ArrayList<Integer> primes = new ArrayList<>();

	private static void computePrimes() {
		primes.add(2);
		for (int i = 3; i < 1e6; i += 2) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
	}

	private static boolean isPrime(long n) {
		for (int i = 0; i < primes.size() && primes.get(i) <= (int) Math.sqrt(n); i++) {
			if (n % primes.get(i) == 0) {
				return false;
			}
		}
		return true;
	}
}
