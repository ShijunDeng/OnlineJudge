#include<iostream>
#include<vector>
using namespace std;


class Solution {
public:
    bool searchMatrix(vector<vector<int> >& matrix, int target) {
        int rows=matrix.size();
        if(rows==0) {
            return false;
        }
        if(rows==1||target>matrix[rows-1][0]) {
            return searchArray(matrix[rows-1],target);
        }
        int columns=matrix[0].size();
        if(columns==0) {
            return false;
        }

        if(matrix[0][0]>target||matrix[rows-1][columns-1]<target) {
            return false;
        }
        int low=0;
        int high=rows-1;
        int mid;
        while(low<=high) {
            mid=(low+high)/2;
            if(target==matrix[mid][0]) {
                return true;
            }
            if(matrix[mid][0]<=target&&matrix[mid][columns-1]>=target) {
                return searchArray(matrix[mid],target);
            }
            if(matrix[low][0]<=target&&matrix[low][columns-1]>=target) {
                return searchArray(matrix[low],target);
            }
             if(matrix[high][0]<=target&&matrix[high][columns-1]>=target) {
                return searchArray(matrix[high],target);
            }
            if(matrix[mid][0]>target) {
                high=mid-1;
            } else {
                low=mid+1;
            }

        }
        return false;
    }

    bool searchArray(vector<int>&array, int target) {
        int low=0;
        int high=array.size()-1;
        int mid;
        while(low<=high) {
            mid=(low+high)/2;
            if(target==array[mid]) {
                return true;
            }
            if(array[mid]>target) {
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return false;
    }
};
int main() {
    Solution s;
    vector<vector<int> >vv;
    vector<int>v0,v1,v2,v3,v4;
    v0.push_back(11);
    v1.push_back(12);

    vv.push_back(v0);
    vv.push_back(v1);

    cout<<s.searchMatrix(vv,12)<<endl;

    return 0;
}
