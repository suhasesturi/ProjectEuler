import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PE3 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		computePrimes();
		while (t-- > 0) {
			long n = Long.parseLong(in.readLine());
			for (int i = 0; i < primes.size() && primes.get(i) <= (int) Math.sqrt(n); ) {
				if (n % primes.get(i) == 0) {
					n /= primes.get(i);
				} else {
					i++;
				}
			}
			System.out.println(n);
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
