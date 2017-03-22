/*
和为S的两个数字
时间限制：1秒 空间限制：32768K 热度指数：7471
 算法知识视频讲解
题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。 
输出描述:
对应每个测试案例，输出两个数，小的先输出。
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> rs = new ArrayList<Integer>();
        if (array == null || array.length ==0) {
            return rs;
        }
        int i = 0;
        int j = array.length-1;
        while ( i < j) {
            if (array[i] + array[j] == sum) {
                rs.add(array[i]);
                rs.add(array[j]);
                return rs;
            }else if (array[i] + array[j] < sum) {
                i++;
            }else{
                j--;
            }
        }
        return rs;
    }
}