import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class PE9 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		computeTriplets();
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(in.readLine());
			if (triplets.get(n) != null) {
				System.out.println(triplets.get(n));
			} else {
				System.out.println(-1);
			}
		}
	}

	private static Map<Integer, Integer> triplets = new HashMap<>();

	private static void computeTriplets() {
		Map<Integer, Integer> squares = new HashMap<>();
		int[] squaresArr = new int[30001];

		for (int i = 1; i <= 3000; i++) {
			squaresArr[i] = i * i;
			squares.put(squaresArr[i], i);
		}

		for (int a = 1; a <= 3000; a++) {
			for (int b = a + 1; b <= 3000; b++) {
				int cSquare = squaresArr[a] + squaresArr[b];
				if (squares.containsKey(squaresArr[a] + squaresArr[b])) {
					if (triplets.containsKey(a + b + squares.get(cSquare))) {
						triplets.put(a + b + squares.get(cSquare), Math.max(triplets.get(a + b + squares.get(cSquare)), a * b * squares.get(cSquare)));
					} else {
						triplets.put(a + b + squares.get(cSquare), a * b * squares.get(cSquare));
					}
				}
			}
		}
	}
}
