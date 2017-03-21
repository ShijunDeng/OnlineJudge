/*
丑数
时间限制：1秒 空间限制：32768K 热度指数：7134
本题知识点： 数组
 算法知识视频讲解
题目描述
把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
*/
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index < 1){
            return 0;
        }
        int [] record = new int [index];
        int i = 1;
        record[0] = 1;
        
        int max2 = 0, max3 = 0, max5 = 0;
        int min;
        while(i < index){
            min = Math.min(Math.min(record[max2] * 2, record[max3] * 3), record[max5] * 5);
            record[i] = min;
            while(2 * record[max2] <= record[i]){
                max2++;
            }
            while(3 * record[max3] <= record[i]){
                max3++;
            }
            while(5 * record[max5] <= record[i]){
                max5++;
            }
            i++;            
        }        
        return record[index - 1];
    }
}
