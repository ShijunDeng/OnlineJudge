#include<stdio.h>
#include<math.h>
int is_prime2(int num)
{
    int i = 0;
    if (num < 2)
    {
        return 0;
    }

    if (num == 2 || num == 3)
    {
        return 1;
    }
    for (i = 2; i * i <= num; i++)
    {
        if (num % i == 0)
        {
            return 0;
        }
    }
    return 1;
}
int is_prime(int num)
{
    int limit = 0, i = 0;
    if (num < 2)
    {
        return 0;
    }

    if (num == 2 || num == 3)
    {
        return 1;
    }

    if (num % 6 != 1 && num % 6 != 5)  //把 num=4的情况处理了  这样1-5、以及不是6x两侧的全部处理
    {
        return 0;
    }

    limit = (int)sqrt(num) + 1;
    for (i = 5; i < limit; i += 6)
    {
        if (num % i == 0 || num % (i + 2) == 0)
        {
            return 0;
        }
    }
    return 1;
}

int main()
{
    int i = 0, n = (((unsigned int) - 1) >> 1);
    for (i = 1; i < n; i++)
    {
        if (is_prime(i) != is_prime2(i))
        {
            printf("find:%d\n", i);
        }
        if (i % 10000000 == 0)
        {
            printf("flag:%d\n", i);
        }
    }
    printf("end\n", i);
    return 0;
}
/*
java version
boolean isPrime(int num) {
		if (num < 2)
			return false;
		if (num == 2 || num == 3) {
			return true;
		}
		if (num % 6 != 1 && num % 6 != 5) {// 把 num=4的情况处理了 这样1-5、以及不是6x两侧的全部处理
			return false;
		}
		int limit = (int) Math.sqrt(num) + 1;
		for (int i = 5; i < limit; i += 6) {
			if (num % i == 0 || num % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}

*/