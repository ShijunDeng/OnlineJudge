#include <iostream>
#include <stack>
using namespace std;
class Solution
{
public:
    int calculate(string s)
    {
        stack<int>numS;
        stack<char>opS;
        int len=s.size();
        int i=0;
        int tmp=0;
        opS.push('#');
        bool on=false;
        while(i<len)
        {
            if(isOperator(s[i]))
            {
                if(getPriority(s[i])>getPriority(opS.top()))
                {
                    opS.push(s[i]);
                }
                else
                {
                    while(getPriority(s[i])<=getPriority(opS.top()))
                    {
                        int b=numS.top();
                        numS.pop();
                        int a=numS.top();
                        numS.pop();
                        numS.push(calulate(a,b,opS.top()));
                        opS.pop();
                    }
                    opS.push(s[i]);
                }
                i++;
            }
            else if(isdigit(s[i]))
            {
                while(isdigit(s[i]))
                {
                    tmp=10*tmp+s[i]-'0';
                    i++;
                }
                on=true;
            }
            else
            {
                i++;
            }
            if(on)
            {
                numS.push(tmp);
                on=false;
                tmp=0;
            }
        }
        while(opS.top()!='#')
        {
            int b=numS.top();
            numS.pop();
            int a=numS.top();
            numS.pop();
            numS.push(calulate(a,b,opS.top()));
            opS.pop();
        }
        return numS.top();
    }
    bool isOperator(char op)
    {
        return op=='+'||op=='-'||op=='*'||op=='/';
    }
    int calulate(int a,int b,char c)
    {
        switch(c)
        {
        case '+':
            return a+b;
        case '-':
            return a-b;
        case '*':
            return   a*b;
        case '/':
            return a/b;
        }
        return -1;
    }
    int getPriority(char c)
    {
        switch(c)
        {
        case '+':
        case '-':
            return 10;
        case '*':
        case '/':
            return 20;
        }
        return 0;
    }
};
/*
int main()
{
    Solution s;
    cout << s.calculate("1+2")<< endl;
    cout << s.calculate("3+5 / 2")<< endl;

    return 0;
}*/
