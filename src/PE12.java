import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PE12 {
	private static ArrayList<Integer> primes = new ArrayList<>();
	private static ArrayList<ArrayList<Integer>> triangles = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		computePrimes();
		computeFactors();
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			for (ArrayList<Integer> triangle : triangles) {
				if (triangle.get(0) > n) {
					System.out.println(triangle.get(1));
					break;
				}
			}
		}
	}

	private static void computeFactors() {
		int current = 1;
		for (int i = 2; ; i++) {
			current += i;
			int factors = factorize(current);
			triangles.add(new ArrayList<>(Arrays.asList(factors, current)));
			if (factors > 1000) {
				break;
			}
		}
	}

	private static int factorize(int n) {
		int factors = 1;
		for (int i = 0; n > 1 && i < primes.size() && primes.get(i) <= n; i++) {
			int current = 1;
			while (n % primes.get(i) == 0) {
				current++;
				n /= primes.get(i);
			}
			factors *= current;
		}
		return factors;
	}

	private static void computePrimes() {
		primes.add(2);
		for (int i = 3; i < 1e6; i += 2) {
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
