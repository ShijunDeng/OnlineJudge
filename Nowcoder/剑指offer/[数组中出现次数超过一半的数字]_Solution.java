/*数组中出现次数超过一半的数字
时间限制：1秒 空间限制：32768K 热度指数：9698
本题知识点： 数组
 算法知识视频讲解
题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0
*/
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length==0){
            return 0;
        }
        int count=1;
        int last = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] == last){
                count ++;
            }else{
                count --;
                if(count == 0){
                    count = 1;
					last = array[i];
            	}
            }
        }
        count = 0;
        for(int e : array){//一定不能丢掉验证的过程
            if(last == e){
                count ++;
            }
        }
    	return count*2 > array.length ? last : 0;
    }
}