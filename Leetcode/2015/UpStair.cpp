#include <iostream>
#include<vector>
using namespace std;
class UpStair {
public:
    int solution(int n) {
        if(n>5) {
            return solution(n-5)+solution(n-3);
        }
        if(n==5||n==3) {
            return 1;
        }
        return 0;
    }
};
int main() {
    UpStair u;
    for(int i=1;i<20;i++){
        cout << "stepsNum:" << i<<" solutionsNum:"<<u.solution(i)<<endl;
    }

    return 0;
}
