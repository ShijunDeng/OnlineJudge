#include<stdio.h>
//#include<string.h>
//#include<malloc.h>
//#include<math.h>
//����״̬��
#define OK 1
#define ERROR 0

#define TRUE 1
#define FALSE 0

typedef int Status;
typedef int Boolean;

#define N 1000

/*************************��Ŀ˵��********************/
/*


*/
Status writeToFile(char str[N])
{
	FILE *fp;
	fp=fopen("E:\\Work\\Development Files\\C\\str.txt","a+");
	fprintf(fp,"%s\n",str);
	fclose(fp);
	return OK;
}

Status deleteSpace()
{
	FILE *fpR,*fpW;
	char str[N];
	int i=0,j=0;
	fpR=fopen("E:\\Work\\Development Files\\C\\str.txt","r");
	fpW=fopen("E:\\Work\\Development Files\\C\\strW.txt","a+");
	while(fgets(str,N,fpR)!=NULL)
	{
		i=j=0;
		while(str[j]!='\0'&&str[j]!='\n')
		{
			while(str[j]!='\0'&&str[j]!='\n'&&str[j]!=' ')
			{
				str[i]=str[j];
				i++;
				j++;
			}
			if(str[j]==' ')
			{
				str[i]=str[j];
				i++;
				j++;
			}
			else
			{
				break;
			}
			while(str[j]==' ')
			{
				j++;
			}
		}
		fprintf(fpW,"%s",str);
	}
	fclose(fpR);
	fclose(fpW);
	return OK;
}


//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{
	char str[N];
	while(gets(str)!=NULL)//while 1#
	{
		writeToFile(str);
	}//end:while 1#
	deleteSpace();
	return OK;
}

int main()
{
	if(ERROR==service())//�����������
	{
		printf("ERROR!\n");
		return ERROR;
	}
	return OK;
}