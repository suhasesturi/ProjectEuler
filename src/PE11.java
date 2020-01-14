import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PE11 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] grid = new int[20][20];
		for (int i = 0; i < 20; i++) {
			String[] s = in.readLine().split(" ");
			for (int j = 0; j < 20; j++) {
				grid[i][j] = Integer.parseInt(s[j]);
			}
		}

		int result = 0;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				int current = 1;
				for (int k = 0; k < 4; k++) {
					if (j + k < 20) {
						current *= grid[i][j + k];
					} else {
						current = 0;
					}
				}
				result = Math.max(result, current);
			}
		}

		for (int j = 0; j < 20; j++) {
			for (int i = 0; i < 20; i++) {
				int current = 1;
				for (int k = 0; k < 4; k++) {
					if (i + k < 20) {
						current *= grid[i + k][j];
					} else {
						current = 0;
					}
				}
				result = Math.max(result, current);
			}
		}

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				int current = 1;
				for (int k = 0; k < 4; k++) {
					if (i + k < 20 && j + k < 20) {
						current *= grid[i + k][j + k];
					} else {
						current = 0;
					}
				}
				result = Math.max(result, current);
			}
		}

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				int current = 1;
				for (int k = 0; k < 4; k++) {
					if (i - k >= 0 && j + k < 20) {
						current *= grid[i - k][j + k];
					} else {
						current = 0;
					}
				}
				result = Math.max(result, current);
			}
		}

		System.out.println(result);
	}
}
