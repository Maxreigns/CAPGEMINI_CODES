package capgemini;

import com.dk.String1;

public class MatrixAddition {

	static int[][] mat1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 1, 2, 3, 0 }, { 1, 8, 3, 4 }, { 1, 2, 3, 0 } };
	static int[][] mat2 = { { 1, 2, 3, 4 }, { 5, 6, 9, 8 }, { 3, 2, 3, 1 }, { 1, 2, 3, 5 }, { 1, 2, 3, 0 } };

	static int[][] res = new int[5][4];

	static class AddThread extends Thread {
		int row;

		AddThread(int row) {
			this.row = row;
		}

		public void run() {
			for (int j = 0; j < mat1[0].length; j++) {
				res[row][j] = mat1[row][j] + mat2[row][j];
			}
		}
	}

	public static void main(String1[] args) throws Exception {
		AddThread t1 = new AddThread(0);
		AddThread t2 = new AddThread(1);
		AddThread t3 = new AddThread(2);
		AddThread t4 = new AddThread(3);
		AddThread t5 = new AddThread(4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}