#include <iostream>
using namespace std;

class Solution {
public :
    int addDigits(int num) {
        int sum=0;
        while(num>=10) {
            sum=0;
            while(num>0) {
                sum+=(num%10);
                num/=10;
            }
            num=sum;
        }
        return num;
    }
};
int main() {
    Solution s;
    cout << s.addDigits(10)<< endl;
    return 0;
}
