package Algorithm;

public class Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, n, "left", "mid", "right");
		}
	}

	public static void func(int rest, int down, String from, String help, String to) {
		if (rest == 1) {
			System.out.println("move " + down + " from " + from + " to " + to);
		} else {
			func(rest - 1, down - 1, from, to, help);
			func(1, down, from, help, to);
			func(rest - 1, down - 1, help, from, to);
		}
	}
	
	/**
		汉诺塔问题
			N: 1-N的问题
	*/
	public static void process(int n, String from, String to, String help) {
		
		if(n == 1) {
			System.out.println("move 1 from" + from + " to" + to);
			return;
		} else {
			//1~n-1 从from-->help 通过to辅助
			//通过3层汉诺塔画一下过程 就可以理解下面三行代码的意思
			process(n-1, from, help, to);
			//打印移动的细节过程
			System.out.println("move "+ n + " from "+from + " to" + to);
			//移动回to 通过help辅助
			process(n-1, help, to, from);
		}

	}
	

	
	
	public static void moveLeftToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to right");
		}
		moveLeftToMid(N - 1);
		System.out.println("move " + N + "from left to right");
		moveMidToRight(N - 1);
	}

	public static void moveRightToLeft(int N) {

	}

	public static void moveLeftToMid(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to mid");
		}
		moveLeftToRight(N - 1);
		System.out.println("move " + N + "from left to mid");
		moveRightToMid(N - 1);
	}

	public static void moveMidToLeft(int N) {

	}

	public static void moveRightToMid(int N) {

	}

	public static void moveMidToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from mid to right");
		}
		moveMidToLeft(N - 1);
		System.out.println("move " + N + "from mid to right");
		moveLeftToRight(N - 1);
	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}

}
