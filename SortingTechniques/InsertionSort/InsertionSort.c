#include <stdio.h>
#include <stdlib.h>

void insertionSort(int a[], int n){
    int i,j,x;
    for( i = 1; i < n; i++){
        j=i-1;
        x=a[i];
        while (a[j] > x && j>-1)
        {
            a[j+1]=a[j];
            j--;
        }
        a[j+1]=x; 

    }
}

int main(){
    int n;
    scanf("%d",&n);
    int arr[n];
    // int *p;
    // p = (int*)malloc(n*sizeof(int));
    for(int i = 0; i < n; i++){
        scanf("%d", &arr[i]);
    }

    insertionSort(arr, n);
    for(int i = 0; i < n; i++){
        printf("%d,",arr[i]);
    }

}
