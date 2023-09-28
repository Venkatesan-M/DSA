#include <stdio.h>
#include <stdlib.h>

void swap(int *a , int *b){
    int temp = *a;
    *a = *b; *b = temp;
}

void selectionSort(int a[], int n){
    int i,j,k;
    for( i = 0; i < n-1; i++){
        j=i;
        k=i;
        for(j; j < n; i++){
            if(a[j]< a[k]){
                k=j;
            }
        }
        swap(&a[i],&a[k]);
    }

}

int main(){
    int n;
    scanf("%d",&n);
    int arr[n];
    for(int i = 0; i < n; i++){
        scanf("%d", &arr[i]);
    }

    selectionSort(arr, n);
    for(int i = 0; i < n; i++){
        printf("%d,",arr[i]);
    }

}
