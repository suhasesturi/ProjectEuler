import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PE1 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			long result = 0;
			long max = (n - 1) / 3;
			result += 3 * (max * (max + 1)) / 2;
			max = (n - 1) / 5;
			result += 5 * (max * (max + 1)) / 2;
			max = (n - 1) / 15;
			result -= 15 * (max * (max + 1)) / 2;
			System.out.println(result);
		}
	}
}
