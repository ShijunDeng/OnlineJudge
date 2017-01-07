#include<iostream>
#include<vector>
#include<string>
using namespace std;
class Solution {
public:
    int minimumTotal(vector<vector<int> > & triangle) {
        int triangleSize=triangle.size();
        if(triangleSize<1) {
            return 0;
        }

        for(int i=triangleSize-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                if(triangle[i+1][j]>triangle[i+1][j+1]) {
                    triangle[i][j]+=triangle[i+1][j+1];
                } else {
                    triangle[i][j]+=triangle[i+1][j];
                }
            }//for
        } //for
        return triangle[0][0];

    }
};
int main() {

    Solution s;
    vector<vector<int> >v;
    vector<int> v1;
    vector<int> v2;
    vector<int> v3;
    v1.push_back(1);
    v2.push_back(1);
    v2.push_back(2);
    v3.push_back(1);
    v3.push_back(2);
    v3.push_back(3);
    v.push_back(v1);
    ///v.push_back(v2);
  //  v.push_back(v3);

    cout<<s.minimumTotal(v)<<endl;
    cout<<"end!\n";


    return 0;
}
