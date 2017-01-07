#include<iostream>
#include<vector>
#include<math.h>
using namespace std;

class Solution {
public:
    bool containsNearbyAlmostDuplicate(vector<int>& nums, int k, int t) {
        int low=0;
        int size=nums.size();
        if(size==0){
            return false;
        }
        int high=size-1;
        int diffLen=high-low;
        int diff=fabs(nums[high]-nums[low]);
        while(low<high) {
            if(diff<=t&&diffLen<=k) {
                return true;
            }
            else {
                if(fabs(nums[low+1]-nums[high]) > fabs(nums[low]-nums[high-1])) {
                    high--;
                    diff=fabs(nums[high]-nums[low]);
                } else {
                    low++;
                    diff=fabs(nums[high]-nums[low]);
                }
                diffLen--;
            }
        }//while
        return false;
    }
};
int main() {
    Solution s;
    vector<int>nums;
    nums.push_back(3);
    nums.push_back(6);
    nums.push_back(0);
    nums.push_back(2);
    // nums.push_back(3);
    //nums.push_back(9);
    cout<<s.containsNearbyAlmostDuplicate(nums,2,2)<<endl;
    return 0;
}
