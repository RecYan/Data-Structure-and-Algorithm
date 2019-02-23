package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
	宣讲项目安排问题
*/
public class BestArrange {

	public static class Program {
		public int start; //宣讲开始时间
		public int end; //宣讲结束时间

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	// 将宣讲结束时间早的 排在前面
	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

	public static int bestArrange(Program[] programs, int start) {
		Arrays.sort(programs, new ProgramComparator());
		int result = 0;
		for (int i = 0; i < programs.length; i++) {
			/**
				当前时间 <= 项目开始的时间
					宣讲可以安排
					同时将当前时间设置为该项目的结束时间
						淘汰到与该宣讲时间冲突的项目
			*/
			if (start <= programs[i].start) {
				result++;
				start = programs[i].end;
			}
		}
		return result;
	}

	

}
