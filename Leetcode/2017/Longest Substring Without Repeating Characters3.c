 /*
Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
Subscribe to see which companies asked this question.
 */
 
int lengthOfLongestSubstring(char* s) {
    int str_len=strlen(s);
    int last_pos[200];
    int i=0;
    int longest=0;
    int last=-1;
    memset(last_pos,-1,sizeof(int)*200);
    for(i=0;i<str_len;i++){
        if(last_pos[s[i]]>last){
            last=last_pos[s[i]];
        }
        if(i-last>longest){
            longest=i-last;
        }
        last_pos[s[i]]=i;
    }
    return longest;   
}