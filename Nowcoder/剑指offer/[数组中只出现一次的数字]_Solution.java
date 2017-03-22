/*数组中只出现一次的数字
时间限制：1秒 空间限制：32768K 热度指数：7640
本题知识点： 数组
 算法知识视频讲解
题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
*/

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    int getFirstOneBit(int x){
        return x & (~(x - 1) );
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int aXORb = 0;
        int a = 0;
        int b = 0;
        for(int x : array){
            aXORb ^= x;
        }
        int firstOnebit = getFirstOneBit(aXORb);
        for(int x : array){
            if(getFirstOneBit(x) == firstOnebit){
                a ^= x;
			}
        }
        b = aXORb ^ a;
        num1[0] = a;
        num2[0] = b;
    }
}