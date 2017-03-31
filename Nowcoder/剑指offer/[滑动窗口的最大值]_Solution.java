/*
滑动窗口的最大值
时间限制：1秒 空间限制：32768K 热度指数：4179
 算法知识视频讲解
题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
 
import java.util.ArrayList;

public class Solution {
    
    private int[] findM(int [] num, int startIndex, int endIndex){
        int[] rs = new int[]{Integer.MIN_VALUE, -1};
      
        for (int i = startIndex; i < endIndex; i++) {       
            if (rs[0] < num[i]) {
                rs[0] = num[i];
                rs[1] = i;
            }
        }
        return rs;
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> rs = new ArrayList<Integer>();
        if (num == null || num.length == 0 || size == 0 || num.length < size) {
            return rs;
        }
        int[] mm = findM(num, 0, size);
        rs.add(mm[0]);
        if (num.length == size) {          
            return rs;
        }
        
        for (int i = size; i < num.length; i++ ) {
            if (i - size + 1 > mm[1]) {
                mm = findM(num, i - size + 1, i + 1);
            } else if (num[i] >= mm[0]) {
                mm[0] = num[i];
                mm[1] = i;
            } 
            rs.add(mm[0]);
		}       
        return rs;        
    }
}