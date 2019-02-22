package Algorithm;

/**
	一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右
	四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
	矩阵中有多少个岛？
*/
public class Islands {

	public static int countIslands(int[][] m) {
		if (m == null || m[0] == null) {
			return 0;
		}
		int N = m.length; //行
		int M = m[0].length; //列
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (m[i][j] == 1) {
					res++; //岛数量
					//感染函数
					infect(m, i, j, N, M);
				}
			}
		}
		return res;
	}

	/**
		遇到1 感感染上 下 左 右 并将1->2 
	*/
	public static void infect(int[][] m, int i, int j, int N, int M) {
		//越界 或 下标不为1
		if (i < 0 || i >= N || j < 0 || j >= M || m[i][j] != 1) {
			return;
		}
		m[i][j] = 2;
		infect(m, i + 1, j, N, M);
		infect(m, i - 1, j, N, M);
		infect(m, i, j + 1, N, M);
		infect(m, i, j - 1, N, M);
	}

	

}
