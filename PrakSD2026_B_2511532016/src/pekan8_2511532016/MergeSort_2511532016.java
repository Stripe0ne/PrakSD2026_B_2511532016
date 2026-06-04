package pekan8_2511532016;

public class MergeSort_2511532016 {
	static void Merge(int[] arr, int l_2016, int m_2016, int r_2016) {
		int n1_2016= m_2016-l_2016+1;
		int n2_2016 = r_2016-m_2016;
		
		int L_2016[] = new int[n1_2016];
		int R_2016[] = new int[n2_2016];
		
		for(int i_2016=0; i_2016<n1_2016;i_2016++) L_2016[i_2016]= arr[i_2016+l_2016];
		for(int j_2016=0; j_2016<n2_2016; j_2016++) R_2016[j_2016]=arr[m_2016+1+j_2016];
		int i_2016=0, j_2016=0;
		
		int k_2016=l_2016;
		while(i_2016<n1_2016 && j_2016<n2_2016) {
			if(L_2016[i_2016] <= R_2016[j_2016]) {
				arr[k_2016]=L_2016[i_2016];
				i_2016++;
			} else {
				arr[k_2016] = R_2016[j_2016];
				j_2016++;
			}
			k_2016++;
		}
		while(i_2016<n1_2016) {
			arr[k_2016]=L_2016[i_2016];
			i_2016++;
			k_2016++;
		}
		while(j_2016<n2_2016) {
			arr[k_2016] =R_2016[j_2016];
			j_2016++;
			k_2016++;
		}
	}
	public static void printArray(int[] arr) {
		for(int i_2016:arr) System.out.print(i_2016 + " ");
		System.out.println();
	}
	
	void sort_2016(int arr[], int l, int r) {
		if(l<r) {
			int m = (l+r)/2;
			sort_2016(arr, l, m);
			sort_2016(arr, m+1,r);
			Merge(arr, l, m, r);	
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr_2016 = {12,11,13,5,6,7};
		System.out.print("Sebelum: ");
		printArray(arr_2016);
		
		MergeSort_2511532016 ob = new MergeSort_2511532016();
		ob.sort_2016(arr_2016, 0, arr_2016.length-1);
		System.out.print("Sesudah Merge Sort: ");
		printArray(arr_2016);
	}

}
