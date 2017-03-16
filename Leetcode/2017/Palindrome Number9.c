/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Subscribe to see which companies asked this question.
*/

bool isPalindrome(int x) {
    int rx=0;
    int ox=x;
    if(x<0){
        return false;
    }
    while(x){
        rx=10*rx+x%10;
        x/=10;
    }
    return ox==rx;
}