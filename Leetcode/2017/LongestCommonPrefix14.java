public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(null==strs||strs.length==0||null==strs[0]||"".equals(strs[0])){
            return "";
        }
        int limit=strs[0].length()-1;
        for(int i=1;i<strs.length;i++){
            int j=0;
            while(j<=limit&&j<strs[i].length()&&strs[0].charAt(j)==strs[i].charAt(j)){
                j++;
            }
            if(j-1<limit){
                limit=j-1;
            }
        }
        return strs[0].substring(0,limit+1);
    }
}