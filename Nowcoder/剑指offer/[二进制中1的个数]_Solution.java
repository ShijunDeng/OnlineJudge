/*二进制中1的个数
时间限制：1秒 空间限制：32768K 热度指数：18411
 算法知识视频讲解
题目描述
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示*/
class Solution {
public:
     int  NumberOf1(int n) {
         int count=0;
         while(n){
             count++;
             n&=(n-1);
		 }
         return count;
     }
};