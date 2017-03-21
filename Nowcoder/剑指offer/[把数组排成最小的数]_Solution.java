/*
把数组排成最小的数
时间限制：1秒 空间限制：32768K 热度指数：6762
本题知识点： 数组
 算法知识视频讲解
题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
*/
import java.util.ArrayList;

public class Solution {
 public String PrintMinNumber(int [] numbers) {
		if(numbers == null || numbers.length == 0){
            return "";
        }
        if(numbers.length == 1){
			return String.valueOf(numbers[0]);
        }
        boolean flag = true;
        for(int i = 0; i < numbers.length && flag; i++){
            flag = false;
            for(int j = 0; j < numbers.length - i - 1; j++ ){
                if(comp(numbers[j], numbers[j + 1])){
                    flag = true;
                    numbers[j] ^= numbers[j + 1];
                    numbers[j + 1] ^= numbers[j];
                    numbers[j] ^= numbers[j + 1];
                }
            }
        }
        String str = "";
        for(int e : numbers){
            str += String.valueOf(e);
        }
        return str;       
    }
    
    
    private boolean comp(int a, int b){
        return Long.valueOf(String.valueOf(a) + String.valueOf(b)) - Long.valueOf(String.valueOf(b) + String.valueOf(a)) > 0;
    }
    
}