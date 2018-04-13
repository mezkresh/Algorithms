import java.util.Scanner;

public class Quick{
	public static void main(String[] args){
		int n;
		int[] array;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		array = new int[n];
		for(int i = 0;i < n;i++)
			array[i] = in.nextInt();
		Quick obj = new Quick();
		obj.quickSort(array,0,n-1);
		for(int i = 0;i < n;i++)
			System.out.print(array[i] + " ");
		
		
		
	}
	
	void quickSort(int[] a,int l,int r){
	
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
		quickSort(a,i,r	);
	}
}