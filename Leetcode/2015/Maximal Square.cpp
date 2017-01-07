#include <iostream>
#include<vector>
#include<memory.h>
using namespace std;
class Solution {
public:
    int maximalSquare(vector<vector<char> >& matrix) {
        int rowsNum=matrix.size();
        if(rowsNum==0) {
            return 0;
        }
        int columnsNum=matrix[0].size();
        if(columnsNum==0) {
            return 0;
        }

        int **left=new int*[rowsNum];
        int **top=new int*[rowsNum];
        int **nums=new int*[rowsNum];
        int maxSqureNum=0;
        for(int i=0; i<rowsNum; i++) {
            left[i]=new int[columnsNum];
            top[i]=new int[columnsNum];
            nums[i]=new int[columnsNum];
            memset( left[i],0,columnsNum*sizeof(int));
            memset( top[i],0,columnsNum*sizeof(int));
            memset( nums[i],0,columnsNum*sizeof(int));
        }

        for(int i=0; i<rowsNum; i++) {
            nums[i][0]=left[i][0]=matrix[i][0]-'0';
            for(int j=1; j<columnsNum; j++) {
                left[i][j]=( matrix[i][j]=='0'?0:left[i][j-1]+1);
                nums[i][j]=matrix[i][j]-'0';
                if(nums[i][j]>maxSqureNum) {
                    maxSqureNum=nums[i][j];
                }
            }
            if(nums[i][0]>maxSqureNum) {
                maxSqureNum=nums[i][0];
            }
        }

        for(int j=0; j<columnsNum; j++) {
            nums[0][j]=top[0][j]=matrix[0][j]-'0';
            for(int i=1; i<rowsNum; i++) {
                top[i][j]=(matrix[i][j]=='0'?0:top[i-1][j]+1);
            }
        }

        for(int i=1; i<rowsNum; i++) {
            for(int j=1; j<columnsNum; j++) {
                if(left[i][j-1]&&top[i-1][j]&&nums[i][j]) {
                    nums[i][j]=min(min(left[i][j-1],top[i-1][j]),nums[i-1][j-1])+1;
                    if(nums[i][j]>maxSqureNum) {
                        maxSqureNum=nums[i][j];
                    }
                }
            }
        }
        for(int i=0; i<rowsNum; i++) {
            delete []left[i];
            delete []top[i];
            delete [] nums[i];
        }
        delete []left;
        delete []top;
        delete [] nums;
        return maxSqureNum*maxSqureNum;
    }
};

int main() {
    vector<char>v1;
    v1.push_back('1');
    v1.push_back('1');
    v1.push_back('1');
    v1.push_back('1');
    vector<char>v2;
    v2.push_back('1');
    v2.push_back('1');
    v2.push_back('1');
    v2.push_back('1');
    vector<char>v3;
    v3.push_back('1');
    v3.push_back('1');
    v3.push_back('1');
    v3.push_back('1');
    vector<vector<char> >matrix;
    matrix.push_back(v1);
    matrix.push_back(v2);
    matrix.push_back(v3);
    Solution u;
    cout<<u.maximalSquare(matrix)<<endl;
    return 0;
}
