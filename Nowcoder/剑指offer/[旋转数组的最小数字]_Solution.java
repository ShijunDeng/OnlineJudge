/*
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
*/
import java.util.ArrayList;
public class Solution {
   public int minNumberInRotateArray(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}

		int low = 0;
		int high = array.length - 1;
		if (array[low] < array[high] || low == high) {
			return array[low];
		}
		int mid = 0;
		while (array[low] >= array[high]) {
            if(low==high-1){
                return array[high];
            }			
            mid = (low + high) / 2;  
            if (array[mid] == array[low] && array[mid] == array[high]) {
                int tmp=array[low];
				for (int i = low+1; i <= high; i++) {
					if (array[i] < tmp) {
						tmp= array[i];
					}
				}
                return tmp;
			}else if (array[mid] >= array[high]) {
				low = mid;
			} else if (array[mid] <= array[high]) {
				high = mid;
			}
		}
		return 0;
	}
}