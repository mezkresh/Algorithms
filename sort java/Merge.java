import java.util.Scanner;

public class Merge{

	
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n;
		int[] array;
		n = in.nextInt();
		array = new int[n];
		for(int i=0;i<n;i++)
			array[i] = in.nextInt();
		Merge obj = new Merge();
		obj.merge_sort(array,0,n-1);
		for(int i = 0; i < n; i++)
			System.out.print(array[i]+" ");
	}
	void merge_sort(int[] a,int l,int r){
		if(l<r){
			int mid = (l+r)/2;
			merge_sort(a,l,mid);
			merge_sort(a,mid+1,r);
			merge(a,l,mid,r);
		}
	}
	void merge(int[] a,int l,int mid,int r){
		int i = l;
		int j = mid+1;
		int[] buf = new int[r-l+1];
		int bufCounter = 0;
		while(i<=mid && j<=r){
			if(a[i]<=a[j]){
				buf[bufCounter] = a[i];
				i++;
				bufCounter++;
			}
			else{
				buf[bufCounter] = a[j];
				j++;
				bufCounter++;
			}
		}
		while(i<=mid){
			buf[bufCounter] = a[i];
			i++;
			bufCounter++;
		}
		while(j<=r){
			buf[bufCounter] = a[j];
			j++;
			bufCounter++;
		}
		for(int z=l;z<=r;z++)
			a[z] = buf[z-l];
	
	}
	
}