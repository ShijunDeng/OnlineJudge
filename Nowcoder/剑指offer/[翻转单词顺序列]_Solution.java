/*
翻转单词顺序列
时间限制：1秒 空间限制：32768K 热度指数：6953
本题知识点： 字符串
 算法知识视频讲解
题目描述
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
*/
public class Solution {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        
        char[] array = str.toCharArray();
        
        char[] covert = new char[array.length];
        
        int i = array.length - 1;
        int j, k=0, p;
        while (i >=0 ) {
            j = i;
            while (i>=0 && array[i] != ' ') {
                i--;
            }
            p = i + 1;
            while (p <= j) {
                covert[k] = array[p];
                k++;
                p++;
            }
           while (i>=0 && array[i] == ' ') {
               covert[k] = ' ';
               k++;
               i--;
           }                      
        }
        return String.valueOf(covert);
    }
}