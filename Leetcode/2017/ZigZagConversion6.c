/*
6. ZigZag Conversion Add to List
DescriptionSubmissionsSolutions
Total Accepted: 140653
Total Submissions: 536022
Difficulty: Medium
Contributors: Admin
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
Subscribe to see which companies asked this question.
*/
char* convert(char* s, int numRows) {
	int len_src=strlen(s);
	char *rs=(char*)malloc(sizeof(char)*(len_src+1));
	int i,j,k,step;
	rs[len_src]=0;
	if(numRows==1){
	    strncpy(rs,s,len_src+1);
	    return rs;
	}
	for(i=0,k=0;i<len_src;i+=2*(numRows-1)){
		rs[k++]=s[i];
	}
	i=1;

	step=2*(numRows-2);
	while(i<numRows-1){
		j=i;
		while(j<len_src){
			rs[k++]=s[j];
			if(j+step<len_src){
				rs[k++]=s[j+step];
			}
			j+=2*(numRows-1);
		}
		step-=2;
		i++;
	}

	for(i=numRows-1;i<len_src;i+=2*(numRows-1)){
		rs[k++]=s[i];
	}
	return rs;

}
