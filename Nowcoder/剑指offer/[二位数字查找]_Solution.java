/*
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*/
 class Solution
{
	public boolean Find(int target, int [][] array) {
		if(null==array||null==array[0]||array.length==0||array[0].length==0) {
			return false;
		}
		int row=array.length;
		int column=array[0].length;
		int i=0,j=column-1;
		while(i<row&&j>=0) {
			if(array[i][j]<target) {
				i++;
			} else if(array[i][j]>target) {
				j--;
			} else {
				return true;
			}
		}
		return false;
	}
}