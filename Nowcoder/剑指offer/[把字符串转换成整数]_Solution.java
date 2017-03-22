/*
把字符串转换成整数
时间限制：1秒 空间限制：32768K 热度指数：6084
本题知识点： 字符串
 算法知识视频讲解
题目描述
将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0 
输入描述:
输入一个字符串,包括数字字母符号,可以为空


输出描述:
如果是合法的数值表达则返回该数字，否则返回0

输入例子:
+2147483647
    1a33

输出例子:
2147483647
    0
*/
public class Solution {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] array = str.toCharArray();
        int index = 0;
        int flag = 1;
        int sum = 0;
        while (array[index] == ' ') {
            index++;
        }
        if (index < array.length && array[index] == '+') {
            flag = 1;
            index++;
        } else if (index < array.length && array[index] == '-') {
            flag = -1;
            index++;
        }
        while (index < array.length && array[index] == ' ') {
            index++;
        }
        while (index < array.length) {
            if (array[index] >= '0' && array[index] <= '9') {
                sum = 10*sum + array[index] - '0';
            	index++; 
            } else {
                return 0;
            }           
        }
        return flag > 0 ? sum : -sum;       
    }
}