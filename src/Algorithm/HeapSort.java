package Algorithm;

import java.util.Arrays;
/**
	堆排序思路
		1 将原有数组变换为大根堆
		2 将最后一个节点(数组中最小值)与堆顶元素互换，同时将堆大小减一(排除堆底最大元素)
		  进行heapify操作(节点下移)
		3 循环上述过程  

*/
public class HeapSort {

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		// 1 数组转为大根堆
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i); // 将元素i插入到0->i-1形成的大根堆中
		}
		// 2 将堆底元素与堆顶元素互换
		int size = arr.length;
		swap(arr, 0, --size);
		// 2 heapify操作
		while (size > 0) {
			heapify(arr, 0, size);
			swap(arr, 0, --size); //元素互换 堆大小减一
		}
	}

	/**数组元素转为大根堆
		将带插入的元素与堆顶元素比较
			若当前元素大于堆顶元素，则将该元素与堆顶元素互换，同时替换对应的下标(节点上移)
	
	*/
	public static void heapInsert(int[] arr, int index) {
		/**
			元素i
				左孩子 i*2+1
				右孩子 i*2+2
				父节点 (i-1)/2
		*/
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2); //元素i与i的父节点交换
			index = (index - 1) / 2; //变换节点下边
		}
	}

	/**
		节点元素下移过程
		size：堆大小
		Index: Index值变小了 		
		1 找出节点下标左孩子和右孩子中最大值
		2 孩子节点中的最大值与该节点元素比较
		3 
	
	*/
	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1; //对应节点的左孩子
		while (left < size) {
			//left + 1 < size:右孩子不越界且右孩子大于左孩子时 选右孩子下标
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			//孩子节点中的最大值与该节点元素比较 选出最大值的下标
			largest = arr[largest] > arr[index] ? largest : index;
			// 最大值仍然是堆顶 不用下层
			if (largest == index) {
				break;
			}
			//不满足 则节点下移
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	

}
