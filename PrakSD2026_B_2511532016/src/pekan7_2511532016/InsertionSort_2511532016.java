package pekan7_2511532016;

public class InsertionSort_2511532016 {
	
	public static void insertionSort_2016(int[] arr_2016) {
		int n_2016 = arr_2016.length;
		for(int i_2016=1; i_2016<n_2016; i_2016++) {
		int key_2016 = arr_2016[i_2016];
		int j_2016 = i_2016-1;
		while(j_2016>= 0 && arr_2016[j_2016]>key_2016) {
			arr_2016[j_2016+1] = arr_2016[j_2016];
			j_2016--;
		}
		arr_2016[j_2016+1] = key_2016;
		}
		
	}
	public static void main(String[] args) {
		int arr_2016[] = {23,78,45,832,56,1};
		int n_2016 = arr_2016.length;
		System.out.printf("Array yang belum terurut:\n");
		for(int i_2016=0; i_2016<n_2016; i_2016++) System.out.print(arr_2016[i_2016]+" ");
		
		System.out.println("");
		insertionSort_2016(arr_2016);
		System.out.printf("Array yang sudah terurut:\n");
		for(int i=0; i<n_2016; i++) System.out.print(arr_2016[i] + " ");
		
		System.out.println("");

	}

}
