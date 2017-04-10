/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
Subscribe to see which companies asked this question.
*/
public class Solution {
    int compute(int a, int b, char op) {
        switch (op){
            case '+':return a + b;
            case '-':return a - b;
            case '*':return a * b;
            case '/':return a / b;
            default :return -1;
        }
    }
    public int evalRPN(String[] tokens) {
        if (tokens == null) {
           return -1; 
        }
        
        int[] num = new int [tokens.length];
        int numIndex = 0;
        for (String s : tokens) {
            if (Character.isDigit(s.charAt(0)) == false && s.length() == 1) {
                numIndex -= 2;
                num[numIndex] = compute(num[numIndex], num[numIndex + 1], s.charAt(0));
                numIndex ++;    
            }else {
                num[numIndex++] = Integer.parseInt(s);                                  
            }
        }        
        return num[0];
    }
}