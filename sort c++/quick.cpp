#include <iostream>

using namespace std;

void quickSort(int* array,int left,int right);

int main(){
	
	int n;
	cin >> n;
	int* array = new int[n];	
	for(int i=0;i<n;i++){
		cin >> array[i];
	}
	
	quickSort(array,0,n-1);
	
	for(int i=0;i<n;i++){
		cout << array[i];
	}
	
	return 0;
}

void quickSort(int* a,int l,int r){
	
	int i = l;
	int j = r;
	int temp;
	int pivot = a[(l+r)/2];
	
	while(i<=j){
		while(a[i]<pivot)
			i++;
		while(a[j]>pivot)
			j--;
		if(i<=j){
			temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
	if(l<j)
		quickSort(a,l,j);
	if(i<r)
		quickSort(a,i,r);
	
}
