#include<iostream>
#include<vector>
using namespace std;


class Solution {
public:
    bool searchMatrix(vector<vector<int> >& matrix, int target) {
        int rowsNum=matrix.size();
        if(rowsNum==0) {
            return false;
        }
        int columnsNum=matrix[0].size();
        if(columnsNum==0) {
            return false;
        }
        return searchMatrixBound(matrix,0,rowsNum-1,0,columnsNum-1,target);
    }
private:
    bool searchMatrixBound(vector<vector<int> >& matrix,int rBegin,int rEnd,int cBegin,int cEnd,int target) {
        int rMid=(rBegin+rEnd)/2;
        int cMid=(cBegin+cEnd)/2;
        if(target==matrix[rMid][cMid]) {
            return true;
        }
        int rs=false;
        if(target<=matrix[rMid][cMid]&&target>=matrix[rBegin][cBegin]) {
            rs= searchMatrixBound(matrix,rBegin,rMid,cBegin,cMid,target);
        }
        if(false==rs&&cMid+1<=cEnd&&target<=matrix[rMid][cEnd]&&target>=matrix[rBegin][cMid+1]) {
            rs= searchMatrixBound(matrix,rBegin,rMid,cMid+1,cEnd,target);
        }
        if(false==rs&&rMid+1<=rEnd&&target<=matrix[rEnd][cMid]&&target>=matrix[rMid+1][cBegin]) {
            rs= searchMatrixBound(matrix,rMid+1,rEnd,cBegin,cMid,target);
        }
        if(false==rs&&cMid+1<=cEnd&&rMid+1<=rEnd&&target<=matrix[rEnd][cEnd]&&target>=matrix[rMid+1][cMid+1]) {
            return searchMatrixBound(matrix,rMid+1,rEnd,cMid+1,cEnd,target);
        }
        return rs;
    }//searchMatrix

};
int main() {
    Solution s;
    vector<vector<int> >vv;
    vector<int>v0,v1,v2,v3,v4;
    v0.push_back(1);
    v0.push_back(2);
    v0.push_back(3);
    v0.push_back(4);
    v0.push_back(5);

    v1.push_back(6);
    v1.push_back(7);
    v1.push_back(8);
    v1.push_back(9);
    v1.push_back(10);

    v2.push_back(11);
    v2.push_back(12);
    v2.push_back(13);
    v2.push_back(14);
    v2.push_back(15);

    v3.push_back(16);
    v3.push_back(17);
    v3.push_back(18);
    v3.push_back(19);
    v3.push_back(20);



    v4.push_back(21);
    v4.push_back(22);
    v4.push_back(23);
    v4.push_back(24);
    v4.push_back(25);

    vv.push_back(v0);
    vv.push_back(v1);
    vv.push_back(v2);
    vv.push_back(v3);
    vv.push_back(v4);


    cout<<s.searchMatrix(vv,5)<<endl;
    cout<<s.searchMatrix(vv,10)<<endl;
    cout<<s.searchMatrix(vv,12)<<endl;
    cout<<s.searchMatrix(vv,13)<<endl;
    cout<<s.searchMatrix(vv,14)<<endl;

    return 0;
}
