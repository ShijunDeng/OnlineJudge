/*栈的压入、弹出序列
时间限制：1秒 空间限制：32768K 热度指数：11069
本题知识点： 栈
 算法知识视频讲解
题目描述
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列
的弹出序列。（注意：这两个序列的长度是相等的）
*/
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> tmp = new Stack<Integer>();
        if(pushA == null || popA == null){
            return  false;
        }
        int lenPushA = pushA.length;
        int lenPopA = popA.length;
        if(lenPushA != lenPopA){
            return false;
        }
        int i=0,j=0;
        while(i < lenPushA){
            if(pushA[i] != popA[j]){
                tmp.push(pushA[i]);
                i++;
            }else{
                i++;
                j++;
            }
		}
        while(tmp.empty() == false){
			if(tmp.pop() != popA[j]){
                break;
            }
            j++;
        }
        return tmp.empty() && j==lenPopA;       
    }
}