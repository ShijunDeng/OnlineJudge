/*
左旋转字符串
时间限制：1秒 空间限制：32768K 热度指数：7526
本题知识点： 字符串
 算法知识视频讲解
题目描述
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
*/
public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str == null || n == 0 ||str.length() == 0 || n % str.length() == 0) {
			return str;
        }
        char[] array = str.toCharArray();
        reverse(array, 0, n-1);
        reverse(array, n, array.length-1);
        reverse(array, 0, array.length-1);
        return String.valueOf(array);
    }
    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            array[start] ^= array[end];
            array[end] ^= array[start];
            array[start] ^= array[end];
            start++;
            end--;
        }
    }
}