package cn.sjdeng.ds;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

/**
 * 复习排序
 * 
 * @author ShijunDeng
 *
 */
public class SortReview {
	/**
	 * 直接插入排序
	 * 
	 * @param number
	 * @param type
	 *            :true ascend and false descend
	 */
	public void insertSort(int[] number, boolean type) {
		int length = number.length;
		if (number == null || length == 0) {
			return;
		}
		for (int i = 1; i < length; i++) {
			int tmp = number[i];
			int j = i;
			while (j > 0 && number[i] < number[j - 1] == type) {
				j--;
			}
			for (int k = i; k > j; k--) {
				number[k] = number[k - 1];
			}
			number[j] = tmp;
		}
	}

	/**
	 * 折半插入排序
	 * 
	 * @param number
	 * @param type
	 *            :true ascend and false descend
	 */
	public void bInsertSort(int[] number, boolean type) {
		int length = number.length;
		if (number == null || length == 0) {
			return;
		}
		int low, high, mid, tmp;
		for (int i = 1; i < length; i++) {
			low = 0;
			high = i - 1;
			while (low <= high) {
				mid = (low + high) / 2;
				if (number[i] < number[mid] == type) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			tmp = number[i];
			for (int j = i; j > high + 1; j--) {
				number[j] = number[j - 1];
			}
			number[high + 1] = tmp;
		}
	}

	/**
	 * shell排序
	 * 
	 * @param number
	 * @param type
	 *            :true ascend and false descend
	 */
	public void shellSort(int[] number, boolean type) {
		int length = number.length;
		if (number == null || length == 0) {
			return;
		}
		int steps[] = new int[] { 9, 5, 3, 2, 1 };
		for (int step : steps) {
			for (int i = step; i < length; i++) {
				int tmp = number[i];
				int j = i;
				while (j >= step && number[i] < number[j - step] == type) {
					j -= step;
				}
				for (int k = i; k > j; k -= step) {
					number[k] = number[k - step];
				}
				number[j] = tmp;
			}
		}
	}

	/**
	 * 冒泡排序
	 * 
	 * @param number
	 * @param type
	 *            :true ascend and false descend
	 */
	public void bubbleSort(int[] number, boolean type) {
		int length = number.length;
		if (number == null || length == 0) {
			return;
		}
		boolean tag = true;
		int tmp;
		for (int i = 0; i < length - 1 && tag; i++) {
			tag = false;
			for (int j = 1; j < length - i; j++) {
				if (number[j] < number[j - 1] == type) {
					tag = true;
					tmp = number[j];
					number[j] = number[j - 1];
					number[j - 1] = tmp;
				}
			}
		}
	}

	/**
	 * 快速排序递归
	 * 
	 * @param number
	 * @param type
	 *            :true ascend and false descend
	 */
	public void quickSortRecur(int[] number, boolean type) {
		int length = number.length;
		if (number == null || length == 0) {
			return;
		}
		qsortRecur(number, 0, length - 1, type);

	}

	/**
	 * 快速排序非递归
	 * 
	 * @param number
	 * @param type
	 *            :true ascend and false descend
	 */
	public void quickSort(int[] number, boolean type) {
		int length = number.length;
		if (number == null || length == 0) {
			return;
		}
		qsort(number, 0, length - 1, type);

	}

	private void qsortRecur(int[] number, int low, int high, boolean type) {
		if (low < high) {
			int pivotKey = partition(number, low, high, type);
			qsortRecur(number, low, pivotKey - 1, type);
			qsortRecur(number, pivotKey + 1, high, type);
		}

	}

	private void qsort(int[] number, int low, int high, boolean type) {
		Stack<Integer> S = new Stack<Integer>();
		int pivotKey;
		S.push(low);
		S.push(high);
		while (S.isEmpty() == false) {
			high = S.pop();
			low = S.pop();
			pivotKey = partition(number, low, high, type);
			if (low < pivotKey - 1) {
				S.push(low);
				S.push(pivotKey - 1);
			}
			if (pivotKey + 1 < high) {
				S.push(pivotKey + 1);
				S.push(high);
			}
		}
	}

	private int partition(int[] number, int low, int high, boolean type) {
		int pivotKey = number[low];

		while (low < high) {
			while (low < high && number[high] > pivotKey == type) {
				high--;
			}
			number[low] = number[high];
			while (low < high && number[low] < pivotKey == type) {
				low++;
			}
			number[high] = number[low];
		}
		number[low] = pivotKey;
		return low;
	}

	/**
	 * 堆排序
	 * 
	 * @param number
	 * @param type
	 *            :true ascend and false descend
	 */
	public void heapSort(int[] number, boolean type) {
		int length = number.length;
		if (number == null || length == 0) {
			return;
		}
		for (int i = (length / 2) - 1; i >= 0; i--) {
			heapAdjust(number, i, length - 1, type);
		}
		int tmp;
		for (int i = length - 1; i > 0; i--) {
			tmp = number[0];
			number[0] = number[i];
			number[i] = tmp;
			heapAdjust(number, 0, i - 1, type);
		}
	}

	/**
	 * 注意下标从0开始,为了应用下标关系,需要根据情况加一减一
	 * 
	 * @param number
	 * @param low
	 * @param high
	 * @param type
	 */
	private void heapAdjust(int[] number, int low, int high, boolean type) {
		int rc = number[low];
		for (int i = 2 * (low + 1); i <= high + 1; i *= 2) {
			if (i < high && number[i - 1] > number[i] == type) {
				i++;
			}
			if (rc < number[i - 1] == type) {
				break;
			}
			number[low] = number[i - 1];
			low = i - 1;
		}
		number[low] = rc;
	}

	/**
	 * 归并排序 递归
	 * 
	 * @param number
	 * @param type
	 *            :true ascend and false descend
	 */
	public void mergeSortRecur(int[] number, boolean type) {
		int length = number.length;
		if (number == null || length == 0) {
			return;
		}
		msortRecur(number, number, 0, length - 1, type);
	}

	private void msortRecur(int[] number, int[] tmp1, int low, int high, boolean type) {
		int[] tmp2 = new int[number.length];
		if (low == high) {
			tmp1[low] = number[low];
		} else {
			int mid = (low + high) / 2;
			msortRecur(number, tmp2, low, mid, type);
			msortRecur(number, tmp2, mid + 1, high, type);
			merge(tmp2, tmp1, low, mid, high, type);
		}
	}

	private void merge(int[] number, int[] rs, int low, int mid, int high, boolean type) {
		int k = low, j = mid + 1;
		for (j = mid + 1; low <= mid && j <= high; k++) {
			if (number[low] < number[j] == type) {
				rs[k] = number[low++];
			} else {
				rs[k] = number[j++];
			}
		}
		while (low <= mid) {
			rs[k++] = number[low++];
		}
		while (j <= high) {
			rs[k++] = number[j++];
		}

	}

	/**
	 * 归并排序 非递归
	 * 
	 * @param number
	 * @param type
	 *            :true ascend and false descend
	 */
	public void mergeSort(int[] number, boolean type) {
		int length = number.length;
		if (number == null || length == 0) {
			return;
		}
		int[] cpNumber = number.clone();
		int size = 1, low, mid, high;
		while (size < length) {
			low = 0;
			while (low + size < length) {
				mid = low + size - 1;
				high = mid + size;
				if (high > length - 1) {
					high = length - 1;
				}
				merge(cpNumber, number, low, mid, high, type);
				low = high + 1;
			}
			cpNumber = Arrays.copyOf(number, length);
			size *= 2;
		}
	}

	public void testSort() {
		int[] number = new int[] { 1, 7, 10, 5, 3, 8, 4, 2, 12, 14, 11, 17, 16, 18 };
		SortReview sortTool = new SortReview();
		System.out.println("insertSort");
		sortTool.insertSort(number, true);
		System.out.println(Arrays.toString(number));
		sortTool.insertSort(number, false);
		System.out.println(Arrays.toString(number));

		number = new int[] { 1, 7, 10, 5, 3, 8, 4, 2, 12, 14, 11, 17, 16, 18 };
		System.out.println("bInsertSort");
		sortTool.bInsertSort(number, true);
		System.out.println(Arrays.toString(number));
		sortTool.bInsertSort(number, false);
		System.out.println(Arrays.toString(number));

		number = new int[] { 1, 7, 10, 5, 3, 8, 4, 2, 12, 14, 11, 17, 16, 18 };
		System.out.println("shellSort");
		sortTool.shellSort(number, true);
		System.out.println(Arrays.toString(number));
		sortTool.shellSort(number, false);
		System.out.println(Arrays.toString(number));

		number = new int[] { 1, 7, 10, 5, 3, 8, 4, 2, 12, 14, 11, 17, 16, 18 };
		System.out.println("bubbleSort");
		sortTool.bubbleSort(number, true);
		System.out.println(Arrays.toString(number));
		sortTool.bubbleSort(number, false);
		System.out.println(Arrays.toString(number));

		number = new int[] { 1, 7, 10, 5, 3, 8, 4, 2, 12, 14, 11, 17, 16, 18 };
		System.out.println("quickSortRecur");
		sortTool.quickSortRecur(number, true);
		System.out.println(Arrays.toString(number));
		sortTool.quickSortRecur(number, false);
		System.out.println(Arrays.toString(number));

		number = new int[] { 1, 7, 10, 5, 3, 8, 4, 2, 12, 14, 11, 17, 16, 18 };
		System.out.println("quickSort");
		sortTool.quickSort(number, true);
		System.out.println(Arrays.toString(number));
		sortTool.quickSort(number, false);
		System.out.println(Arrays.toString(number));

		number = new int[] { 1, 7, 10, 5, 3, 8, 4, 2, 12, 14, 11, 17, 16, 18 };
		System.out.println("heapSort");
		sortTool.heapSort(number, true);
		System.out.println(Arrays.toString(number));
		sortTool.heapSort(number, false);
		System.out.println(Arrays.toString(number));

		number = new int[] { 1, 7, 10, 5, 3, 8, 4, 2, 12, 14, 11, 17, 16, 18 };
		System.out.println("mergeSortRecur");
		sortTool.mergeSortRecur(number, true);
		System.out.println(Arrays.toString(number));
		sortTool.mergeSortRecur(number, false);
		System.out.println(Arrays.toString(number));

		number = new int[] { 1, 7, 10, 5, 3, 8, 4, 2, 12, 14, 11, 17, 16, 18 };
		System.out.println("mergeSort");
		sortTool.mergeSort(number, true);
		System.out.println(Arrays.toString(number));
		sortTool.mergeSort(number, false);
		System.out.println(Arrays.toString(number));
	}

	@Test
	public void testXXX() {
		testSort();
	}
}
