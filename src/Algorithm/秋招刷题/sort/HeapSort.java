package Algorithm.sort;

/**
 * 堆排序
 *                  j
 *      left 2*j+1     right 2*j+2
 *
 */
public class HeapSort {

    // n:树中的节点个数[num.length]  i:heapify处理的节点
    // heapify只能保证一个节点符合堆的性质
    public static void heapify(int[] num, int n, int i) {
        if(i >= n) {
            return;
        }

        int left = 2 * i + 1; //左叶子节点[数组下标]
        int right = 2 * i + 2;
        int max = i; //parent

        if(left < n && num[left] > num[max]) { // left < n 保证节点不越界 --> 数组下标不越界
            max = left;
        }
        if(right < n && num[right] > num[max]) {
            max = right;
        }
        if(max != i) { //i节点已经是最大值 停止交换
            swap(num, max, i);
            heapify(num, n, max);
        }
    }

    public static void buildHeap(int[] num) {
        int n = num.length; //树中节点个数
        int lastNode = n - 1;
        int parentNode = (lastNode - 1) / 2; // n-1层开始heapify
        for(int i=parentNode; i>=0; i--) {
            heapify(num, n, i);
        }
    }

    public static void heapSort(int[] num) {
        buildHeap(num);
        int n = num.length;
        int lastNode = n - 1;
        for(int i=lastNode; i>=0; i--) {
            swap(num, 0, i); //交换根节点与最后一个节点
            heapify(num, i, 0); //i控制最大节点的断开[节点数量-1] 继续从根节点heapify
        }
    }

    private static void swap(int[] num, int j, int max) {
        int temp = num[j];
        num[j] = num[max];
        num[max] = temp;
    }

    public static void main(String[] args) {

        int[] num = {2, 5, 3, 1, 4, 10};
        heapSort(num);
        //buildHeap(num);
        for(int i : num) {
            System.out.print(i + " ");
        }
    }


}
