
#include <stdio.h>

void swap(int *a , int *b){
    int temp = *a;
    *a = *b; *b = temp;
}

void bubbleSort(int arr[], int n){
    int i,j,flag;
    for( i = 0; i < n-1; i++){
        flag = 0;
        for( j = 0; j < n-i-1; j++){
            if(arr[j]>arr[j+1]){
                swap(&arr[j],&arr[j+1]);
                flag = 1;
            }
        }
        if(flag==1){
            break;
        }
    }
}

void Kthlargestnum(int arr[], int n, int k){
    int i,j,flag;
    for( i = 0; i < k; i++){
        flag = 0;
        for( j = 0; j < n-i-1; j++){
            if(arr[j]>arr[j+1]){
                swap(&arr[j],&arr[j+1]);
                flag = 1;
            }
        }
        if(flag==1){
            break;
        }
    }
    printf("\n%d",arr[n-k]);
}

int main()
{
    int arr[] = {8,5,7,3,2};
    bubbleSort(arr, 5);
    for(int k = 0; k < 5; k++){
        printf("%d ",arr[k]);
    }
    Kthlargestnum(arr, 5 ,2);
}
