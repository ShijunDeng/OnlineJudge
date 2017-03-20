包含min函数的栈
时间限制：1秒 空间限制：32768K 热度指数：11041
本题知识点： 栈
 算法知识视频讲解
题目描述
定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

import java.util.Stack;

public class Solution {
	Stack<Integer> A = new Stack<Integer>();
    Stack<Integer> B = new Stack<Integer>();
    
    public void push(int node) {
        if(B.empty() || node < B.peek()){
            B.push(node);
        }else{
            B.push(B.peek());
        }
        A.push(node);
    }
    
    public void pop() {
        A.pop();
        B.pop();
    }
    
    public int top() {
        return A.peek();
    }
    
    public int min() {
        return B.peek();
    }
}