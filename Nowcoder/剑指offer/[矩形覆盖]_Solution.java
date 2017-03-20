/*矩形覆盖
时间限制：1秒 空间限制：32768K 热度指数：16672
 算法知识视频讲解
题目描述
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种
*/

class Solution {
public:
    int rectCover(int number) {
		if(number<4){
            return number;
        }
        int a=0;
        int b=1;
        for(int i=0;i<(number+1)/2;i++){
            a=a+b;
            b=a+b;
        }
        return number%2==0?b:a;
    }
};