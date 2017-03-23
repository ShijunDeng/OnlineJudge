/*
字符流中第一个不重复的字符
时间限制：1秒 空间限制：32768K 热度指数：4471
本题知识点： 字符串
 算法知识视频讲解
题目描述
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。 
输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。
*/

public class Solution {
    
    int[] record = new int[256];
    int index = 0;
    public Solution() {
        for (int i = 0; i < 256; i++) {
            record[i] = -1;
        }
    }
    
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (record[ch] == -1) {
            record[ch] = index++;
        } else if (record[ch] >= 0){
            record[ch] = -2;
        }
        
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
    	int min = 257;
        char c='#';
        for (int i = 0; i < 256; i++) {
            if (record[i] >=0 && record[i] < min) {
                c = (char)i;
                min = record[i];
            }
        }
        return c;
    }
}