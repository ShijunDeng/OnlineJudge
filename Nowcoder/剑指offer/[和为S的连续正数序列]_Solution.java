/*
和为S的连续正数序列
时间限制：1秒 空间限制：32768K 热度指数：6480
 算法知识视频讲解
题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck! 
输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
*/
import java.util.ArrayList;
public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> rs = new ArrayList<ArrayList<Integer>>();
        if(sum < 3){
            return rs;
        }
        int low = 1;
        int high = 2;
        int mid = (1 + sum) / 2;
        int tmp = 3;
        while (low < mid && high < sum) {
            if (tmp == sum) {
                ArrayList<Integer> t = new ArrayList<Integer>();
                for(int i = low; i <=high; i++) {
                    t.add(i);
                }
                rs.add(t);
            }
            while (tmp > sum && low < mid) {
                tmp -= low;
                low ++; 
                if (tmp == sum) {
                    ArrayList<Integer> t = new ArrayList<Integer>();
                    for(int i = low; i <=high; i++) {
                        t.add(i);
                    }
                    rs.add(t);
            	}
            }
                high++;
                tmp += high;         
        }
        return rs;
    }
}