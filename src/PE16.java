import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PE16 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			String number = BigInteger.valueOf(2).pow(n).toString();
			int result = 0;
			for (int i = 0; i < number.length(); i++) {
				result += number.charAt(i) - '0';
			}
			System.out.println(result);
		}
	}
}
