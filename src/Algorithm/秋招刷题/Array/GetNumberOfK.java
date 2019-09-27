package Algorithm.Array;

/**
 * 统计一个数字在排序数组中出现的次数
 */
public class GetNumberOfK {

    public static int getNumberOfK(int[] num, int k) {

        if(num.length == 0) {
            return 0;
        }
        int firstK = getFirstK(num, k, 0, num.length-1);
        int lastK = getLastK(num, k, 0, num.length-1);
        if(firstK != -1 && lastK != -1) {
            return lastK - firstK;
        }
        return 0;
    }

    private static int getFirstK(int[] num, int k, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = start + (end - start)/2;
        if(num[mid] == k) {
            if((mid > 0 && num[mid-1] != k) || mid == 0) {
                return mid; //正好是mid
            } else {
                end = mid - 1;
            }
        } else {
            if(num[mid] > k)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return getFirstK(num, k, start, end);
    }

    private static int getLastK(int[] num, int k, int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = start + (end - start)/2;
        if(num[mid] == k) {
            if((mid < num.length-1 && num[mid-1] != k) || mid == num.length-1) {
                return mid;
            } else {
                start = mid + 1; //继续向后找
            }
        } else {
            if(num[mid] > k)
                end = mid - 1; //最后一个k在前面
            else
                start = mid + 1;
        }
        return getLastK(num, k, start, end);

    }


}
