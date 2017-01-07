#include <iostream>
#include<vector>
#include<string.h>
using namespace std;
class Solution {
public:
    bool canFinish(int numCourses, vector<pair<int, int> >& prerequisites) {
        if(numCourses<2) {
            return true;
        }

        int *count=new int[numCourses];
        int *stackArray=new int[numCourses];
        int stackSize=0;
        int countedCourses=0;
        memset(count,0,numCourses*sizeof(int));
        vector<pair<int, int> >::iterator iters;
        for(iters=prerequisites.begin(); iters!=prerequisites.end(); iters++) {
            count[(*iters).first]++;
        }

        for(int i=0; i<numCourses; i++) {
            if(!count[i]) {
                stackArray[stackSize]=i;
                stackSize++;
               // count[i]=-1;//visited
            }
        }

        while(stackSize>0) {
            stackSize--;
            int e=stackArray[stackSize];
            countedCourses++;
            count[e]=-1;

            for(iters=prerequisites.begin(); iters!=prerequisites.end(); iters++) {
                if(count[(*iters).first]!=-1&&(*iters).second==e) {
                    count[(*iters).first]--;
                    if( !count[(*iters).first]) {
                        stackArray[stackSize]=(*iters).first;
                        stackSize++;
                    }
                }//if
            }//for
        }//while

        delete[]count;
        delete[]stackArray;
        return countedCourses==numCourses;
    }
};
int main() {
    Solution u;
    pair<int,int>p1(1,0);
    pair<int,int>p2(0,1);
    vector<pair<int,int> >v;
    v.push_back(p1);
    v.push_back(p2);
    cout<<u.canFinish(3,v)<<endl;
    cout<<"end!"<<endl;
    return 0;
}
