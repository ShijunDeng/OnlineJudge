/*
15. 3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
Subscribe to see which companies asked this question.

*/
int comp (const void * a, const void * b)
{
    return *(int *)a - *(int *)b;
}
int** threeSum(int* nums, int numsSize, int* returnSize)
{
    int **rs = (int **) malloc(20480*sizeof(int*));
    int k = 0;
    int target = 0;
    int i = 0, j = 0;
    int count = 0;

    if (nums)
    {
        qsort(nums, numsSize, sizeof (int), comp);
        while (k < numsSize - 2)
        {
            if (k == 0 || (k > 0 && nums[k] != nums[k - 1]) )
            {
                target = -nums[k];
                i = k + 1;
                j = numsSize - 1;
                while (i < j)
                {
                    if (nums[i] + nums[j] < target)
                    {
                        i++;
                    }
                    else if (nums[i] + nums[j] > target)
                    {
                        j--;
                    }
                    else
                    {
                        rs[count] = (int*)malloc(3 * sizeof(int));
                        rs[count][0] = nums[i];
                        rs[count][1] = nums[j];
                        rs[count][2] = nums[k];
                        while (i < j && nums[i] == nums[i + 1])
                        {
                            i++;
                        }
                        while (i < j && nums[j] == nums[j - 1])
                        {
                            j--;
                        }
                        i++;
                        j--;
                        count++;
                    }
                }
            }
            k++;
        }
    }
    *returnSize = count;
    return rs;
}