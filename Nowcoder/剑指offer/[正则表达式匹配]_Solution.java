/*
正则表达式匹配
时间限制：1秒 空间限制：32768K 热度指数：3710
本题知识点： 字符串
 算法知识视频讲解
题目描述
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有
字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
*/

public class Solution {
    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        if (str.length != 0 && pattern.length == 0) {
            return false;
        }
        return match(str, 0, pattern, 0);
    }
    
    public boolean match(char[] str, int i, char[] pattern, int j) {
        if (i == str.length && j== pattern.length) {
            return true;
        }
        if (i < str.length && j == pattern.length) {
            return false;
        }
        
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            if ((i < str.length && str[i] == pattern[j]) || (pattern[j] == '.' && i < str.length)){
                return match(str, i+1 , pattern, j + 2) || match(str, i+1 , pattern, j) || match(str, i , pattern, j + 2);
            } else {
				return match(str, i, pattern, j + 2);
            }            
        }
        if ( j < pattern.length && i < str.length &&str[i] == pattern[j] || (pattern[j] == '.' && i < str.length)) {
            return match(str, i + 1, pattern, j + 1);
        }
        return false;
    }
}