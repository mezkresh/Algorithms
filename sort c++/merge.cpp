#include <iostream>

using namespace std;
void merge_sort(int* array,int* buffer,int l,int r);
void merge(int* array,int* buffer,int l,int mid,int r);


int main(){
	int n;
	cin >> n;
	int* array = new int[n];
	int* buffer = new int[n];
	
	for(int i=0;i<n;i++){
		cin >> array[i];
	}
	
	merge_sort(array,buffer,0,n);
	
	for(int i=0;i<n;i++){
		cout << array[i];
	}
	
	return 0;
}

void merge_sort(int* array,int* buffer,int l,int r){
	r--;
	if(l<r){
		int mid = (l+r)/2;
		merge_sort(array,buffer,l,mid);
		merge_sort(array,buffer,mid+1,r);
		merge(array,buffer,l,mid,r);
	}
}

void merge(int* array,int* buffer,int l,int mid,int r){
	int i=l;
	int k=l;
	int j=mid+1;
	while((i<=mid) && (j<=r)){
		if(array[i] <= array[j]){
			buffer[k] = array[i];
			k++;
			i++;
		}else{
			buffer[k] = array[j];
			k++;
			j++;
		}
	}
	while(i<=mid){
		buffer[k] = array[i];
		k++;
		i++;
	}
	while(j<=r){
		buffer[k] = array[j];
		k++;
		j++;
	}
	for(int z = l;z<=r;z++){
		array[z] = buffer[z];
	}
}


