#include <iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int size=nums.size();
        int peakIndex=0;
        if(nums[size-1]>nums[size-2]) {
            peakIndex=size-1;
        }
        int low=1,high=size-1;
        int mid=(low+high)/2;
        while(low<=high) {
            if(nums[mid]>nums[mid+1]&&nums[mid]>nums[mid-1]) {
                peakIndex=mid;
                break;
            } else if(nums[mid]>nums[mid+1]) {
                high=mid-1;
            } else {
                low=mid+1;
            }
            mid=(low+high)/2;
        }
        return peakIndex;
    }
};

int main() {
    Solution u;
    vector<int>v;
    v.push_back(1);
    v.push_back(3);
    v.push_back(5);
    v.push_back(7);
    cout<<u.findPeakElement(v)<<endl;
    cout<<"end!"<<endl;
    return 0;
}
