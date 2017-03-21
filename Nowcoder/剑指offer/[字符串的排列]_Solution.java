/*字符串的排列
时间限制：1秒 空间限制：32768K 热度指数：7730
本题知识点： 字符串
 算法知识视频讲解
题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。 
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。*/
import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public ArrayList<String> Permutation(String str) {
       ArrayList<String> rs = new ArrayList<String>();
        if(str == null || str.length()==0){
            return rs;
        }
        tryK(0,rs,str.toCharArray());
         Collections.sort(rs);
        return rs;
    }
    private void tryK(int k, ArrayList<String> rs, char []s ){
        if(k > s.length-1){
            rs.add(String.valueOf(s));
        }else{
            for(int i=k; i < s.length; i++){
                if(i !=k && s[i] == s[k]){
                    continue;
                }
                swap(i, k, s);
                tryK(k+1, rs, s);
                swap(k, i, s);
            }
        }
        
    }
    
    private void swap(int i, int j, char []s){
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
}