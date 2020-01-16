import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PE13 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		BigInteger result = BigInteger.ZERO;
		for (int i = 0; i < n; i++) {
			result = result.add(new BigInteger(in.readLine()));
		}
		System.out.println(result.toString().substring(0, 10));
	}
}
