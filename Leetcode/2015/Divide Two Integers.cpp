#include<iostream>
#include<vector>
#include<cmath>
using namespace std;
class Solution {
public:
    int divide(int dividend, int divisor) {
        bool negetive=((dividend^divisor)>>31)==-1;
        if(divisor==0) return INT_MAX;
        bool isMin=false;
        if(dividend==INT_MIN) {
            if(divisor==INT_MIN) return 1;
            isMin=true; //We need to convert dividend to non-negetive
            dividend+=abs(divisor);
        }
        if(divisor==INT_MIN) return 0;
        divisor=abs(divisor);
        dividend=abs(dividend);
        int times=0;
        while((divisor<<1)>0 && (divisor<<1)<=dividend) {
            times++;
            divisor<<=1;
        }
        int ans=0;
        while(times-->=0) {
            ans<<=1;
            if(dividend>=divisor) {
                dividend-=divisor;
                ans+=1;
            }
            divisor>>=1;
        }
        if(isMin) {
            if(negetive&&ans==INT_MAX) return INT_MIN;
            if(!negetive &&ans==INT_MAX) return INT_MAX;
            ans++;
        }
        return negetive?-ans:ans;
    }
};
int main() {
    Solution s;
    cout<<s.divide(6,2)<<endl;
    cout<<s.divide(6,4)<<endl;
    return 0;
}
