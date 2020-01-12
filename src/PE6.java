import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PE6 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			int sum = (n * (n + 1)) / 2;
			long result = 0;
			for (int i = 1; i <= n; i++) {
				result += ((long) i * (sum - i));
			}
			System.out.println(result);
		}
	}
}
