#include<iostream>
#include<vector>
#include<string>
using namespace std;
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        if(n<1) {
            return rs;
        }
        string tmp="";
        pair(n,n,tmp);
        return rs;
    }
private:
    void pair(int left,int right,string tmp) {
        if(left==0&&right==0) {
            rs.push_back(tmp);
            tmp.clear();
        } else if(left>=0&&left<=right) {
            if(left>0) {
                pair(left-1,right,tmp+"(");
            }
            if(left!=right) {
                pair(left,right-1,tmp+")");
            }
        }
    }
private:
    vector<string>rs;
};
int main() {
    Solution s;
    vector<string> rs=s.generateParenthesis(3);
    for(int i=0; i<rs.size(); i++) {
        cout<<rs[i]<<endl;
    }
    return 0;
}

