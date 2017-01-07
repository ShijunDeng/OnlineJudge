#include<iostream>
#include<vector>
#include<string>
#include<set>
#include<stack>
#include<queue>
using namespace std;
class Solution {
public:
    int numTrees(int n) {
        long long sum1=1;
        long long sum2=1;
        for(int i=1; i<=n; i++) {
            sum1*=i;
            sum2*=(i+n);
            if(sum2%sum1==0) {
                sum2/=sum1;
                sum1=1;
            }
        }

        return (sum2)/(sum1*(n+1));
    }
};

int main() {
    Solution s;
    cout<<s.numTrees(19);
    return 0;
}
