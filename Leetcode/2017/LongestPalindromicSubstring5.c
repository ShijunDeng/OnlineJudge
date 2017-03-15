/*
5. Longest Palindromic Substring Add to List
DescriptionSubmissionsSolutions
Total Accepted: 182309
Total Submissions: 731020
Difficulty: Medium
Contributors: Admin
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
Example:

Input: "cbbd"

Output: "bb"
*/
char* longestPalindrome(char* s)
{
	int i,j,k;
	int longest=0;
	int ri=0,rj=0;
	int str_len=strlen(s);
	char*rs=NULL;
	if(!s) {
		return NULL;
	}
	for(k=0; k<str_len-1; k++) {
		i=k;
		if(s[i]==s[i+1]) {
			j=i+1;
			while(i>=0&&j<str_len&&s[i]==s[j]) {
				i--;
				j++;
			}
			if(j-i-1>longest) {
				longest=j-i-1;
				ri=i+1;
				rj=j-1;
			}
		} 
		i=k;
		if(i-1>=0&&s[i-1]==s[i+1]) {
			j=i+1;
			i--;
			while(i>=0&&j<str_len&&s[i]==s[j]) {
				i--;
				j++;
			}
			if(j-i-1>longest) {
				longest=j-i-1;
				ri=i+1;
				rj=j-1;
			}
		} 
	}
	rs=(char *)malloc(sizeof(char)*(rj-ri+2));
	//memset(rs,0,sizeof(rs));
	strncpy(rs,s+ri,rj-ri+1);
	rs[rj-ri+1]='\0';
	return rs;
}

int main(void){
	char str[20];
	scanf("%s",str);
	printf("%s\n",longestPalindrome(str));
	return 0;
}
