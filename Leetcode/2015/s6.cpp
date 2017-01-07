#include<iostream>
#include<vector>
#include<string>
using namespace std;
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size()<2) {
            return 0;
        }
        int maxProfit=prices[1]-prices[0];
        int tmpzProfit=0;
        for(string::size_type i=1; i<prices.size(); i++) {
            tmpzProfit+=(prices[i]-prices[i-1]);
            if(tmpzProfit>maxProfit) {
                maxProfit=tmpzProfit;
            }
            if(tmpzProfit<0) {
                tmpzProfit=0;
            }
        }//for
        return maxProfit;
    }
};
int main() {

    Solution s;
    vector<int>v;
    v.push_back(1);
    v.push_back(2);
    v.push_back(3);
    cout<<s.maxProfit(v)<<endl;
    cout<<"end!\n";


    return 0;
}
