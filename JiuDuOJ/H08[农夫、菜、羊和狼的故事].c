#include<stdio.h>

//����״̬��
#define OK 0
#define ERROR -1
#define TRUE 1
#define FALSE 0
#define CANTEXIST 10//״̬�����Թ���(�����ڶ���֮����б��Ե��Ŀ���)
#define EXIST 20//״̬���Թ���
#define SUCCESS 30//�ɹ��ɺ�
#define N 1000

#define GO 0 //�ӳ�ʼ����Ŀ�İ�����
#define COME 1//��Ŀ�İ�����ʼ������
typedef int Status;
typedef int Boolean;
/*
��Ŀ������
��һ��ũ���һֻ��һ��˺�һֻ�ǹ���.
��û��ũ�򿴹ܣ�����Ҫ������Ҫ�Բ�.
���Ǵ���С��ֻ��ũ���һ���������ӡ�
��ũ�����ν�����⣿
���룺
��Ŀû���κ����롣
�����
��Ŀ�������ֽ������������������ٵĽ��������
��˳�����ũ������򡢲ˡ���ȫ���˹�����Ҫ�ļ������衣
�����Ҫ���������ȥ�����"sheep_go"��
�����Ҫ��������������"sheep_come"��
�����Ҫ���˴�����ȥ�����"vegetable_go"��
�����Ҫ���˴����������"vegetable_come"��
�����Ҫ���Ǵ�����ȥ�����"wolf_go"��
�����Ҫ���Ǵ����������"wolf_come"��
�����Ҫ���ַ��������"nothing_come"��
�����Ҫ���ֹ��������"nothing_go"��
ÿ���һ�ַ��������һ��"succeed"��
�������룺
���������
��ʾ��
��Ŀ�����ж�����������ÿ�ַ��������Ҫ�ٿ�һ�С�
һ�ַ����еĶ�仰��ÿ�仰ռһ�С�

*/

char pathStr[][20]= {"nothing_go","wolf_go","sheep_go","vegetable_go","nothing_come","wolf_come","sheep_come","vegetable_come"};
int mark[2][16]= {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}; //������������״̬ �����ظ�����
int path[N];//��¼���͵�˳�� pathStr�е����ͷ�ʽ���±�
int ways[4][4]= {1,0,0,0, //ֻ���˹���
                 1,1,0,0,//�˺���
                 1,0,1,0,//�˺���
                 1,0,0,1	//�˺Ͳ�
                };

//������״̬�Ƿ���Դ���
Boolean safe(int state[4])
{
    if(state[0]==1)
        return TRUE;//ũ���� ��ȫ
    if(	(state[0]==0&&state[1]==0&&state[2]==0&&state[3]==1)||//ֻ�в˵�����һ��
            (state[0]==0&&state[1]==0&&state[2]==1&&state[3]==0)||//ֻ���򵥶���һ��
            (state[0]==0&&state[1]==1&&state[2]==0&&state[3]==0)||//ֻ���ǵ�����һ��
            (state[0]==0&&state[1]==1&&state[2]==0&&state[3]==1)||//�ǺͲ���һ��
            (state[0]==0&&state[1]==0&&state[2]==0&&state[3]==0) )//�ð�Ϊ��
    {
        return TRUE;
    }
    return FALSE;
}

//���A,B������״̬
Boolean check(int A[4],int B[4])
{
    if(B[0]==1&&B[1]==1&&B[2]==1&&B[3]==1 &&
            A[0]==0&&A[1]==0&&A[2]==0&&A[3]==0)
        return SUCCESS;
    if(safe(A)==TRUE&&safe(B)==TRUE)
    {
        return EXIST;
    }
    return CANTEXIST;
}
//��ǰ��A,B����״̬ �Ƿ���԰���w�ַ�ʽ�ɺӺ� direction��ʾ����
Boolean checkAll(int w,int A[4],int B[4],int direction)
{
    int AA[4]= {A[0]-ways[w][0],A[1]-ways[w][1],A[2]-ways[w][2],A[3]-ways[w][3]};
    int BB[4]= {B[0]+ways[w][0],B[1]+ways[w][1],B[2]+ways[w][2],B[3]+ways[w][3]};
    int markIndexA=0;
    int markIndexB=0;
    if( AA[0]>=0&&AA[1]>=0&&AA[2]>=0&&AA[3]>=0 &&safe(AA)==TRUE&&safe(BB)==TRUE)//���Զɺ�:1 Ҫ���͵Ķ������ 2 ���ͺ�������״̬�ǰ�ȫ��
    {
        markIndexA=AA[0]*8+AA[1]*4+AA[2]*2+AA[3]*1;
        markIndexB=BB[0]*8+BB[1]*4+BB[2]*2+BB[3]*1;
        //������͹����״̬ �Ƿ����Ѿ���������
        if(mark[direction][markIndexA]==1&&mark[1-direction][markIndexB]==1)//����ע��A,B����Ե� Ӧ�ø���direction�������� �Ӷ���ȷ�ı��״̬
            return FALSE;
        return TRUE;
    }
    else
    {
        return FALSE;
    }
}

//��˷�����ɺӷ�ʽ
Status tryCross(int A[4],int B[4],int step,int direction)
{
    int w=0,k=0;
    int markIndexA,markIndexB;
    for(w=0; w<4; w++) //for #1 ������̽���ַ�ʽ
    {
        if(checkAll(w,A,B,direction)==TRUE)//if #1  ���Զɺ�  ������̽
        {
            A[0]=A[0]-ways[w][0];
            A[1]=A[1]-ways[w][1];
            A[2]=A[2]-ways[w][2];
            A[3]=A[3]-ways[w][3];
            B[0]=B[0]+ways[w][0];
            B[1]=B[1]+ways[w][1];
            B[2]=B[2]+ways[w][2];
            B[3]=B[3]+ways[w][3];
            path[step]=w+direction*4;//��Ƕɺӵķ�ʽ  ��������Щ����
            markIndexA=A[0]*8+A[1]*4+A[2]*2+A[3]*1;//���һ��״̬ ��ʾ���ַ�ʽ�Ѿ���̽����
            markIndexB=B[0]*8+B[1]*4+B[2]*2+B[3]*1;
            mark[direction][markIndexA]=1;
            mark[1-direction][markIndexB]=1;

            if(direction==GO&&SUCCESS==check(A,B))//�ҵ�һ�ֿ��з�����
            {
                for(k=0; k<step+1; k++)
                {
                    printf("%s\n",pathStr[path[k]]);
                }
                printf("succeed\n");
            }
            else
            {
                tryCross(B,A,step+1,1-direction);//��̽��һ��
            }
            //��˷ �ָ��ֳ�
            mark[direction][markIndexA]=0;
            mark[1-direction][markIndexB]=0;

            A[0]=A[0]+ways[w][0];
            A[1]=A[1]+ways[w][1];
            A[2]=A[2]+ways[w][2];
            A[3]=A[3]+ways[w][3];
            B[0]=B[0]-ways[w][0];
            B[1]=B[1]-ways[w][1];
            B[2]=B[2]-ways[w][2];
            B[3]=B[3]-ways[w][3];
        }//end:if #1

    }//end:for #1

    return OK;
}

//ҵ������:�������� ������غ���������� ���ش�����
Status service()
{

    //˳��ũ�� �� ��  ��
    int A[]= {1,1,1,1}; //��ʼ��һ��
    int B[]= {0,0,0,0}; //�԰�
    tryCross(A,B,0,GO);
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
