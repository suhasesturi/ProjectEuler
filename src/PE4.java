import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class PE4 {
	private static ArrayList<Integer> palindromes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		computePalindromes();
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			System.out.println(findPalindrome(n));
		}
	}

	private static int findPalindrome(int n) {
		int a = 0, b = palindromes.size() - 1;
		while (a < b) {
			int mid = (a + b + 1) / 2;
			if (palindromes.get(mid) < n) {
				a = mid;
			} else {
				b = mid - 1;
			}
		}
		return palindromes.get(a);
	}

	private static void computePalindromes() {
		for (int i = 100; i < 1000; i++) {
			for (int j = i; j < 1000; j++) {
				int product = i * j;
				if (isPalindrome(product)) {
					palindromes.add(product);
				}
			}
		}
		Collections.sort(palindromes);
	}

	private static boolean isPalindrome(int n) {
		String num = String.valueOf(n);
		for (int i = 0, j = num.length() - 1; i < j; i++, j--) {
			if (num.charAt(i) != num.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
