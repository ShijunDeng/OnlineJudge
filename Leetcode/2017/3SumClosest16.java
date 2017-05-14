/*
16. 3Sum Closest
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Subscribe to see which companies asked this question.
*/
int comp1 (const void * a, const void * b)
{
    return *(int*)a - *(int*)b;
}

int threeSumClosest (int* nums, int numsSize, int target)
{
    int diff = ( ( (unsigned int) - 1) >> 1);
    int rs = 0;
    int k = 0;
    int i = 0, j = 0;
    int sum = 0;

    if (nums)
    {
        qsort (nums, numsSize, sizeof (int), comp1);

        while (k < numsSize - 2)
        {
            if ((k > 0 && nums[k] != nums[k - 1]) || k == 0)
            {

                i = k + 1;
                j = numsSize - 1;

                while (i < j)
                {
                    sum = nums[i] + nums[j] + nums[k];

                    if (fabs(sum - target) < diff)
                    {
                        rs = sum;
                        diff = fabs(sum - target);
                    }

                    if (sum < target)
                    {
                        i++;
                    }
                    else
                    {
                        j--;
                    }
                }
            }

            k++;
        }
    }

    return rs;
}
