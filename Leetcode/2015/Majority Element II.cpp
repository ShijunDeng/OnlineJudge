#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        vector<int> rs;
        int size=nums.size();
        if(size<1) {
            return rs;
        }
        sort(nums.begin(),nums.end());
        int i=0;
        while(i<size) {
            int tmp=nums[i];
            int count=1;
            while(i+1<size&&nums[i]==nums[i+1]) {
                count++;
                i++;
            }
            if(count>(int)size/3) {
                rs.push_back(tmp);
            }
            i++;
        }//while
        return rs;
    }
};

int main() {
    Solution s;
    vector<int>v;
    v.push_back(1);
    v.push_back(2);
    v.push_back(3);
    vector<int>rs=s.majorityElement(v);
    for ( string::size_type i=0; i<rs.size();i++ ) {
        cout<<rs[i]<<endl;
    }

    return 0;
}
