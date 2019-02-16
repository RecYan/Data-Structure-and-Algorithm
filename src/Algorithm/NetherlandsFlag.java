package Algorithm;
/** 荷兰国旗
Created by Yan_Jiang 
 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，
 大于num的数放在数组的右边
*/

public class NetherlandsFlag {

	//l:arr数组左边界；r:arr数组右边界；p：带比较的数字
	public static int[] partition(int[] arr, int l, int r, int p) {
		int less = l - 1; //小于区域指针
		int more = r + 1; //大于区域指针
		int index = l; //数组元素指针
		while (index < more) {
			if (arr[index] < p) { 
			/**小于区域处理
				该位置元素与小于区域的下一个元素交换
				inedx++
				less++
			*/
				swap(arr, ++less, index++);
			} else if (arr[index] > p) {
				/**大于区域处理
				该位置元素与大于区域的前一个元素交换
				inedx不变[还需要继续判断与p的大小关系]
				more--
			*/
				swap(arr, --more, index);
			} else {
				index++;
			}
		}
		return new int[] { less + 1, more - 1 }; //返回等于区域数组边界元素
	}

	// for test
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 1);
		printArray(res);
		
	}
}
