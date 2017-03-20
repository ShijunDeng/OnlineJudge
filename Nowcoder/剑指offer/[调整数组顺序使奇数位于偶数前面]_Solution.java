/*调整数组顺序使奇数位于偶数前面
时间限制：1秒 空间限制：32768K 热度指数：15860
本题知识点： 数组
 算法知识视频讲解
题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
*/
 public static void ReorderOddEven(int[] datas)
{
    if (datas == null || datas.Length <= 0)
    {
        return;
    }

    int begin = 0;
    int end = datas.Length - 1;
    int temp = -1;

    while (begin < end)
    {
        // 向后移动begin，直到它指向偶数
        while (begin < end && datas[begin] % 2 != 0)
        {
            begin++;
        }
        // 向前移动pEnd，直到它指向奇数
        while (begin < end && datas[end] % 2 == 0)
        {
            end--;
        }

        if (begin < end)
        {
            // 交换偶数和奇数
            temp = datas[begin];
            datas[begin] = datas[end];
            datas[end] = temp;
        }
    }
}
public class Solution {
    public void reOrderArray(int [] array) {
        int j=0;//记录第一个为奇数的位置
        int m=0;//记录排好序的奇数的最后一个位置
        for(int i=0;i<array.length;i++)
        {    
            if(array[i]%2==1)//找到第一个奇数
            {
                int temp = array[i];//记录第一个奇数
                int ti=i;
                for(;ti>0;ti--)
                {
                    array[ti]=array[ti-1];//将第一个奇数之前的所有元素往后移一个位置
                }
                array[0] = temp;//将第一个奇数放到array[0]位置
                j=i;
                break;
            }
        }
        for(++j;j<array.length;j++)//依次寻找剩余的奇数
        {
            if(array[j]%2==1)
            {
                int temp = array[j];
                int tj = j;
                for(;tj>m;tj--)
                {
                    array[tj]=array[tj-1];
                }
                array[++m]=temp;
            }
        }
        
    }
}