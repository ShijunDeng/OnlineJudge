/*
数字在排序数组中出现的次数
时间限制：1秒 空间限制：32768K 热度指数：7551
本题知识点： 数组
 算法知识视频讲解
题目描述
统计一个数字在排序数组中出现的次数。
*/
public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        int count = 0;
        int low = 0, high = array.length - 1;
        int mid = 0;
        while(low <= high){
			mid = (low + high) / 2;
            if(array[mid] == k){
                break;
            }else if(array[mid] > k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        if(array[mid] == k){
            count = 1;
            low = mid - 1;
            high = mid + 1;
            while(low >= 0 && array[low] == k){
                low--;
                count++;
            }
            while(high < array.length && array[high] == k){
                high++;
                count++;
            }            
        }
        return count;        
    }
}