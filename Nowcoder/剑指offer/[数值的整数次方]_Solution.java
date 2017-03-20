/*数值的整数次方
时间限制：1秒 空间限制：32768K 热度指数：15545
 算法知识视频讲解
题目描述
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。*/
public class Solution {
    public double Power(double base, int exponent) {
        if(base==0.0){
            return 0;
        }
        if(exponent==0){
            return 1;
        }
        double rs=1.0;
        if(exponent>0){
            while(exponent>0){
                rs*=base;
                exponent--;
            }
            return rs;
        } else if(exponent<0){
            exponent=-exponent;
            while(exponent>0){
                rs*=base;
                exponent--;
            }
            return 1.0/rs;
        }
        return 0;
  }
}
