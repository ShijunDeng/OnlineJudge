#include<stdio.h>
#include<string.h>
int main()
{
    int n;
    char model[10];
    char cpModel[10];
    char data[1000][10];
    int selected[1000];
    int selectedSize=0;
    int pos[10];
    int posSize=0;

    scanf("%s %d",model,&n);
    for(int i=0;i<n;i++){
        scanf("%s",data[i]);
    }
    for(int i=0;i<10;i++){
        if(model[i]=='*'){
            pos[posSize++]=i;
        }
    }

    for(int i=0;i<n;i++){
        strcpy(cpModel,model);
        for(int k=0;k<posSize;k++){
            cpModel[pos[k]]=data[i][pos[k]];
        }

        if(strcmp(data[i],cpModel)==0){
            selected[selectedSize++]=i;
        }
    }
    printf("%d\n",selectedSize);
    for(int i=0;i<selectedSize;i++){
        printf("%s\n",data[selected[i]]);
    }
    return 0;
}
