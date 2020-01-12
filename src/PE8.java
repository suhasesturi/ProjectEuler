import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PE8 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			String[] s = in.readLine().split(" ");
			int k = Integer.parseInt(s[1]);
			String n = in.readLine();
			int tempK = k;
			int result = 0, current = 1;
			for (int i = 0; i < n.length(); ) {
				while (i < n.length() && k > 0 && n.charAt(i) != '0') {
					if (n.charAt(i) == '0') {
						current = 1;
						break;
					}
					current *= n.charAt(i) - '0';
					i++;
					k--;
				}
				if (k == 0) {
					result = Math.max(result, current);
				}

				if (i < n.length()) {
					if (n.charAt(i) == '0') {
						k = tempK;
						current = 1;
					} else {
						current /= n.charAt(i - tempK) - '0';
						current *= n.charAt(i) - '0';
					}
					i++;
				}
				if (k == 0) {
					result = Math.max(result, current);
				}
			}
			System.out.println(result);
		}
	}
}
